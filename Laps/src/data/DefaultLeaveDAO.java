package data;

import java.util.ArrayList;

import model.DefaultLeaveDTO;

public interface DefaultLeaveDAO {

	public void insertDL(DefaultLeaveDTO dl) throws DAOException;

	public void updateDL(DefaultLeaveDTO dl) throws DAOException;

	public void deleteDL(DefaultLeaveDTO dl) throws DAOException;

	public ArrayList<DefaultLeaveDTO> getAllDL() throws DAOException;

}
