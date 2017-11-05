<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>Email</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.email}</td>
				<td><a href="user?name=${user.name}">Go to user page</a></td>

				   <td><form action="deleteUser" method="post">
           	<input type="submit" value=" Delete " />
           	 <input type="hidden" value="${user.id}" name="id" />
           </form>
           </td>
		</c:forEach>
	</table>
	<form action="addUser" method="post">
   		Add user<br>
   		  Id <input type="text" name="id">
   			Name <input type="text" name="name">
   			E-mail <input type="text" name="mail">

   					<input type="submit" value=" Add ">
   	</form>
   	Find user
   	<form action="findUser" method="post">
               	 <input type="text" name="name" />
               	 <input type="submit" value=" Find " />
    </form>
   <form action="logout" method="post">
   	<input type="submit" value=" Logout " />
   </form>
</body>
</html>