<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List Categories</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container mt-4">
    <div class="card">
        <div class="card-header d-flex justify-content-between align-items-center">
            <span>List Category</span>
            <a href="/admin/categories/add" class="btn btn-primary btn-sm">+ Add Category</a>
        </div>
        <div class="card-body">
            <c:if test="${message != null}">
                <div class="alert alert-primary">${message}</div>
            </c:if>


            <form action="/admin/categories/search" method="get" class="mb-3 d-flex">
                <input type="text" name="name" class="form-control me-2"
                       placeholder="Search by category name..." value="${param.name}">
                <button type="submit" class="btn btn-primary">Search</button>
            </form>

            <table class="table table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Category Name</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${categories}" var="category">
                    <tr>
                        <td>${category.id}</td>
                        <td>${category.categoryName}</td>
                        <td>
                            <a href="/admin/categories/edit/${category.id}" class="btn btn-warning btn-sm">Edit</a>
                            <a href="/admin/categories/delete/${category.id}" class="btn btn-danger btn-sm"
                               onclick="return confirm('Are you sure to delete this category?');">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
