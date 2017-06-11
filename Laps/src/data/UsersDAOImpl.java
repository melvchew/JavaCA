package data;

import java.util.ArrayList;
import model.UsersDTO;
import javax.persistence.*;

public class UsersDAOImpl implements UsersDAO {
	
	

	@Override
	public void insertUser(UsersDTO DTO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(UsersDTO DTO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UsersDTO getUser(int userid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UsersDTO> getUsersByManager(UsersDTO user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(UsersDTO DTO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkUser(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
