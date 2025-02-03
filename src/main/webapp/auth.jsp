<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">


#ssbt{
 background-color:gray;
 color:white;
 border:1px solid  #87CEFA;
 font-size:70%;
 background-color: #87CEFA;
 width: 36%;
 height: 50%;
 margin:4%;
}
ssbt:hover {
  opacity: 0.8;
}
.container{
    margin-left:31%;
    margin-reight:30%;
    margin-top:7%;
   font-size:140%;
}
h1{
    margin-left: 44%;
    margin-top: 10%;
    color : #87CEFA;
}

#inpt{
  border-radius:10% 10% 10% 10%;
  width: 155%;
  height: 50%;
  margin:7%;
  border-style: solid 0.5px gray;
  
}

</style>
<title>Login</title>
</head>
<body>
<h1 >Login page</h1>
	<div class="container">
	   <form action="Login" method="post">
	   <table>
		   <tr >
		   		<td>Enter Name:</td>
		   		<td><input type="text" name="login" required id="inpt"></td>
		   </tr>
		   <tr >
		   		<td>Password:</td>
		   		<td><input type="password" name="pwd" required id="inpt"></td>
		   </tr>
		   <tr>
		   		<td colspan="2"><input type="submit" value="Log in " id="ssbt"></td>
	      </tr>
     </table>
     </form>
   </div>
   
</body>
</html>