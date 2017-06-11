package model;

import data.*;

public class TESTTESTTESTTEST {

	public static void main(String[] args) {

		DefaultLeaveDAO dl = new DefaultLeaveDAOImpl();
		DefaultLeaveDTO sdf = new DefaultLeaveDTO(4,3,0);
		try {
			dl.insertDL(sdf);
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
