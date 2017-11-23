package by.tr.web.dao.command.impl;

import java.io.IOException;
import java.util.List;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import by.tr.web.dao.command.DaoCommand;
import by.tr.web.dao.command.impl.parser.DOMHelper;
import by.tr.web.dao.command.impl.util.FilePathHelper;
import by.tr.web.dao.command.impl.util.Messages;
import by.tr.web.dao.exception.DaoException;
import by.tr.web.entity.CD;


public class ParseWithDOM implements DaoCommand {

	private FilePathHelper fileHelper = new FilePathHelper();
	private DOMParser parser = new DOMParser();
	
	
	@Override
	public List<CD> getCD(String filename) throws DaoException {		

		try {
			parser = new DOMParser();

			String filePath = fileHelper.getFilePath(filename);
			parser.parse(filePath);
			
			Document doc = parser.getDocument();
	        List<CD> listCD = DOMHelper.extractInfo(doc);
	        
	        return listCD;
		}
		catch (SAXException ex){
			throw new DaoException(Messages.PARSER_ERROR_MSG, ex);
		}
		catch(IOException ex){
			throw new DaoException(Messages.FILE_ERROR_MSG, ex);
		}
	}
}
