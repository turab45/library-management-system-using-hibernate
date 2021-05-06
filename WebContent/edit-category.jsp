<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="models.*"%>
    <%@page import="dao.*"%>
    <%@page import="daoimpl.*"%>
    
    
    <%
 session = request.getSession();
 User user = (User) session.getAttribute("user");
 
 Integer id = Integer.parseInt(request.getParameter("id"));
 
 CategoryDao categoryDaoImpl = new CategoryDaoImpl();
 
 Category category = categoryDaoImpl.getCategoryById(id);
 
 String action = "update";
 
 if(user != null){
 %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Edit Category</title>
    <%@ include file="links.jsp" %>
</head>

<body style="font-family: Lora, serif;background-color: #fff;">
    <%@ include file="navbar.jsp" %>  
    <div class="article-clean">
        <div class="container">
            <div class="row">
                <div class="col-lg-10 col-xl-8 offset-lg-1 offset-xl-2">
                    <div class="intro"></div>
                    <form action="Category?id=<%=category.getId() %>&&action=<%=action%>" method="post">
                        <div class="form-row profile-row">
                            <div class="col-md-8">
                                <h1 class="text-center" style="color: rgb(31,40,81);">Update Category</h1>
                                <hr style="background-color: rgb(31,40,81);">
                                <div class="form-group"><label style="color: rgb(31,40,81);font-size: 16px;font-weight: bold;">Category</label><input value="<%=category.getCategory() %>" name="category" class="form-control" type="text" style="border-color: rgb(31,40,81);"></div>
                                <hr style="background-color: #fff;">
                                <div class="form-row">
                                    <div class="col-md-12 content-right"><button class="btn btn-primary form-btn" type="submit" style="background-color: rgb(31,40,81);border-color: rgb(31,40,81);">UPDATE</button><button class="btn btn-danger form-btn" type="reset" style="background-color: rgb(31,40,81);border-color: rgb(31,40,81);">CANCEL </button></div>
                                </div>
                            </div>
                        </div>
                    </form>
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