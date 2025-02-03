<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="stylee.css">
</head>
<style>
h2{
    margin-left: 2%;
    margin-top: 3%;
    color :#87CEFA;
    font-size:180%;
}

.container{
    margin-left:33%;
    margin-reight:30%;
    margin-top:4%;
   font-size:140%;
}
input{
 margin:4%;
 width:80%;
 height:45px;
}
label{
 color:gray;
}
.btn{
	display: inline-block;
  padding: 15px 25px;
  font-size: 24px;
  cursor: pointer;
  text-align: center;
  text-decoration: none;
  outline: none;
  color: #fff;
  background-color:#87CEFA;
  border: none;
  border-radius: 15px;
  box-shadow: 0 9px #999;
  margin:3%;
  margin-left:6%;
}
</style>
<body>
     <h2>Ajouter une Emprunt</h2>
     <div class="container">
     <form method="post" action="EmpruntController">
    
    <input type="text" name="nom" placeholder="Nom"><br>

    
    <input type="text" name="cin" placeholder="CIN"><br>

    
    <input type="text" name="tel" placeholder="Telephone"><br>

    
    <input type="text" name="livre" placeholder="Livre"><br>
    
    
	<input type="text" name="prix" placeholder="Prix"><br>
	
	
	<input type="date" name="date_emprunt"placeholder="Date d'Emprunt"><br>
	
	
	<input type="date" name="date_retour" placeholder="Date de Retour"> <br>
	
	<input type="submit" value="Enregistrer" class="btn">
    </form>
     </div>
</body>
</html>