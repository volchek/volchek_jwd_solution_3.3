package by.tr.web.dao.command.impl.parsers;

import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import by.tr.web.entity.CD;
import by.tr.web.entity.CD_TAGS;


public class DOMHelper {

	private final static int FIRST_ELEM = 0;

	
	public static List<CD> extractInfo(Document document){
		
		List<CD> listCD = new LinkedList<CD>();
		Element root = document.getDocumentElement();
		
		NodeList cdNodes = root.getElementsByTagName(CD_TAGS.CD.name());
		CD currentCD = null;
		for (int i = 0; i < cdNodes.getLength(); ++i){
			currentCD = new CD();
			Element currentElement = (Element)cdNodes.item(i);
			String currentAttr = currentElement.getAttribute(CD_TAGS.id.name());

			currentCD.setId(Integer.parseInt(currentAttr));
			setValues(currentCD, currentElement);
			listCD.add(currentCD);
		}
		return listCD;
	}
	
	
	private static void setValues(CD currentCD, Element elem){
		currentCD.setArtist(findText(CD_TAGS.ARTIST.name(), elem));
		currentCD.setCompany(findText(CD_TAGS.COMPANY.name(), elem));
		currentCD.setCountry(findText(CD_TAGS.COUNTRY.name(), elem));
		currentCD.setTitle(findText(CD_TAGS.TITLE.name(), elem));
		String price = findText(CD_TAGS.PRICE.name(), elem);
		currentCD.setPrice(Double.parseDouble(price));
		String year = findText(CD_TAGS.YEAR.name(), elem);
		currentCD.setYear(Integer.parseInt(year));
	}
	
	
	private static String findText(String tag, Element currentElem){
		NodeList childs = currentElem.getElementsByTagName(tag);
		Element child = (Element)childs.item(FIRST_ELEM);
		String text = child.getChildNodes().item(FIRST_ELEM).getNodeValue().trim();
		return text;
	}
	
}
