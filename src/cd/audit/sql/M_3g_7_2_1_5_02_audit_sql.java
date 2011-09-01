package cd.audit.sql;

public class M_3g_7_2_1_5_02_audit_sql {

	/**
	 * 	城市代码	10 bytes	地市编码	填写实际地市编码	■ in{ 全集 }
	 * 该语句返回数目不为空即通过稽核

		select a.city_no,b.area_no_3g
		from 
		(select city_no from REPORT.ZB_DEV_M_3G_05_02 where month_no='201106') a
		inner join
		(select area_no_3g from dim.dim_area where area_no_3g is not null) b
		on
		a.city_no=b.area_no_3g;
	 */
	public static final String _02_CITY_NO = "select a.city_no,b.area_no_3g " +
			"from " +
			"(select city_no from REPORT.ZB_DEV_M_3G_05_02 where month_no=?) a " +
			"inner join " +
			"(select area_no_3g from dim.dim_area where area_no_3g is not null) b " +
			"on " +
			"a.city_no=b.area_no_3g;";
	
	/**
	 * 号段类型	2 bytes	号段类型	本期要求：186号段用户  = “01” 非186号段用户= “02”	■ IN{ 01,02 }
	 * 该语句返回数目为空即通过稽核
	 
		select distinct IS_186 
		from REPORT.ZB_DEV_M_3G_05_02 
		where month_no='201106' and IS_186 not in ('01','02');
	 */
	public static final String _02_IS_186 = "select distinct IS_186 " +
			"from REPORT.ZB_DEV_M_3G_05_02 " +
			"where month_no=? and IS_186 not in ('01','02');";
	
	/**
	 * 上网卡产品包类型	4 bytes	产品包类型	预付费产品包一=“0101”
		预付费产品包二=“0102”
		预付费产品包三=“0103”
		预付费产品包四=“0104”
		预付费产品包五=“0105”
		预付费产品包六=“0106”
		预付费产品包七=“0107”
		后付费产品包一=“0201”
		后付费产品包二=“0202”
		后付费产品包三=“0203”
		后付费产品包四=“0204”
		其他产品包=“9999	
		■ IN{ 0101,0102,0103,0104,0105，0106，0107，0201,0202，0203，0204，9999}
	 *  该语句返回数目为空即通过稽核
	 
		select distinct product_type 
		from REPORT.ZB_DEV_M_3G_05_02 
		where month_no='201106' 
			and product_type not in 
			('0101','0102','0103','0104','0105','0106','0107','0201','0202','0203','0204','9999');
	 */
	public static final String _02_PRODUCT_TYPE = "select distinct product_type " +
			"from REPORT.ZB_DEV_M_3G_05_02 " +
			"where month_no=? and " +
			"product_type not in " +
			"('0101','0102','0103','0104','0105','0106','0107','0201','0202','0203','0204','9999');";
	
	/**
	 * 初始套餐类型	4 bytes	套餐类型	本期只上传以下编码：
		无线上网卡标准资费  =“0002”
		50元/月学生套餐= “0200”
		80元/月套餐=   “0201”
		150元/月套餐=  “0202”
		200元/月套餐=  “0203”
		300元/月套餐= “0204”
		3GB半年卡套餐= “0205”
		6GB年卡套餐  = “0206”
		沃家庭捆绑的套餐 20元/月  = “0230”
		沃家庭捆绑的套餐 300元/年 = “0231”
		沃.家庭捆绑的无线上网卡其他套餐=‘0239’		
		■ IN{“0002”,“0200”, “0201”, “0202”, “0203”, “0204”,“0205”,“0206”，“0230”，“0231”“0239”}
	 * 该语句返回数目为空即通过稽核
	 
		select distinct INIT_DINNER_TYPE 
		from REPORT.ZB_DEV_M_3G_05_02 
		where month_no='201106'AND INIT_DINNER_TYPE not in 
			('0002','0200', '0201','0202','0203','0204', '0205','0206','0230','0231','0239');
	 */
	public static final String _02_INIT_DINNER_TYPE = "select distinct INIT_DINNER_TYPE " +
			"from REPORT.ZB_DEV_M_3G_05_02 " +
			"where month_no=? AND INIT_DINNER_TYPE not in " +
			"('0002','0200', '0201','0202','0203','0204', '0205','0206','0230','0231','0239');";
	
	
	/**
	 * 产品类型	2 bytes	产品类型	传全集	■ = 全集
	 * 该语句返回数目为3即通过稽核
	 
		select DISTINCT PRO_TYPE 
		from REPORT.ZB_DEV_M_3G_05_02 
		where month_no='201106' AND PRO_TYPE IN ('01','02','03')
	 */
	public static final String _02_PRO_TYPE = "select DISTINCT PRO_TYPE " +
			"from REPORT.ZB_DEV_M_3G_05_02 " +
			"where month_no=? AND PRO_TYPE IN ('01','02','03');";
	
	
	/**
	 * 缴费模式	2 bytes	缴费模式	省后付费=“1A”
		全国预付费=“2B”
		省预付费  =“2A”	■ = { 1A，2B,2A }
		当缴费模式为2B时，仅北京公司填报
	 * 该语句返回数目为空即通过稽核
	 
		select DISTINCT pay_mode 
		from REPORT.ZB_DEV_M_3G_05_02 
		where month_no='201106' AND pay_mode NOT IN ('1A','2A')
	 */
	public static final String _02_PAY_MODE = "select DISTINCT pay_mode " +
			"from REPORT.ZB_DEV_M_3G_05_02 " +
			"where month_no=? AND pay_mode NOT IN ('1A','2A')";
}
