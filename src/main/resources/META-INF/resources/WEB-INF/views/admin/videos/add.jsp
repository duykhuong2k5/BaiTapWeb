<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add/Edit Video</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container mt-4">
    <form action="<c:url value='/admin/videos/saveOrUpdate'/>" method="post">
        <div class="card">
            <div class="card-header">
                <h2>Add/Edit Video</h2>
            </div>
            <div class="card-body">
                <input type="hidden" name="id" value="${video.id}">
                <div class="mb-3">
                    <label>Title</label>
                    <input type="text" name="title" value="${video.title}" class="form-control"/>
                </div>
                <div class="mb-3">
                    <label>Description</label>
                    <textarea name="description" class="form-control">${video.description}</textarea>
                </div>
                <div class="mb-3">
                    <label>URL</label>
                    <input type="text" name="url" value="${video.url}" class="form-control"/>
                </div>
            </div>
            <div class="card-footer">
                <a href="/admin/videos" class="btn btn-secondary">Back</a>
                <button type="submit" class="btn btn-primary">Save</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
