package cd.audit.sql;

public class M_3g_7_2_1_5_02_audit_sql {

	/**
	 * 	���д���	10 bytes	���б���	��дʵ�ʵ��б���	�� in{ ȫ�� }
	 * ����䷵����Ŀ��Ϊ�ռ�ͨ������

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
	 * �Ŷ�����	2 bytes	�Ŷ�����	����Ҫ��186�Ŷ��û�  = ��01�� ��186�Ŷ��û�= ��02��	�� IN{ 01,02 }
	 * ����䷵����ĿΪ�ռ�ͨ������
	 
		select distinct IS_186 
		from REPORT.ZB_DEV_M_3G_05_02 
		where month_no='201106' and IS_186 not in ('01','02');
	 */
	public static final String _02_IS_186 = "select distinct IS_186 " +
			"from REPORT.ZB_DEV_M_3G_05_02 " +
			"where month_no=? and IS_186 not in ('01','02');";
	
	/**
	 * ��������Ʒ������	4 bytes	��Ʒ������	Ԥ���Ѳ�Ʒ��һ=��0101��
		Ԥ���Ѳ�Ʒ����=��0102��
		Ԥ���Ѳ�Ʒ����=��0103��
		Ԥ���Ѳ�Ʒ����=��0104��
		Ԥ���Ѳ�Ʒ����=��0105��
		Ԥ���Ѳ�Ʒ����=��0106��
		Ԥ���Ѳ�Ʒ����=��0107��
		�󸶷Ѳ�Ʒ��һ=��0201��
		�󸶷Ѳ�Ʒ����=��0202��
		�󸶷Ѳ�Ʒ����=��0203��
		�󸶷Ѳ�Ʒ����=��0204��
		������Ʒ��=��9999	
		�� IN{ 0101,0102,0103,0104,0105��0106��0107��0201,0202��0203��0204��9999}
	 *  ����䷵����ĿΪ�ռ�ͨ������
	 
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
	 * ��ʼ�ײ�����	4 bytes	�ײ�����	����ֻ�ϴ����±��룺
		������������׼�ʷ�  =��0002��
		50Ԫ/��ѧ���ײ�= ��0200��
		80Ԫ/���ײ�=   ��0201��
		150Ԫ/���ײ�=  ��0202��
		200Ԫ/���ײ�=  ��0203��
		300Ԫ/���ײ�= ��0204��
		3GB���꿨�ײ�= ��0205��
		6GB�꿨�ײ�  = ��0206��
		�ּ�ͥ������ײ� 20Ԫ/��  = ��0230��
		�ּ�ͥ������ײ� 300Ԫ/�� = ��0231��
		��.��ͥ��������������������ײ�=��0239��		
		�� IN{��0002��,��0200��, ��0201��, ��0202��, ��0203��, ��0204��,��0205��,��0206������0230������0231����0239��}
	 * ����䷵����ĿΪ�ռ�ͨ������
	 
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
	 * ��Ʒ����	2 bytes	��Ʒ����	��ȫ��	�� = ȫ��
	 * ����䷵����ĿΪ3��ͨ������
	 
		select DISTINCT PRO_TYPE 
		from REPORT.ZB_DEV_M_3G_05_02 
		where month_no='201106' AND PRO_TYPE IN ('01','02','03')
	 */
	public static final String _02_PRO_TYPE = "select DISTINCT PRO_TYPE " +
			"from REPORT.ZB_DEV_M_3G_05_02 " +
			"where month_no=? AND PRO_TYPE IN ('01','02','03');";
	
	
	/**
	 * �ɷ�ģʽ	2 bytes	�ɷ�ģʽ	ʡ�󸶷�=��1A��
		ȫ��Ԥ����=��2B��
		ʡԤ����  =��2A��	�� = { 1A��2B,2A }
		���ɷ�ģʽΪ2Bʱ����������˾�
	 * ����䷵����ĿΪ�ռ�ͨ������
	 
		select DISTINCT pay_mode 
		from REPORT.ZB_DEV_M_3G_05_02 
		where month_no='201106' AND pay_mode NOT IN ('1A','2A')
	 */
	public static final String _02_PAY_MODE = "select DISTINCT pay_mode " +
			"from REPORT.ZB_DEV_M_3G_05_02 " +
			"where month_no=? AND pay_mode NOT IN ('1A','2A')";
}
