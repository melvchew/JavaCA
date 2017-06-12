package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DAOException;
import service.LeaveAppnManager;
import model.LeaveAppnDTO;

/**
 * Servlet implementation class ManageLeaveApplication
 */
@WebServlet("/ManageLeaveApplication")
public class ManageLeaveApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManageLeaveApplication() {
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
		LeaveAppnManager lam = new LeaveAppnManager();

		try {
			LeaveAppnDTO leave = lam.getLeaveAppn(4);
			request.setAttribute("leave", leave);
		} catch (DAOException e) {
			System.out.println(e);
		}

		RequestDispatcher rd = request.getRequestDispatcher("/view/manageLeaveAppn.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LeaveAppnManager lam = new LeaveAppnManager();
		int appnId = Integer.parseInt(request.getParameter("appnId"));
		String action = request.getParameter("btnAction");
		try {
			LeaveAppnDTO leave = lam.getLeaveAppn(appnId);
			String mgrComments = request.getParameter("mgrComments");

			if (mgrComments.isEmpty()) {
				// throw some exception
			}

			leave.setMgrComments(mgrComments);
			
			if (action.equals("Approve"))
				leave.setStatus("APPROVED");
			else
				leave.setStatus("REJECTED");
			
			//need to add or remove remaining leaves
			
			lam.updateLeaveAppn(leave);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		doGet(request, response);
	}

}
