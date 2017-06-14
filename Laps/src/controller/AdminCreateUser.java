package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DAOException;
import model.UsersDTO;
import service.DateManager;
import service.PositionManager;
import service.UserManager;

/**
 * Servlet implementation class createUser
 */
@WebServlet("/createuser")
public class AdminCreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCreateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			doProcess(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doProcess(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws NumberFormatException, Exception {
		UserManager uMan = new UserManager();
		UsersDTO u = new UsersDTO();
		PositionManager pMan=new PositionManager();
		DateManager dMan = new DateManager();
		
		u.setUsername(request.getParameter("uname"));
		u.setPassword(request.getParameter("passwd"));
		u.setPosition(pMan.findPositionById(Integer.parseInt(request.getParameter("posid"))));
		u.setName(request.getParameter("name"));
		System.out.println("DOB: "+request.getParameter("dob"));
		u.setDob(dMan.createDate(request.getParameter("dob")));
		u.setPhone(request.getParameter("phone"));
		u.setAddress(request.getParameter("addr"));
		u.setEmail(request.getParameter("email"));
		u.setManagerId(Integer.parseInt(request.getParameter("manageid")));
		u.setOtHours(0);//the default OT hour should be 0.
		
		uMan.insertUser(u);
				
		RequestDispatcher rd = request.getRequestDispatcher("/showusers");
		rd.forward(request, response);
				
	}

}
