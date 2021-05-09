package servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDao;
import dao.CategoryDao;
import dao.IssueDao;
import dao.RoleDao;
import dao.StudentDao;
import daoimpl.BookDaoImpl;
import daoimpl.CategoryDaoImpl;
import daoimpl.IssueDaoImpl;
import daoimpl.RoleDaoImpl;
import daoimpl.StudentDaoImpl;
import models.Book;
import models.Category;
import models.Issue;
import models.Role;
import models.Student;
import models.User;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/Book")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryDao categoryDaoImpl = new CategoryDaoImpl();
	BookDao bookDaoImpl = new BookDaoImpl();
	RoleDao roleDaoImpl = new RoleDaoImpl();
	static StudentDao studentDaoImpl = new StudentDaoImpl();
	IssueDao issueDaoImpl = new IssueDaoImpl();

	List<Student> allStudents = studentDaoImpl.getAllStudent();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");

		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String categoryName = request.getParameter("category");

		

		String action = request.getParameter("action");

		System.out.print("Action: " + action);
		System.out.print("No of copies: " + request.getParameter("no-of-copies"));

		Book book = null;
		Integer id = null;
		Integer result = null;
		switch (action) {

		case "add":
			Category category = categoryDaoImpl.getCategoryById(categoryDaoImpl.getIdByName(categoryName));
			Integer noOfCopies = Integer.parseInt(request.getParameter("no-of-copies"));
			book = new Book();
			book.setTitle(title);
			book.setBookCode(generateBookCode());
			book.setAuthor(author);
			book.setCategory(category);
			book.setNoOfCopies(noOfCopies);
			book.setCreatedBy(u.getRole().getId());
			book.setCreateDate(new Date());
			book.setUpdatedBy(u.getRole().getId());
			book.setUpdateDate(new Date());

			result = bookDaoImpl.addBook(book);
			
			response.sendRedirect("view-book.jsp");
			
			break;

		case "update":
			category = categoryDaoImpl.getCategoryById(categoryDaoImpl.getIdByName(categoryName));
			noOfCopies = Integer.parseInt(request.getParameter("no-of-copies"));
			id = Integer.parseInt(request.getParameter("id"));
			book = bookDaoImpl.getBookById(id);
			book.setTitle(title);
			book.setAuthor(author);
			book.setCategory(category);
			book.setNoOfCopies(noOfCopies);

			Role role = new Role();
			role.setId(u.getRole().getId());

			book.setUpdatedBy(role.getId());

			result = bookDaoImpl.updateBook(book);
			System.out.print("Result : " + result);
			if (result > 0) {
				response.sendRedirect("view-book.jsp");
			}

			break;
		case "delete":
			id = Integer.parseInt(request.getParameter("id"));
			Book b = bookDaoImpl.getBookById(id);
			result = bookDaoImpl.deleteBook(b);

			response.sendRedirect("view-book.jsp");

			break;

		case "issue":
			String[] selectedStudentIds = request.getParameterValues("selected");

			String studentRoll = request.getParameter("student-roll-no");

			Integer studentId = studentDaoImpl.getIdByRollNo(studentRoll);

			Student student = studentDaoImpl.getStudentById(studentId);

			for (int i = 0; i < selectedStudentIds.length; i++) {
				Integer bookId = Integer.parseInt(selectedStudentIds[i]);

				Book book2 = bookDaoImpl.getBookById(bookId);
				

				Issue issue = new Issue();
				issue.setBook(book2);
				issue.setStudent(student);
				issue.setCreatedBy(u.getRole().getId());
				issue.setIssuedBy(u.getId());
				issue.setCreateDate(new Date());
				issue.setUpdateDate(new Date());
				issue.setUpdatedBy(u.getRole().getId());
				issue.setStatus(1);

				result = issueDaoImpl.addIssue(issue);

			}

			response.sendRedirect("view-issued-book.jsp");

			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	static public String generateBookCode() {

		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String numbers = "0123456789";

		// Using random method
		Random rndm_method = new Random();

		String code = "";

		for (int i = 0; i < 6; i++) {
			// Use of charAt() method : to get character value
			// Use of nextInt() as it is scanning the value as int
			if (i == 2) {
				code += "-";
			}
			if (i == 0 || i == 1) {
				code += Capital_chars.charAt(rndm_method.nextInt(Capital_chars.length()));
			} else {
				code += numbers.charAt(rndm_method.nextInt(numbers.length()));
			}
		}
		return code;
	}

}
