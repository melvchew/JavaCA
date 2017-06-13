package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HolidaysDTO;
import service.HolidayManager;

/**
 * Servlet implementation class AdminViewAllAndDeleteHolidays
 */
@WebServlet("/AdminViewAllAndDeleteHolidays")
public class AdminViewAllAndDeleteHolidays extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminViewAllAndDeleteHolidays() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date =request.getParameter("date");
		HolidayManager holidayManager=new HolidayManager();
		if(date != null){
			Timestamp date1=Timestamp.valueOf(date);
			HolidaysDTO dto=null;
			try {
				dto=holidayManager.findHolidayBydate(date1);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				System.out.println(dto.getDescription());
				holidayManager.deleteHoliday(dto);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ArrayList<HolidaysDTO> result = null;
		try {
			result = holidayManager.getAllHolidays();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("slist", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/AdminViewHolidays.jsp");

		rd.forward(request, response);
	
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
