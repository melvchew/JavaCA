package data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import model.OtClaimsDTO;
import model.UsersDTO;

public class OtClaimsDAOImpl implements OtClaimsDAO{

	EntityManager entitymanager = PersistenceManager.INSTANCE.getEntityManager();

	public void insertOtClaims(OtClaimsDTO dto) throws DAOException{
		try{
			 entitymanager.getTransaction().begin();
			  entitymanager.persist(dto);
			  entitymanager.getTransaction().commit();
			PersistenceManager.INSTANCE.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}//Create new OverTime Claim
	
	public void updateOtClaims(OtClaimsDTO dto) throws DAOException{
		try{
			OtClaimsDTO user = entitymanager.find(OtClaimsDTO.class, dto.getClaimId());
			entitymanager.getTransaction().begin();
			user.setStatus(dto.getStatus());
			entitymanager.getTransaction().commit();
			PersistenceManager.INSTANCE.close();
		}
		catch(Exception e){
			String msg = "Error when Updating Leave Application. Message: " + e;
			throw new DAOException(msg);
		}
	}//Accept/Reject OverTime Claim
	
	public void deleteOtClaims(OtClaimsDTO dto) throws DAOException{
		try{
			OtClaimsDTO user = entitymanager.find(OtClaimsDTO.class, dto.getClaimId());
			entitymanager.getTransaction().begin();
			user.setStatus("DELETED");
			entitymanager.getTransaction().commit();
		}
		catch(Exception e){
			String msg = "Error when Deleting Leave Application. Message: " + e;
			throw new DAOException(msg);
		}
	}//Change OverTime Claim status to "DELETED"
	
	public ArrayList<OtClaimsDTO> getAllOtClaims() throws DAOException{
		List<OtClaimsDTO> lotlist = new ArrayList<>();
		try {
			lotlist = entitymanager.createQuery("SELECT u FROM OtClaimsDTO u", OtClaimsDTO.class).getResultList();
					
		} catch (Exception e) {
			String msg = "Error when inserting user. Message: " + e;
			throw new DAOException(msg);
		}
		return lotlist.size() == 0? null : new ArrayList<OtClaimsDTO>(lotlist);
	}
	
	public ArrayList<OtClaimsDTO> getOtClaims(UsersDTO user) throws DAOException{
		List<OtClaimsDTO> lotlist = new ArrayList<>();
		try {
			lotlist = entitymanager.createQuery("SELECT u FROM OtClaimsDTO u WHERE u.claimId = :uname", OtClaimsDTO.class).setParameter("uname", user.getUserId()).getResultList();
					
		} catch (Exception e) {
			String msg = "Error when inserting user. Message: " + e;
			throw new DAOException(msg);
		}
		return lotlist.size() == 0? null : new ArrayList<OtClaimsDTO>(lotlist);
	}
	
	public ArrayList<OtClaimsDTO> getPendingOtClaims() throws DAOException{
		List<OtClaimsDTO> lotlist = new ArrayList<>();
		try {
			lotlist = entitymanager.createQuery("SELECT u FROM OtClaimsDTO u where u.status = 'PENDING'", OtClaimsDTO.class).getResultList();
					
		} catch (Exception e) {
			String msg = "Error when inserting user. Message: " + e;
			throw new DAOException(msg);
		}
		return lotlist.size() == 0? null : new ArrayList<OtClaimsDTO>(lotlist);
	}
	
}