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
<title>HOME PAGE </title>
</head>

<body>
   <div  class="logout"  >
   <a  class="log_out"href="Logout" >Logout</a>
   </div> 
   <br><br><br><br>
   <h4>Table des Emprunts</h4>    
    <button class="btn"><a href="gest_emp.jsp">Ajouter Emprunt</a></button> 
    <button class="btn"><a href="List_Retard.jsp">Prêts en Retard</a></button>  
    <button class="btn"><a href="Filtre.jsp">Gestion des Prêts</a></button>                                   
   <table border="1" width="100%">
   <tr>
     <th>Id</th>
     <th>Nom</th>
     <th>CIN</th>
     <th>Telephone</th>
     <th>Livre</th>
     <th>Prix</th>
     <th>Date d'Emprunt</th>
     <th>Date de Retour</th>
     <th>Etat</th>
   </tr>
   <%
   int nbr=0;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
		 PreparedStatement ps=con.prepareStatement("select * from emprunt");
		 ResultSet rs=ps.executeQuery();
		 while(rs.next()){
			 %>
			 <tr>
			     <td><%=rs.getString(1) %></td>
			     <td><%=rs.getString(2) %></td>
			     <td><%=rs.getString(3) %></td>
			     <td><%=rs.getString(4) %></td>
			     <td><%=rs.getString(5) %></td>
			     <td><%=rs.getString(6) %></td>
			     <td><%=rs.getString(7) %></td>
			     <td><%=rs.getString(8) %></td>
			     <td><%=rs.getString(9) %></td>
			 </tr>
			 <% 
		 }
		ps=con.prepareStatement("select COUNT(*) from emprunt");
		rs=ps.executeQuery();
		rs.next();
		nbr= rs.getInt(1);
		rs.close();
		ps.close();
		con.close();
}catch(ClassNotFoundException e){
	e.printStackTrace();
} catch (SQLException e) {
	e.printStackTrace();
}
   %>
   </table>
   le nombre des emprunts : <%=nbr %>
   
   
   
</body>
</html>