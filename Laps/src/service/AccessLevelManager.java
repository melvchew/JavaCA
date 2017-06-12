package service;

import data.DAOFactory;
import model.AccessLevelDTO;
import data.AccessLevelDAO;
import data.DAOException;

public class AccessLevelManager {

	private AccessLevelDAO accessLevelDAO;
	
	public AccessLevelManager(){
		accessLevelDAO = DAOFactory.getAccessLevel();
	}
	
	public AccessLevelDTO getAccessLevel(int access_level_id){
		try {
			return accessLevelDAO.getAccessLevel(access_level_id);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
