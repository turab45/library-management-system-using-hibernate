package servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RoleDao;
import dao.StudentDao;
import daoimpl.RoleDaoImpl;
import daoimpl.StudentDaoImpl;
import models.Role;
import models.Student;
import models.User;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/Student")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RoleDao roleDaoImpl = new RoleDaoImpl();
	StudentDao studentDaoImpl = new StudentDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String rollNo = request.getParameter("rollNo");
		String sDate1= request.getParameter("date-of-birht");
		
		 Date date = null;
		try {
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			date = dateFormat.parse(sDate1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		String action = request.getParameter("action");
		
		Student student = null;
		Integer result = null;
		
		System.out.print("Action is: "+action);
		
		switch (action) {
		case "add":
			student = new Student();
			student.setName(firstname+" "+lastname);
			student.setEmail(email);
			student.setDateOfBirth(date);
			student.setRollNo(rollNo);
			student.setContact(contact);
			student.setCreateDate(new Date());
			student.setUpdateDate(new Date());
			student.setCreatedBy(u.getRole().getId());
			student.setUpdatedBy(u.getRole().getId());
			
			Role createdBy = roleDaoImpl.getRoleById(u.getRole().getId());
			student.setCreatedBy(createdBy.getId());
			
			result = studentDaoImpl.addStudent(student);
			
			System.out.println("Today date is : "+new Date());
			
				response.sendRedirect("view-student.jsp");
			
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
