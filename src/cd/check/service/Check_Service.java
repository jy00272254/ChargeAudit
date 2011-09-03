package cd.check.service;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import cd.check.sql.Check;
import cd.db2.DB2Factory;
import cd.util.check.LogCheck;
import cd.util.time.TimeFormat;

public class Check_Service {

	private static Logger log = Logger.getLogger(Check_Service.class);
	
	/**
	 * ���ָ���Ĺ�������״̬,Ĭ��ʱ���ʽΪMONTH
	 * @param procId
	 * @param time
	 * @return
	 */
	public Integer checkSingle(String procId, String time){
		return checkSingle(procId, TimeFormat.MONTH, time);
	}
	
	/**
	 * ���ָ���Ĺ�������״̬
	 * @param procId
	 * @param time
	 * @return
	 */
	public Integer checkSingle(String procId, String timeFormat, String time){
		
		// �洢����ID�����ڸ�ʽ����Ϊ��
		if(procId == null || "".equals(procId)
				|| time == null || "".equals(time))
			return null;
		
		// �洢����ID��������ڼ�����
		Map<String, String> all = ProcId.all();
		Set<String> keys = all.keySet();
		String procName = null;
		for(String key : keys){
			if(procId.equals(key)){
				procName = all.get(key);
				break;
			}
		}
		if(procName == null)
			return null;
		
		String sql = null;
		try {
			Field field = Class.forName("cd.check.sql.Check").getField(procName);
			sql = (String) field.get(Class.forName("cd.check.sql.Check").newInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		LogCheck lc = new LogCheck();
		
		int result = lc.check( timeFormat, time, sql);
		
		return result;
	
	}
	
	/**
	 * ������еĽ�������״̬
	 * @param time
	 * @return
	 */
	public List<Map<String, Integer>> checkAll(String time){
		Connection conn = DB2Factory.getConn();
		
		if(conn == null){
			log.warn("���ݿ����ӻ�ȡʧ��!");
			return null;
		}
		
		List<Map<String, Integer>> result = new ArrayList<Map<String,Integer>>();
		
		LogCheck lc = new LogCheck();
		
		// 2g ָ���ϴ�
		//7.6.2 �������ۺ�ͳ��
		Map<String, Integer>  _762 = new HashMap<String, Integer>();
		_762.put("M_2g_7_6_2_02", lc.check( TimeFormat.MONTH, time, Check.M_2g_7_6_2_02));
		_762.put("M_2g_7_6_2_03", lc.check( TimeFormat.MONTH, time, Check.M_2g_7_6_2_03));
		_762.put("M_2g_7_6_2_04", lc.check( TimeFormat.MONTH, time, Check.M_2g_7_6_2_04));
		_762.put("M_2g_7_6_2_05", lc.check( TimeFormat.MONTH, time, Check.M_2g_7_6_2_05));
		result.add(_762);
		
		//2g 8.2 �ۺ�ָ��һ
		Map<String, Integer>  _2g82 = new HashMap<String, Integer>();
		_2g82.put("M_2g_8_2", lc.check( TimeFormat.MONTH, time, Check.M_2g_8_2));
		result.add(_2g82);
		
		//2g 8.3 �ۺ�ָ��� 
		Map<String, Integer>  _2g83 = new HashMap<String, Integer>();
		_2g83.put("M_2g_8_3", lc.check( TimeFormat.MONTH, time, Check.M_2g_8_3));
		result.add(_2g83);
		
		//3g ָ���ϴ�
		//7.2.1.5 ����������ҵ��
		Map<String, Integer>  _7215 = new HashMap<String, Integer>();
		_7215.put("M_3g_7_2_1_5_02", lc.check( TimeFormat.MONTH, time, Check.M_3g_7_2_1_5_02));
		_7215.put("M_3g_7_2_1_5_03", lc.check( TimeFormat.MONTH, time, Check.M_3g_7_2_1_5_03));
		_7215.put("M_3g_7_2_1_5_05", lc.check( TimeFormat.MONTH, time, Check.M_3g_7_2_1_5_05));
		_7215.put("M_3g_7_2_1_5_06", lc.check( TimeFormat.MONTH, time, Check.M_3g_7_2_1_5_06));
		_7215.put("M_3g_7_2_1_5_09", lc.check( TimeFormat.MONTH, time, Check.M_3g_7_2_1_5_09));
		_7215.put("M_3g_7_2_1_5_11", lc.check( TimeFormat.MONTH, time, Check.M_3g_7_2_1_5_11));
		_7215.put("M_3g_7_2_1_5_13", lc.check( TimeFormat.MONTH, time, Check.M_3g_7_2_1_5_13));
		_7215.put("M_3g_7_2_1_5_15", lc.check( TimeFormat.MONTH, time, Check.M_3g_7_2_1_5_15));
		result.add(_7215);
		
		// 7.2.1.6 ����ר��������������չ�±�
		Map<String, Integer>  _7216 = new HashMap<String, Integer>();
		_7216.put("M_3g_7_2_1_6", lc.check( TimeFormat.MONTH, time, Check.M_3g_7_2_1_6));
		result.add(_7216);
		
		//7.2.3.1 ������չ��ͳ��
		Map<String, Integer>  _7231 = new HashMap<String, Integer>();
		_7231.put("M_3g_7_2_3_1_02", lc.check( TimeFormat.MONTH, time, Check.M_3g_7_2_3_1_02));
		_7231.put("M_3g_7_2_3_1_03", lc.check( TimeFormat.MONTH, time, Check.M_3g_7_2_3_1_03));
		_7231.put("M_3g_7_2_3_1_04", lc.check( TimeFormat.MONTH, time, Check.M_3g_7_2_3_1_04));
		result.add(_7231);
		
		// 7.3.1.4 ����������ҵ�����±�
		Map<String, Integer>  _7314 = new HashMap<String, Integer>();
		_7314.put("M_3g_7_3_1_4_02", lc.check( TimeFormat.MONTH, time, Check.M_3g_7_3_1_4_02));
		_7314.put("M_3g_7_3_1_4_03", lc.check( TimeFormat.MONTH, time, Check.M_3g_7_3_1_4_03));
		_7314.put("M_3g_7_3_1_4_07", lc.check( TimeFormat.MONTH, time, Check.M_3g_7_3_1_4_07));
		result.add(_7314);
		
		//7.3.1.5 ����ר������������ҵ�����±�
		Map<String, Integer>  _7315 = new HashMap<String, Integer>();
		_7315.put("M_3g_7_3_1_5", lc.check( TimeFormat.MONTH, time, Check.M_3g_7_3_1_5));
		result.add(_7315);
		
		//7.4.1.4 ��������������
		Map<String, Integer>  _7414 = new HashMap<String, Integer>();
		_7414.put("M_3g_7_4_1_4_03", lc.check( TimeFormat.MONTH, time, Check.M_3g_7_4_1_4_03));
		_7414.put("M_3g_7_4_1_4_08", lc.check( TimeFormat.MONTH, time, Check.M_3g_7_4_1_4_08));
		result.add(_7414);
		
		//7.5.1.3 �������ۺ��±�
		Map<String, Integer>  _7513 = new HashMap<String, Integer>();
		_7513.put("M_3g_7_5_1_3", lc.check( TimeFormat.MONTH, time, Check.M_3g_7_5_1_3));
		result.add(_7513);
		
		//7.5.1.4 �����������±�
		Map<String, Integer>  _7514 = new HashMap<String, Integer>();
		_7514.put("M_3g_7_5_1_4_02", lc.check( TimeFormat.MONTH, time, Check.M_3g_7_5_1_4_02));
		_7514.put("M_3g_7_5_1_4_03", lc.check( TimeFormat.MONTH, time, Check.M_3g_7_5_1_4_03));
		_7514.put("M_3g_7_5_1_4_04", lc.check( TimeFormat.MONTH, time, Check.M_3g_7_5_1_4_04));
		_7514.put("M_3g_7_5_1_4_05", lc.check( TimeFormat.MONTH, time, Check.M_3g_7_5_1_4_05));
		result.add(_7514);
		
		//7.5.1.5 �����ն����±�
		Map<String, Integer>  _7515 = new HashMap<String, Integer>();
		_7515.put("M_3g_7_5_1_5", lc.check( TimeFormat.MONTH, time, Check.M_3g_7_5_1_5));
		result.add(_7515);
		
		//7.5.1.6 ����Ӷ�����±�
		Map<String, Integer>  _7516 = new HashMap<String, Integer>();
		_7516.put("M_3g_7_5_1_6", lc.check( TimeFormat.MONTH, time, Check.M_3g_7_5_1_6));
		result.add(_7516);
		
		// 3g 8.2 �ۺ�ָ��챨һ
		Map<String, Integer>  _82 = new HashMap<String, Integer>();
		_82.put("M_3g_8_2_02", lc.check( TimeFormat.MONTH, time, Check.M_3g_8_2_02));
		_82.put("M_3g_8_2_03", lc.check( TimeFormat.MONTH, time, Check.M_3g_8_2_03));
		result.add(_82);
		
		//�������ݽӿ�
		//3.1.1.5 ����ʵ����Դ����(��)
		Map<String, Integer> _3115 = new HashMap<String, Integer>();
		_3115.put("M_ZX_3_1_1_5", lc.check( TimeFormat.DAY, null, Check.M_ZX_3_1_1_5));
		result.add(_3115);
		
		//4.1.1.1 �ͻ�
		Map<String, Integer> _4111 = new HashMap<String, Integer>();
		_4111.put("M_ZX_4_1_1_1", lc.check( TimeFormat.MONTH, time, Check.M_ZX_4_1_1_1));
		result.add(_4111);
		
		//4.1.1.2 ��֯�ͻ�
		Map<String, Integer> _4112 = new HashMap<String, Integer>();
		_4112.put("M_ZX_4_1_1_2", lc.check( TimeFormat.MONTH, time, Check.M_ZX_4_1_1_2));
		result.add(_4112);
		
		//4.1.1.3 ���˿ͻ�
		Map<String, Integer> _4113 = new HashMap<String, Integer>();
		_4113.put("M_ZX_4_1_1_3", lc.check( TimeFormat.MONTH, time, Check.M_ZX_4_1_1_3));
		result.add(_4113);
		
		//4.1.1.6 �ͻ�֤����Ϣ
		Map<String, Integer> _4116 = new HashMap<String, Integer>();
		_4116.put("M_ZX_4_1_1_6", lc.check( TimeFormat.MONTH, time, Check.M_ZX_4_1_1_6));
		result.add(_4116);
		
		//4.3.1.1 ������Ϣ
		Map<String, Integer> _4311 = new HashMap<String, Integer>();
		_4311.put("M_ZX_4_3_1_1", lc.check( TimeFormat.MONTH, time, Check.M_ZX_4_3_1_1));
		result.add(_4311);
		
		//4.3.1.2 ����Ӷ��
		Map<String, Integer> _4312 = new HashMap<String, Integer>();
		_4312.put("M_ZX_4_3_1_2", lc.check( TimeFormat.MONTH, time, Check.M_ZX_4_3_1_2));
		result.add(_4312);
		
		//4.8.1.1 ������Դ��
		Map<String, Integer> _4811 = new HashMap<String, Integer>();
		_4811.put("M_ZX_4_8_1_1", lc.check( TimeFormat.MONTH, time, Check.M_ZX_4_8_1_1));
		result.add(_4811);
		
		//3G������ϸ����
		//3.1.3.1. ������Ϣ��
		Map<String, Integer> _3131 = new HashMap<String, Integer>();
		_3131.put("M_3GMX_3_1_3_1", lc.check( TimeFormat.MONTH, time, Check.M_3GMX_3_1_3_1));
		result.add(_3131);
		
		//3.4.1. ������Ϣ
		Map<String, Integer> _341 = new HashMap<String, Integer>();
		_341.put("M_3GMX_3_4_1", lc.check( TimeFormat.MONTH, time, Check.M_3GMX_3_4_1));
		result.add(_341);
		
		DB2Factory.closeConn(conn);
		
		return result;
	}
	
	
	public static void main(String[] args) {
		try {
			Field field = Class.forName("cd.check.sql.Check").getField("M_3GMX_3_1_3_1");
			String sql = (String) field.get(Class.forName("cd.check.sql.Check").newInstance());
			System.out.println(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
