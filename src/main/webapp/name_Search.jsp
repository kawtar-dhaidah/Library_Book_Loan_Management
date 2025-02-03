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
<br><br><br>
	<h1>Espace d'Emprunts</h1>
	<h2>Resultat de %<%=request.getParameter("search_name") %>%</h2>
	<br><br><br>
	<div class="search_zone">
	<form method="Post" action="FiltreServlet">
		<div class="searchbox1">
		<input class="searchbox" name="search_name" type="text" placeholder="search">
		<input class="searchbutton" type="submit" value="Search">
		</div>
		
		<div class="searchbox2">
		<input  class="searchbox" name="search_Date" type="date">
		<input  class="searchbutton"type="submit" value="Search">
		</div>
	</form>
	</div>
	
	<br><br><br><br>
	<br><br>
	
	
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
      
    </tr>
    <tr>
   
    </tr>
     
		<% List<Emprunt> Emprunts = new ArrayList<>();
		Emprunts=(List<Emprunt>)request.getAttribute("client");
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
		<td><a href="Etat_update.jsp?id=<%=Emprunts.get(i).getID()%>">D�tails</a></td>
		
		 </tr>
		<% }%>
		
		
		

</table>


</body>
</html>