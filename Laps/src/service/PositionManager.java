package service;
import data.DAOException;
import data.DAOFactory;
import data.PositionDAO;
import model.PositionDTO;
import model.UsersDTO;

public class PositionManager {

	private PositionDAO positionDAO;
	
	public PositionManager(){
		positionDAO = DAOFactory.getPosition();
	}
	
	public void insertPosition(PositionDTO dto) throws DAOException{
		positionDAO.insertPosition(dto);
	}
	public void updatePosition(PositionDTO dto) throws DAOException{
		positionDAO.updatePosition(dto);
	}
	public void deletePosition(PositionDTO dto) throws DAOException{
		positionDAO.deletePosition(dto);
	}
	public PositionDTO getPosition(UsersDTO users) throws DAOException{
		return positionDAO.getPosition(users);
	}
}
