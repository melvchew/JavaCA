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
import model.UsersDTO;
import service.UserManager;

/**
 * Servlet implementation class ShowUsers
 */
@WebServlet("/showusers")
public class AdminShowUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminShowUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserManager uMan = new UserManager();
		ArrayList<UsersDTO> uList = new ArrayList<UsersDTO>();
		
		try {
			uList = uMan.getAllUser();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
		//System.out.println(uList.size());
		request.setAttribute("uList", uList);
		RequestDispatcher rd = request.getRequestDispatcher("/view/AdminManageStaff.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
	}

}
