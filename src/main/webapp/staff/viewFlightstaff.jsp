<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%
  response.addHeader("Pragma", "no-cache");
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
  response.addHeader("Cache-Control", "pre-check=0, post-check=0");
  response.setDateHeader("Expires", 0);

  if(session.getAttribute("sessionEmail")==null)	  
      response.sendRedirect("Login.jsp");
  %> 
  
  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight | SkyHigh Airline</title>
<script src="https://kit.fontawesome.com/9ed6a12a9d.js"></script>
<link rel="stylesheet" href="css/style.css">
<link rel="shortcut icon" type="x-icon" href="img/SKYHIGHICO.ico"/>
<link href="/images/images/logo/favicon.png" rel="shortcut icon" type="image/vnd.microsoft.icon">
</head>
<body background="img/skyHighBG.jpg">

<!-- For header and sticky header -->
	<header>
		<a class="logoHome" id="logoHome" href="HomeController?action=homeS"><img class="headlog" src="img/skyhighLg-smaller.png" alt="logo"></a>
		<ul>
			<li class="selHo"><a href="ReportController?action=report">REPORT</a></li>
			<li class="selHo"><a href="BookingController?action=listBooking">BOOKING</a></li>
			<li class="selHo"><a href="FlightController?action=showallFlight">FLIGHT</a></li>
			<li class="selHo"><a href="PassengerController?action=passengerList">PASSENGER</a></li>
			<li class="selHo"><a href="StaffController?action=staffList">STAFF</a></li>
		</ul>
		<a class="cta" href="LogoutController"><button>LOGOUT</button></a>
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

<!-- START VIEW -->
<div class="containerV">
	<h2>FLIGHT DETAILS</h2><br><br>
	<c:choose>
	<c:when test="${flight.flighttype=='One-way'}">
	<div class="view-box">
		<div class="view-IdvBox">
				<label for="f_from">FROM:</label>
				
					(<c:out value="${flight.from_f}"/>) <c:out value="${airportf.airportname}"/>
				
				
		</div>
		<div class="view-IdvBox">
			<label for="f_to">TO:</label>
				(<c:out value="${flight.to_f}"/>) <c:out value="${airportT.airportname}"/>
			
		</div>
	</div>
	
	<div class="viewD-box">
		<div class="viewD-IdvBox">
			<label for="departuredate">DEPARTURE DATE:</label>
			<c:out value="${flight.departuredate}"/><br>
			<label for="departuretime">DEPARTURE TIME:</label>
			<c:out value="${flight.departuretime}"/><br>
		</div>
		
		<div class="viewD-IdvBox">
			<label for="arrivaldate">ARRIVAL DATE:</label>
			<c:out value="${flight.arrivaldate}"/><br>
			<label for="arrivaltime">ARRIVAL TIME:</label>
			<c:out value="${flight.arrivaltime}"/><br>
		</div>
	
	</div>
	</c:when>
	<c:otherwise>
	<div class="viewD-box">
		<div  class="left-rightProfile">
		<label for="f_from">FROM:</label>
					(<c:out value="${flight.from_f}"/>) <c:out value="${airportf.airportname}"/><br>
		<label for="f_to">TO:</label>
					(<c:out value="${flight.to_f}"/>) <c:out value="${airportT.airportname}"/><br>
			<label for="departuredate">DEPARTURE DATE:</label>
			<c:out value="${flight.departuredate}"/><br>
			<label for="departuretime">DEPARTURE TIME:</label>
			<c:out value="${flight.departuretime}"/><br><br>
			<label for="arrivaldate">ARRIVAL DATE:</label>
			<c:out value="${flight.arrivaldate}"/><br>
			<label for="arrivaltime">ARRIVAL TIME:</label>
			<c:out value="${flight.arrivaltime}"/><br>
		</div>
		
		<div  class="left-rightProfile">
		<label for="f_to">FROM:</label>
				(<c:out value="${flight.to_f}"/>) <c:out value="${airportT.airportname}"/><br>
		<label for="f_from">TO:</label>
				(<c:out value="${flight.from_f}"/>) <c:out value="${airportf.airportname}"/><br>
			<label for="returndate">DEPARTURE RETURN DATE:</label>
			<c:out value="${flight.returndate}"/><br>
			<label for="returntime">DEPARTURE RETURN TIME:</label>
			<c:out value="${flight.returntime}"/><br><br>
			<label for="arrivalreturndate">ARRIVAL RETURN DATE:</label>
			<c:out value="${flight.arrivalreturndate}"/><br>
			<label for="arrivalreturntime">ARRIVAL RETURN TIME:</label>
			<c:out value="${flight.arrivalreturntime}"/><br>
		</div>
	
	</div>
	
	
	
	</c:otherwise>
	</c:choose>
	
		<br>
		<table> 
			<tr><td class="normal"><label for="flightid">FLIGHT ID:</label>
			<c:out value="${flight.flightid}"/></td>
		
		
		
			<td class="normal"><label for="flighttype">FLIGHT TYPE:</label>
			<c:out value="${flight.flighttype}"/></td>
	
			</tr>
	</table><label for="price">PRICE:</label>
			<c:out value="${flight.price}"/><br>
	<a href="FlightController?action=showallFlight" class="sub1">Back</a><br>
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