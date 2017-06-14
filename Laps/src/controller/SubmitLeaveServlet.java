package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.UsersDAO;
import data.UsersDAOImpl;
import model.LeaveAppnDTO;
import model.LeaveDTO;
import model.LeaveTypeDTO;
import model.UsersDTO;
import service.DateManager;
import service.LeaveAppnManager;
import service.LeaveManager;
import service.LeaveTypeManager;
import service.UserManager;

/**
 * Servlet implementation class SubmitLeaveServlet
 */
@WebServlet("/SubmitLeaveServlet")
public class SubmitLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubmitLeaveServlet() {
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
			LeaveAppnManager lam = new LeaveAppnManager();
			DateManager dm = new DateManager();
			UserManager um = new UserManager();

			// UsersDTO user = um.getUser(request.getParameter("username"));
			UsersDTO user = um.getUser("pete"); //hard coded
			LeaveTypeManager ltm = new LeaveTypeManager();
			LeaveTypeDTO lt = ltm.getLeaveType(Integer.parseInt(request.getParameter("leavetype")));
			LeaveAppnDTO dto = new LeaveAppnDTO();
			dto.setStartDate(dm.createDate(request.getParameter("StartDate")));
			dto.setEndDate(dm.createDate(request.getParameter("EndDate")));

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate localDate = LocalDate.now();
			dto.setAppnDate(dm.createDate(dtf.format(localDate)));

			dto.setLeaveType(lt);
			dto.setUser(user);
			dto.setEmpComments(request.getParameter("reasons"));
			dto.setStatus("PENDING");
			// get the number of days left by the user
			LeaveManager lm = new LeaveManager();
			LeaveDTO leaveDTO = lm.getLeaveByUser(user, lt);
			double daysLeft = leaveDTO.getDaysRemaining();
			double daysApplied = (double) lam.getNumberOfLeaveDays(dto.getStartDate(), dto.getEndDate());

			// check the leave application is valid.
			if (daysApplied == -1) {
				message = "End Date has to be earlier than Start Date";
			} else if ((daysLeft - daysApplied) < 0) {
				message = "Insufficient Leave left";
			} else {
				lam.insertLeaveAppn(dto);
				leaveDTO.setDaysRemaining(daysLeft - daysApplied);
				lm.updateLeave(leaveDTO);
				message = "Leave has been applied successfully!";
			}

			request.setAttribute("msg", message);

		} catch (Exception e) {
			// TODO: handle exception
		}
		doGet(request, response);
	}
}
