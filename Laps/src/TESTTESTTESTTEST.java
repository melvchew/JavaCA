
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
		try {
			LeaveTypeManager ltm = new LeaveTypeManager();
			LeaveTypeDTO dto = new LeaveTypeDTO(1,"Annual");
			ltm.updateLeavetype(dto);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

}
	}
