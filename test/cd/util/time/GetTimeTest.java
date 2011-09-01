package cd.util.time;

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
}
