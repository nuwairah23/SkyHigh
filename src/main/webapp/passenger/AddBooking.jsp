<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%
  response.addHeader("Pragma", "no-cache");
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
  response.addHeader("Cache-Control", "pre-check=0, post-check=0");
  response.setDateHeader("Expires", 0);

  int uid=0;
  String role=null;
  String email=null;
  
  if(session.getAttribute("sessionEmail")==null)	  
      response.sendRedirect("/SkyHigh/Login.jsp");
  else
  {
		uid = (int)session.getAttribute("sessionId");
		role = (String)session.getAttribute("sessionRole");
		email = (String)session.getAttribute("sessionEmail"); 
	  
  }
  %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking | SkyHigh Airline</title>
<script src="https://kit.fontawesome.com/9ed6a12a9d.js"></script>
<link rel="stylesheet" href="css/style.css">
<link rel="shortcut icon" type="x-icon" href="img/SKYHIGHICO.ico"/>
<link href="/images/images/logo/favicon.png" rel="shortcut icon" type="image/vnd.microsoft.icon">
</head>

<body background="img/skyHighBG.jpg">

<!-- For header and sticky header -->
	<header>
		<a class="logoHome" id="logoHome" href="passenger/HomeLog.jsp"><img class="headlog" src="img/skyhighLg-smaller.png" alt="logo"></a>
		<ul>
			<li class="selHo"><a href="#explore">EXPLORE</a></li>
			<li class="selHo"><a href="BookingController?action=listBook&id=<%=uid%>">MY BOOKING</a></li>
			<li class="selHo"><a href="PassengerController?action=viewProfile&id=<%=uid%>">PROFILE</a></li>
			<li class="selHo"><a href="#support">SUPPORT</a></li>
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
	    
	</section>


<!-- START HERE -->

	<form action="BookingController" method="post">
	<div class="container-profile">
	<div class="left-rightProfile"><div class="left-Profile">
	
		<!-- pass passenger id and details here -->
		<label for="firstname">First Name</label>:<br>  	    <c:out value="${pass.firstname}"/><br>
    	<label for="lastname">Last/Surname</label>: <br> 		<c:out value="${pass.lastname}"/><br>
    	<label for="sid">Passport/IC</label>: <br> 				<c:out value="${pass.passport_ic}"/><br>   	
    	<label for="price">Address</label>: <br> 				<c:out value="${pass.address}"/><br>	
      	<label for="quantity">Contact Number</label>: <br> 		<c:out value="${pass.contactnumber}" /><br>    	
        
        <input type="hidden" name="passid" id="passid" value="${pass.passengerid}">
        
	</div></div>
	<input type="hidden" name="fid" id="fid" value="${fli.flightid}"/>
	<div class="left-rightProfile"><div class="right-Profile">
	
	
		<c:choose><c:when test="${f.flighttype=='One-way'}">
		
		<div class="up-downProfile"> 
		<!-- flight details picked -->
		<label for="flightid">Flight ID</label>:         		<c:out value="${fli.flightid}"/><br>
		<label for="from">FROM</label>:           				<c:out value="${fli.from_f}"/><br>
		<label for="to">TO</label>:           					<c:out value="${fli.to_f}"/><br>
    	<label for="departuredate">Departure Date</label>:		<c:out value="${fli.departuredate}"/><br>    	
    	<label for="departuretime">Departure Time</label>:      <c:out value="${fli.departuretime}"/><br>	
      	<label for="arrivaldate">Arrival Date</label>:        	<c:out value="${fli.arrivaldate}"/><br>   	
        <label for="arrivaltime">Arrival Time</label>:          <c:out value="${fli.arrivaltime}"/><br><br>
        
        
		</div><br> </c:when>
		<c:otherwise>
		
		<div class="up-downProfile"> 
		<!-- flight details picked -->
		<label for="flightid">Flight ID</label>:         		<c:out value="${fli.flightid}"/><br>
		<label for="from">FROM</label>:           				<c:out value="${fli.from_f}"/><br>
		<label for="to">TO</label>:           					<c:out value="${fli.to_f}"/><br>
    	<label for="departuredate">Departure Date</label>:		<c:out value="${fli.departuredate}"/><br>    	
    	<label for="departuretime">Departure Time</label>:      <c:out value="${fli.departuretime}"/><br>	
      	<label for="arrivaldate">Arrival Date</label>:        	<c:out value="${fli.arrivaldate}"/><br>   	
        <label for="arrivaltime">Arrival Time</label>:          <c:out value="${fli.arrivaltime}"/><br><br>
		</div>
		
		<div class="up-downProfile"> 
		<!-- flight details picked -->
		<label for="flightid">Flight ID</label>:           		<c:out value="${fli.flightid}"/><br>
		<label for="from">FROM</label>:           				<c:out value="${fli.to_f}"/><br>
		<label for="to">TO</label>:          					<c:out value="${fli.from_f}"/><br>
    	<label for="departuredate">Departure Date</label>: 		<c:out value="${fli.returndate}"/><br>    	
    	<label for="departuretime">Departure Time</label>:      <c:out value="${fli.returntime}"/><br>
      	<label for="arrivaldate">Return Arrival Date</label>:   <c:out value="${fli.arrivalreturndate}"/><br>   	
        <label for="arrivaltime">Return Arrival Time</label>:   <c:out value="${fli.arrivalreturntime}"/><br><br>
       
		</div><br>
		</c:otherwise>
		</c:choose>
		<div class="up-downProfile">
		
		  
		RM <input class="fliPrice" id="fliPrice" name="fliPrice" value="${fli.price}" readonly> x <input type="number" class="NumOfPass" id="NumOfPass" name="NumOfPass" min="1" value="1" step="1">
		<br><br>Total <a class="sub" id="equal">=</a> <input name="tprice" id="tprice" value="0" readonly> include tax
		
		<!-- calculation per guest -->
		
		</div>
	</div></div>
	
	<script type="text/javascript">
		var fliprice = document.getElementById("fliPrice");
		var NumOfPass = document.getElementById("NumOfPass");
		var tprice = document.getElementById("tprice");
		
		document.getElementById("equal").addEventListener('click', function () {
			console.log(parseFloat(NumOfPass.value));
			console.log(parseFloat(fliprice.value));
			
			var t;
			 t =(parseFloat(NumOfPass.value)*parseFloat(fliprice.value));
			 taxed = t*(6/100);
			 tprice.value = t+taxed;
			 console.log(taxed);
			
		});
	</script>
	
</div>

<a class="sub" id="open">CONTINUE</a>

<div class="modal-container" id="modal_container">
<div class="modal">
<div class="exit"><a class="btn-mdl2" id="close">X</a></div>
<h2><mark>Choose Your Payment Method</mark></h2><br>



<div class="name">

		<div class="low">
		<input type="radio" id="db" name="paymenttype" value="Debit-Credit" style="margin-right: 0px">
		<label class="RadioButton" for="em">Debit/Credit</label>
		</div>
		<div class="low">
		<input type="radio" id="ob" name="paymenttype" value="Online Banking" style="margin-right: 0px">
		<label class="RadioButton" for="ob"> Online Banking</label>     <!-- round trip here -->
		</div>
		<div class="low">
		<input type="radio" id="pp" name="paymenttype" value="PayPal" style="margin-right: 0px">
		<label class="RadioButton" for="pp"> PayPal</label>     <!-- round trip here -->
		</div>
	 <div class="low">
		<input type="radio" id="gp" name="paymenttype" value="GrabPay" style="margin-right: 0px">
		<label class="RadioButton" for="gp"> GrabPay</label>     <!-- round trip here -->
		</div>
	<br><br>
</div>
<% 
java.util.Date utilDate = new java.util.Date();
java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
%>
<input type="hidden" name="datebookingmade" value="<%=sqlDate %>" />
<input type="submit" class="sub" value="PAY NOW">

</div></div>
<script type="text/javascript" src="js/signup.js"></script>

</form>


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