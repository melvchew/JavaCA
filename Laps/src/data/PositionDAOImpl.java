package data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.PositionDTO;
import model.UsersDTO;

public class PositionDAOImpl implements PositionDAO {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("jpa-laps");
	EntityManager entitymanager = emfactory.createEntityManager();

	@Override
	public void insertPosition(PositionDTO dto) throws DAOException {
		try {

			entitymanager.getTransaction().begin();
			entitymanager.persist(dto);
			entitymanager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updatePosition(PositionDTO dto) throws DAOException {
		try {
			PositionDTO user = entitymanager.find(PositionDTO.class, dto.getPositionId());
			entitymanager.getTransaction().begin();
			// user.setStatus(dto.getStatus());
			entitymanager.getTransaction().commit();

		} catch (Exception e) {
			String msg = "Error when Updating Leave Application. Message: " + e;
			throw new DAOException(msg);
		}
	}

	@Override
	public void deletePosition(PositionDTO dto) throws DAOException {
		try {
			PositionDTO user = entitymanager.find(PositionDTO.class, dto.getPositionId());
			entitymanager.getTransaction().begin();
			// user.setStatus("DELETED");
			entitymanager.getTransaction().commit();

		} catch (Exception e) {
			String msg = "Error when Deleting Leave Application. Message: " + e;
			throw new DAOException(msg);
		}
	}

	@Override
	public PositionDTO getPosition(UsersDTO users) throws DAOException {
		// TODO Auto-generated method stub
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("jpa-laps");
		EntityManager entitymanager = emfactory.createEntityManager();
		PositionDTO p = entitymanager.find(PositionDTO.class, users.getPosition());
		return p;
	}

	@Override
	public PositionDTO getPosition(int positionId) throws DAOException {
		// TODO Auto-generated method stub
		PositionDTO p = entitymanager.find(PositionDTO.class, positionId);
		return p;
	}

}
