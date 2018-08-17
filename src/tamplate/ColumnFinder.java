package tamplate;


import domain.ImageBean;
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
		case IMAGE :
			break;
		default:
			break;
		}
		Field[] f = clazz.getDeclaredFields();
		for (int i=0;i<f.length;i++) {
			s+=(i!=(f.length-1))?
					f[i].getName().toUpperCase()+",":
						f[i].getName().toUpperCase();
		}
		System.out.println("column finder : " + s);
	return s;
	}
}
