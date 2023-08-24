package com.learneracademy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/teacher_assignments")
public class TeacherAssignmentsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection connection = DatabaseUtil.getConnection()) {
            String query = "SELECT ta.assignment_id, t.first_name, t.last_name, c.class_name, s.subject_name " +
                           "FROM teacher_assignments ta " +
                           "JOIN teachers t ON ta.teacher_id = t.teacher_id " +
                           "JOIN classes c ON ta.class_id = c.class_id " +
                           "JOIN subjects s ON ta.subject_id = s.subject_id";

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            List<TeacherAssignment> assignments = new ArrayList<>();
            while (resultSet.next()) {
                int assignmentId = resultSet.getInt("assignment_id");
                String teacherFirstName = resultSet.getString("first_name");
                String teacherLastName = resultSet.getString("last_name");
                String className = resultSet.getString("class_name");
                String subjectName = resultSet.getString("subject_name");

                // Create a new TeacherAssignment instance and set the retrieved data
                TeacherAssignment assignment = new TeacherAssignment(assignmentId, teacherFirstName, teacherLastName, className, subjectName);
                assignments.add(assignment);
            }


            request.setAttribute("assignments", assignments);
            request.getRequestDispatcher("/WEB-INF/teacher_assignments.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("An error occurred.");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int teacherId = Integer.parseInt(request.getParameter("teacher_id"));
        int classId = Integer.parseInt(request.getParameter("class_id"));
        int subjectId = Integer.parseInt(request.getParameter("subject_id"));

        try (Connection connection = DatabaseUtil.getConnection()) {
            String sql = "INSERT INTO teacher_assignments (teacher_id, class_id, subject_id) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, teacherId);
            statement.setInt(2, classId);
            statement.setInt(3, subjectId);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                response.getWriter().println("Teacher assignment added successfully.");
            } else {
                response.getWriter().println("Failed to add teacher assignment.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("An error occurred.");
        }
    }
}