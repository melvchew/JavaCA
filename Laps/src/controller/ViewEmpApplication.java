package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import data.DAOException;
import model.LeaveAppnDTO;
import service.LeaveAppnManager;

/**
 * Servlet implementation class LoadClass
 */
@WebServlet("/ViewEmpApplication")
public class ViewEmpApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewEmpApplication() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			LeaveAppnManager lam = new LeaveAppnManager();

			ArrayList<LeaveAppnDTO> la = lam.getPendingLeaveAppn();
			request.setAttribute("leaveList", la);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/view/viewEmpAppn.jsp");
		rd.forward(request, response);
	}

}
