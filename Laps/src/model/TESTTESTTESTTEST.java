package model;

import data.*;

public class TESTTESTTESTTEST {

	public static void main(String[] args) {

		LeaveTypeDAO lt = new LeaveTypeDAOImpl();
		try {
			System.out.println(lt.getLeaveType(2).getLeaveType().toString());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		
		
		
	}

}
