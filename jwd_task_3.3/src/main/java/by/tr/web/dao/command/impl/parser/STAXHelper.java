package by.tr.web.dao.command.impl.parser;

import java.util.LinkedList;
import java.util.List;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.tr.web.entity.CD;
import by.tr.web.entity.CDTags;


public class STAXHelper {

	
	public static List<CD> process(XMLStreamReader reader) throws XMLStreamException{
		
		List<CD> CDList = new LinkedList<CD>();
		CD currentCD = null;
		String elementName = null;

		while(reader.hasNext()){
			int eventType = reader.next();

			switch(eventType){
	
			case XMLStreamConstants.START_ELEMENT:
				elementName = reader.getLocalName();
				
				if (elementName.equals(CDTags.CD.name())){
					currentCD = new CD();
					processStartElement(reader, currentCD);
				}
				break;
			
			case XMLStreamConstants.CHARACTERS:
				processCharacters(reader, currentCD, elementName);
				break;
			
			case XMLStreamConstants.END_ELEMENT:
				processEndElement(reader, currentCD, CDList);
				elementName = null;
				break;
			}
		}

		return CDList;
	}
	
	
	private static void processStartElement(XMLStreamReader reader, CD currentCD){
		int id = Integer.parseInt(reader.getAttributeValue(null, CDTags.id.name()));
		currentCD.setId(id);
	}

	
	private static void processCharacters(XMLStreamReader reader, CD currentCD, String tagName){
		String text = reader.getText().trim();
		if (text.isEmpty()){
			return;
		}
		
		CDTags tag = CDTags.valueOf(tagName);
		switch(tag){
		case TITLE:
			currentCD.setTitle(text);
			break;
		case ARTIST:
			currentCD.setArtist(text);
			break;
		case COUNTRY:
			currentCD.setCountry(text);
			break;
		case COMPANY:
			currentCD.setCompany(text);
			break;
		case PRICE:
			currentCD.setPrice(Double.parseDouble(text));
			break;
		case YEAR:
			currentCD.setYear(Integer.parseInt(text));
			break;
		default:
			break;
		}
	}
		

	private static void processEndElement(XMLStreamReader reader, CD currentCD, List<CD> list){
		String tagName = reader.getLocalName();
		if (tagName.equals(CDTags.CD.name())){
			list.add(currentCD);
			currentCD = null;
		}
	}	
	
}
