package model;

import java.util.ArrayList;
import data.*;

public class TESTTESTTESTTEST {

	public static void main(String[] args) {

		DefaultLeaveDAO dl = new DefaultLeaveDAOImpl();

		try {
			ArrayList<DefaultLeaveDTO> a = dl.getAllDL();
			for (DefaultLeaveDTO s : a) {
				System.out.println(s.getPositionId() + " " + s.getLeaveTypeId() + " " + s.getDays());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
