package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DAOException;
import data.LeaveAppnDAO;
import data.LeaveAppnDAOImpl;
import data.UsersDAO;
import data.UsersDAOImpl;
import model.LeaveAppnDTO;
import model.UsersDTO;
import service.LeaveAppnManager;
import service.UserManager;

/**
 * Servlet implementation class vewLeaveHistory
 */
@WebServlet("/employee/viewleavehistory")
public class ViewLeaveHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewLeaveHistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		try {
			//gets UserDTO from request.getParameter();
			UserManager um = new UserManager();
			//UsersDTO user = um.getUser(request.getParameter("username"));
			
			
			//gets UserDTO from request.session
			HttpSession session = request.getSession();					//instantiates a session object
//			session.setAttribute("user", user); 
//			user = (UsersDTO) session.getAttribute("user"); 			//gets the UsersDTO from the session
			
			
			
//			UsersDAO userdao = new UsersDAOImpl();						//hardcoded
			UsersDTO user = new UsersDTO();					//hardcoded
			String id = request.getParameter("id");
			if ( id != null) {
				user = um.getUser(id);
				request.setAttribute("id", id);
			} else{
				user = (UsersDTO) session.getAttribute("loggedInUser");
			}
			
			LeaveAppnManager lam = new LeaveAppnManager(); 				//obtains the service Manager
			ArrayList<LeaveAppnDTO> leaveList = lam.getLeaveAppn(user); //uses service Manager to extract data from database
			request.setAttribute("leaveList", leaveList); 				// add to request
			RequestDispatcher rd = request.getRequestDispatcher("/view/viewLeaveHistory.jsp"); //sets the jsp page
			rd.forward(request, response);								//forward to the jsp page
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			System.out.println(e1);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
