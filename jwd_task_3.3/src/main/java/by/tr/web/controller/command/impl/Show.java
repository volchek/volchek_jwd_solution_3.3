package by.tr.web.controller.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.tr.web.controller.command.ControllerCommand;
import by.tr.web.controller.command.util.CommandConsts;
import by.tr.web.entity.CD;


public class Show implements ControllerCommand {
   
	private List<CD> currentCD = null;
	private static final String PAGE_Param = "page";	
	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{ 

		List<CD> result = ResultHolder.getInstance().getResult();
  
		RequestDispatcher d = null;
		int currentPage = CommandConsts.START_INDEX + 1;
				
		String pageParamValue = request.getParameter(PAGE_Param);

		if (pageParamValue != null) {
			currentPage = Integer.parseInt(pageParamValue) - 1;
		}
        
		getCDSubarray(currentPage, result);
		setAttributes(request, currentPage, result);

		d = request.getRequestDispatcher(CommandConsts.RESULT_PAGE);
		d.forward(request, response);

	}
    
    
		private void setAttributes(HttpServletRequest request, int currentPage, List<CD> result){
		request.setAttribute(CommandConsts.ATTR_NAME_TAG, currentCD);
		request.setAttribute(CommandConsts.CURRENT_PAGE_TAG, currentPage + 1);
		request.setAttribute(CommandConsts.PAGE_COUNT_TAG, result.size() / CommandConsts.RECORD_COUNT);
	}
    
    
	private void getCDSubarray(int currentPage, List<CD> result){
		if ( (currentPage * CommandConsts.RECORD_COUNT + CommandConsts.RECORD_COUNT) < result.size() ){
			currentCD = result.subList(currentPage * CommandConsts.RECORD_COUNT, currentPage * CommandConsts.RECORD_COUNT + CommandConsts.RECORD_COUNT);
		}
		else {
			currentCD = result.subList(currentPage * CommandConsts.RECORD_COUNT, result.size());
		}
	}
	
}
