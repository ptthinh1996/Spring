<%@ page import="practice.sv.bai1.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html land = "en">
<head>
    <title>Show</title>
</head>
<body>
<div>
    <h1>List Student</h1>
    <div>
        <c:forEach items="${students}" var="student">
            <div>
                <ul>
                    <li>${student.lastName}</li>
                    <li>${student.firstName}</li>
                    <li>${student.birthDay}</li>
                    <li>${student.email}</li>
                </ul>
                <br>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
