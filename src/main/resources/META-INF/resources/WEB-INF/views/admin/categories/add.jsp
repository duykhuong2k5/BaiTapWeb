<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Category</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<section class="row">
    <div class="col-6 offset-3 mt-4">
        <form action="<c:url value='/admin/categories/saveOrUpdate' />" method="POST">
            <div class="card">
                <div class="card-header">
                    <h2>Add New Category</h2>
                </div>
                <div class="card-body">
                    <div class="mb-3">
                        <label for="id" class="form-label">Category ID:</label>
                        <input type="text" readonly class="form-control" value="${category.id}" id="id" name="id">
                    </div>
                    <div class="mb-3">
                        <label for="name" class="form-label">Category Name:</label>
                        <input type="text" class="form-control" value="${category.categoryName}" id="name" name="categoryName">
                    </div>
                </div>
                <div class="card-footer">
                    <a href="<c:url value='/admin/categories' />" class="btn btn-success">List</a>
                    <button class="btn btn-primary" type="submit">Save</button>
                </div>
            </div>
        </form>
    </div>
</section>
</body>
</html>
