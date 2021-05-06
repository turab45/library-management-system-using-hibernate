<%@page import="daoimpl.UserDaoImpl"%>
<%@page import="dao.UserDAO"%>
<%@page import="daoimpl.StudentDaoImpl"%>
<%@page import="dao.StudentDao"%>
<%@page import="daoimpl.IssueDaoImpl"%>
<%@page import="dao.IssueDao"%>
<%@page import="daoimpl.CategoryDaoImpl"%>
<%@page import="dao.CategoryDao"%>
<%@page import="java.util.List"%>
<%@page import="daoimpl.BookDaoImpl"%>
<%@page import="dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="models.*"%>
    
    
    <%
    
    IssueDao issueDaoImpl = new IssueDaoImpl();
    CategoryDao categoryDaoImpl = new CategoryDaoImpl();
    BookDao bookDaoImpl = new BookDaoImpl();
    StudentDao studentDaoImpl = new StudentDaoImpl();
    UserDAO userDaoImpl = new UserDaoImpl();
    
    List<Issue> allIssuedBooks = issueDaoImpl.getAllIssue();
    
 session = request.getSession();
 User user = (User) session.getAttribute("user");
 
 String action = "return";
 
 if(user != null){
 %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Books</title>
     <%@ include file="links.jsp" %> 
</head>

<body style="margin: -20px 0px;background-color: #fff;">
    <%@ include file="navbar.jsp" %>  
    <div class="article-clean" style="background-color: #fff;">
        <div class="container" style="background-color: #fff;">
            <div class="intro">
                <h1 class="text-center" style="color: rgb(31,40,81);font-weight: bold;">Issued Books</h1>
                <p class="text-center"> </p>
            </div>
            <% if (allIssuedBooks.size() > 0) {%>
            <div class="table-responsive shadow" style="background-color: #fff;">
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th style="color: rgb(31,40,81);font-size: 18px;font-family: Lora, serif;">ID</th>
                            <th style="color: rgb(31,40,81);font-size: 18px;">Book</th>
                            <th style="color: rgb(31,40,81);font-size: 18px;">Student</th>
                            <th style="color: rgb(31,40,81);font-size: 18px;">Issue Date</th>
                            <th style="color: rgb(31,40,81);font-size: 18px;">Issued By</th>
                            <th class="text-center" colspan="2" style="color: rgb(31,40,81);font-size: 18px;">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%for(Issue issue: allIssuedBooks){
                    	Book book = bookDaoImpl.getBookById(issue.getBook().getId());
                    	Student student = studentDaoImpl.getStudentById(issue.getStudent().getId() );
                    	User u = userDaoImpl.getUserById(issue.getIssuedBy().getId());
                    	
                    	%>
                    
                        <tr>
                            <td style="color: rgb(14,16,18);"><%=issue.getId() %></td>
                            <td style="color: rgb(14,16,18);"><%=book.getTitle() %></td>
                            <td style="color: rgb(14,16,18);"><%=student.getName() %></td>
                            <td style="color: rgb(14,16,18);"><%=issue.getIssueDate() %></td>
                            <td style="color: rgb(14,16,18);"><%=u.getName()%></td>
                             <% // Book?id=<%=book.getId() && action=<%="update" %>
                            <td style="width: 36px;"><a href="Issue?id=<%=issue.getId()%>&&action=<%=action %>" style="text-decoration: none;font-weight: bold;"><button>RETURN</button></a></td>
                            
                        </tr>
                        <tr></tr>
                        <%} %>
                    </tbody>
                </table>
            </div>
            <%} else{ %>
            
            	<center><h1>No Books</h1></center>
            <%} %>
        </div>
    </div>
     <%@ include file="scripts.jsp" %> 
</body>

</html>
<%}else{
	response.sendRedirect("login.jsp");
}%>