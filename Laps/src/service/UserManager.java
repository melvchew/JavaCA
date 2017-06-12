package service;
import java.util.ArrayList;

import data.DAOException;
import data.DAOFactory;
import data.UsersDAO;
import model.UsersDTO;

public class UserManager {

	private UsersDAO usersDAO;
	
	public UserManager(){
		usersDAO = DAOFactory.getUsers();
	}
	
	public void insertUser(UsersDTO DTO) throws DAOException{
		usersDAO.insertUser(DTO);
	}
	public void updateUser(UsersDTO DTO) throws DAOException{
		usersDAO.updateUser(DTO);
	}
	public UsersDTO getUser(String username) throws DAOException{
		return usersDAO.getUser(username);
	}
	public ArrayList<UsersDTO> getUsersByManager(UsersDTO user) throws DAOException{
		return usersDAO.getUsersByManager(user);
	}
	public void deleteUser(UsersDTO DTO) throws DAOException{
		usersDAO.deleteUser(DTO);
	}
	public boolean checkUser(String username, String password) throws DAOException{
		return usersDAO.checkUser(username, password);
	}
}
