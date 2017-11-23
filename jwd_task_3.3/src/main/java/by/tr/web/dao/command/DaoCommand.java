package by.tr.web.dao.command;

import java.util.List;

import by.tr.web.entity.CD;
import by.tr.web.dao.exceptions.DaoException;

public interface DaoCommand {
	
	List<CD> getCD(String filename) throws DaoException;
}
