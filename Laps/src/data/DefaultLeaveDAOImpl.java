package data;

import java.util.ArrayList;

import javax.persistence.*;

import model.DefaultLeaveDTO;

public class DefaultLeaveDAOImpl implements DefaultLeaveDAO {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("jpa-laps");
	EntityManager em = emfactory.createEntityManager();

	public void insertDL(DefaultLeaveDTO dl) throws DAOException {

		em.getTransaction().begin();
		em.persist(dl);
		em.getTransaction().commit();

	}

	public void updateDL(DefaultLeaveDTO dl) throws DAOException {

	}

	public void deleteDL(DefaultLeaveDTO dl) throws DAOException {

	}

	public ArrayList<DefaultLeaveDTO> getAllDL() throws DAOException {
		// AccessLevelDTO al = entitymanager.find(AccessLevelDTO.class, );

		return null;
	}

}
