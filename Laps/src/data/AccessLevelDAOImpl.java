package data;

import java.util.ArrayList;

import javax.persistence.*;
import model.AccessLevelDTO;
import model.DefaultLeaveDTO;

public class AccessLevelDAOImpl implements AccessLevelDAO {
	
//	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("jpa-laps");
//	EntityManager em = emfactory.createEntityManager();
	EntityManager em = PersistenceManager.INSTANCE.getEntityManager();

	public AccessLevelDTO getAccessLevel(int access_level_id) throws DAOException {

		AccessLevelDTO al = em.find(AccessLevelDTO.class, access_level_id);

		return al;
	}



}
