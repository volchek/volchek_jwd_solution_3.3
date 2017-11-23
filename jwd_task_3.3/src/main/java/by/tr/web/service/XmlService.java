package by.tr.web.service;

import java.util.List;

import by.tr.web.entity.CD;
import by.tr.web.service.exception.ServiceException;


public interface XmlService {

	List<CD> getCD(String parserName) throws ServiceException;	

}
