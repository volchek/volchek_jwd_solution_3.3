package by.tr.web.dao.command.impl.parser;

import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import by.tr.web.entity.CD;
import by.tr.web.entity.CDTags;


public class DOMHelper {

	private final static int FIRST_ELEM = 0;

	
	public static List<CD> extractInfo(Document document){
		
		List<CD> listCD = new LinkedList<CD>();
		Element root = document.getDocumentElement();
		
		NodeList cdNodes = root.getElementsByTagName(CDTags.CD.name());
		CD currentCD = null;
		for (int i = 0; i < cdNodes.getLength(); ++i){
			currentCD = new CD();
			Element currentElement = (Element)cdNodes.item(i);
			String currentAttr = currentElement.getAttribute(CDTags.id.name());

			currentCD.setId(Integer.parseInt(currentAttr));
			setValues(currentCD, currentElement);
			listCD.add(currentCD);
		}
		return listCD;
	}
	
	
	private static void setValues(CD currentCD, Element elem){
		currentCD.setArtist(findText(CDTags.ARTIST.name(), elem));
		currentCD.setCompany(findText(CDTags.COMPANY.name(), elem));
		currentCD.setCountry(findText(CDTags.COUNTRY.name(), elem));
		currentCD.setTitle(findText(CDTags.TITLE.name(), elem));
		String price = findText(CDTags.PRICE.name(), elem);
		currentCD.setPrice(Double.parseDouble(price));
		String year = findText(CDTags.YEAR.name(), elem);
		currentCD.setYear(Integer.parseInt(year));
	}
	
	
	private static String findText(String tag, Element currentElem){
		NodeList childs = currentElem.getElementsByTagName(tag);
		Element child = (Element)childs.item(FIRST_ELEM);
		String text = child.getChildNodes().item(FIRST_ELEM).getNodeValue().trim();
		return text;
	}
	
}
