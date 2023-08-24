<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher Assignments</title>
</head>
<body>
    <h1>Teacher Assignments</h1>

    <h2>Add new assignment</h2>
    <form action="teacher_assignments" method="post">
        Teacher ID: <input type="number" name="teacher_id"><br>
        Class ID: <input type="number" name="class_id"><br>
        Subject ID: <input type="number" name="subject_id"><br>
        <input type="submit" value="Add Assignment">
    </form>

    <h2>All assignments</h2>
    <table>
        <tr>
            <th>Teacher ID</th>
            <th>Teacher name</th>
            <th>Class</th>
            <th>Subject</th>
        </tr>
        <c:forEach items="${assignments}" var="assignment">
            <tr>
                <td>${assignment.assignmentId}</td>
<td>${assignment.teacherFirstName} ${assignment.teacherLastName}</td>
<td>${assignment.className}</td>
<td>${assignment.subjectName}</td>

            </tr>
        </c:forEach>
    </table>
</body>
</html>