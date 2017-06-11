package data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.LeaveAppnDTO;
import model.UsersDTO;

public class LeaveAppnDAOImpl {
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("jpa-laps");
	EntityManager entitymanager = emfactory.createEntityManager();
	
	public void insertLeaveAppn(LeaveAppnDTO dto) throws Exception {
		try {

			 entitymanager.getTransaction().begin();
			  entitymanager.persist(dto);
			  entitymanager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateLeaveAppn(LeaveAppnDTO dto) throws Exception {
		try {
			LeaveAppnDTO user = entitymanager.find(LeaveAppnDTO.class, dto.getAppnId());
			entitymanager.getTransaction().begin();
			user.setStatus(dto.getStatus());
			entitymanager.getTransaction().commit();

		} catch (Exception e) {
			String msg = "Error when Updating Leave Application. Message: " + e;
			throw new DAOException(msg);
		}
	} //reject and accept leaveappn
	public void deleteLeaveAppn(LeaveAppnDTO dto) throws Exception {
		try {
			LeaveAppnDTO user = entitymanager.find(LeaveAppnDTO.class, dto.getAppnId());
			entitymanager.getTransaction().begin();
			user.setStatus("DELETED");
			entitymanager.getTransaction().commit();

		} catch (Exception e) {
			String msg = "Error when Deleting Leave Application. Message: " + e;
			throw new DAOException(msg);
		}
	} //change status column to deleted.
	public ArrayList<LeaveAppnDTO> getAllLeaveAppn() throws Exception {
		List<LeaveAppnDTO> laplist = new ArrayList<>();
		try {
			laplist = entitymanager.createQuery("SELECT u FROM LeaveAppnDTO u", LeaveAppnDTO.class).getResultList();
					
		} catch (Exception e) {
			String msg = "Error when inserting user. Message: " + e;
			throw new DAOException(msg);
		}
		return laplist.size() == 0? null : new ArrayList<LeaveAppnDTO>(laplist);
	}
	
	
	public ArrayList<LeaveAppnDTO> getLeaveAppn(UsersDTO user) throws Exception {
		List<LeaveAppnDTO> laplist = new ArrayList<>();
		try {
			laplist = entitymanager.createQuery("SELECT u FROM LeaveAppnDTO u WHERE u.userId = :uname", LeaveAppnDTO.class).setParameter("uname", user.getUserId()).getResultList();
					
		} catch (Exception e) {
			String msg = "Error when inserting user. Message: " + e;
			throw new DAOException(msg);
		}
		return laplist.size() == 0? null : new ArrayList<LeaveAppnDTO>(laplist);
	
	}
	
	
	public ArrayList<LeaveAppnDTO> getPendingLeaveAppn() throws Exception {
		List<LeaveAppnDTO> laplist = new ArrayList<>();
		try {
			laplist = entitymanager.createQuery("SELECT u FROM LeaveAppnDTO u where u.status = 'PENDING'", LeaveAppnDTO.class).getResultList();
					
		} catch (Exception e) {
			String msg = "Error when inserting user. Message: " + e;
			throw new DAOException(msg);
		}
		return laplist.size() == 0? null : new ArrayList<LeaveAppnDTO>(laplist);
	
	}
}
