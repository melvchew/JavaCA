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
import model.LeaveTypeDTO;
import service.LeaveTypeManager;

/**
 * Servlet implementation class ManageStaffLeaveTypes
 */
@WebServlet("/ManageStaffLeaveTypes")
public class AdminManageStaffLeaveTypes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminManageStaffLeaveTypes() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			LeaveTypeManager ltm = new LeaveTypeManager();
			ArrayList<LeaveTypeDTO> lt = ltm.getAllLeaveTypes();
			request.setAttribute("leaveTypeList", lt);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/view/manageStaffLeaveTypes.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			LeaveTypeManager ltm = new LeaveTypeManager();
			ArrayList<LeaveTypeDTO> al = ltm.getAllLeaveTypes();
			for (LeaveTypeDTO smth : al) {
				smth.setLeaveType(request.getParameter(smth.getLeaveTypeId() + ""));
				ltm.updateLeavetype(smth);
			}
			al = ltm.getAllLeaveTypes();
			request.setAttribute("leaveTypeList", al);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/view/manageStaffLeaveTypes.jsp");
		rd.forward(request, response);
	}

}
