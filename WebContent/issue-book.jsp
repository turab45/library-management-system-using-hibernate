<%@page import="java.util.List"%>
<%@page import="daoimpl.CategoryDaoImpl"%>
<%@page import="dao.CategoryDao"%>
<%@page import="daoimpl.BookDaoImpl"%>
<%@page import="dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="models.*"%>

    
    
    <%
    
   BookDao bookDaoImpl = new BookDaoImpl();
   CategoryDao categoryDaoImpl = new CategoryDaoImpl();
   List<Book> allBooks = bookDaoImpl.getAllBook();
    
 session = request.getSession();
 User user = (User) session.getAttribute("user");
 
 String action = "issue";
 
 if(user != null){
 %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Issue Book</title>
    <%@ include file="links.jsp" %>
</head>

<body style="font-family: Lora, serif;background-color: #fff;">
    <%@ include file="navbar.jsp" %>  
    <div class="article-clean">
        <div class="container">
            <div class="row">
                <div class="col-lg-10 col-xl-8 offset-lg-1 offset-xl-2">
                    <div class="intro"></div>
                    <form action="Book?action=<%=action%>" method="post">
                        <div class="form-row profile-row">
                            <div class="col-md-8">
                                <h1 class="text-center" style="color: rgb(31,40,81);">Issue Book</h1>
                                <hr style="background-color: rgb(31,40,81);">
                               
                                <div class="form-group"><label style="color: rgb(31,40,81);font-size: 16px;font-weight: bold;">Student Roll No</label><input name="student-roll-no" class="form-control" type="text" style="border-color: rgb(31,40,81);"></div>
                                <hr style="background-color: #fff;">
                                <div class="form-row">
                                    <div class="col-md-12 content-right"><button class="btn btn-primary form-btn" type="submit" style="background-color: rgb(31,40,81);border-color: rgb(31,40,81);">ISSUE</button><button class="btn btn-danger form-btn" type="reset" style="background-color: rgb(31,40,81);border-color: rgb(31,40,81);">CANCEL </button></div>
                                </div>
                            </div>
                        </div>
                    
                    <div style="margin-top: 20px"></div>
                    
                </div>
            </div>
        </div>
        <div style="margin: 20px">
        <h1 style="margin-bottom: 10px">Select Books</h1>
        <% if (allBooks.size() > 0) {%>
        <div class="container">
        	<% for (Book b : allBooks){ %>
            
                <input style="margin: 10px" type="checkbox" name="selected" value=<%=b.getId() %>> <%=b.getTitle()%> 
                
                 
            <%} %> 
            </div>   
            </form>    
            <%} else{ %>
            
            	<center><h1>No Books</h1></center>
            <%} %>
        </div>
    </div>
     <%@ include file="scripts.jsp" %> 
</body>
<%}else{
	response.sendRedirect("login.jsp");
}%>
</html>