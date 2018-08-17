package repository;

import java.util.HashMap;
import java.util.Map;
import domain.ImageBean;
import tamplate.*;

public class ImageDAOImpl implements ImageDAO{
	private static ImageDAO instance = new ImageDAOImpl();
	public static ImageDAO getInstance() {
		return instance;
	}
	
	QueryTamplate q;
	@Override
	public void insert(Map<?, ?> param) {
		Map<String, Object> map = new HashMap<>();
		map.put("value1", param.get("value1"));
		map.put("value2", param.get("value2"));
		map.put("value3", param.get("value3"));
		map.put("table", param.get("table"));
		q = new AddQuery(); //테이블
		q.play((HashMap<String, Object>) map);
	}

	@Override
	public ImageBean selectOne(String id) {
		q = new RetrieveQuery();
		Map<String, Object> param = new HashMap<>();
		System.out.println("이미지 DAO select one : "+id);
		param.put("memId", id);
		param.put("table", "IMAGE");
		q.play((HashMap<String, Object>) param);
		return (ImageBean) q.getO();
	}

}
