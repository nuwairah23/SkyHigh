<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SkyHigh Airline</title>
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
			<li class="selHo"><a href="#support">SUPPORT</a></li>
			<li class="selHo"><a href="#explore">EXPLORE</a></li>
		</ul>
		<a class="cta" href="Login.jsp"><button>LOGIN</button></a>
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
		<br><br><br><br><br>
	    <img class="logo" src="img/skyhighLg.png" alt="logo">
	</section>
	
<!-- START LIST -->

<div class="table-pad">
	<table class="table flight">
	
	
	<c:forEach items="${flight}" var="f">
	<c:choose>
	<c:when test="${f.flighttype=='One-way'}">
	<tr>
		<td><div><c:out value="${f.from_f}"/></div><div></div><div><c:out value="${f.departuretime}"/></div></td>
		<td><div><c:out value="${f.to_f}"/></div><div></div><div><c:out value="${f.arrivaltime}"/></div></td>
		<td>RM: <c:out value="${f.price}"/></td>
		<td><a href="FlightController?action=viewFlight&to_f=<c:out value="${f.to_f}"/>&from_f=<c:out value="${f.from_f}"/>&flightid=<c:out value="${f.flightid}"  />" class="sub">Choose</a>
		</td>
	</tr>
	</c:when>
	<c:otherwise>
  
	<tr>
		<td><div><c:out value="${f.from_f}"/></div><div></div><div><c:out value="${f.departuretime}"/></div></td>
		<td><div><c:out value="${f.to_f}"/></div><div></div><div><c:out value="${f.arrivaltime}"/></div></td>
		<td><div><c:out value="${f.to_f}"/></div><div></div><div><c:out value="${f.returntime}"/></div></td>
		<td><div><c:out value="${f.from_f}"/></div><div></div><div><c:out value="${f.arrivalreturntime}"/></div></td>
		<td>RM: <c:out value="${f.price}"/></td>
		<td><a href="FlightController?action=viewFlight&to_f=<c:out value="${f.to_f}"/>&from_f=<c:out value="${f.from_f}"/>&flightid=<c:out value="${f.flightid}"  />" class="sub">Choose</a>
		</td>
	</tr>

	</c:otherwise>
	</c:choose>

	</c:forEach>
	</table>

</div>


<!-- Footer start here -->
	<br><br><br>
	<div><img class="foot" src="img/footerC.png" alt="footer"></div>
	
	<div class="feet">
		<div class="generic-container flex flex-wrap">
			<div class="flex  flex-wrap w-4/4 md:w-full body-text-2">
	
	<div class="rowcol">			
		<div data-component="accordion" class="accordion-root">
			<div class="accordion-title">
				<h5 class="flex items-center"><span class="column-title">About Us</span></h5> 
		    </div> 
			<div class="accordion-content overflow-hidden" style="height: 155px;"> 
			<ul class="column-list mt-2 list-none pl-0" style="list-style: none;">
			<li class="column-list-item"><a href="#Our Network">Our Network</a></li> 
			<li class="column-list-item"><a href="#BrandActivities">Brand Activities</a></li> 
			<li class="column-list-item"><a href="#Newsroom">Newsroom</a></li>
		 	<li class="column-list-item"><a href="#Careers">Careers</a></li></ul>
		 	</div>
		 </div>
	</div> 
	
	<div class="rowcol">
		<div data-component="accordion" class="accordion-root">
		 	<div class="accordion-title">
		 		<h5 class="flex items-center"><span class="column-title">Support</span></h5>
		 	</div> 
		  	<div class="accordion-content overflow-hidden" style="height: 125px;"> 
		 		<ul class="column-list mt-2 list-none pl-0" style="list-style: none;">
		 		<li class="column-list-item"><a href="#faqs">FAQs</a></li> 
		 		<li class="column-list-item"><a href="#store-finder">Find a Store</a></li> 
		 		<li class="column-list-item"><a href="#self-help">Self Help </a></li> 
		 		<li class="column-list-item"><a href="#contact-us">Contact Us</a></li></ul>
		  	</div>
		</div>
	</div> 
		 
	<div class="rowcol">
		<div data-component="accordion" class="accordion-root">
		    <div class="accordion-title">
		    	<h5 class="flex items-center"><span class="column-title">Terms &amp; Notices</span></h5>
		    </div> 
		    <div class="accordion-content overflow-hidden" style="height: 96px;"> 
		    	<ul class="column-list mt-2 list-none pl-0" style="list-style: none;">
		    	<li class="column-list-item"><a href="#important-notices">Important Notices</a></li> 
		    	<li class="column-list-item"><a href="#terms-conditions">Terms &amp; Conditions</a></li> 
		    	<li class="column-list-item"><a href="#privacy-notice">Privacy Notice</a></li></ul><br>
		    	<h5 class="column-title">Connect with Us</h5> 
		    	<div class="flex mt-2 mb-6">
		    		<a href="#facebook" target="_blank"><i class="fa-brands fa-facebook-square"></i></a> 
		    		<a href="#twitter" target="_blank"><i class="fa-brands fa-instagram"></i></a> 
		    		<a href="#instagram" target="_blank"><i class="fa-brands fa-twitter"></i></a> 
		    		<a href="#youtube" target="_blank"><i class="fa-brands fa-youtube"></i></a> 
		    	</div>
		     </div>
		 </div>
	</div> 
		    
<div class="rowcol">
        <div class="rowcol"><h5 class="column-title"> Contact Us</h5> 
            <div class="sp-module-content">
                <div class="custom">
                    <table style="width: 100%;"><tbody>
                      <tr><td>
                        <span style="color: black;"><strong>Sky High Sdn. Bhd.</strong></span><br>
                        <span style="color: black;">No. 155, Jalan Tun Razak,</span><br>
                        <span style="color: black;">50400 Kuala Lumpur,</span><br>
                        <span style="color: black;">Malaysia.</span><br><br>
                        <span style="color: black;"><a style="color: black;" href="#">webskyhigh@mail.com.my</a></span><br><br>
                        <span style="color: black;"><strong>Tel</strong>: <span style="color: black;">+603-5544 2000</span></span><br>
                      </td></tr>
                    </tbody></table>
                </div>
            </div> 
        </div>
    </div>
            </div>
        </div>
    </div>

<!-- Tiny footer -->
            <div class="tiny"><a>© COPYRIGHT SKYHIGH - GROUP 1</a></div>
</body>
</html>