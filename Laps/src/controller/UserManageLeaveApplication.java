package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DAOException;
import model.LeaveAppnDTO;
import model.LeaveTypeDTO;
import service.DateManager;
import service.LeaveAppnManager;
import service.LeaveTypeManager;

/**
 * Servlet implementation class UserManageLeaveApplication
 */
@WebServlet("/employee/manageleave")
public class UserManageLeaveApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserManageLeaveApplication() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LeaveAppnManager lam = new LeaveAppnManager();
		
		
		int key = Integer.parseInt(request.getParameter("LeaveAppnId"));
		try {
			LeaveAppnDTO leave = lam.getLeaveAppn(key);
			request.setAttribute("leave", leave);
			RequestDispatcher rd = request.getRequestDispatcher("/view/UserManageLeaveApplication.jsp");
			rd.forward(request, response);
		} catch (DAOException e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LeaveAppnManager lam = new LeaveAppnManager();
		LeaveTypeManager ltm = new LeaveTypeManager();
		int appnId = Integer.parseInt(request.getParameter("appnId"));
		String action = request.getParameter("btnAction");
		
		System.out.println("------"+action);
		System.out.println("--Start Date : --"+request.getParameter("StartDate"));
		System.out.println("--E Date : --"+ request.getParameter("EndDate"));
		System.out.println("--Leave Type -- "+ request.getParameter("LeaveType"));
		
		DateManager dm = new DateManager();
		try {
			LeaveAppnDTO leave = lam.getLeaveAppn(appnId);
			System.out.println(action);
			if(action == "UPDATE"){
				//TODO: update the appn
				leave.setStartDate(dm.createDate(request.getParameter("StartDate")));
				leave.setEndDate(dm.createDate(request.getParameter("EndDate")));
				LeaveTypeDTO leaveType = ltm.getLeaveType(Integer.parseInt(request.getParameter("LeaveType")));
				System.out.println(leaveType.getLeaveType());
				leave.setLeaveType(leaveType);
				leave.setStatus("UPDATED");
				lam.updateLeaveAppn(leave);
				
			} else if(action == "DELETE"){
				//TODO: update status to DELETE
				leave.setStatus("DELETED");
				System.out.println(leave.getStatus());
				lam.updateLeaveAppn(leave);
			} else if(action == "CANCEL"){
				leave.setStatus("CANCELLED");
				lam.updateLeaveAppn(leave);
			}
			
			String mgrComments = request.getParameter("mgrComments");

			if (mgrComments.isEmpty()) {
				// throw some exception
			}

			//leave.setMgrComments(mgrComments);
			
//			if (action.equals("Approve"))
//				leave.setStatus("APPROVED");
//			else
//				leave.setStatus("REJECTED");
			
			//need to add or remove remaining leaves
			
			lam.updateLeaveAppn(leave);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		doGet(request, response);
	
	}

}
