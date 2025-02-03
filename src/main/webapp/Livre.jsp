<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>Livres</title>
<link rel="stylesheet" href="/lstyle.css">
</head>
<style>
* {
  
    box-sizing: border-box;
    margin: 10px 0px 0px 10px;

    
}

body,html {
  
     position: center;
   self-content:center;
}
body {
    align-items: center;
    background: #ecf0f3;
    color: $font-color;
    display: grid;
    font-family: $font-family;
    font-size: 14px;
    font-weight: 400;
    height: 100vh;
    justify-items: center;
}

a {
   
  text-align: center;
}

a:focus {
    outline: none!important
}

a:hover {
    text-decoration: none
}
div {
    border-spacing: 1;
    border-collapse: collapse;
    background: #ecf0f3;
    border-radius: 10px;
    overflow: hidden;
    width: 100%;
    position: relative;
    position:center;align-content:center;
      box-shadow: 14px 14px 20px #cbced1, -14px -14px 20px white;
    
   
   
}

table * {
    position: relative
    }
    
 td {
      padding:20px;
    pargin :10px;
 }
 h1{

        font-size: 24px;
       margin-top: 10px;
  font-weight: 900;
  font-size: 1.8rem;
  color: #1DA1F2;
  letter-spacing: 1px;
  text-align: center;
 }
 
/* input {
      border: 1px solid $form-border-color;
      border-radius: 4px;
      height: 30px;
      line-height: 38px;
      padding-left: 5px;
    }*/
    input::placeholder {
  color: gray;
}

input {
  background: #ecf0f3;
  padding: 10px;
  padding-left: 20px;
  height: 50px;
  font-size: 14px;
  border-radius: 50px;
  box-shadow: inset 6px 6px 6px #cbced1, inset -6px -6px 6px white;
}
  
 .sub{
 
 color: white;
  margin-top: 20px;
  background: #1DA1F2;
  height: 40px;
  width:100px;
  border-radius: 20px;
  cursor: pointer;
  font-weight: 900;
  box-shadow: 6px 6px 6px #cbced1, -6px -6px 6px white;
  transition: 0.5s;
 }
 
 .sub:hover {
  box-shadow: none;
}
.lis{
 position: absolute;
  font-size: 19px;
  bottom: 4px;
  right: 4px;
  text-decoration: none;
  color: black;
  background: #1DA1F2;
  border-radius: 10px;
  padding: 2px;}
tr>td{
  
  font-size: 21px;

}
.logout{
	
  background:#d8d8d8;
  width: 100px;
  cursor:pointer;
  position:absolute;
  right:2%;
  top:2%;
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
  .logout:hover {background-image: url( 'https://dh3vbjnk0bnfa.cloudfront.net/static/centralauth/images/btn-login.png' );background-position: 65px 5px;text-indent: 15px;  }


.log_out{text-decoration: none;outline: none;color: black;}

</style>

<body  >
<div  class="logout"  >
   <a  class="log_out"href="Logout" >Logout</a>
   </div> 
<form action="Stock" method="post">

<div><h1>Ajout des livres</h1>
		<table  class="table table-hover">

			<tr>		
			

				<td> Nom de livre</td>
				<td><input type="text" name="uname" placeholder="Entrer le nom de livre"></td>
			</tr>
			<tr>
				<td>Auteur</td>
				<td><input type="text" name="auteur" placeholder="Entrer l'auteur de livre"></td>
			</tr>
			<tr>
				<td>Prix</td>
				<td><input type="text" name="prix" placeholder="Entrer le prix de livre"></td>
			</tr>
			<tr>
				<td>Qte</td>
				<td><input type="text" name="qte" placeholder="Entrer la quantit� de livre"></td>
			</tr>
			<tr>
				<td></td>
			
				<td> <a href='Livre.jsp'><input class="sub"  type="submit" value="Add"></a></td>
			</tr>
			
		</table>
		 <a href='List' class="lis" >Book List</a></div>
	</form>
</body>
</html>