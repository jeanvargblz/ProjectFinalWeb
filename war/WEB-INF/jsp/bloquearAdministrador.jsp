<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="pw2.*"%>
<%@ page import="java.util.*;"%>
<% List<Usuario> array = (List<Usuario>) request.getAttribute("lista");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="../js/accionAdmin.js"></script>
<title>Bloquear Administrador</title>
</head>
<body>
	<%if(array.size() != 0) {%>
	<form action="/accionAdministrador" id="bloquearAccionAdmin">
	<%	for(Usuario r : array) {	%><br>
	<div class="relacion">
		<input type="radio" name="emailAdmin" value="<%out.print(r.getEmail());%>">
		<b>Email : </b><%	out.print(r.getEmail());%><br>
		<b>Nombre :</b> <%	out.print(r.getNombre() + " ");%>
		<b>Ape. Paterno :</b> <%	out.print(r.getPaterno() + " ");%>
		<b>Ape. Materno : </b><%	out.print(r.getMaterno());%><br>
		<b>Dni : </b><%	out.print(r.getDni());%><br>
		<%if(r.getBloqueado() == true) {%>
		<b>Estado : </b><p style="color : red">BLOQUEADO<br></p>
		<%} else {%>
		<b>Estado : </b><p style="color : green">DESBLOQUEADO<br></p>
	<%}%>
	</div>
	<%	}%>
	<br>
	<input type="submit" value="Bloquear/Desbloquear Usuario">
	</form>
	<%} else {%>
		<br>
		<b> NO EXISTE NINGUN ADMIN</b><br>
	<%}%>
	<br>

</body>
</html>