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
 * Servlet implementation class UpdateUser
 */
@WebServlet("/upduser")
public class updateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserManager uMan = new UserManager();
		UsersDTO u;
		PositionManager pMan=new PositionManager();
		DateManager dMan = new DateManager();
		
		try {
			//Get original username from Update.jsp,then get UsersDTO object u
			u = uMan.getUser(request.getParameter("originalName"));
			//Set data form page to object u
			u.setUsername(request.getParameter("uname"));
			u.setPassword(request.getParameter("passwd"));
			u.setPosition(pMan.getPosition(Integer.parseInt(request.getParameter("posid"))));
			u.setName(request.getParameter("name"));
			
			//Need to change!!!! Remaining problem!!!
			u.setDob(dMan.createDate(request.getParameter("dob").substring(0, 10)));
			
			u.setPhone(request.getParameter("phone"));
			u.setAddress(request.getParameter("addr"));
			u.setEmail(request.getParameter("email"));
			u.setManagerId(Integer.parseInt(request.getParameter("manageid")));
			u.setOtHours(Double.parseDouble(request.getParameter("othour")));
			//Update to database
			uMan.updateUser(u);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		RequestDispatcher rd = request.getRequestDispatcher("/showusers");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Get username from manageStaff.jsp
		String uname = request.getParameter("username");
		
		UserManager uMan = new UserManager();
		UsersDTO u = new UsersDTO();
		
		try {
			//Use getUser(username) method to pass the userDTO object to "u"
			u = uMan.getUser(uname);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Give u to the UpdateUser.jsp
		request.setAttribute("u", u);
		RequestDispatcher rd = request.getRequestDispatcher("/view/UpdateUser.jsp");
		rd.forward(request, response);
	}


}
