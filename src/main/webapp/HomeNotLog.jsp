<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page import="java.sql.*" %>
    <%@page import="java.sql.Connection" %>
    <%@page import="airlines.connection.ConnectionManager" %>
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
		<a class="logoHome" id="logoHome" href="HomeNotLog.jsp"><img class="headlog" src="img/skyhighLg-smaller.png" alt="logo"></a>
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
	    
	</section>
	<img class="logo" src="img/skyhighLg.png" alt="logo">
<!-- START FORM -->
<form action="FlightController" method="get">
<input type="hidden" name="action" value="searchFlight">
<input type="hidden" name="sesh" value="notlog">
<div class="findBox">

	<div class="top-box">
		<div class="top-IdvBox">
			<div class="top">
				FROM <br>
				<select class="in" id="from_f" name="from_f">                   <!-- retrieve here -->
				<%
 					try{
 						
 						Connection con = null; 
 						Statement stmt =null;
 						ResultSet res = null;
 						
 						con = ConnectionManager.getConnection();
 						
 						stmt = con.createStatement();
 						String sql = "SELECT * FROM airport";
 						res = stmt.executeQuery(sql);
 						
 						while (res.next()){
 							%>
 							<option><%=res.getString("airportcode") %></option>
 							<%
 						}
 						
 					}catch (Exception e){
 						e.printStackTrace();
 					}
 				%>
				</select>
			</div>
		</div>
		<div class="top-IdvBox">
			<div class="top">
				TO <br>
				<select class="in" id="to_f" name="to_f">                          <!-- retrieve here -->
				<%
 					try{
 						
 						Connection con = null; 
 						Statement stmt =null;
 						ResultSet res = null;
 						
 						con = ConnectionManager.getConnection();
 						
 						stmt = con.createStatement();
 						String sql = "SELECT * FROM airport";
 						res = stmt.executeQuery(sql);
 						
 						while (res.next()){
 							%>
 							<option><%=res.getString("airportcode") %></option>
 							<%
 						}
 						
 					}catch (Exception e){
 						e.printStackTrace();
 					}
 				%>
				</select>
			</div>
		</div>
	</div>
	
	<div class="low-box">
		<div class="low-IdvBox">
		<div class="low-box">
		<input type="radio" id="em" name="flighttype" value="One-way" style="margin-right: 0px">
		<label class="RadioButton" for="em"> One Way </label>
		</div>
		<div class="low">
		<input type="radio" id="ph" name="flighttype" value="Round-trip" style="margin-right: 0px">
		<label class="RadioButton" for="ph"> Round Trip</label>     <!-- round trip here -->
		</div>
	    </div>
	    
		
		<div class="low-IdvBox">
			<div class="low">
				DEPART
			</div>
			<div class="low">
			<div class="dateDe-con">
			<input class="in" type="date" name="fromDate" max="" id="fromDate">            <!-- retrieve here -->
			</div>
			</div>
		</div>
		
		<div class="low-IdvBox">
		<div id="toggleRound" class="toggleRound">
			<div class="low">
				RETURN
			</div>
			<div class="low">
			<div class="dateRe-con">
			<input class="in" type="date" name="toDate" min="" id="toDate">                 <!-- retrieve here -->
			</div>
			</div>
		</div>
		</div>
		
		<script type="text/javascript">
		 
			document.getElementById('ph').addEventListener('click', function(){
				toggleRound.classList.add('show');
			});
			
			document.getElementById('em').addEventListener('click', function(){
				toggleRound.classList.remove('show');
			});
			
		</script>
		
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		
		<input type="hidden" name="departuredate" id="departuredate" value=""/>  
		<input type="hidden" name="returndate" id="returndate" value=""/> 
		
		<script type="text/javascript">
			var fromDate;
			$('#fromDate').on('change', function(){
				fromDate= $(this).val();
				$('#toDate').prop('min', function(){
					return fromDate;
				})
				document.getElementById('departuredate').value = fromDate;
			});
			var toDate;
			$('#toDate').on('change', function(){
				toDate= $(this).val();
				$('#fromDate').prop('max', function(){
					return toDate;
				})
				document.getElementById('returndate').value = toDate; <!-- dk what to put -->
			});
		</script>
	</div>
</div>

<div class="but-con">
<input class="sub" type="submit" value="Search">
</div>

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