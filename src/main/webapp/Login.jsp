<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>Login | SkyHigh Airline</title>
<script src="https://kit.fontawesome.com/9ed6a12a9d.js"></script>
<script type="text/javascript" src="js/signup.js"></script>
<link rel="stylesheet" href="css/style.css">
<link rel="shortcut icon" type="x-icon" href="img/SKYHIGHICO.ico"/>
<script> 
		function validate() { 
		     var userid = document.form.userid.value; 
		     var password = document.form.password.value;
		 
		     if (userid==null) { 
			     alert("User ID cannot be blank"); 
			     return false; 
		     }
		     else if(password==null) { 
			     alert("Password cannot be blank"); 
			     return false; 
		     } 
		}
</script> 
</head>

<body background="img/skyHighBG.jpg">

<!-- For header and sticky header -->
	<header>
		<a class="logoHome" id="logoHome" href="HomeController?action=home"><img class="headlog" src="img/skyhighLg-smaller.png" alt="logo"></a>
		<ul>
			<li class="selHo"><a href="#explore">Explore</a></li>
			<li class="selHo"><a href="#support">Support</a></li>
		</ul>
		<a class="cta" href="#login"><button>LOGIN</button></a>
	</header>
	
	<section class="banner" >
		<script type="text/javascript">
			window.addEventListener
				("scroll", function()
					{
					var header = document.querySelector("header");
					header.classList.toggle("sticky", window.scrollY > 0);
					}
				)
		</script>
		<br><br><br><br>
	    
	</section>
<br>
<!-- body/form start here -->
<form action="LoginController" method="post">

<div class="title-highlight">
			<h1><mark> Log in  </mark></h1>
			<h2>Welcome back, traveler.</h2><br><br>
</div>

Email<br>
	<input class="in" type="text" name="email" id="email" placeholder="Email">
	<br><br>
<div class="pw">
Password<br>
	<input class="in" type="password" name="password" id="password" placeholder="Password">
	<input class="in" type="hidden" name="role" id="role" value="passenger"><br>
	<span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
         : request.getAttribute("errMessage")%></span>
	<br>
	<div class="padd">Don't have an account?<a href="SignUp.jsp"> Sign Up</a> now!</div><br>
</div>

<div class="ButCon"><input class="sub" type="submit" value="SUBMIT"></div>
</form>

<!-- Footer start here -->
	<br>
	<div><img class="foot-login-signup" src="img/footerC.png" alt="footer"></div>
	
<!-- Tiny footer -->
			<div class="tiny"><a>© COPYRIGHT SKYHIGH - GROUP 1</a></div>
</body>
</html>