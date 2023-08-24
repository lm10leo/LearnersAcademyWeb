<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Set up Teachers</title>
</head>
<body>
    <h2>Set up Teachers</h2>
    <form action="addTeacher" method="post">
        <label for="teacher_id">Teacher ID:</label>
        <input type="number" id="teacher_id" name="teacher_id" required><br><br>

        <label for="first_name">First Name:</label>
        <input type="text" id="first_name" name="first_name" required><br><br>

        <label for="last_name">Last Name:</label>
        <input type="text" id="last_name" name="last_name" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <!-- Add more fields as needed -->

        <input type="submit" value="Add Teacher">
    </form>
</body>
</html>
