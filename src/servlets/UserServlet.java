package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RoleDao;
import dao.UserDAO;
import daoimpl.RoleDaoImpl;
import daoimpl.UserDaoImpl;
import models.Role;
import models.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/User")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RoleDao roleDaoImpl = new RoleDaoImpl();
	UserDAO userDAOImpl = new UserDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		String role = request.getParameter("role");
		
		System.out.println(name+", "+email+", "+pass+", "+role);
		String action = request.getParameter("action");
		
		
		switch (action) {
		case "add":
			User user = new User();
			user.setName(name);
			user.setEmail(email);
			user.setPassword(pass);
			
			
			Role role2 = roleDaoImpl.getRoleById(roleDaoImpl.getRoleIdByName(role));
			System.out.println("Role Details: "+role2);
			Role createdBy = roleDaoImpl.getRoleById(u.getRole().getId());
			user.setRole(role2);
			user.setCreatedBy(createdBy.getId());
			
			Integer result = userDAOImpl.addUser(user);
			
			
				response.sendRedirect("view-user.jsp");
			
			break;

		case "update":
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			user = userDAOImpl.getUserById(id);
			
			user.setName(name);
			user.setEmail(email);
			user.setPassword(pass);
			
			
			role2 = roleDaoImpl.getRoleById(roleDaoImpl.getRoleIdByName(role));
	
			Role updatedBy = roleDaoImpl.getRoleById(u.getRole().getId());
			user.setRole(role2);
			user.setUpdatedBy(updatedBy.getId());
			
			result = userDAOImpl.updateUser(user);
			
			
				response.sendRedirect("view-user.jsp");
			
			break;
		case "delete":
			id = Integer.parseInt(request.getParameter("id"));
			
			User user2 = userDAOImpl.getUserById(id);
			
			userDAOImpl.deleteUser(user2);
			
			
				response.sendRedirect("view-user.jsp");
			
			break;
			
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
