package cd.zb;

import java.util.List;

import org.junit.Test;

public class TestZB_CONSTANT {

	@Test
	public void testSQL(){
		List<String> result = ZB_CONSTANT.ҵ��ʹ����_SQL;
		
		for(String s : result){
			System.out.println(s.replaceFirst("\\?", "'20110916'"));
		}
	}
}
