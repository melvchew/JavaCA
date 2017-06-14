package data;

import java.util.ArrayList;

import javax.persistence.*;

import java.util.*;
import model.AccessLevelDTO;
import model.DefaultLeaveDTO;
import model.UsersDTO;

public class AccessLevelDAOImpl implements AccessLevelDAO {
	
//	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("jpa-laps");
//	EntityManager em = emfactory.createEntityManager();
	EntityManager em = PersistenceManager.INSTANCE.getEntityManager();

	public AccessLevelDTO getAccessLevel(int access_level_id) throws DAOException {

		AccessLevelDTO al = em.find(AccessLevelDTO.class, access_level_id);

		return al;
	}

	public ArrayList<AccessLevelDTO> getAllAccessLevel() throws DAOException{
		List<AccessLevelDTO> accList = new ArrayList<>();
		try {
			accList = em.createQuery("SELECT a FROM AccessLevelDTO a", AccessLevelDTO.class).getResultList();
					
		} catch (Exception e) {
			String msg = "Error when get all access levels. Message: " + e;
			throw new DAOException(msg);
		}
		return accList.size() == 0? null : new ArrayList<AccessLevelDTO>(accList);
	}

}
