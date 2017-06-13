package model;

import java.util.ArrayList;

import data.*;
import service.LeaveAppnManager1;

public class TESTTESTTESTTEST {

	public static void main(String[] args) {

		LeaveAppnManager1 lam = new LeaveAppnManager1();
		try {
			ArrayList<LeaveAppnDTO> al = lam.getAllLeaveForApproval();
			for (LeaveAppnDTO i : al) {
				System.out.println(i.getStartDate().toString());
				System.out.println("\n");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
