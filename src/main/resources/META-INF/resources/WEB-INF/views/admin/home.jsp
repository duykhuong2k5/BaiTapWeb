<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h2>Admin Dashboard</h2>
    <div class="row">
        <div class="col-md-4">
            <a href="${pageContext.request.contextPath}/admin/users" class="btn btn-primary btn-block">Manage Accounts</a>
        </div>
        <div class="col-md-4">
            <a href="${pageContext.request.contextPath}/admin/categories" class="btn btn-primary btn-block">Manage Categories</a>
        </div>
        <div class="col-md-4">
            <a href="${pageContext.request.contextPath}/admin/videos" class="btn btn-primary btn-block">Manage Videos</a>
        </div>
    </div>
</div>
</body>
</html>
