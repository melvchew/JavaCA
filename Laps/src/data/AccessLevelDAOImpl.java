package data;

import javax.persistence.*;
import model.AccessLevelDTO;

public class AccessLevelDAOImpl implements AccessLevelDAO {

	public AccessLevelDTO getAccessLevel(int access_level_id) throws DAOException {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("jpa-laps");
		EntityManager em = emfactory.createEntityManager();
		AccessLevelDTO al = em.find(AccessLevelDTO.class, access_level_id);

		return al;
	}

}
