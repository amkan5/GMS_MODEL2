package tamplate;


import domain.MemberBean;
import enums.Domain;
import java.lang.reflect.Field;

public class ColumnFinder {
	public static String find(Domain dom) {
		String s ="";
		Class<MemberBean> clazz = null;
		switch (dom) {
		case MEMBER :
			clazz=MemberBean.class;
			break;
		default:
			break;
		}
		Field[] f = clazz.getDeclaredFields();
		for (int i=0;i<f.length;i++) {
			s+=(i!=(f.length-i))?
					f[i].getName().toUpperCase()+",":
						f[i].getName().toUpperCase();
		}
	return s;
	}
}
