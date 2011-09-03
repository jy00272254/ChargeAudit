package cd.check.service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ProcId {

	public static final String P_MID_M_3G_WIRELESS_INDEX = "P_MID_M_3G_WIRELESS_INDEX";
	// 2g ָ���ϴ�
	// 7.6.2 �������ۺ�ͳ��
	public static final String M_2g_7_6_2_02 = "M_2g_7_6_2_02";
	public static final String M_2g_7_6_2_03 = "M_2g_7_6_2_03";
	public static final String M_2g_7_6_2_04 = "M_2g_7_6_2_04";
	public static final String M_2g_7_6_2_05 = "M_2g_7_6_2_05";
	// 2g 8.2 �ۺ�ָ��һ
	public static final String M_2g_8_2 = "M_2g_8_2";
	// 2g 8.3 �ۺ�ָ���
	public static final String M_2g_8_3 = "M_2g_8_3";

	// 3g ָ���ϴ�
	// 7.2.1.5 ����������ҵ��
	public static final String M_3g_7_2_1_5_02 = "M_3g_7_2_1_5_02";
	public static final String M_3g_7_2_1_5_03 = "M_3g_7_2_1_5_03";
	public static final String M_3g_7_2_1_5_05 = "M_3g_7_2_1_5_05";
	public static final String M_3g_7_2_1_5_06 = "M_3g_7_2_1_5_06";
	public static final String M_3g_7_2_1_5_09 = "M_3g_7_2_1_5_09";
	public static final String M_3g_7_2_1_5_11 = "M_3g_7_2_1_5_11";
	public static final String M_3g_7_2_1_5_13 = "M_3g_7_2_1_5_13";
	public static final String M_3g_7_2_1_5_15 = "M_3g_7_2_1_5_15";
	// 7.2.1.6 ����ר��������������չ�±�
	public static final String M_3g_7_2_1_6 = "M_3g_7_2_1_6";
	// 7.2.3.1 ������չ��ͳ��
	public static final String M_3g_7_2_3_1_02 = "M_3g_7_2_3_1_02";
	public static final String M_3g_7_2_3_1_03 = "M_3g_7_2_3_1_03";
	public static final String M_3g_7_2_3_1_04 = "M_3g_7_2_3_1_04";
	// 7.3.1.4 ����������ҵ�����±�
	public static final String M_3g_7_3_1_4_02 = "M_3g_7_3_1_4_02";
	public static final String M_3g_7_3_1_4_03 = "M_3g_7_3_1_4_03";
	public static final String M_3g_7_3_1_4_07 = "M_3g_7_3_1_4_07";
	// 7.3.1.5 ����ר������������ҵ�����±�
	public static final String M_3g_7_3_1_5 = "M_3g_7_3_1_5";
	// 7.4.1.4 ��������������
	public static final String M_3g_7_4_1_4_03 = "M_3g_7_4_1_4_03";
	public static final String M_3g_7_4_1_4_08 = "M_3g_7_4_1_4_08";
	// 7.5.1.3 �������ۺ��±�
	public static final String M_3g_7_5_1_3 = "M_3g_7_5_1_3";
	// 7.5.1.4 �����������±�
	public static final String M_3g_7_5_1_4_02 = "M_3g_7_5_1_4_02";
	public static final String M_3g_7_5_1_4_03 = "M_3g_7_5_1_4_03";
	public static final String M_3g_7_5_1_4_04 = "M_3g_7_5_1_4_04";
	public static final String M_3g_7_5_1_4_05 = "M_3g_7_5_1_4_05";
	// 7.5.1.5 �����ն����±�
	public static final String M_3g_7_5_1_5 = "M_3g_7_5_1_5";
	// 7.5.1.6 ����Ӷ�����±�
	public static final String M_3g_7_5_1_6 = "M_3g_7_5_1_6";
	// 3g 8.2 �ۺ�ָ��챨һ
	public static final String M_3g_8_2_02 = "M_3g_8_2_02";
	public static final String M_3g_8_2_03 = "M_3g_8_2_03";

	// �������ݽӿ�
	// 3.1.1.5 ����ʵ����Դ����(��)
	public static final String M_ZX_3_1_1_5 = "M_ZX_3_1_1_5";
	// 4.1.1.1 �ͻ�
	public static final String M_ZX_4_1_1_1 = "M_ZX_4_1_1_1";
	// 4.1.1.2 ��֯�ͻ�
	public static final String M_ZX_4_1_1_2 = "M_ZX_4_1_1_2";
	// 4.1.1.3 ���˿ͻ�
	public static final String M_ZX_4_1_1_3 = "M_ZX_4_1_1_3";
	// 4.1.1.6 �ͻ�֤����Ϣ
	public static final String M_ZX_4_1_1_6 = "M_ZX_4_1_1_6";
	// 4.3.1.1 ������Ϣ
	public static final String M_ZX_4_3_1_1 = "M_ZX_4_3_1_1";
	// 4.3.1.2 ����Ӷ��
	public static final String M_ZX_4_3_1_2 = "M_ZX_4_3_1_2";
	// 4.8.1.1 ������Դ��
	public static final String M_ZX_4_8_1_1 = "M_ZX_4_8_1_1";

	// 3G������ϸ����
	// 3.1.3.1. ������Ϣ��
	public static final String M_3GMX_3_1_3_1 = "M_3GMX_3_1_3_1";
	// 3.4.1. ������Ϣ
	public static final String M_3GMX_3_4_1 = "M_3GMX_3_4_1";

	/**
	 * ��ȡ���ж���ĳ���ֵ,����service���ж�����ֵ�Ƿ�Ϸ�.
	 * @return
	 */
	public static Map<String, String> all() {
		Map<String, String> all = new HashMap<String, String>();
		try {
			@SuppressWarnings("unchecked")
			Class<ProcId> procId = (Class<ProcId>) Class.forName("cd.check.service.ProcId");
			Field[] fields = procId.getFields();

			for (Field field : fields) {
				all.put(field.getName(), (String) field.get(procId.newInstance()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return all;
	}

	public static void main(String[] args) {
		Map<String, String> result = ProcId.all();
		Set<String> keys = result.keySet();
		for(String key : keys){
			System.out.println(key + " -- " + result.get(key));
		}
	}

}
