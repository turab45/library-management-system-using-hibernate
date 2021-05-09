package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IssueDao;
import daoimpl.IssueDaoImpl;
import models.Issue;

/**
 * Servlet implementation class IssueServlet
 */
@WebServlet("/Issue")
public class IssueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IssueDao issueDaoImpl = new IssueDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		String action = request.getParameter("action");
		
		Integer result = null;
		
		switch (action) {
		case "return":
			Issue issue = issueDaoImpl.getIssueById(id);
			
			result = issueDaoImpl.returnBook(issue);
			
			
				response.sendRedirect("view-issued-book.jsp");
			
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
