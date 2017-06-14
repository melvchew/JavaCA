package data;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.DefaultLeaveDTO;
import model.LeaveDTO;
import model.LeaveTypeDTO;
import model.UsersDTO;

public class LeaveDAOImpl implements LeaveDAO {
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("jpa-laps");
	EntityManager entitymanager = emfactory.createEntityManager();
	
	public void insertLeave(LeaveDTO leave)throws DAOException {
		try {
			
			entitymanager.getTransaction().begin();
			entitymanager.persist(leave);
			entitymanager.getTransaction().commit();
		} catch (Exception e) {
			String msg = "Error when inserting leave. Message: " + e;
			throw new DAOException(msg);
		}
				
	
	}
	public void updateLeave(LeaveDTO leave)throws DAOException {
		
		entitymanager.getTransaction().begin();
		entitymanager.createQuery("UPDATE LeaveDTO leave SET leave.daysRemaining = :d WHERE leave.userId = :u AND " + "leave.leaveTypeId = :l")
				.setParameter("d", leave.getDaysRemaining()).setParameter("u", leave.getUserId())
				.setParameter("l", leave.getLeaveTypeId()).executeUpdate();
		entitymanager.getTransaction().commit();


			
	}
	public void deleteLeave(UsersDTO user) throws DAOException {
		
		
		entitymanager.getTransaction().begin();
		entitymanager.createQuery("DELETE FROM LeaveDTO leave WHERE leave.userId = :u")
				.setParameter("u", user.getUserId()).executeUpdate();
		entitymanager.getTransaction().commit();
		
	}
	public ArrayList<LeaveDTO> getLeave(UsersDTO user) {
		
		List<LeaveDTO> leaveList;
		
		leaveList = entitymanager.createQuery("SELECT leave FROM LeaveDTO leave WHERE leave.userId = :u", LeaveDTO.class)
				.setParameter("u", user.getUserId()).getResultList();
		
		return leaveList.size() == 0 ? null : new ArrayList<>(leaveList);
	}
	@Override
	public LeaveDTO getLeaveByUser(UsersDTO user, LeaveTypeDTO leave) throws Exception {
		LeaveID leaveid = new LeaveID();
		leaveid.setLeaveTypeId(leave.getLeaveTypeId());
		leaveid.setUserId(user.getUserId());
		LeaveDTO dto = entitymanager.find(LeaveDTO.class, leaveid); 
		return dto;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	

}
