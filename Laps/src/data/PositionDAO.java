package data;

import java.util.ArrayList;
import model.PositionDTO;
import model.UsersDTO;

public interface PositionDAO {

	public void insertPosition(PositionDTO dto) throws DAOException;
	public void updatePosition(PositionDTO dto) throws DAOException;
	public void deletePosition(PositionDTO dto) throws DAOException; //update delete coloumn flag
	public PositionDTO getPosition(UsersDTO users) throws DAOException;
	public PositionDTO findPositionById(Integer id) throws Exception;
	public ArrayList<PositionDTO> getAllPositions() throws Exception; 
	
}
