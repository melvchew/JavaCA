package data;

import model.AccessLevelDTO;

public interface AccessLevelDAO {

	AccessLevelDTO getAccessLevel(int access_level_id) throws DAOException;
	
}
