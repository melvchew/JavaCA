package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import data.DAOException;
import model.LeaveAppnDTO;
import service.LeaveAppnManager1;


/**
 * Servlet implementation class LoadClass
 */
@WebServlet("/viewEmpAppn")
public class testcontroll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public testcontroll() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, DAOException {
		String path = "/view/viewEmpAppn.jsp";

		//Retrieves User by using HTTPSession established
//		User user = new User();
//		user = (User)request.getSession().getAttribute("profile");
		
		LeaveAppnManager1 lam = new LeaveAppnManager1();
		
		ArrayList<LeaveAppnDTO> la = lam.getAllLeaveForApproval();
		
		//stores in request so as to enable usage in forwarded jsp
		request.setAttribute("leaveList", la);
		
		//creates a dispatcher and forwards to jsp page
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}
}
