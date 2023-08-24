<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Learner's Academy - Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        ul {
            list-style: none;
            padding: 0;
        }
        li {
            margin-bottom: 10px;
        }
        a {
            display: block;
            padding: 10px;
            text-decoration: none;
            color: #333;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
            transition: background-color 0.3s;
        }
        a:hover {
            background-color: #e0e0e0;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to Learner's Academy Admin Portal</h1>
        <ul>
            <li><a href="processSubject">Set up Subjects</a></li>
            <li><a href="teachers">Set up Teachers</a></li>
            <li><a href="setupClass">Set up Classes</a></li>
            <li><a href="assignclasssubject">Assign Classes to Subjects</a></li>
            <li><a href="assignment">Assign Teachers to Classes and Subjects</a></li>
            <li><a href="viewreport">View Class Report</a></li>
        </ul>
    </div>
</body>
</html>
