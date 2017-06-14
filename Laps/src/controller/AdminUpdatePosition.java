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

import data.DAOException;
import model.AccessLevelDTO;
import model.HolidaysDTO;
import model.PositionDTO;
import service.AccessLevelManager;
import service.HolidayManager;
import service.PositionManager;

/**
 * Servlet implementation class AdminUpdatePosition
 */
@WebServlet("/AdminUpdatePosition")
public class AdminUpdatePosition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdatePosition() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		AccessLevelManager aManager = new AccessLevelManager();
		
		try {
			ArrayList<AccessLevelDTO> accessList = aManager.getAllAccessLevel();
			request.setAttribute("accessList", accessList);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/AdminUpdatePosition.jsp");
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PositionManager positionManager=new PositionManager();
		String jobtitle=request.getParameter("JobTitle");
		String AccessLevelID=request.getParameter("select");
		
		String AccessLevelName=null;
		if(AccessLevelID=="1"){
			AccessLevelName="Manager";
			
		}else{
			AccessLevelName="Employee";
		}
		
		int positionID = Integer.parseInt(request.getParameter("positionId"));
		
		PositionDTO positionDTO=new PositionDTO();
		
		try {
			positionDTO=positionManager.findPositionById(positionID);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		AccessLevelDTO accessLevelDTO=new AccessLevelDTO();
		accessLevelDTO.setAccessLevelId(Integer.parseInt(AccessLevelID));
	    accessLevelDTO.setAccessLevelName(AccessLevelName);
	   
	    positionDTO.setJobTitle(jobtitle);
	    positionDTO.setAccessLevel(accessLevelDTO);
		
		try {
			positionManager.updatePosition(positionDTO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		doGet(request, response);
	}

}
