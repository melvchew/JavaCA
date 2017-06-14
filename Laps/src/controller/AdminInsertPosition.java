package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AccessLevelDTO;
import model.PositionDTO;
import service.PositionManager;

/**
 * Servlet implementation class AdminInsertPosition
 */
@WebServlet("/admin/insertposition")
public class AdminInsertPosition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInsertPosition() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       RequestDispatcher rd = request.getRequestDispatcher("/view/AdminInsertPosition.jsp");
		
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
		
		PositionDTO positionDTO=new PositionDTO();
		
		AccessLevelDTO accessLevelDTO=new AccessLevelDTO();
		accessLevelDTO.setAccessLevelId(Integer.parseInt(AccessLevelID));
	    accessLevelDTO.setAccessLevelName(AccessLevelName);
	   
	    positionDTO.setJobTitle(jobtitle);
	    positionDTO.setAccessLevel(accessLevelDTO);
		
		try {
			positionManager.insertPosition(positionDTO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		doGet(request, response);
	}

}
