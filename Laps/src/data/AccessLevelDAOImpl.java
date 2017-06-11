package data;

import javax.persistence.*;
import model.AccessLevelDTO;

public class AccessLevelDAOImpl implements AccessLevelDAO {

	public AccessLevelDTO getAccessLevel(int access_level_id) throws Exception {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("jpa-laps");
		EntityManager entitymanager = emfactory.createEntityManager();
		AccessLevelDTO al = entitymanager.find(AccessLevelDTO.class, access_level_id);

		return al;
	}

}
