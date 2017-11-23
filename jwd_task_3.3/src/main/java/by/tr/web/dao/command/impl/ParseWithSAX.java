package by.tr.web.dao.command.impl;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.SAXException;
import java.util.List;
import java.io.IOException;

import by.tr.web.dao.command.DaoCommand;
import by.tr.web.dao.command.impl.parser.SAXHandler;
import by.tr.web.dao.command.impl.util.FilePathHelper;
import by.tr.web.dao.command.impl.util.Messages;
import by.tr.web.dao.exception.DaoException;
import by.tr.web.entity.CD;


public class ParseWithSAX implements DaoCommand {

	private FilePathHelper fileHelper = new FilePathHelper();	
	
	@Override
	public List<CD> getCD(String filename) throws DaoException {
		
		try {
			
			XMLReader reader = XMLReaderFactory.createXMLReader();
			
			SAXHandler handler = new SAXHandler();
			reader.setContentHandler(handler);
			reader.setErrorHandler(handler);
			
			String filePath = fileHelper.getFilePath(filename);
			reader.parse(new InputSource(filePath));
			
			List<CD> listCD = handler.getCDList();
			
			return listCD;
		}
		catch (SAXException ex) {
			throw new DaoException(Messages.PARSER_ERROR_MSG, ex);
		}
		catch(IOException ex){
			throw new DaoException(Messages.FILE_ERROR_MSG, ex);
		}
	}
	
}
