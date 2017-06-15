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
import model.LeaveDTO;
import model.LeaveTypeDTO;
import model.UsersDTO;
import service.LeaveManager;
import service.UserManager;

/**
 * Servlet implementation class AdminManageStaffLeave
 */
@WebServlet("/AdminManageStaffLeave")
public class AdminManageStaffLeave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminManageStaffLeave() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			ArrayList<LeaveDTO> leaveList;
			UserManager um = new UserManager();
			UsersDTO user = um.getUser("pete");
			LeaveManager lm = new LeaveManager();
			leaveList = lm.getLeave(user);
			request.setAttribute("leaveList", leaveList);
			RequestDispatcher rd = request.getRequestDispatcher("/view/AdminManageStaffLeave.jsp");
			rd.forward(request, response);
		} catch (Exception e) {

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<LeaveDTO> leaveList;
		try {
			UserManager um = new UserManager();
			
			UsersDTO user = um.getUser("pete");
			LeaveManager lm = new LeaveManager();
			leaveList = lm.getLeave(user);
			request.setAttribute("leaveList", leaveList);
			for (LeaveDTO dto : leaveList) {

				dto.setDaysRemaining(Double.parseDouble(request.getParameter(dto.getLeaveTypeId() + "")));
				lm.updateLeave(dto);
			}
		}

		catch (Exception e) {

		}
		RequestDispatcher rd = request.getRequestDispatcher("/view/AdminManageStaffLeave.jsp");
		rd.forward(request, response);
	}

}
