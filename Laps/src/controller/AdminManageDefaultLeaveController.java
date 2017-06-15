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
import model.DefaultLeaveDTO;
import service.DefaultLeaveManager;
import service.LeaveTypeManager;
import service.PositionManager;


/**
 * Servlet implementation class manageDefaultLeaveController
 */
@WebServlet("/admin/managedefaultleaves")
public class AdminManageDefaultLeaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminManageDefaultLeaveController() {
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
			DefaultLeaveManager dlm = new DefaultLeaveManager();

			ArrayList<DefaultLeaveDTO> dlList;

			dlList = dlm.getAllDL();
			
			PositionManager pm = new PositionManager();
			LeaveTypeManager ltm = new LeaveTypeManager();

			for (DefaultLeaveDTO dl : dlList) {
				dl.setPosition(pm.findPositionById(dl.getPositionId()));
				dl.setLeaveType(ltm.getLeaveType(dl.getLeaveTypeId()));
			}

			// TODO Auto-generated catch block
			request.setAttribute("dlList", dlList);

			RequestDispatcher rd = request.getRequestDispatcher("/view/AdminManageDefaultLeave.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			DefaultLeaveManager dlm = new DefaultLeaveManager();
			ArrayList<DefaultLeaveDTO> dlList = dlm.getAllDL();
			
			PositionManager pm = new PositionManager();
			LeaveTypeManager ltm = new LeaveTypeManager();

			for (DefaultLeaveDTO dl : dlList) {
				dl.setPosition(pm.findPositionById(dl.getPositionId()));
				dl.setLeaveType(ltm.getLeaveType(dl.getLeaveTypeId()));
			}
			for (int i = 0; i < dlList.size(); i++) {
				DefaultLeaveDTO ldto = new DefaultLeaveDTO();
				ldto = dlList.get(i);
				String id = Integer.toString(ldto.getLeaveTypeId()) + Integer.toString(ldto.getPositionId());
				ldto.setDays(Double.parseDouble(request.getParameter(id)));
				dlm.updateDL(ldto);
				/*
				 * System.out.println(id); System.out.println(request.getParameter(id));
				 * System.out.println(ldto.getDays());
				 */
				request.setAttribute("dlList", dlList);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/view/AdminManageDefaultLeave.jsp");
		rd.forward(request, response);

	}

}
