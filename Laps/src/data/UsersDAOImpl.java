package data;

import java.util.*;

import model.UsersDTO;
import javax.persistence.*;
import model.UsersDTO;

public class UsersDAOImpl implements UsersDAO {

//	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("jpa-laps");
//	EntityManager entitymanager = emfactory.createEntityManager();
	EntityManager entitymanager = PersistenceManager.INSTANCE.getEntityManager();

	@Override
	public void insertUser(UsersDTO DTO) throws DAOException {
		try {
			UsersDTO user = DTO;

			entitymanager.getTransaction().begin();
			entitymanager.persist(DTO);
			entitymanager.getTransaction().commit();
		} catch (Exception e) {
			String msg = "Error when inserting user. Message: " + e;
			throw new DAOException(msg);
		}
	}

	@Override
	public void updateUser(UsersDTO DTO) throws DAOException {
		try {
			UsersDTO user = entitymanager.find(UsersDTO.class, DTO.getUserId());

			entitymanager.getTransaction().begin();
			user.setUsername(DTO.getUsername());
			user.setPassword(DTO.getPassword());
			user.setPosition(DTO.getPosition());
			user.setName(DTO.getName());
			user.setDob(DTO.getDob());
			user.setPhone(DTO.getPhone());
			user.setAddress(DTO.getAddress());
			user.setEmail(DTO.getEmail());
			user.setManagerId(DTO.getManagerId());
			user.setOtHours(DTO.getOtHours());
			entitymanager.getTransaction().commit();

		} catch (Exception e) {
			String msg = "Error when updating user. Message: " + e;
			throw new DAOException(msg);
		}

	}

	@Override
	public UsersDTO getUser(String username) throws DAOException {
		List<UsersDTO> users = new ArrayList<>();

		try {
			users = entitymanager.createQuery("SELECT u FROM UsersDTO u WHERE u.username = :uname", UsersDTO.class)
					.setParameter("uname", username).getResultList();
		} catch (Exception e) {
			String msg = "Error when getting user. Message: " + e;
			throw new DAOException(msg);
		}
		return users.size() == 0 ? null : users.get(0); // return the first
														// occurrence
	}

	public ArrayList<UsersDTO> getUsersByManagerOneLevel(UsersDTO user) throws DAOException {
		List<UsersDTO> users = new ArrayList<>();
		try {
			users = entitymanager.createQuery("SELECT u FROM UsersDTO u WHERE u.managerId = :mname", UsersDTO.class)
					.setParameter("mname", user.getUserId()).getResultList();
		} catch (Exception e) {
			String msg = "Error when getting user. Message: " + e;
			throw new DAOException(msg);
		}
		return users.size() == 0 ? null : new ArrayList<UsersDTO>(users);
	}

	@Override
	public ArrayList<UsersDTO> getUsersByManager(UsersDTO user) throws DAOException {
		ArrayList<UsersDTO> tempList = getUsersByManagerOneLevel(user);
		ArrayList<UsersDTO> resultList = new ArrayList<UsersDTO>();
		while (tempList.size() != 0) { // will loop until the temp list is empty
			UsersDTO u = tempList.get(0); // get the top one
			ArrayList<UsersDTO> r = getUsersByManagerOneLevel(u); // get its
																	// children
																	// if there
																	// are any

			if (r != null) {
				for (UsersDTO x : r) {
					tempList.add(x); // add the children into the temp list
				}
			}

			resultList.add(u); // add the top one into actual result list
			tempList.remove(0); // remove the top one

		}
		return resultList.size() == 0 ? null : resultList;
	}

	@Override
	public void deleteUser(UsersDTO DTO) throws DAOException {
		try {
			UsersDTO user = entitymanager.find(UsersDTO.class, DTO.getUserId());

			entitymanager.getTransaction().begin();
			// change delete flag column to 1
			entitymanager.getTransaction().commit();

		} catch (Exception e) {
			String msg = "Error when deleting user. Message: " + e;
			throw new DAOException(msg);
		}

	}

	@Override
	public boolean checkUser(String username, String password) throws DAOException {
		List<UsersDTO> users = new ArrayList<>();

		try {
			users = entitymanager
					.createQuery("SELECT u FROM UsersDTO u WHERE u.username = :uname AND u.password = :password",
							UsersDTO.class)
					.setParameter("uname", username).setParameter("password", password).getResultList();
		} catch (Exception e) {
			String msg = "Error when checking user. Message: " + e;
			throw new DAOException(msg);
		}

		boolean result = users.size() == 0 ? false : true;
		return result;
	}
	
	@Override
	//Cornelia add on 6-13
	public ArrayList<UsersDTO> getAllUsers() throws DAOException {
		// TODO Auto-generated method stub
		List<UsersDTO> users = new ArrayList<>();
		try {
			users = entitymanager.createQuery("SELECT u FROM UsersDTO u", UsersDTO.class).getResultList();
					
		} catch (Exception e) {
			String msg = "Error when get all users. Message: " + e;
			throw new DAOException(msg);
		}
		return users.size() == 0? null : new ArrayList<UsersDTO>(users);
	}

}

