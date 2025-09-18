<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add/Edit User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container mt-4">
    <form action="<c:url value='/admin/users/saveOrUpdate'/>" method="post">
        <div class="card">
            <div class="card-header">
                <h2>${user.id == null ? "Add User" : "Edit User"}</h2>
            </div>
            <div class="card-body">
                <input type="hidden" name="id" value="${user.id}"/>

                <div class="mb-3">
                    <label>Email</label>
                    <input type="text" name="email" value="${user.email}" class="form-control"/>
                </div>

                <div class="mb-3">
                    <label>User Name</label>
                    <input type="text" name="userName" value="${user.userName}" class="form-control"/>
                </div>

                <div class="mb-3">
                    <label>Full Name</label>
                    <input type="text" name="fullName" value="${user.fullName}" class="form-control"/>
                </div>

                <div class="mb-3">
                    <label>Password</label>
                    <input type="password" name="password" value="${user.password}" class="form-control"/>
                </div>

                <div class="mb-3">
                    <label>Avatar</label>
                    <input type="text" name="avatar" value="${user.avatar}" class="form-control"/>
                </div>

                <div class="mb-3">
                    <label>Role</label>
                    <input type="number" name="roleid" value="${user.roleid}" class="form-control"/>
                </div>

                <div class="mb-3">
                    <label>Phone</label>
                    <input type="text" name="phone" value="${user.phone}" class="form-control"/>
                </div>
            </div>
            <div class="card-footer">
                <a href="/admin/users" class="btn btn-secondary">Back</a>
                <button type="submit" class="btn btn-primary">Save</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
