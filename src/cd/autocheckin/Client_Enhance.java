package cd.autocheckin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import cd.util.regex.CustomRegex;
import cd.util.time.GetTime;
import cd.util.time.SleepTime;

/**
 * �Զ��򿪳���.
 * @author dingc
 *
 */
public class Client_Enhance {
	
	private HttpClient httpClient;
	private String username;
	private String password;
	private Logger log = Logger.getLogger(Client_Enhance.class);

	public Client_Enhance() {
	}

	public Client_Enhance(HttpClient httpClient, String username, String password) {
		this.httpClient = httpClient;
		this.username = username;
		this.password = password;
	}

	public static void main(String[] args) {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		new Client_Enhance(httpClient, "chengding", "123456").checkIn();
	}
	
	/**
	 * ��ȡ�´δ�ʱ��
	 * �õ����Ǵ���ʱ��ĺ�����
	 * @return
	 */
	public long nextDakaTime(){
		
		long result = 0;
		
		Calendar c = new GregorianCalendar();
		//��ǰʱ��
		long curr = c.getTimeInMillis(); 
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), 8, 30, 0);
		// ��������8��30��
		long _0830 = c.getTimeInMillis();
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), 18, 30, 0);
		// ��������6��30��
		long _1630 = c.getTimeInMillis();
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)+1, 8, 30, 0);
		// ��������8��30��
		long _0830n = c.getTimeInMillis();
		
		// �����ǰʱ��С������8��30��,ȡ�����ϴ�ʱ��
		if(curr <= _0830){
			result = _0830;
		}
		// �����ǰʱ���������8��30����С������6��30��,ȡ�������ʱ��
		if(curr > _0830 && curr <= _1630){
			result = _1630;
		}
		// �����ǰʱ���������6��30��,ȡ����������8��30�ִ�ʱ��
		if( curr > _1630){
			result = _0830n;
		}
		return result;
	}
	
	/**
	 * �ۺϴ�
	 * @return
	 */
	public boolean checkIn() {
		
		// ����´δ�ʱ��
		long nextDakaTime = nextDakaTime();
		log.warn("��ȡ�´δ�ʱ��...");
		// ��ȡ��ǰʱ��
		long currTime = System.currentTimeMillis();
		// �ж�ʱ���Ƿ񵽴��ʱ��
		log.warn("�ж�ʱ���Ƿ񵽴��ʱ��...");
		while(currTime < nextDakaTime){
			//δ����ʱ��,�ӳ�ʱ��
			SleepTime.Sleep(120000);
			currTime = System.currentTimeMillis();
			log.warn("δ�����ʱ��,��ʱ...");
		}
		log.warn("�����ʱ��,��¼ϵͳ...");
		
		// �����ʱ��,��¼ϵͳ
		int loginCount = 0;
		while(!login()){
			log.warn("��¼ʧ��,��ʱ�������µ�¼,��¼����:" + (loginCount+1));
			SleepTime.Sleep(5000);
			loginCount ++ ;
			if(loginCount >= 3){
				log.warn("��¼����������ֵ,�����˳�.");
				return false;
			}
		}
		log.warn("��¼�ɹ�...");
		
		// �ж��Ƿ��Ѿ���
		int displayHisCount = 0;
		String[] dakaInfo = displayHis();
		while(dakaInfo == null){
			SleepTime.Sleep(5000);
			displayHisCount ++;
			if(loginCount >= 3){
				log.warn("��ȡ��Ϣ����������ֵ,δ��ô���Ϣ,ֱ�ӿ�ʼ��...");
				break;
			}
		}
		
		return false;
	}

	/**
	 * ע��,�˳���ϵͳ
	 */
	public void logout(){
		HttpResponse response = null;
		// ע����¼
		HttpGet get = new HttpGet(
				"http://10.244.8.190:8081/oa/j_spring_security_logout");
		//http://10.244.8.190:8081/oa/j_spring_security_logout
		try {
			response = httpClient.execute(get);
			EntityUtils.consume(response.getEntity());
			log.warn("ע���ɹ�!");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * ��
	 */
	public void daka(){
		HttpResponse response = null;
		HttpEntity entity = null;
		BufferedReader br = null;

		// ���°�
		HttpGet get = new HttpGet(
				"http://10.244.8.190:8081/oa/module/common/daka.do");
		//http://10.244.8.190:8081/oa/module/common/daka.do?_dc=1314178283843
		try {
			response = httpClient.execute(get);

			entity = response.getEntity();
			br = new BufferedReader(new InputStreamReader(entity.getContent(),
					"UTF-8"));

			StringBuffer sb = new StringBuffer();
			String str = null;
			while ((str = br.readLine()) != null) {
				sb.append(str);
			}
			log.warn(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * ��ʾ��ǰ����Ϣ,�����������жϴ��Ƿ�ɹ�
	 */
	public String[] displayHis() {
		// http://10.244.8.190:8081/oa/module/common/monthlist.do

		HttpResponse response = null;
		HttpEntity entity = null;
		BufferedReader br = null;
		String[] dakaInfo = null;

		// ͨ�����ʵ�¼�����������ʾ��ҳ������֤��¼�ɹ�
//		HttpGet get = new HttpGet("http://10.244.8.190:8081/oa/module/common/monthlist.do");
		//��˾�Ĵ�ϵͳ�������ǰ��� 25-24������,��GET���ض����첻��ȡ��ʱ��.��Ҫ��POSTָ��ʱ��
		HttpPost post = new HttpPost("http://10.244.8.190:8081/oa/module/common/monthlist.do");
		try {
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			
			params.add(new BasicNameValuePair("limit", "31"));
			params.add(new BasicNameValuePair("month", GetTime.dakaMonth()));
			params.add(new BasicNameValuePair("start", "0"));
			
			post.setEntity(new UrlEncodedFormEntity(params));
			
			response = httpClient.execute(post);

			entity = response.getEntity();
			br = new BufferedReader(new InputStreamReader(entity.getContent(),"UTF-8"));

			StringBuffer sb = new StringBuffer();
			String str = null;
			while ((str = br.readLine()) != null) {
				sb.append(str);
			}

			CustomRegex cr = new CustomRegex();
			List<List<String>> result = cr
					.match(sb.toString(),
							"username:'(.*?)',empno.*?,dakaDate:'"	
							+ GetTime.today2()
							+ "',date1:'(.*?)',.*?,date4:'(.*?)',");
			if(result.size() == 0){
				log.warn("û�ж�ȡ��������");
			}else{
				log.warn(
						GetTime.today2()+
						" -- [����] "+result.get(0).get(0) + 
						" -- [�ϰ��] " + result.get(0).get(1)	+ 
						" -- [�°��] " + result.get(0).get(2));
				dakaInfo = new String[]{result.get(0).get(1), result.get(0).get(2)};
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return dakaInfo;
	}

	/**
	 * ��¼��ϵͳ,�ɹ�����TRUE,ʧ�ܷ���FALSE
	 */
	public boolean login() {

		HttpPost post = new HttpPost("http://10.244.8.190:8081/oa/j_spring_security_check");
		HttpResponse response = null;
		HttpEntity entity = null;
		boolean result = false;
		BufferedReader br = null;
		try {
			// ��¼ϵͳ
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("j_username", username));
			params.add(new BasicNameValuePair("j_password", password));

			post.setEntity(new UrlEncodedFormEntity(params));
			response = httpClient.execute(post);

			EntityUtils.consume(response.getEntity());

			// ͨ�����ʵ�¼�����������ʾ��ҳ������֤��¼�ɹ�
			HttpGet get = new HttpGet("http://10.244.8.190:8081/oa/module/common/main.jsp");
			response = httpClient.execute(get);

			entity = response.getEntity();
			br = new BufferedReader(new InputStreamReader(entity.getContent(),"UTF-8"));

			StringBuffer sb = new StringBuffer();
			String str = null;
			while ((str = br.readLine()) != null) {
				sb.append(str);
			}

			// ��֤�Ƿ��¼�ɹ�
			str = sb.toString();
			// System.out.println(str);
			if (str.contains("�����������û����������¼ϵͳ")) {
				result = false;
			} else if (str.contains("��ӭ����")) {
				result = true;
			} else {
				result = false;
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
}
