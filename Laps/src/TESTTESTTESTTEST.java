
import java.util.ArrayList;
import java.util.*;
import data.*;
import model.LeaveAppnDTO;
import model.LeaveDTO;
import model.LeaveTypeDTO;
import model.UsersDTO;
import service.DateManager;
import service.LeaveAppnManager;
import service.LeaveManager;
import service.LeaveTypeManager;

public class TESTTESTTESTTEST {

	public static void main(String[] args) {
		try {
			LeaveManager lm =new LeaveManager();
			LeaveAppnManager lam = new LeaveAppnManager();
			DateManager dm = new DateManager();
			UsersDAO userdao = new UsersDAOImpl();
			UsersDTO user = userdao.getUser("pete");
			LeaveTypeManager ltm = new LeaveTypeManager();
			LeaveTypeDTO lt = ltm.getLeaveType(1);
			LeaveDTO leaveDTO = lm.getLeaveByUser(user,lt);
			double daysLeft = leaveDTO.getDaysRemaining();
			System.out.println(leaveDTO.getDaysRemaining());
		}
		catch (Exception e) {
			e.printStackTrace();
		}

}
	}
