<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Subject</title>
</head>
<body>
    <h2>Add Subject</h2>
    <form action="subject" method="post">
        <label for="subjectId">Subject ID:</label>
        <input type="number" id="subjectId" name="subject_id" required><br><br>
        
        <label for="subjectName">Subject Name:</label>
        <input type="text" id="subjectName" name="subject_name" required><br><br>
        
        <label for="subjectDescription">Subject Description:</label>
        <textarea id="subjectDescription" name="subject_description" rows="4" required></textarea><br><br>
        
        <input type="submit" value="Add Subject">
    </form>
</body>
</html>
