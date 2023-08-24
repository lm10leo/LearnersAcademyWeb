<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Assign Classes to Subjects</title>
</head>
<body>
    <h2>Assign Classes to Subjects</h2>
    <form action="addclass_subject" method="post">
        <label for="classId">Class ID:</label>
        <input type="number" id="classId" name="classId" required><br><br>

        <label for="subjectId">Subject ID:</label>
        <input type="number" id="subjectId" name="subjectId" required><br><br>

        <input type="submit" value="Assign Class to Subject">
    </form>
</body>
</html>