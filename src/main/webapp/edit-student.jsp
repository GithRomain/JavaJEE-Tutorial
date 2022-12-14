<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="css/add-student-style.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <title>Edit a student</title>
</head>
<body>
<c:if test="${!empty sessionScope.prenom && !empty sessionScope.nom}">
    <p> Welcome ${sessionScope.prenom} ${sessionScope.nom} </p>
</c:if>
<div id="wrapper">
    <div id="header">
        <h2>SG Students</h2>
    </div>
</div>
<div id="container">
    <h3> Edit a Student</h3>
    <form action="EditStudentServlet" method = "post">
        <table>
            <tbody>
            <tr>
                <td><label>FirstName: </label> </td>
                <td><input type="text" name = "firstName" value="${Student.first_name}"/></td>
            </tr>
            <tr>
                <td><label>LastName: </label> </td>
                <td><input type="text" name = "lastName" value="${Student.last_name}"/></td>
            </tr>
            <tr>
                <td><label>Email: </label> </td>
                <td><input type="text" name = "email" value="${Student.email}"/></td>
            </tr>
            <tr>
                <td><label></label> </td>
                <td><input type="submit" value = "Save"/></td>
            </tr>
            </tbody>
        </table>
    </form>
    <div style="clear:both;"></div>
    <a href="StudentControllerServlet">Back to List</a>
    <a href="WelcomeServlet" style="text-align: center" class="add-student-button"> logOut</a>
</div>
</body>
</html>
