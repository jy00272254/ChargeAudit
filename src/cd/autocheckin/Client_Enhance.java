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
 * 自动打开程序.
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
	 * 获取下次打卡时间
	 * 得到的是代表时间的毫秒数
	 * @return
	 */
	public long nextDakaTime(){
		
		long result = 0;
		
		Calendar c = new GregorianCalendar();
		//当前时间
		long curr = c.getTimeInMillis(); 
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), 8, 30, 0);
		// 今天早上8点30分
		long _0830 = c.getTimeInMillis();
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), 18, 30, 0);
		// 今天下午6点30分
		long _1630 = c.getTimeInMillis();
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)+1, 8, 30, 0);
		// 明天早上8点30分
		long _0830n = c.getTimeInMillis();
		
		// 如果当前时间小于早上8点30分,取得早上打卡时间
		if(curr <= _0830){
			result = _0830;
		}
		// 如果当前时间大于早上8点30分且小于下午6点30分,取得下午打卡时间
		if(curr > _0830 && curr <= _1630){
			result = _1630;
		}
		// 如果当前时间大于下午6点30分,取得明天早上8点30分打卡时间
		if( curr > _1630){
			result = _0830n;
		}
		return result;
	}
	
	/**
	 * 综合打卡
	 * @return
	 */
	public boolean checkIn() {
		
		// 获得下次打卡时间
		long nextDakaTime = nextDakaTime();
		log.warn("获取下次打卡时间...");
		// 获取当前时间
		long currTime = System.currentTimeMillis();
		// 判断时间是否到达打卡时间
		log.warn("判断时间是否到达打卡时间...");
		while(currTime < nextDakaTime){
			//未到打卡时间,延迟时间
			SleepTime.Sleep(120000);
			currTime = System.currentTimeMillis();
			log.warn("未到达打卡时间,延时...");
		}
		log.warn("到达打卡时间,登录系统...");
		
		// 到达打卡时间,登录系统
		int loginCount = 0;
		while(!login()){
			log.warn("登录失败,延时后尝试重新登录,登录次数:" + (loginCount+1));
			SleepTime.Sleep(5000);
			loginCount ++ ;
			if(loginCount >= 3){
				log.warn("登录次数到达阈值,程序退出.");
				return false;
			}
		}
		log.warn("登录成功...");
		
		// 判断是否已经打卡
		int displayHisCount = 0;
		String[] dakaInfo = displayHis();
		while(dakaInfo == null){
			SleepTime.Sleep(5000);
			displayHisCount ++;
			if(loginCount >= 3){
				log.warn("获取信息次数到达阈值,未获得打开信息,直接开始打卡...");
				break;
			}
		}
		
		return false;
	}

	/**
	 * 注销,退出打卡系统
	 */
	public void logout(){
		HttpResponse response = null;
		// 注销登录
		HttpGet get = new HttpGet(
				"http://10.244.8.190:8081/oa/j_spring_security_logout");
		//http://10.244.8.190:8081/oa/j_spring_security_logout
		try {
			response = httpClient.execute(get);
			EntityUtils.consume(response.getEntity());
			log.warn("注销成功!");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 打卡
	 */
	public void daka(){
		HttpResponse response = null;
		HttpEntity entity = null;
		BufferedReader br = null;

		// 打卡下班
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
	 * 显示当前打卡消息,返回流用于判断打卡是否成功
	 */
	public String[] displayHis() {
		// http://10.244.8.190:8081/oa/module/common/monthlist.do

		HttpResponse response = null;
		HttpEntity entity = null;
		BufferedReader br = null;
		String[] dakaInfo = null;

		// 通过访问登录后才能正常显示的页面来验证登录成功
//		HttpGet get = new HttpGet("http://10.244.8.190:8081/oa/module/common/monthlist.do");
		//公司的打卡系统的日期是按照 25-24号来的,用GET在特定几天不能取到时间.需要用POST指定时间
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
				log.warn("没有读取到打卡数据");
			}else{
				log.warn(
						GetTime.today2()+
						" -- [姓名] "+result.get(0).get(0) + 
						" -- [上班打卡] " + result.get(0).get(1)	+ 
						" -- [下班打卡] " + result.get(0).get(2));
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
	 * 登录打卡系统,成功返回TRUE,失败返回FALSE
	 */
	public boolean login() {

		HttpPost post = new HttpPost("http://10.244.8.190:8081/oa/j_spring_security_check");
		HttpResponse response = null;
		HttpEntity entity = null;
		boolean result = false;
		BufferedReader br = null;
		try {
			// 登录系统
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("j_username", username));
			params.add(new BasicNameValuePair("j_password", password));

			post.setEntity(new UrlEncodedFormEntity(params));
			response = httpClient.execute(post);

			EntityUtils.consume(response.getEntity());

			// 通过访问登录后才能正常显示的页面来验证登录成功
			HttpGet get = new HttpGet("http://10.244.8.190:8081/oa/module/common/main.jsp");
			response = httpClient.execute(get);

			entity = response.getEntity();
			br = new BufferedReader(new InputStreamReader(entity.getContent(),"UTF-8"));

			StringBuffer sb = new StringBuffer();
			String str = null;
			while ((str = br.readLine()) != null) {
				sb.append(str);
			}

			// 验证是否登录成功
			str = sb.toString();
			// System.out.println(str);
			if (str.contains("请输入您的用户名和密码登录系统")) {
				result = false;
			} else if (str.contains("欢迎您，")) {
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
