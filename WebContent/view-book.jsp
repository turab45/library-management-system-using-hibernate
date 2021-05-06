<%@page import="daoimpl.CategoryDaoImpl"%>
<%@page import="dao.CategoryDao"%>
<%@page import="java.util.List"%>
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
 
 String action = "delete";
 
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
                <h1 class="text-center" style="color: rgb(31,40,81);font-weight: bold;">Books</h1>
                <p class="text-center"> </p>
            </div>
            <% if (allBooks.size() > 0) {%>
            <div class="table-responsive shadow" style="background-color: #fff;">
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th style="color: rgb(31,40,81);font-size: 18px;font-family: Lora, serif;">ID</th>
                            <th style="color: rgb(31,40,81);font-size: 18px;">Title</th>
                            <th style="color: rgb(31,40,81);font-size: 18px;">Author</th>
                            <th style="color: rgb(31,40,81);font-size: 18px;">Category</th>
                            <th style="color: rgb(31,40,81);font-size: 18px;">No of Copies</th>
                            <th class="text-center" colspan="2" style="color: rgb(31,40,81);font-size: 18px;">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%for(Book book: allBooks){
                    	Category c = categoryDaoImpl.getCategoryById(book.getCategory().getId());
                    	%>
                    
                        <tr>
                            <td style="color: rgb(14,16,18);"><%=book.getId() %></td>
                            <td style="color: rgb(14,16,18);"><%=book.getTitle() %></td>
                            <td style="color: rgb(14,16,18);"><%=book.getAuthor() %></td>
                            <td style="color: rgb(14,16,18);"><%=c.getCategory() %></td>
                            <td style="color: rgb(14,16,18);"><%=book.getNoOfCopies()%></td>
                             <% // Book?id=<%=book.getId() && action=<%="update" %>
                            <td style="width: 36px;"><a href="edit-book.jsp?id=<%=book.getId()%>" style="text-decoration: none;font-weight: bold;"><i class="fas fa-edit"></i></a></td>
                            <td style="width: 36px;height: 49px;"><a href="Book?id=<%=book.getId()%>&&action=<%=action %>" style="color: red;font-weight: bold;"></a><a href="Book?id=<%=book.getId()%>&&action=<%=action %>" style="text-decoration: none;font-weight: bold;"><i class="material-icons" style="width: 11;height: 13;color: rgb(255,19,34);">delete</i></a></td>
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