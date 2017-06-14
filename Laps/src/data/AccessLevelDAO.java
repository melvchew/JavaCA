package data;

import java.util.ArrayList;

import antlr.collections.List;
import model.AccessLevelDTO;

public interface AccessLevelDAO {

	AccessLevelDTO getAccessLevel(int access_level_id) throws DAOException;
	
	public ArrayList<AccessLevelDTO> getAllAccessLevel() throws DAOException;


	
}
