package by.tr.web.service.impl;

import java.util.List;

import by.tr.web.entity.CD;
import by.tr.web.dao.command.DaoCommand;
import by.tr.web.dao.command.DaoCommandFactory;
import by.tr.web.dao.exceptions.DaoException;
import by.tr.web.service.XmlService;
import by.tr.web.service.exceptions.ServiceException;


public class XmlServiceImpl implements XmlService {
	
	private static final String FILENAME = "cd_catalog.xml";
	
	public List<CD> getCD(String parserName) throws ServiceException {
					
		DaoCommandFactory daoInstance = DaoCommandFactory.getInstance();
		DaoCommand commandInstance = daoInstance.getCommand(parserName);
				
		List<CD> result = null;
		try {
			result = commandInstance.getCD(FILENAME);
			System.out.println(result.size());
		}
		catch(DaoException ex){
			throw new ServiceException(ex);
		}

		return result;
	}
}
