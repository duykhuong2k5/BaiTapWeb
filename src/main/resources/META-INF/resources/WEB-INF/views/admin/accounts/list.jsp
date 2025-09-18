<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container mt-4">
    <h2>User List</h2>

    <!-- Search -->
    <form action="/admin/users/search" method="get" class="mb-3 d-flex">
        <input type="text" name="name" class="form-control me-2"
               placeholder="Search by username..." value="${param.name}">
        <button type="submit" class="btn btn-primary">Search</button>
    </form>

    <a href="/admin/users/add" class="btn btn-success mb-3">Add User</a>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Email</th>
            <th>User Name</th>
            <th>Full Name</th>
            <th>Role</th>
            <th>Phone</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="u">
            <tr>
                <td>${u.id}</td>
                <td>${u.email}</td>
                <td>${u.userName}</td>
                <td>${u.fullName}</td>
                <td>${u.roleid}</td>
                <td>${u.phone}</td>
                <td>
                    <a href="/admin/users/edit/${u.id}" class="btn btn-warning btn-sm">Edit</a>
                    <a href="/admin/users/delete/${u.id}" class="btn btn-danger btn-sm">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
