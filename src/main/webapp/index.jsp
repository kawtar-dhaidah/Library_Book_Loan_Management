<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" %>
<%
String login="";
if (session.getAttribute("login")!=null){
	login=session.getAttribute("login").toString();
}else{
	response.sendRedirect("auth.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="stylee.css">
<title>LOGIN</title>
<style>
#title{
	color:gray;
	font-size:280%;
	margin-left:39%;
	margin-right:40%;
	
}
button{
	border-radius:20px 20px 20px 20px;
	background-color:#87CEFA;
    border: 1px ;
    margin:5%;
    padding: 20px;  
	
}
#btn{
	color :white;
	font-size:20px;
	margin-top:-20%;    
	margin: 64px;
}
.container{
	margin-left:35%;
	margin-right:30%;
	margin-top:10%;
	
}
a{
text-decoration: none;}
.logout{
	
  background:#d8d8d8;
  width: 100px;
  cursor:pointer;
  position:absolute;
  right:2%;
  border-radius:50px;
  padding:10px 20px 10px 0;
  color:White;
  font-size:14px;
  text-align:left;
  text-indent:40px;
  display:block;
  margin:0 auto;
  font-family: Arial, Helvetica, sans-serif;
 
 
  /* Animations: */
  -webkit-transition-timing-function: ease-in-out;
  -webkit-transition-duration: .4s;
  -webkit-transition-property: all;
  
  -moz-transition-timing-function: ease-in-out;
  -moz-transition-duration: .4s;
  -moz-transition-property: all;
  
}
.logout:hover {
  background-image: url( 'https://dh3vbjnk0bnfa.cloudfront.net/static/centralauth/images/btn-login.png' );
  background-position: 65px 5px;
  text-indent: 15px;  
}


.log_out{
	text-decoration: none;
  	outline: none;
  	color: black;
}

</style>

</head>
<body>
 <div  class="logout"  >
   <a  class="log_out"href="Logout" >Logout</a>
   </div>
  
    <div id="title">Welcome <%=login %></div>
    
  
   
   
   <div class="container">
   <div id="b1"><button><a href="tab_emp.jsp" id="btn">GESTION DES PRETS</a></button></div>
	<div id="b2"><button><a href="List" id="btn">GESTION DES LIVRES</a></button></div>
	</div>
</body>
</html>