<%@ page import="com.example.javajeetutorial.Student" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Web Student Tracker</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<%--<% List<Student> theStudents = (List<Student>)request.getAttribute("STUDENT_LIST"); %>--%>
<body>
<%--<%=theStudents %>--%>
<c:if test="${!empty sessionScope.prenom && !empty sessionScope.nom}">
    <p> Welcome ${sessionScope.prenom} ${sessionScope.nom} </p>
</c:if>
<div id="wrapper">
    <div id="header">
        <h2>List of SG Students</h2>
    </div>
</div>
<div id="container">
    <div id="content">
        <table>
            <tr>
                <th>First Name </th>
                <th>Last Name</th>
                <th>Email </th>
            </tr>
<%--            <% for(Student tempStudent:theStudents) { %>
            <tr>
                <td><%= tempStudent.getFirst_name() %></td>
                <td><%= tempStudent.getLast_name() %></td>
                <td><%= tempStudent.getEmail() %></td>
                    <%} %>
            </tr>--%>
            <c:forEach var="tempStudent" items="${STUDENT_LIST}" >
                <c:url var="EditLink" value= "EditStudentServlet">
                    <c:param name="studentId" value="${tempStudent.id}"/>
                </c:url>
                <tr>
                    <td> ${tempStudent.first_name}</td>
                    <td> ${tempStudent.last_name}</td>
                    <td> ${tempStudent.email}</td>
                    <td> <a href="${EditLink }"> Edit</a></td>
                </tr>
            </c:forEach>
        </table>
        <p>




        </p>
        <a href="AddStudentServlet" style="text-align: center" class="add-student-button"> Add</a>
        <a href="WelcomeServlet" style="text-align: center" class="add-student-button"> logOut</a>
    </div>
</div>
</body>
</html>
