package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DAOException;
import model.AccessLevelDTO;
import model.LeaveAppnDTO;
import model.PositionDTO;
import model.UsersDTO;
import service.LeaveAppnManager;
import service.UserManager;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/view/Login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			String username = request.getParameter("txtUname");
			String password = request.getParameter("txtPwd");
			UserManager um = new UserManager();

			if (um.checkUser(username, password)) {

				if (session.isNew()) {
					session.setAttribute("uName", username);
				} else
					username = (String) session.getAttribute("uName");

				UsersDTO u = um.getUser(username);
				System.out.println("BREAK****\n\n\n\n\n" + username + "\n\n\n\n\nBREAK******");
				String accesslvl = u.getPosition().getAccessLevel().getAccessLevelName();
				RequestDispatcher rd = null;
				switch (accesslvl) {
				case "Manager":
					rd = request.getRequestDispatcher("/view/viewEmpAppn.jsp");///// CHANGE
																				///// URL
					break;
				case "Employee":
					rd = request.getRequestDispatcher("/view/applyLeave.jsp");///// CHANGE
																				///// URL
					break;
				case "Administrator":
					rd = request.getRequestDispatcher("/view/CreateUser.jsp");///// CHANGE
																				///// URL
					break;
				}
				rd.forward(request, response);
			} else {
				System.out.println("LOGIN UNSUCCESSFUL");
				RequestDispatcher rd = request.getRequestDispatcher("");///// Login
																		///// failed
																		///// url
				rd.forward(request, response);
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}

	}

}
