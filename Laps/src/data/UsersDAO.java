package data;

import java.util.ArrayList;

import model.UsersDTO;

public interface UsersDAO {

	public void insertUser(UsersDTO DTO) throws DAOException;
	public void updateUser(UsersDTO DTO) throws DAOException;
	public UsersDTO getUser(String username) throws DAOException;
	public ArrayList<UsersDTO> getUsersByManager(UsersDTO user) throws DAOException;
	public void deleteUser(UsersDTO DTO) throws DAOException;
	public boolean checkUser(String username, String password) throws DAOException;
}
