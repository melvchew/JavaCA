package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DAOException;
import model.LeaveAppnDTO;
import model.UsersDTO;
import service.LeaveAppnManager;
import service.UserManager;

@WebServlet("/manager/ViewUsersHistoryByManager")
public class ViewUsersHistoryByManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewUsersHistoryByManager() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			UserManager um = new UserManager();

			ArrayList<UsersDTO> al = um.getUsersByManager(um.getUser("zwe"));// PASS
																				// MANAGER
																				// ID
																				// HERE
																				// FROM
																				// LOGIN
			request.setAttribute("empList", al);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/view/viewUsersHistoryByManager.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			UserManager um = new UserManager();
			UsersDTO user = um.getUser(request.getParameter("id"));
			LeaveAppnManager lam = new LeaveAppnManager();
			ArrayList<LeaveAppnDTO> leaveList = lam.getLeaveAppn(user);
			request.setAttribute("leaveList", leaveList);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/view/viewLeaveHistory.jsp");
		rd.forward(request, response);
	}
}
