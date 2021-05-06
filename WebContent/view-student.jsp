<%@page import="daoimpl.RoleDaoImpl"%>
<%@page import="dao.RoleDao"%>
<%@page import="daoimpl.StudentDaoImpl"%>
<%@page import="dao.StudentDao"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="models.*"%>
    
    
    <%
 session = request.getSession();
 User user = (User) session.getAttribute("user");
 
 StudentDao studetDaoImpl = new StudentDaoImpl();
 RoleDao roleDaoImpl = new RoleDaoImpl();
 
 List<Student> allStudent = studetDaoImpl.getAllStudent();
 
System.out.println("Student size: "+allStudent.size());
 
 if(user != null){
 %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Students</title>
     <%@ include file="links.jsp" %> 
</head>

<body style="margin: -20px 0px;background-color: #fff;">
<%@ include file="navbar.jsp" %>  
    <div class="article-clean" style="background-color: #fff;">
        <div class="container" style="background-color: #fff;">
            <div class="intro">
                <h1 class="text-center" style="color: rgb(31,40,81);font-weight: bold;">Students</h1>
                <p class="text-center"> </p>
            </div>
            
            <% if(allStudent.size() > 0){ %>
            <div class="table-responsive shadow" style="background-color: #fff;">
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th style="color: rgb(31,40,81);font-size: 18px;font-family: Lora, serif;">Roll No</th>
                            <th style="color: rgb(31,40,81);font-size: 18px;">Name</th>
                            <th style="color: rgb(31,40,81);font-size: 18px;">Date of birth</th>
                            <th style="color: rgb(31,40,81);font-size: 18px;">Contact</th>
                            <th style="color: rgb(31,40,81);font-size: 18px;">Email</th>
                            <th style="color: rgb(31,40,81);font-size: 18px;">Create Date</th>
                            <th style="color: rgb(31,40,81);font-size: 18px;">Created By</th>
                            <th style="color: rgb(31,40,81);font-size: 18px;">Update Date</th>
                            <th style="color: rgb(31,40,81);font-size: 18px;">Updated By</th>
                            <th class="text-center" colspan="2" style="color: rgb(31,40,81);font-size: 18px;">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                    
                    <% for (Student s: allStudent){ %>
                    
                    <% 
                    
                    	System.out.println("Created By ID: "+s.getCreatedBy().getId());
                    	Role createdBy = roleDaoImpl.getRoleById(s.getCreatedBy().getId());
                    Role updatedBy = null;
                    	if(s.getUpdatedBy() != null){
                    	updatedBy = roleDaoImpl.getRoleById(s.getUpdatedBy().getId());} %>
                        <tr>
                            <td style="color: rgb(14,16,18);"><%=s.getRollNo() %></td>
                            <td style="color: rgb(14,16,18);"><%=s.getName() %></td>
                            <td style="color: rgb(14,16,18);"><%=s.getDateOfBirth() %></td>
                            <td style="color: rgb(14,16,18);"><%=s.getContact() %></td>
                            <td style="color: rgb(14,16,18);"><%=s.getEmail() %></td>
                             <td style="color: rgb(14,16,18);"><%=s.getCreateDate().toString() %></td>  
                            <td style="color: rgb(14,16,18);">--</td> 
                            
                            <td style="color: rgb(14,16,18);">--</td>
                          
                            <td style="color: rgb(14,16,18);">--</td>
                            
                             
                            
                            
                            <td style="width: 36px;"><a href="#" style="text-decoration: none;font-weight: bold;"><i class="fas fa-edit"></i></a></td>
                            <td style="width: 36px;height: 49px;"><a href="#" style="/*text-decoration: none;*//*background-color: red;*//*color: rgb(221,16,16);*//*border: 1px solid;*//*border-radius: 5px;*//*width: 12px;*//*height: 20px;*/color: red;font-weight: bold;"></a><a href="#" style="text-decoration: none;font-weight: bold;"><i class="material-icons" style="width: 11;height: 13;color: rgb(255,19,34);">delete</i></a></td>
                        </tr>
                        <tr></tr>
                        <%} %>
                    </tbody>
                </table>
            </div>
            <%}else{ %>
            <center><h1>No Students</h1></center>
            <%}%>
        </div>
    </div>
    <%@ include file="scripts.jsp" %> 
</body>

</html>
<%}else{
	response.sendRedirect("login.jsp");
}%>