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
import service.LeaveTypeManager;

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
			UsersDAO userdao = new UsersDAOImpl();
			UsersDTO user = userdao.getUser("pete");
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
			//check if the user has enough leaves left
			LeaveDTO axe = new LeaveDTO();
			axe.setLeaveTypeId(Integer.parseInt(request.getParameter("leavetype")));
			axe.setUserId(user.getUserId());
			double daysLeft = axe.getDaysRemaining();
			double daysApplied = (double) lam.getNumberOfLeaveDays(dto.getStartDate(), dto.getEndDate());
			if(((daysLeft - daysApplied) >= 0) && (daysApplied==-1)){
				message = "End Date has to be earlier than Start Date";
			}
			else if(daysLeft -daysApplied <0){
				message = "Insufficient Leave left";
			}else if(((daysLeft - daysApplied) >= 0) && (daysApplied !=1)) {
				lam.insertLeaveAppn(dto);
				message = "Leave has been applied successfully!";
			}
			
			request.setAttribute("msg", message);
			
			//check if EndDate>StartDate
			


		} catch (Exception e) {
			// TODO: handle exception
		}
		doGet(request, response);
	}
}
