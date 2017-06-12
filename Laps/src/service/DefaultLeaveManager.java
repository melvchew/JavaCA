package service;

import java.util.ArrayList;

import data.DAOException;
import data.DAOFactory;
import data.DefaultLeaveDAO;
import model.DefaultLeaveDTO;

public class DefaultLeaveManager {

	private DefaultLeaveDAO defaultLeaveDAO;
	
	public DefaultLeaveManager(){
		defaultLeaveDAO = DAOFactory.getDefaultLeave();
	}
	
	public void insertDL(DefaultLeaveDTO dl) throws DAOException{
		defaultLeaveDAO.insertDL(dl);
	}

	public void updateDL(DefaultLeaveDTO dl) throws DAOException{
		defaultLeaveDAO.updateDL(dl);
	}

	public void deleteDL(DefaultLeaveDTO dl) throws DAOException{
		defaultLeaveDAO.deleteDL(dl);
	}

	public ArrayList<DefaultLeaveDTO> getAllDL() throws DAOException{
		return defaultLeaveDAO.getAllDL();
	}
}
