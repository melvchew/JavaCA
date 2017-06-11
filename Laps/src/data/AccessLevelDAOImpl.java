package data;

import javax.persistence.*;
import model.AccessLevelDTO;

public class AccessLevelDAOImpl implements AccessLevelDAO {
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("jpa-laps");
	EntityManager em = emfactory.createEntityManager();

	public AccessLevelDTO getAccessLevel(int access_level_id) throws DAOException {

		AccessLevelDTO al = em.find(AccessLevelDTO.class, access_level_id);

		return al;
	}

}
