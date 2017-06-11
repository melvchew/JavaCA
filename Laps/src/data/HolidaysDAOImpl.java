package data;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.HolidaysDTO;
import data.PersistenceManager;

public class HolidaysDAOImpl implements HolidaysDAO {
	
	EntityManager entitymanager = PersistenceManager.INSTANCE.getEntityManager();
	
	@Override
	public void insertHoliday(HolidaysDTO dto) throws Exception{
	try{
		entitymanager.persist(dto);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		PersistenceManager.INSTANCE.close();
	} catch(Exception e){
		
		System.out.println(e);
	}
	}
    
	@Override
	public void updateHoliday(HolidaysDTO dto) throws Exception{
		try{
			entitymanager.find(HolidaysDTO.class, dto.getDate());
			entitymanager.getTransaction().commit();
			entitymanager.close();
			PersistenceManager.INSTANCE.close();
			
		} catch(Exception e){
			System.out.println(e);
		}
		
	}


	@Override
	public void deleteHoliday(HolidaysDTO dto) throws Exception {
		
		try{
			entitymanager.remove(dto);
			entitymanager.getTransaction().commit();
			entitymanager.close();
			PersistenceManager.INSTANCE.close();
			
		} catch(Exception e){
			System.out.println(e);
		}
		
	}

	@Override
	public ArrayList<HolidaysDTO> getAllHolidays() throws Exception {
		ArrayList<HolidaysDTO> list = null;
		try{
			Query query = entitymanager.createQuery("Select s from HolidaysDTO s");
			
			 list = (ArrayList<HolidaysDTO>)query.getResultList();
	
				entitymanager.close();
				
				PersistenceManager.INSTANCE.close();
		
		
		
		}catch (Exception e)
		{
			System.out.println(e);
		}
		return list;
		
	}
}