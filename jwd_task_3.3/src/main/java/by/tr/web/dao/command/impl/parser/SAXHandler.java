package by.tr.web.dao.command.impl.parser;

import java.util.List;
import java.util.LinkedList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import by.tr.web.entity.CD;
import by.tr.web.entity.CDTags;


public class SAXHandler extends DefaultHandler {

	private List<CD> CDList = new LinkedList<CD>();
	private CD currentCD = null;
	private StringBuilder content = null;

	
	public List<CD> getCDList(){
		return CDList;
	}
	
	
	@Override
	public void startElement(String uri, String localName, String qName, 
					Attributes attributes) throws SAXException {
		content = new StringBuilder();
		if(localName.equals(CDTags.CD.name())){
			currentCD = new CD();
			int id = Integer.parseInt(attributes.getValue(CDTags.id.name()));
			currentCD.setId(id);
		}
	}
	 
	
	@Override
	public void characters(char[] buffer, int start, int length){
		content.append(buffer, start, length);
	}

	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		CDTags tag = CDTags.valueOf(localName);
		
		switch(tag){
		case TITLE:
			currentCD.setTitle(content.toString());
			break;
		case ARTIST:
			currentCD.setArtist(content.toString());
			break;
		case COUNTRY:
			currentCD.setCountry(content.toString());
			break;
		case COMPANY:
			currentCD.setCompany(content.toString());
			break;
		case PRICE:
			currentCD.setPrice(Double.parseDouble(content.toString()));
			break;
		case YEAR:
			currentCD.setYear(Integer.parseInt(content.toString()));
			break;
		case CD:
			CDList.add(currentCD);
			currentCD = null;
			break;
		default:
			break;
		}
	}
	
	@Override
	public void warning(SAXParseException ex){
		System.err.println(ex.getMessage());
	}
	
	
	@Override
	public void error(SAXParseException ex){
		System.err.println(ex.getMessage());
	}
	
	@Override
	public void fatalError(SAXParseException ex) throws SAXParseException{
		System.err.println(ex.getMessage());
		throw(ex);
	}
	
}
