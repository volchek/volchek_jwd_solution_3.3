package by.tr.web.dao;

import java.util.List;
import by.tr.web.entity.CD;
import by.tr.web.dao.exceptions.DaoException;


public interface UserDao {

	List<CD> getCD(String parserName) throws DaoException;
	
}
