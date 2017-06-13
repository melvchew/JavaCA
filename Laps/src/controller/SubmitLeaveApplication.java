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

		RequestDispatcher rd = request.getRequestDispatcher("/view/applyLeave.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message = "Success";
		try {
			UsersDAO userdao = new UsersDAOImpl();
			UsersDTO user = userdao.getUser("pete");
			LeaveTypeManager ltm = new LeaveTypeManager();
			// String leavetypeString = request.getParameter("leavetype");
			// int leavetypeID = Integer.parseInt(leavetypeString);
			// LeaveTypeDTO lt = ltm.getLeaveType(leavetypeID);
			//TODO: ADD VALIDATION
			LeaveTypeDTO lt = ltm.getLeaveType(Integer.parseInt(request.getParameter("leavetype")));
			Date startdate = new Date(); // Date.
			Date enddate = new Date();
			Date appndate = new Date();
			
			LeaveAppnDTO la = new LeaveAppnDTO();
			la.setStatus("PENDING");
			la.setEndDate(enddate);
			la.setAppnDate(appndate);
			la.setStartDate(startdate);
			la.setLeaveType(lt);
			la.setUser(user);
			LeaveAppnManager lam = new LeaveAppnManager();
			lam.insertLeaveAppn(la);
			
			message = "Success. Ez Peazy.";
			request.setAttribute("msg", message);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		doGet(request, response);
	}

}
