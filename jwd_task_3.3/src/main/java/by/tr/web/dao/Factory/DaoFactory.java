package by.tr.web.dao.Factory;

import by.tr.web.dao.UserDao;


public class DaoFactory {
	
	private static final DaoFactory instance = new DaoFactory();

	private final UserDao userDao = null;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public static DaoFactory getInstance() {
		return instance;
	}	

	private DaoFactory() {}


}
