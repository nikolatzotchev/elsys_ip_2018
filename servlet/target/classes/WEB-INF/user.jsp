<%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <html>
 <head>
     <title>User</title>
 </head>
 <body>
 <table>
     <tr><th> Id </th> <th> Name </th> <th> E-mail </th></tr>
     <tr>
         <td> ${user.id} </td>
         <td> ${user.name} </td>
         <td> ${user.email}</td>
     </tr>
 </table>
 <form action="user" method="post">
     <input type="hidden" value="${user.name}" name="name" />
     New name : <input type="text" name="newName" />
     New e-mail: <input type="text" name="newMail" />
     <input type="submit" value=" Update info " />
 </form>
 <form action="logout" method="post">
     <input type="submit" value=" Logout " />
 </form>

 </body>
 </html>