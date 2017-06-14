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

import model.AccessLevelDTO;
import model.HolidaysDTO;
import model.PositionDTO;
import service.HolidayManager;
import service.PositionManager;

/**
 * Servlet implementation class AdminViewAllPositions
 */
@WebServlet("/admin/viewpositions")
public class AdminViewAllPositions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminViewAllPositions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PositionManager positionManager=new PositionManager();
		String positionID = request.getParameter("positionId");
		if(positionID !=null){
			int positionID1 = Integer.parseInt(positionID);
			
			PositionDTO positionDTO=new PositionDTO();
			
			try {
				positionDTO=positionManager.findPositionById(positionID1);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		    //positionDTO.setDeleteFlag(1);
		    
			try {
				positionManager.deletePosition(positionDTO);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		ArrayList<PositionDTO> result = null;
		try {
			result = positionManager.getAllPositions();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("slist", result);
		RequestDispatcher rd = request.getRequestDispatcher("/view/AdminViewAllPosition.jsp");

		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
