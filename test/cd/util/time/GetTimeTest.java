package cd.util.time;

import java.util.List;

import org.junit.Test;

public class GetTimeTest {

	@Test
	public void testCurrMonth(){
		System.out.println(GetTime.currMonth());
	}
	
	@Test
	public void testToday1(){
		System.out.println(GetTime.today1());
	}
	
	@Test
	public void testToday2(){
		System.out.println(GetTime.today2());
	}
	
	@Test
	public void testYesterday(){
		System.out.println(GetTime.yesterday());
	}
	
	@Test
	public void testFromTo(){
		List<String> result = GetTime.fromTo("20110901", "20110930", TimeFormat.DAY);
		for(String s : result ){
			System.out.println(s);
		}
	}
	
	@Test
	public void testFromTo1(){
		List<String> result = GetTime.fromTo("20110801", -2, TimeFormat.DAY);
		for(String s : result ){
			System.out.println(s);
		}
	}
}
