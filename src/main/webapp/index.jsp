<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Thinh
  Date: 12/25/2017
  Time: 3:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language= "java" %>
<html>
<head>
  <title>UploadFile</title>
</head>

<body>
<div class="container">
  <div class="row">
    <form  action="main" method="POST" enctype="multipart/form-data">
      <div class="form-group">
        <input type="file" name="file">
      </div>
      <button type="submit" class="btn btn-default"> Submit </button>
    </form>
  </div>
</div>
</body>
</html>
