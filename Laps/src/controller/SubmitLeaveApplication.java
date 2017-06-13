package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
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
import service.DateManager;
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
//			HttpSession session = request.getSession();
//			session.setAttribute("user", user);
			LeaveTypeManager ltm = new LeaveTypeManager();
			DateManager dm = new DateManager();
			
			LeaveTypeDTO lt = ltm.getLeaveType(1);
			LeaveAppnDTO la = new LeaveAppnDTO();
//			la.setStatus("PENDING");
//			la.setEndDate(dm.createDate(request.getParameter("EndDate")));
//			la.setAppnDate(new Date());
//			la.setStartDate(dm.createDate(request.getParameter("StartDate")));
//			la.setLeaveType(lt);
//			la.setUser(user);
			la.setAppnDate(new Date());
			la.setStartDate(dm.createDate("6/14/2017"));
			la.setEndDate(dm.createDate("6/15/2017"));
			la.setLeaveType(lt);
			la.setUser(user);
			la.setStatus("PENDING");
			LeaveAppnManager lam = new LeaveAppnManager();
			
			//TODO: ADD VALIDATION
			
			lam.insertLeaveAppn(la);
			
			message = "Success. Ez Peazy.";
			request.setAttribute("msg", message);

		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		doGet(request, response);
	}

}
