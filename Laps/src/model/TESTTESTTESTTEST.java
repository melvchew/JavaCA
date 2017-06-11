package model;

import data.*;

public class TESTTESTTESTTEST {

	public static void main(String[] args) {

		AccessLevelDAO al = new AccessLevelDAOImpl();
		try {
			al.getAccessLevel(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
