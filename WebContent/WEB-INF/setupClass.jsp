<!-- setupClass.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Set up Classes</title>
</head>
<body>
    <h2>Set up Classes</h2>
    <form action="setupClass" method="post">
        <label for="classId">Class ID:</label>
        <input type="number" id="classId" name="classId" required><br><br>

        <label for="className">Class Name:</label>
        <input type="text" id="className" name="className" required><br><br>

        <input type="submit" value="Add Class">
    </form>
</body>
</html>
