<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"  href="css/index.css">
<link rel="stylesheet"  href="all.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://assets3.lottiefiles.com/packages/lf20_ihxIYc.json">
<title>Index Page</title>
</head>

<body>
    <nav>
        <div class="logo">
            <h1> <img src="assets/images/bank_logo.png" width="45px" height="55px"> Bank of Pune</h1>
        </div>

        <div class="menu">
            <ul>
                <li> <a href="#about">About Us</a></li>
                <li><a href="#services">Services</a> </li>
                <li><a href="#contact">Contact Us</a> </li>
            </ul>
        </div>
    </nav>

    <header class="site-header">
        <section>
            <div class="leftside">
                <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>
                <img src="assets/images/bank_image.jpg">
            </div>
            <div class="rightside" id="about">
                <h1>Welcome to the Bank of Pune!!</h1>
                <p> " The bank which knows the value of your money " </p>
                <button onclick="location.href='LoginPage.jsp' ">Log In</button>
                <br>
                <button onclick="location.href='RegistrationPage.jsp' ">Create New Account</button>
            </div>

        </section>
    </header>

    <div class="main">
        <div class="about" id="services">
            <h2>Our Services</h2>
        </div>
        <!--cards -->

        <div class="card">
            <div class="image">
                <img src="assets/images/login.jpg" height="300px">
            </div>
            <div class="title">
                <h1>Log In</h1>
            </div>
            <div class="des">
                <p>Already have an account?</p>
                <button onclick="location.href='LoginPage.jsp' ">Click here..</button>
            </div>
        </div>

        <div class="card">
            <div class="image">
                <img src="assets/images/register.png" height="300px">
            </div>
            <div class="title">
                <h1> Create New Account </h1>
            </div>
            <div class="des">
                <p>Don't have an account?</p>
                <button onclick="location.href='RegistrationPage.jsp' ">Click here..</button>
            </div>
        </div>

        <div class="card">
            <div class="image">
                <img src="assets/images/bankloan.jpg" height="300px">
            </div>
            <div class="title">
                <h1> Apply for Loan </h1>
            </div>
            <div class="des">
                <p>We provide all kind of loans.</p>
                <button onclick="location.href=#">Click here..</button>
            </div>
        </div>

        <div class="card">
            <div class="image">
                <img src="assets/images/student.jpg" height="300px">
            </div>
            <div class="title">
                <h1> Student Facilities </h1>
            </div>
            <div class="des">
                <p>We are here to help you.</p>
                <button onclick="location.href=#">Click here..</button>
            </div>
        </div>
        <!--cards -->
    </div>

    <footer>
        <div class="container-fluid" id="contact">
            <h2>Contact Us</h2><br>
            <div class="footercontact">
                <h3>General Inquiries:</h3> <br>
                <span>
                    Address: Bund Garden, Pune, Maharashtra - 411001<br>
                    Contact No : +91 9876543210
                </span>
            </div>
            <br></br><br><br>
        </div>

        <div class="links">
            <ul>
                <li><a href="#"><i class="fa fa-envelope"></i></a></li>
                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                <li><a href="#"><i class="fa fa-instagram"></i></a></li>
            </ul>
        </div>
    </footer>
</body>

</html>