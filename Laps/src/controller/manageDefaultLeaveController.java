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
import model.LeaveTypeDTO;
import service.DefaultLeaveManager;


/**
 * Servlet implementation class manageDefaultLeaveController
 */
@WebServlet("/manageDefaultLeaveController")
public class manageDefaultLeaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public manageDefaultLeaveController() {
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

			// TODO Auto-generated catch block
			request.setAttribute("dlList", dlList);

			RequestDispatcher rd = request.getRequestDispatcher("/view/manageDefaultLeave.jsp");
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

			for (int i = 0; i < dlList.size(); i++) {
				DefaultLeaveDTO ldto = new DefaultLeaveDTO();
				ldto = dlList.get(i);
				String id = Integer.toString(ldto.getLeaveTypeId()) + Integer.toString(ldto.getPositionId());
				ldto.setDays(Integer.parseInt(request.getParameter(id)));
				dlm.updateDL(ldto);
				/*
				 * System.out.println(id); System.out.println(request.getParameter(id));
				 * System.out.println(ldto.getDays());
				 */
				request.setAttribute("dlList", dlList);
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/view/manageDefaultLeave.jsp");
		rd.forward(request, response);

	}

}
