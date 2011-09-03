package cd.check.service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ProcId {

	public static final String P_MID_M_3G_WIRELESS_INDEX = "P_MID_M_3G_WIRELESS_INDEX";
	// 2g 指标上传
	// 7.6.2 渠道类综合统计
	public static final String M_2g_7_6_2_02 = "M_2g_7_6_2_02";
	public static final String M_2g_7_6_2_03 = "M_2g_7_6_2_03";
	public static final String M_2g_7_6_2_04 = "M_2g_7_6_2_04";
	public static final String M_2g_7_6_2_05 = "M_2g_7_6_2_05";
	// 2g 8.2 综合指标一
	public static final String M_2g_8_2 = "M_2g_8_2";
	// 2g 8.3 综合指标二
	public static final String M_2g_8_3 = "M_2g_8_3";

	// 3g 指标上传
	// 7.2.1.5 无线上网卡业务
	public static final String M_3g_7_2_1_5_02 = "M_3g_7_2_1_5_02";
	public static final String M_3g_7_2_1_5_03 = "M_3g_7_2_1_5_03";
	public static final String M_3g_7_2_1_5_05 = "M_3g_7_2_1_5_05";
	public static final String M_3g_7_2_1_5_06 = "M_3g_7_2_1_5_06";
	public static final String M_3g_7_2_1_5_09 = "M_3g_7_2_1_5_09";
	public static final String M_3g_7_2_1_5_11 = "M_3g_7_2_1_5_11";
	public static final String M_3g_7_2_1_5_13 = "M_3g_7_2_1_5_13";
	public static final String M_3g_7_2_1_5_15 = "M_3g_7_2_1_5_15";
	// 7.2.1.6 定制专用无线上网卡发展月报
	public static final String M_3g_7_2_1_6 = "M_3g_7_2_1_6";
	// 7.2.3.1 渠道发展类统计
	public static final String M_3g_7_2_3_1_02 = "M_3g_7_2_3_1_02";
	public static final String M_3g_7_2_3_1_03 = "M_3g_7_2_3_1_03";
	public static final String M_3g_7_2_3_1_04 = "M_3g_7_2_3_1_04";
	// 7.3.1.4 无线上网卡业务量月报
	public static final String M_3g_7_3_1_4_02 = "M_3g_7_3_1_4_02";
	public static final String M_3g_7_3_1_4_03 = "M_3g_7_3_1_4_03";
	public static final String M_3g_7_3_1_4_07 = "M_3g_7_3_1_4_07";
	// 7.3.1.5 定制专用无线上网卡业务量月报
	public static final String M_3g_7_3_1_5 = "M_3g_7_3_1_5";
	// 7.4.1.4 无线上网卡收入
	public static final String M_3g_7_4_1_4_03 = "M_3g_7_4_1_4_03";
	public static final String M_3g_7_4_1_4_08 = "M_3g_7_4_1_4_08";
	// 7.5.1.3 渠道类综合月报
	public static final String M_3g_7_5_1_3 = "M_3g_7_5_1_3";
	// 7.5.1.4 渠道数量类月报
	public static final String M_3g_7_5_1_4_02 = "M_3g_7_5_1_4_02";
	public static final String M_3g_7_5_1_4_03 = "M_3g_7_5_1_4_03";
	public static final String M_3g_7_5_1_4_04 = "M_3g_7_5_1_4_04";
	public static final String M_3g_7_5_1_4_05 = "M_3g_7_5_1_4_05";
	// 7.5.1.5 渠道终端类月报
	public static final String M_3g_7_5_1_5 = "M_3g_7_5_1_5";
	// 7.5.1.6 渠道佣金类月报
	public static final String M_3g_7_5_1_6 = "M_3g_7_5_1_6";
	// 3g 8.2 综合指标快报一
	public static final String M_3g_8_2_02 = "M_3g_8_2_02";
	public static final String M_3g_8_2_03 = "M_3g_8_2_03";

	// 纵向数据接口
	// 3.1.1.5 订购实例资源属性(日)
	public static final String M_ZX_3_1_1_5 = "M_ZX_3_1_1_5";
	// 4.1.1.1 客户
	public static final String M_ZX_4_1_1_1 = "M_ZX_4_1_1_1";
	// 4.1.1.2 组织客户
	public static final String M_ZX_4_1_1_2 = "M_ZX_4_1_1_2";
	// 4.1.1.3 个人客户
	public static final String M_ZX_4_1_1_3 = "M_ZX_4_1_1_3";
	// 4.1.1.6 客户证件信息
	public static final String M_ZX_4_1_1_6 = "M_ZX_4_1_1_6";
	// 4.3.1.1 渠道信息
	public static final String M_ZX_4_3_1_1 = "M_ZX_4_3_1_1";
	// 4.3.1.2 渠道佣金
	public static final String M_ZX_4_3_1_2 = "M_ZX_4_3_1_2";
	// 4.8.1.1 号码资源表
	public static final String M_ZX_4_8_1_1 = "M_ZX_4_8_1_1";

	// 3G核心明细数据
	// 3.1.3.1. 渠道信息表
	public static final String M_3GMX_3_1_3_1 = "M_3GMX_3_1_3_1";
	// 3.4.1. 扇区信息
	public static final String M_3GMX_3_4_1 = "M_3GMX_3_4_1";

	/**
	 * 获取所有定义的常量值,用于service中判定传入值是否合法.
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
