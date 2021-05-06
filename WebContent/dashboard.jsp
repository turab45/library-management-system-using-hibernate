<%@page import="daoimpl.StudentDaoImpl"%>
<%@page import="dao.StudentDao"%>
<%@page import="daoimpl.IssueDaoImpl"%>
<%@page import="dao.IssueDao"%>
<%@page import="java.util.List"%>
<%@page import="daoimpl.BookDaoImpl"%>
<%@page import="dao.BookDao"%>
<%@page import="models.*"%>
<%@page import="daoimpl.UserDaoImpl"%>
<%@page import="dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    
 <%
 session = request.getSession();
 User user = (User) session.getAttribute("user");
 
 if(user != null){
 %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Home</title>
    <%@ include file="links.jsp" %>  
</head>


<% 
	UserDAO usDaoImpl = new UserDaoImpl();
	BookDao bookDaoImpl = new BookDaoImpl();
	IssueDao issueDaoImpl = new IssueDaoImpl();
	StudentDao studentDaoImpl = new StudentDaoImpl();
	
	List<Book> allBooks = bookDaoImpl.getAllBook();
	List<Issue> allIssuedBooks = issueDaoImpl.getAllIssue();
	List<Student> allStudent = studentDaoImpl.getAllStudent();

%>


<body style="font-family: Lora, serif;background-color: #fff;">
<%@ include file="navbar.jsp" %>  
    <div></div>
    <div class="features-boxed" style="background-color: #fff;">
        <div class="container" style="background-color: #fff;">
            <div class="intro">
                <h2 class="text-center">MyLib </h2>
                <p class="text-center">"I have always imagined that Paradise will be a kind of a Library."</p>
            </div>
            <div class="row justify-content-center features" style="background-color: #fff;">
                <div class="col-sm-6 col-md-5 col-lg-4 item" style="background-color: #fff;">
                    <div class="box" style="background-color: rgb(31,40,81);/*border-radius: 1px solid;*/border-radius: 30px;"><i class="fas fa-users icon" style="color: #fff;"></i>
                        <h3><a class="name" style="color: #fff; text-decoration: none;" href="view-student.jsp">Students</a></h3>
                        <h3 class="name" style="color: #fff;"><%=allStudent.size() %></h3>
                    </div>
                </div>
                <div class="col-sm-6 col-md-5 col-lg-4 item">
                    <div class="box" style="background-color: rgb(31,40,81);"><i class="fa fa-book icon" style="color: #fff;"></i>
                        <h3><a class="name" style="color: #fff; text-decoration: none;" href="view-book.jsp">Books</a></h3>
                        
                        <h3 class="name" style="color: #fff;"><%= allBooks.size()%></h3>
                    </div>
                </div>
                <div class="col-sm-6 col-md-5 col-lg-4 item">
                    <div class="box" style="background-color: rgb(31,40,81);"><i class="fa fa-list-alt icon" style="color: #fff;"></i>
                         <h3><a class="name" style="color: #fff; text-decoration: none;" href="view-issued-book.jsp">Issued Books</a></h3>
                        <h3 class="name" style="color: #fff;"><%=allIssuedBooks.size() %></h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <%@ include file="scripts.jsp" %>
</body>

<%}else{
	response.sendRedirect("login.jsp");
}%>
</html>
