<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List Videos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container mt-4">
    <div class="card">
        <div class="card-header d-flex justify-content-between">
            <span>List Videos</span>
            <a href="/admin/videos/add" class="btn btn-primary btn-sm">+ Add Video</a>
        </div>
        <div class="card-body">
            <!-- Search form -->
            <form action="/admin/videos/search" method="get" class="mb-3 d-flex">
                <input type="text" name="keyword" class="form-control me-2"
                       placeholder="Search by title..." value="${param.keyword}">
                <button type="submit" class="btn btn-primary">Search</button>
            </form>

            <table class="table table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th>URL</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="v" items="${videos}">
                    <tr>
                        <td>${v.id}</td>
                        <td>${v.title}</td>
                        <td>${v.description}</td>
                        <td><a href="${v.url}" target="_blank">${v.url}</a></td>
                        <td>
                            <a href="/admin/videos/edit/${v.id}" class="btn btn-warning btn-sm">Edit</a>
                            <a href="/admin/videos/delete/${v.id}" class="btn btn-danger btn-sm"
                               onclick="return confirm('Delete this video?');">Delete</a>
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
