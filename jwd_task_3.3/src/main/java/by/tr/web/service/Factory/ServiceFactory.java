package by.tr.web.service.Factory;

import by.tr.web.service.XmlService;
import by.tr.web.service.impl.XmlServiceImpl;


public final class ServiceFactory {

	private static final ServiceFactory instance = new ServiceFactory();

	private final XmlService userService = new XmlServiceImpl();
	
	
	public XmlService getUserService() {
		return userService;
	}

	public static ServiceFactory getInstance() {
		return instance;
	}	

	private ServiceFactory() {}


}
