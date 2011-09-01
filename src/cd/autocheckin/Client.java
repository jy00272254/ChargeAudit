package cd.autocheckin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import cd.util.regex.CustomRegex;
import cd.util.time.GetTime;

public class Client {
	
	private HttpClient httpClient;
	private String username;
	private String password;
	private Logger log = Logger.getLogger(Client.class);

	public Client() {
	}

	public Client(HttpClient httpClient, String username, String password) {
		this.httpClient = httpClient;
		this.username = username;
		this.password = password;
	}

	public boolean checkIn() {
		if (login()) {
			log.warn("登录成功!");
			displayHis();
			daka();
			displayHis();
			logout();
			return true;
		} else {
			log.warn("登录失败!");
			return false;
		}
	}

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
	
	public void displayHis() {
		// http://10.244.8.190:8081/oa/module/common/monthlist.do

		HttpResponse response = null;
		HttpEntity entity = null;
		BufferedReader br = null;

		// 通过访问登录后才能正常显示的页面来验证登录成功
		HttpGet get = new HttpGet(
				"http://10.244.8.190:8081/oa/module/common/monthlist.do");
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

			CustomRegex cr = new CustomRegex();
			List<List<String>> result = cr
					.match(sb.toString(),
							"username:'(.*?)',empno.*?,dakaDate:'"	
							+ GetTime.today2()
							+ "',date1:'(.*?)',.*?,date4:'(.*?)',");
			
			log.warn(
					GetTime.today2()+
					" -- [姓名] "+result.get(0).get(0) + 
					" -- [上班打卡] " + result.get(0).get(1)	+ 
					" -- [下班打卡] " + result.get(0).get(2) );
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
	 * 登录打卡系统,成功返回TRUE,失败返回FALSE
	 */
	public boolean login() {

		HttpPost post = new HttpPost(
				"http://10.244.8.190:8081/oa/j_spring_security_check");
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
			HttpGet get = new HttpGet(
					"http://10.244.8.190:8081/oa/module/common/main.jsp");
			response = httpClient.execute(get);

			entity = response.getEntity();
			br = new BufferedReader(new InputStreamReader(entity.getContent(),
					"UTF-8"));

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
