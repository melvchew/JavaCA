package data;

import java.util.ArrayList;

import model.DefaultLeaveDTO;

public interface DefaultLeaveDAO {
	public void insertDL(DefaultLeaveDTO dl) throws Exception;
	public void updateDL(DefaultLeaveDTO dl) throws Exception;
	public void deleteDL(DefaultLeaveDTO dl) throws Exception;
	public ArrayList<DefaultLeaveDTO> getAllDL() throws Exception; 
}
