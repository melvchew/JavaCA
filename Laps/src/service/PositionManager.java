package service;
import java.util.ArrayList;

import data.DAOException;
import data.DAOFactory;
import data.PositionDAO;
import model.HolidaysDTO;
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
	
	public PositionDTO findPositionById(Integer id) throws Exception{
		return positionDAO.findPositionById(id);
	}
	public ArrayList<PositionDTO> getAllPositions() throws Exception{
		return positionDAO.getAllPositions();
	}
}