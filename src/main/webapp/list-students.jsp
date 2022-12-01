<%--
  Created by IntelliJ IDEA.
  User: romainpasquier
  Date: 24/11/2022
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.* ,com.example.javajeetutorial.*" %>
<html>
<head>
    <title>Web Student Book</title>
</head>
<% List<Student> theStudents = (List<Student>)request.getAttribute("STUDENT_LIST"); %>
<body>
<!-- ${STUDENT_LIST}-->
<%= theStudents %>
</body>
</html>
