<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        if (${Error}){
            alert("Veuillez rentrer des données valides");
        }
    </script>
</head>
<body>
<c:if test="${!empty sessionScope.prenom && !empty sessionScope.nom}">
    <p> Welcome ${sessionScope.prenom} ${sessionScope.nom} </p>
</c:if>

<form action="WelcomeServlet" method="post">
    First Name: <input type="text" name="firstName" value="${Student[0]}"/>
    Last Name:<input type="text" name="lastName" value="${Student[1]}"/>
    <input type="submit" value="OK" />
</form>
</body>
</html>
