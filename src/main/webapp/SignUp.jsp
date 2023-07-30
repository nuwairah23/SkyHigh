<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://kit.fontawesome.com/9ed6a12a9d.js"></script>
<meta charset="ISO-8859-1">
<title>Sign Up | SkyHigh Airline</title>

<script src="https://kit.fontawesome.com/9ed6a12a9d.js"></script>
<link rel="stylesheet" href="css/style.css">
<link rel="shortcut icon" type="x-icon" href="img/SKYHIGHICO.ico"/>

<link href="/images/images/logo/favicon.png" rel="shortcut icon" type="image/vnd.microsoft.icon">
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
<form action="signupController" method="post">

<div class="title-highlight">
	
			<h1><mark> Sign Up  </mark></h1>
			<h2>Welcome aboard!</h2><br><br>
			
</div>

Email<br>
	<input class="in" type="text" name="email" id="email" placeholder="Email">
	<br><br>
<div class="pw">
Password<br>
	<input class="in" type="password" name="password" id="password" placeholder="Password">
	<div class="padd">Already have an account?<a href="Login.jsp"> Login</a> here.</div><br>
</div>

<a class="sub" id="open">Register for free!</a>


<div class="modal-container" id="modal_container">
<div class="modal">
<div class="exit"><a class="btn-mdl2" id="close">X</a></div>
<h2><mark>Hello there. What's is your name?</mark></h2><br>



<div class="name-box">
Name<br>
	<input class="in" type="text" name="name" id="name" placeholder="Given Name as in IC/Passport">
	<br>
Family name/Surname<br>
	<input class="in" type="text" name="lname" id="lname" placeholder="Family name/surname as in IC/Passport">
	<br><br>
</div>

Phone number<br>
	<input class="in" type="text" name="pnum" id="pnum" placeholder="Phone Number">
	<br><br>

<input class="in" type="hidden" name="role" value="passenger">

<div class="ButCon"><input class="sub" type="submit" value="SUBMIT"></div> <!-- button submit here -->
</div></div>
<script type="text/javascript" src="js/signup.js"></script>

</form>

<!-- Footer start here -->
	<br>
	<div><img class="foot-login-signup" src="img/footerC.png" alt="footer"></div>
	
<!-- Tiny footer -->
			<div class="tiny"><a>© COPYRIGHT SKYHIGH - GROUP 1</a></div>
</body>

</html>