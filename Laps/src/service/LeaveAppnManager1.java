package service;

import java.util.ArrayList;
import data.*;
import model.LeaveAppnDTO;

public class LeaveAppnManager1 {

	private LeaveAppnDAO LeaveAppnDAO;

	public LeaveAppnManager1() {
		super();
		LeaveAppnDAO = DAOFactory.getLeaveAppn();
	}

	public ArrayList<LeaveAppnDTO> getAllLeaveForApproval() {
		ArrayList<LeaveAppnDTO> al = null;
		try {
			al = LeaveAppnDAO.getPendingLeaveAppn();
		} catch (DAOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return al;
	}

	public void approveLeave(int id) {
		LeaveAppnDTO dto = new LeaveAppnDTO();
		dto.setAppnId(id);
		dto.setStatus("APPROVED");
		try {
			LeaveAppnDAO.updateLeaveAppn(dto);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	public void rejectLeave(int id) {
		LeaveAppnDTO dto = new LeaveAppnDTO();
		dto.setAppnId(id);
		dto.setStatus("REJECTED");
		try {
			LeaveAppnDAO.updateLeaveAppn(dto);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

}