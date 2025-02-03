<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="classes.Emprunt" %>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
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
<title> Emprunts</title>
<link rel="stylesheet" type="text/css" href="Styless.css">
</head>
<body>

<div  class="logout"  >
   <a  class="log_out"href="Logout" >Logout</a>
   </div> 
<br><br>
	<h1>Gerer Votre Espace d'Emprunts</h1>
	<h2>Changer l'état de vos emprunts</h2>
	<%session.setAttribute("id", request.getParameter("id")); %>
	<br><br><br>
	<div class="search_zone">
	
	</div>
	
	<br><br>
	<br><br>
	
	<form  method="post" action="UpdateServlet">
	<table>
    <tr>
      <th>Client</th>
      <th>CIN</th>
      <th>Telephone</th>
      <th>Livre</th>
      <th>Prix</th>
      <th>Date d'Emprunte</th>
      <th>Date de Retour</th>
      <th>Etat</th>
      <th>Action</th>
      
    </tr>
    <tr>
   
    </tr>
     
		<% List<Emprunt> Emprunts = new ArrayList<>();
		Emprunts=Emprunt.getEmprunt_id(request.getParameter("id"));
		for (int i=0;i<Emprunts.size();i++) { 
		%>
		<tr>
		<td><%=Emprunts.get(i).getClient()%></td>
		<td><%=Emprunts.get(i).getCIN()%></td>
		<td><%=Emprunts.get(i).getTelehone()%></td>
		<td><%=Emprunts.get(i).getLivre()%></td>
		<td><%=Emprunts.get(i).getPrix()%></td>
		<td><%=Emprunts.get(i).getDate_Emprunt()%></td>
		<td><%=Emprunts.get(i).getDate_retour()%></td>
		<td><%=Emprunts.get(i).getEtat()%></td>
		<td>
			
			<label><input type="checkbox" name="etat" value="Valider" >V</label>
			<label><input type="checkbox" name="etat" value="Retard">R</label>
			
			
		
		</td>
		 </tr>
		<% }
		
		%>
		
		
		

</table>
<br><br>
	<input  class="btn" type="submit" value="Valider">
</form>



</body>
</html>