package data;

import java.util.ArrayList;

import javax.persistence.*;

import model.AccessLevelDTO;
import model.DefaultLeaveDTO;

public class DefaultLeaveDAOImpl implements DefaultLeaveDAO {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("jpa-laps");
	EntityManager entitymanager = emfactory.createEntityManager();

	public void insertDL(DefaultLeaveDTO dl) throws DAOException {

	}

	public void updateDL(DefaultLeaveDTO dl) throws DAOException {

	}

	public void deleteDL(DefaultLeaveDTO dl) throws DAOException {

	}

	public ArrayList<DefaultLeaveDTO> getAllDL() throws DAOException {
		AccessLevelDTO al = entitymanager.find(AccessLevelDTO.class, );

		return al;
	}

}
