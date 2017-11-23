package by.tr.web.controller.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ControllerCommand {

	void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
