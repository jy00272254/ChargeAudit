package cd.main;

import java.lang.reflect.Field;

import cd.util.time.GetTime;

public class Test1 {

	public static void main(String[] args) {
		try {
			Field[] sqlsFields = Class.forName("cd.precheck.sql.M_3g_7_2_1_5_sql").getFields();
			for(Field sqlsField : sqlsFields){
				String sql = (String) sqlsField.get(Class.forName("cd.precheck.sql.M_3g_7_2_1_5_sql").newInstance());
				System.out.println(sqlsField.getName());
				System.out.println(sql);
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}

}
