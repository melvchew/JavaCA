package data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import model.DefaultLeaveDTO;
import model.UsersDTO;

public class DefaultLeaveDAOImpl implements DefaultLeaveDAO {

//	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("jpa-laps");
//	EntityManager em = emfactory.createEntityManager();
	EntityManager em = PersistenceManager.INSTANCE.getEntityManager();

	public void insertDL(DefaultLeaveDTO dl) throws DAOException {

		em.getTransaction().begin();
		em.persist(dl);
		em.getTransaction().commit();

	}

	public void updateDL(DefaultLeaveDTO dl) throws DAOException {

		em.getTransaction().begin();
		em.createQuery("UPDATE DefaultLeaveDTO dl SET dl.days = :d WHERE dl.positionId = :p AND " + "dl.leaveTypeId = :l")
				.setParameter("d", dl.getDays()).setParameter("p", dl.getPositionId())
				.setParameter("l", dl.getLeaveTypeId()).executeUpdate();
		em.getTransaction().commit();

	}

	public void deleteDL(DefaultLeaveDTO dl) throws DAOException {

		em.getTransaction().begin();
		em.remove(em.contains(dl) ? dl : em.merge(dl));
		em.getTransaction().commit();

	}

	public ArrayList<DefaultLeaveDTO> getAllDL() throws DAOException {

		return (ArrayList<DefaultLeaveDTO>)em.createQuery("SELECT dl FROM DefaultLeaveDTO dl").getResultList();

	}

}
