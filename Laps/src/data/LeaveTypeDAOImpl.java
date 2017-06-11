package data;

import javax.persistence.*;
import model.LeaveTypeDTO;

public class LeaveTypeDAOImpl implements LeaveTypeDAO {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("jpa-laps");
	EntityManager em = emfactory.createEntityManager();

	public LeaveTypeDTO getLeaveType(int LeaveTypeId) {

		LeaveTypeDTO lt = em.find(LeaveTypeDTO.class, LeaveTypeId);
		return lt;

	}

}
