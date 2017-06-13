package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DAOException;
import data.UsersDAO;
import data.UsersDAOImpl;
import model.LeaveAppnDTO;
import model.LeaveTypeDTO;
import model.UsersDTO;
import service.LeaveAppnManager;
import service.LeaveTypeManager;
import service.UserManager;

/**
 * Servlet implementation class SubmitLeaveController
 */
@WebServlet("/SubmitLeaveController")
public class SubmitLeaveApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubmitLeaveApplication() {
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
		// to get staff id from session

		try {
			UsersDAO userdao = new UsersDAOImpl();
			UsersDTO user = userdao.getUser("pete");
			LeaveTypeManager ltm = new LeaveTypeManager();
			LeaveTypeDTO lt = ltm.getLeaveType(Integer.parseInt(request.getParameter("leaveType")));
			Date startDate = new Date(request.getParameter("StartDate")); // Date.
			Date endDate = new Date(request.getParameter("EndDate"));
			Date appndate = new Date();
			LeaveAppnDTO la = new LeaveAppnDTO(1, lt, user, appndate, startDate, endDate,"", "","PENDING");
			LeaveAppnManager lam = new LeaveAppnManager();
			lam.insertLeaveAppn(la);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);

			// user = (UsersDTO) session.getAttribute("user");

			RequestDispatcher rd = request.getRequestDispatcher("/view/applyLeave.jsp");
			rd.forward(request, response);

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
	}

}
