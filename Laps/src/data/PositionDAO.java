package data;

import model.PositionDTO;
import model.UsersDTO;

public interface PositionDAO {

	public void insertPosition(PositionDTO dto) throws Exception;
	public void updatePosition(PositionDTO dto) throws Exception;
	public void deletePosition(PositionDTO dto) throws Exception; //update delete coloumn flag
	public PositionDTO getPosition(UsersDTO users) throws Exception;
	
}
