
import java.util.ArrayList;
import java.util.*;
import data.*;
import model.LeaveAppnDTO;
import model.LeaveTypeDTO;
import model.UsersDTO;
import service.DateManager;
import service.LeaveAppnManager;
import service.LeaveTypeManager;

public class TESTTESTTESTTEST {

	public static void main(String[] args) {

		LeaveAppnManager lam = new LeaveAppnManager();
		try {
			DateManager dm = new DateManager();
			UsersDAO userdao = new UsersDAOImpl();
			UsersDTO user = userdao.getUser("pete");
			LeaveTypeManager ltm = new LeaveTypeManager();
			LeaveTypeDTO lt = ltm.getLeaveType(1);
			LeaveAppnDTO dto = new LeaveAppnDTO();
			dto.setAppnDate(new Date());
			dto.setStartDate(dm.createDate("6/14/2017"));
			dto.setEndDate(dm.createDate("6/15/2017"));
			dto.setLeaveType(lt);
			dto.setUser(user);
			dto.setStatus("PENDING");
			lam.insertLeaveAppn(dto);
		}catch(Exception e)
	{
		e.printStackTrace();
	}

}

}
