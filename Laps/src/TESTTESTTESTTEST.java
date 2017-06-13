

import java.util.ArrayList;

import data.*;
import model.LeaveAppnDTO;
import service.LeaveAppnManager;

public class TESTTESTTESTTEST {

	public static void main(String[] args) {

		LeaveAppnManager lam = new LeaveAppnManager();
		try {
			ArrayList<LeaveAppnDTO> al = lam.getPendingLeaveAppn();
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
