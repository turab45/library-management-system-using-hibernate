<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<ul class="nav flex-column d-flex sidebar mobile-hid" style="background-color: rgb(31,40,81);">
        <li class="nav-item logo-holder">
            <div class="text-center text-white logo py-4 mx-4"><label style="font-family: Lora, serif;">MyLib</label><a class="text-white float-right" id="sidebarToggleHolder" href="#"><i class="fas fa-bars" id="sidebarToggle"></i></a></div>
        </li>
        <li class="nav-item"></li>
        <li class="nav-item"><a class="nav-link text-left text-white py-1 px-0" href="dashboard.jsp"><i class="fa fa-dashboard mx-3"></i><i class="fa fa-caret-right d-none position-absolute"></i><span class="text-nowrap mx-2">Dashboard</span></a></li>
        <li class="nav-item"></li>
        <li class="nav-item dropdown"><a class="dropdown-toggle nav-link text-left text-white py-1 px-0 position-relative" data-toggle="dropdown" aria-expanded="false" href="#"><i class="fas fa-user mx-3"></i><span class="text-nowrap mx-2">User</span><i class="fas fa-caret-down float-none float-lg-right fa-sm"></i></a>
            <div
                class="dropdown-menu border-0 animated fadeIn" role="menu"><a class="dropdown-item text-white" role="presentation" href="add-user.jsp" style="font-family: Lora, serif;">Add User</a><a class="dropdown-item text-white" role="presentation" href="view-user.jsp">View Users</a></div>
        </li>
        <li class="nav-item dropdown"><a class="dropdown-toggle nav-link text-left text-white py-1 px-0 position-relative" data-toggle="dropdown" aria-expanded="false" href="#"><i class="fas fa-users mx-3"></i><span class="text-nowrap mx-2">Students</span><i class="fas fa-caret-down float-none float-lg-right fa-sm"></i></a>
            <div
                class="dropdown-menu border-0 animated fadeIn" role="menu"><a class="dropdown-item text-white" role="presentation" href="add-student.jsp">Add Student</a><a class="dropdown-item text-white" role="presentation" href="view-student.jsp">View Students</a></div>
        </li>
        <li class="nav-item dropdown"><a class="dropdown-toggle nav-link text-left text-white py-1 px-0 position-relative" data-toggle="dropdown" aria-expanded="false" href="#"><i class="fas fa-book mx-3"></i><span class="text-nowrap mx-2">Books</span><i class="fas fa-caret-down float-none float-lg-right fa-sm"></i></a>
            <div
                class="dropdown-menu border-0 animated fadeIn" role="menu"><a class="dropdown-item text-white" role="presentation" href="add-book.jsp">Add Book</a><a class="dropdown-item text-white" role="presentation" href="view-book.jsp"><span>View Books</span></a><a class="dropdown-item text-white" role="presentation"
                    href="issue-book.jsp"><span>Issue Book</span></a></div>
        </li>
        <li class="nav-item dropdown"><a class="dropdown-toggle nav-link text-left text-white py-1 px-0 position-relative" data-toggle="dropdown" aria-expanded="false" href="#"><i class="far fa-list-alt mx-3"></i><span class="text-nowrap mx-2">Category</span><i class="fas fa-caret-down float-none float-lg-right fa-sm"></i></a>
            <div
                class="dropdown-menu border-0 animated fadeIn" role="menu"><a class="dropdown-item text-white" role="presentation" href="add-category.jsp">Add Category</a><a class="dropdown-item text-white" role="presentation" href="view-category.jsp">View Categories</a></div>
        </li>
        <li class="nav-item dropdown"><a class="dropdown-toggle nav-link text-left text-white py-1 px-0 position-relative" data-toggle="dropdown" aria-expanded="false" href="#"><i class="fas fa-user-cog mx-3"></i><span class="text-nowrap mx-2">Permissions</span><i class="fas fa-caret-down float-none float-lg-right fa-sm"></i></a>
            <div
                class="dropdown-menu border-0 animated fadeIn" role="menu"><a class="dropdown-item text-white" role="presentation" href="add-permission.jsp">Add Permission</a><a class="dropdown-item text-white" role="presentation" href="view-permission.jsp">View Permission</a><a class="dropdown-item text-white"
                    role="presentation" href="#">Assign Permission</a></div>
        </li>
        <li class="nav-item dropdown"><a class="dropdown-toggle nav-link text-left text-white py-1 px-0 position-relative" data-toggle="dropdown" aria-expanded="false" href="#"><i class="fas fa-sliders-h mx-3"></i><span class="text-nowrap mx-2">Settings</span><i class="fas fa-caret-down float-none float-lg-right fa-sm"></i></a>
            <div
                class="dropdown-menu border-0 animated fadeIn" role="menu"><a class="dropdown-item text-white" role="presentation" href="my-profile.jsp"><span>My Profile</span></a></div>
        </li>
        <li class="nav-item"><a class="nav-link text-left text-white py-1 px-0" href="Handle?action=<%="logout"%>"><i class="fas fa-sign-out-alt mx-3"></i><i class="fa fa-caret-right d-none position-absolute"></i><span class="text-nowrap mx-2">Log out</span></a></li>
    </ul>