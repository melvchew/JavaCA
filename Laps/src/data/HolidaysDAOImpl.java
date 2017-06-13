package data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.HolidaysDTO;
import data.PersistenceManager;
//some comm
public class HolidaysDAOImpl implements HolidaysDAO {
	
EntityManager entitymanager = PersistenceManager.INSTANCE.getEntityManager();
	
	@Override
	public void insertHoliday(HolidaysDTO dto) throws Exception{
	try{
		entitymanager.getTransaction().begin();
		entitymanager.persist(dto);
		entitymanager.getTransaction().commit();
		//entitymanager.close();
		//PersistenceManager.INSTANCE.close();
	} catch(Exception e){
		
		System.out.println(e);
	}
	}
    
	@Override
	public void updateHoliday(HolidaysDTO dto) throws Exception{
		try{
			entitymanager.getTransaction().begin();
			HolidaysDTO holidaysDTO =entitymanager.find(HolidaysDTO.class, dto.getDate());
			holidaysDTO.setDescription(dto.getDescription());
			entitymanager.getTransaction().commit();
			//entitymanager.close();
			//PersistenceManager.INSTANCE.close();
			
		} catch(Exception e){
			System.out.println(e);
		}
		
	}


	@Override
	public void deleteHoliday(HolidaysDTO dto) throws Exception {
		
		try{
			entitymanager.getTransaction().begin();
			entitymanager.remove(entitymanager.getReference(HolidaysDTO.class,dto.getDate()));
			entitymanager.getTransaction().commit();
			//entitymanager.close();
			//PersistenceManager.INSTANCE.close();
			
		} catch(Exception e){
			System.out.println(e);
		}
		
	}

	@Override
	public ArrayList<HolidaysDTO> getAllHolidays() throws Exception {
		ArrayList<HolidaysDTO> list = null;
		try{
			entitymanager.getTransaction().begin();
			Query query = entitymanager.createQuery("Select s from HolidaysDTO s");
			
			 list = (ArrayList<HolidaysDTO>)query.getResultList();
	
				//entitymanager.close();
				
				//PersistenceManager.INSTANCE.close();
		
		}catch (Exception e)
		{
			System.out.println(e);
		}
		return list;
		
	}

	public HolidaysDTO findHolidayBydate(Timestamp date)	throws Exception{
		
		HolidaysDTO holidaysDTO=null;
		try{
			//entitymanager.getTransaction().begin();
			
		 holidaysDTO =entitymanager.find(HolidaysDTO.class, date);
		 //entitymanager.close();
			
		}catch (Exception e){
			
			System.out.println(e);
		}
		
		return holidaysDTO;
		
	}

	public boolean isHoliday(Date date) throws Exception {
		boolean isHoliday = false;
		HolidaysDTO day = entitymanager.find(HolidaysDTO.class, date);
		if(day != null){
			isHoliday = true;
		}
		return isHoliday;
	}
}