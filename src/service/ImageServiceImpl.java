package service;

import java.util.Map;

import domain.ImageBean;
import repository.ImageDAO;
import repository.ImageDAOImpl;

public class ImageServiceImpl implements ImageService{
	private static ImageService instance = new ImageServiceImpl();
	public static ImageService getInstance() {
		return instance;
	}
	@Override
	public void add(Map<?,?> param) {
		ImageDAOImpl.getInstance().insert(param);
	}

	@Override
	public ImageBean retrieve(String id) {
		return ImageDAOImpl.getInstance().selectOne(id);
	}

}
