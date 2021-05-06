<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    
    <% String action = "login"; %> 
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Login - Brand</title>
    <link rel="stylesheet" href="login assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora">
    
</head>

<body style="background-color: rgb(31,40,81); font-family: Lora;">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-9 col-lg-12 col-xl-10">
                <div class="card shadow-lg o-hidden border-0 my-5">
                    <div class="card-body p-0">
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-flex">
                                <div class="flex-grow-1 bg-login-image" style="background-image: url(&quot;login assets/img/lib.jpg;);padding: 0;margin: 0;"></div>
                            </div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h4 class="text-dark mb-4">Welcome Back!</h4>
                                        <h2 class="text-dark mb-4">Login</h2>
                                    </div>
                                    <form class="user" method="Post" action="Handle?action=<%=action%>">
                                        <div class="form-group"><input required class="form-control form-control-user" type="email" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="Enter Email Address..." name="email" style="border-color: rgb(31,40,81);"></div>
                                        <div class="form-group"><input required class="form-control form-control-user" type="password" id="exampleInputPassword" placeholder="Password" name="password" style="border-color: rgb(31,40,81);"></div>
                                        <div class="form-group">
                                            <div class="custom-control custom-checkbox small"></div>
                                        </div><button class="btn btn-block text-white btn-user" type="submit" style="background-color: rgb(31,40,81);/*border-color: rgb(31,40,81);*/">Login</button>
                                        <hr>
                                        <hr>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
    <script src="assets/js/theme.js"></script>
</body>

</html>