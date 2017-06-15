package data;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
			PositionDTO pos = entitymanager.find(PositionDTO.class, dto.getPositionId());
			entitymanager.getTransaction().begin();
			pos.setDeleteFlag(true);
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
	public PositionDTO findPositionById(Integer id) throws Exception{
		PositionDTO positionDTO=null;
		try{
			positionDTO=entitymanager.find(PositionDTO.class, id);
		}catch (Exception e){
			
			System.out.println(e);
		}
		
		return positionDTO;
		
	}
	
	public ArrayList<PositionDTO> getAllPositions() throws Exception{
		ArrayList<PositionDTO> list = null;
		try{
			entitymanager.getTransaction().begin();
			Query query = entitymanager.createQuery("Select s from PositionDTO s WHERE s.deleteFlag != true");
			
			 list = (ArrayList<PositionDTO>)query.getResultList();
	
				//entitymanager.close();
				
				//PersistenceManager.INSTANCE.close();
		
		}catch (Exception e)
		{
			System.out.println(e);
		}
		return list;
	}

}