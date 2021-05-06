<%@page import="daoimpl.RoleDaoImpl"%>
<%@page import="dao.RoleDao"%>
<%@page import="daoimpl.UserDaoImpl"%>
<%@page import="dao.UserDAO"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="models.*"%>
    
    
    <%
    
    UserDAO userDaoImpl = new UserDaoImpl();
    RoleDao roleDaoImpl = new RoleDaoImpl();
    
    List<User> allUsers = userDaoImpl.getAllUser();
    
    
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
    <title>Users</title>
    <%@ include file="links.jsp" %> 
</head>

<body style="margin: -20px 0px;background-color: #fff;">
    <%@ include file="navbar.jsp" %> 
    <div class="article-clean" style="background-color: #fff;">
        <div class="container" style="background-color: #fff;">
            <div class="intro">
                <h1 class="text-center" style="color: rgb(31,40,81);font-weight: bold;">Users</h1>
                <p class="text-center"> </p>
            </div>
            <div class="table-responsive shadow" style="background-color: #fff;">
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th style="color: rgb(31,40,81);font-size: 18px;font-family: Lora, serif;">ID</th>
                            <th style="color: rgb(31,40,81);font-size: 18px;">Name</th>
                            <th style="color: rgb(31,40,81);font-size: 18px;">Email</th>
                            <th style="color: rgb(31,40,81);font-size: 18px;">Password</th>
                            <th style="color: rgb(31,40,81);font-size: 18px;">Create Date</th>
                            <th style="color: rgb(31,40,81);font-size: 18px;">Created By</th>
                            <th style="color: rgb(31,40,81);font-size: 18px;">Update Date</th>
                            <th style="color: rgb(31,40,81);font-size: 18px;">Updated By</th>
                            <th class="text-center" colspan="2" style="color: rgb(31,40,81);font-size: 18px;">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                    
                    <%for (User u: allUsers){ 
                    Role createdBy = roleDaoImpl.getRoleById(u.getRole().getId());
                    Role updatedBy = roleDaoImpl.getRoleById(u.getRole().getId());
                    %>
                    
                        <tr>
                            <td style="color: rgb(14,16,18);"><%=u.getId() %></td>
                            <td style="color: rgb(14,16,18);"><%=u.getName() %></td>
                            <td style="color: rgb(14,16,18);"><%=u.getEmail() %></td>
                            <td style="color: rgb(14,16,18);"><%=u.getPassword() %></td>
                            <td style="color: rgb(14,16,18);"><%=u.getCreateDate() %></td>
                            <td style="color: rgb(14,16,18);"><%=createdBy.getRole() %></td>
                            <td style="color: rgb(14,16,18);"><%=u.getUpdateDate() %></td>
                            <td style="color: rgb(14,16,18);"><%=updatedBy.getRole() %></td>
                            <td style="width: 36px;"><a href="edit-user.jsp?id=<%=u.getId()%>" style="text-decoration: none;font-weight: bold;"><i class="fas fa-edit"></i></a></td>
                            <td style="width: 36px;height: 49px;"><a href="#" style="/*text-decoration: none;*//*background-color: red;*//*color: rgb(221,16,16);*//*border: 1px solid;*//*border-radius: 5px;*//*width: 12px;*//*height: 20px;*/color: red;font-weight: bold;"></a><a href="User?id=<%=u.getId()%>&&action=<%=action %>" style="text-decoration: none;font-weight: bold;"><i class="material-icons" style="width: 11;height: 13;color: rgb(255,19,34);">delete</i></a></td>
                        </tr>
                        
                        <tr></tr>
                        
                     <%} %>
                        
                    </tbody>
                </table>
            </div>
        </div>
    </div>
   <%@ include file="scripts.jsp" %> 
</body>

</html>
<%}else{
	response.sendRedirect("login.jsp");
}%>