package by.tr.web.dao.command.impl;

import java.io.InputStream;
import java.io.FileNotFoundException;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;

import by.tr.web.dao.command.DaoCommand;
import by.tr.web.dao.command.impl.parsers.STAXHelper;
import by.tr.web.dao.command.impl.util.FilePathHelper;
import by.tr.web.dao.command.impl.util.Messages;
import by.tr.web.dao.exceptions.DaoException;
import by.tr.web.entity.CD;


public class ParseWithSTAX implements DaoCommand {

	private FilePathHelper fileHelper = new FilePathHelper();
	private XMLInputFactory staxFactory = XMLInputFactory.newInstance();

	
	@Override
	public List<CD> getCD(String filename) throws DaoException  {
		
		List<CD> listCD = null;
		
		try {
			
			InputStream fileStream = fileHelper.getFileStream(filename);
			
			XMLStreamReader reader = staxFactory.createXMLStreamReader(fileStream);
			listCD = STAXHelper.process(reader);			
			
			return listCD;
		}
		catch (XMLStreamException e) {
			throw new DaoException(Messages.PARSER_ERROR_MSG, e);
		}
		catch(FileNotFoundException e){
			throw new DaoException(Messages.FILE_ERROR_MSG, e);
		}
	}
}
