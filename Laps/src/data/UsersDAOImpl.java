package data;

import java.util.*;

import model.UsersDTO;
import javax.persistence.*;
import model.UsersDTO;

public class UsersDAOImpl implements UsersDAO {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("jpa-laps");
	EntityManager entitymanager = emfactory.createEntityManager();

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
			user.setPositionId(DTO.getPositionId());
			user.setName(DTO.getName());
			user.setDob(DTO.getDob());
			user.setPhone(DTO.getPhone());
			user.setAddress(DTO.getAddress());
			user.setEmail(DTO.getEmail());
			user.setManagerId(DTO.getManagerId());
			user.setOtHours(DTO.getOtHours());
			entitymanager.getTransaction().commit();

		} catch (Exception e) {
			String msg = "Error when inserting user. Message: " + e;
			throw new DAOException(msg);
		}

	}

	@Override
	public UsersDTO getUser(String username) throws DAOException {
		UsersDTO user = new UsersDTO();

		try {
			user = entitymanager.createQuery("SELECT u FROM TABLE users WHERE u.username = :uname", UsersDTO.class)
					.setParameter("uname", username).getSingleResult();
		} catch (Exception e) {
			String msg = "Error when inserting user. Message: " + e;
			throw new DAOException(msg);
		}
		return user;
	}

	@Override
	public ArrayList<UsersDTO> getUsersByManager(UsersDTO user) throws DAOException {
		List<UsersDTO> users = new ArrayList<>();
		try {
			users = entitymanager.createQuery("SELECT u FROM TABLE users WHERE u.manager_id = :mname", UsersDTO.class)
					.setParameter("uname", user.getUserId()).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ArrayList<UsersDTO>(users);
	}

	@Override
	public void deleteUser(UsersDTO DTO) throws DAOException {
		try {
			UsersDTO user = entitymanager.find(UsersDTO.class, DTO.getUserId());

			entitymanager.getTransaction().begin();
			// change delete flag column to 1
			entitymanager.getTransaction().commit();

		} catch (Exception e) {
			String msg = "Error when inserting user. Message: " + e;
			throw new DAOException(msg);
		}

	}

	@Override
	public boolean checkUser(String username, String password) throws DAOException {
		UsersDTO user = new UsersDTO();

		try {
			user = entitymanager.createQuery("SELECT u FROM TABLE users WHERE u.username = :uname AND u.password = :password", UsersDTO.class)
					.setParameter("uname", username).setParameter("password", password).getSingleResult();
		} catch (Exception e) {
			String msg = "Error when inserting user. Message: " + e;
			throw new DAOException(msg);
		}
		
		boolean result = user.getUsername().equals(null)? false : true;
		return result;
	}

}
