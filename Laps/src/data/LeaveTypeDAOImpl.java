package data;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import model.LeaveAppnDTO;
import model.LeaveTypeDTO;

public class LeaveTypeDAOImpl implements LeaveTypeDAO {

	EntityManager em = PersistenceManager.INSTANCE.getEntityManager();

	public LeaveTypeDTO getLeaveType(int LeaveTypeId) throws DAOException {

		LeaveTypeDTO lt = em.find(LeaveTypeDTO.class, LeaveTypeId);
		return lt;

	}

	public ArrayList<LeaveTypeDTO> getAllLeaveTypes() throws DAOException {
		List<LeaveTypeDTO> lt = em.createQuery("SELECT u FROM LeaveTypeDTO u", LeaveTypeDTO.class).getResultList();
		return lt.size() == 0 ? null : (ArrayList<LeaveTypeDTO>) lt;
	}

	public void updateLeaveType(LeaveTypeDTO lt) throws DAOException {
		em.getTransaction().begin();
		em.createQuery("UPDATE LeaveTypeDTO lt SET lt.leaveType = :p WHERE lt.leaveTypeId = :d")
				.setParameter("p", lt.getLeaveType()).setParameter("d", lt.getLeaveTypeId()).executeUpdate();
		em.getTransaction().commit();
	}

	public void insertLeaveType(LeaveTypeDTO lt) throws DAOException {
		em.getTransaction().begin();
		em.persist(lt);
		em.getTransaction().commit();

	}

}
