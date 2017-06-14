package model;
import java.util.ArrayList;
import java.util.Date;

import data.*;
import service.DateManager;
import service.LeaveAppnManager;

public class TestByZach {

	public static void main(String[] args) throws Exception {
		
		UsersDAO ud = new UsersDAOImpl();
		UsersDTO user = ud.getUser("AAA");
//		
//		LeaveTypeDAO ltd = DAOFactory.getLeaveType();
//		LeaveTypeDTO lt = ltd.getLeaveType(1);
//		
		DateManager dm = new DateManager();
//		
//		LeaveAppnDAO lad = DAOFactory.getLeaveAppn();
//		LeaveAppnDTO leave = new LeaveAppnDTO();
//		leave.setUser(user);
//		leave.setLeaveType(lt);
//		leave.setAppnDate(new Date());
//		leave.setStartDate(dm.createDate("06/12/2017"));
//		leave.setEndDate(dm.createDate("06/16/2017"));
//		leave.setStatus("PENDING");
//		
//		lad.insertLeaveAppn(leave);
		
		HolidaysDAO hd = DAOFactory.getHolidaysDAOInstance();
		System.out.println(hd.isHoliday(dm.createDate("01/02/2017")));
		
		LeaveAppnManager lap = new LeaveAppnManager();
		int dayDiff = lap.getNumberOfLeaveDays(dm.createDate("06/12/2017") , dm.createDate("06/26/2017"));
		
		System.out.println("Date diff is " + dayDiff);
		
//		boolean isAvailable = lap.isAvailable(user, dm.createDate("05/08/2017"), dm.createDate("05/10/2017"));
//		System.out.println(isAvailable);
//		
//		isAvailable = lap.isAvailable(user, dm.createDate("05/10/2017"), dm.createDate("05/13/2017"));
//		System.out.println(isAvailable);
		
//		user.setUsername("AAA");
//		user.setPassword("AAA");
//		user.setName("AAA");
//		user.setEmail("email");
//		user.setOtHours(0);
//		user.setDob(new service.DateManager().createDate("08/10/1993"));
//		
//		ArrayList<String> list = new ArrayList<>();
//		list.add("A");
//		list.add("B");
//		list.add("C");
		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//		
//		list.remove(0);
//		list.remove(0);
//		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
		try {
//			ud.updateUser(user);
			Date d = dm.createDate("08/10/2012");
			System.out.println(d.toString());
//			
//			user.setName("BBB");
//			ud.updateUser(user);
//			System.out.println("user updated!");
//			
//			UsersDTO aUser = ud.getUser("AAA");
//			System.out.println(aUser.getEmail());
////			
////			UsersDTO bUser = ud.getUser("CCC");
////			System.out.println(bUser == null? "Nothing": "Something");
////			
//			ArrayList<UsersDTO> users = ud.getUsersByManager(aUser);
//			System.out.println(users == null? "Nothing again": "There is something");
//			
//			for (UsersDTO u : users) {
//				System.out.println(u.getUserId());
//			}
			
//			boolean b = ud.checkUser("AAA", "BBB");
//			System.out.println(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		
	}

}
