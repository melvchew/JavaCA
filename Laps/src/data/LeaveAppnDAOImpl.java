package data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.LeaveAppnDTO;
import model.UsersDTO;

public class LeaveAppnDAOImpl implements LeaveAppnDAO {

	EntityManager entitymanager = PersistenceManager.INSTANCE.getEntityManager();

	public void insertLeaveAppn(LeaveAppnDTO dto) throws DAOException {
		try {

			entitymanager.getTransaction().begin();
			entitymanager.persist(dto);
			entitymanager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateLeaveAppn(LeaveAppnDTO dto) throws DAOException {
		try {
			LeaveAppnDTO user = entitymanager.find(LeaveAppnDTO.class, dto.getAppnId());
			entitymanager.getTransaction().begin();
			dto.setStatus(dto.getStatus());
			entitymanager.getTransaction().commit();

		} catch (Exception e) {
			String msg = "Error when Updating Leave Application. Message: " + e;
			throw new DAOException(msg);
		}
	} // reject and accept leaveappn

	public void deleteLeaveAppn(LeaveAppnDTO dto) throws DAOException {
		try {
			LeaveAppnDTO user = entitymanager.find(LeaveAppnDTO.class, dto.getAppnId());
			entitymanager.getTransaction().begin();
			user.setStatus("DELETED");
			entitymanager.getTransaction().commit();

		} catch (Exception e) {
			String msg = "Error when Deleting Leave Application. Message: " + e;
			throw new DAOException(msg);
		}
	} // change status column to deleted.

	public ArrayList<LeaveAppnDTO> getAllLeaveAppn() throws DAOException {
		List<LeaveAppnDTO> laplist = new ArrayList<>();
		try {
			laplist = entitymanager.createQuery("SELECT u FROM LeaveAppnDTO u", LeaveAppnDTO.class).getResultList();

		} catch (Exception e) {
			String msg = "Error when inserting user. Message: " + e;
			throw new DAOException(msg);
		}
		return laplist.size() == 0 ? null : new ArrayList<LeaveAppnDTO>(laplist);
	}

	public ArrayList<LeaveAppnDTO> getLeaveAppn(UsersDTO user) throws DAOException {
		List<LeaveAppnDTO> laplist = new ArrayList<>();
		try {
			laplist = entitymanager
					.createQuery("SELECT u FROM LeaveAppnDTO u WHERE u.user.userId = :uname", LeaveAppnDTO.class)
					.setParameter("uname", user.getUserId()).getResultList();

		} catch (Exception e) {
			String msg = "Error when inserting user. Message: " + e;
			throw new DAOException(msg);
		}
		return laplist.size() == 0 ? null : new ArrayList<LeaveAppnDTO>(laplist);

	}

	public ArrayList<LeaveAppnDTO> getPendingLeaveAppn() throws DAOException {
		List<LeaveAppnDTO> laplist = new ArrayList<>();
		try {
			laplist = entitymanager
					.createQuery("SELECT u FROM LeaveAppnDTO u where u.status = 'PENDING' or u.status = 'UPDATED'",
							LeaveAppnDTO.class)
					.getResultList();

		} catch (Exception e) {
			String msg = "Error when inserting user. Message: " + e;
			throw new DAOException(msg);
		}
		return laplist.size() == 0 ? null : new ArrayList<LeaveAppnDTO>(laplist);

	}
	
	public LeaveAppnDTO getLeaveAppn(int leaveAppnId) throws DAOException{
		LeaveAppnDTO leaveAppn;
		try {
			leaveAppn = entitymanager.find(LeaveAppnDTO.class, leaveAppnId);
		} catch (Exception e) {
			String msg = "Error when inserting user. Message: " + e;
			throw new DAOException(msg);
		}
		return leaveAppn;
	}
}
