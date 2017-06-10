package data;

import java.util.ArrayList;

import model.UsersDTO;

public interface UsersDAO {

	public void insertUser(UsersDTO DTO) throws Exception;
	public void updateUser(UsersDTO DTO) throws Exception;
	public UsersDTO getUser(int userid) throws Exception;
	public ArrayList<UsersDTO> getUsersByManager(UsersDTO user) throws Exception;
	public void deleteUser(UsersDTO DTO) throws Exception;
	public boolean checkUser(String username, String password) throws Exception;
}
