package controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HolidaysDTO;
import service.HolidayManager;

/**
 * Servlet implementation class AdminInsertHolidays
 */
@WebServlet("/AdminInsertHolidays")
public class AdminInsertHolidays extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInsertHolidays() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       RequestDispatcher rd = request.getRequestDispatcher("/view/AdminInsertHolidays.jsp");
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HolidayManager holidayManager=new HolidayManager();
		String date=request.getParameter("date");
		Timestamp date1=Timestamp.valueOf(date);
		String desp=request.getParameter("Description");
		HolidaysDTO holidaysDTO=new HolidaysDTO();
		holidaysDTO.setDate(date1);
		holidaysDTO.setDescription(desp);
		try {
			holidayManager.insertHoliday(holidaysDTO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		doGet(request, response);
		
	}

}
