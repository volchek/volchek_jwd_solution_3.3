package by.tr.web.controller.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.tr.web.controller.command.ControllerCommand;
import by.tr.web.controller.command.util.CommandConsts;
import by.tr.web.controller.exception.ControllerException;
import by.tr.web.entity.CD;
import by.tr.web.service.XmlService;
import by.tr.web.service.factory.ServiceFactory;
import by.tr.web.service.exception.ServiceException;


public class Parse implements ControllerCommand {
	
	private static final String PARSER_TYPE = "parser";
    
    
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		ServiceFactory serviceObject = ServiceFactory.getInstance();        
		XmlService xmlObject = serviceObject.getUserService();
		
		String parser = request.getParameter(PARSER_TYPE);

		RequestDispatcher d = null;
		
		try {
			List<CD> result = xmlObject.getCD(parser);
			
			ResultHolder.getInstance().setResult(result);
			
			if (result != null && !result.isEmpty()){
				request.setAttribute(CommandConsts.ATTR_NAME_TAG, result.subList(CommandConsts.START_INDEX, CommandConsts.RECORD_COUNT));
				request.setAttribute(CommandConsts.PAGE_COUNT_TAG, result.size() / CommandConsts.RECORD_COUNT);
				request.setAttribute(CommandConsts.CURRENT_PAGE_TAG, CommandConsts.START_INDEX);
				d = request.getRequestDispatcher(CommandConsts.RESULT_PAGE);
			}
			else { d = request.getRequestDispatcher(CommandConsts.CONTENT_ERROR_PAGE); }
		}
		catch(ServiceException ex){
			d = request.getRequestDispatcher(CommandConsts.PARSER_ERROR_PAGE);
		}
		
		d.forward(request, response);
		
	}
}

