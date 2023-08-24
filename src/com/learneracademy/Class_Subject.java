package com.learneracademy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/addclass_subject")
public class Class_Subject extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String classIdParam = request.getParameter("classId");
        String subjectIdParam = request.getParameter("subjectId");

        try (Connection connection = DatabaseUtil.getConnection()) {
            String sql = "INSERT INTO class_subject (class_id, subject_id) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            if (classIdParam == null || subjectIdParam == null) {
                // Handle null parameter values
            } else {
                int class_id = Integer.parseInt(classIdParam);
                int subject_id = Integer.parseInt(subjectIdParam);
                statement.setInt(1, class_id);
                statement.setInt(2, subject_id);
            }

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                response.getWriter().println("Class assigned to subject successfully.");
            } else {
                response.getWriter().println("Failed to assign class to subject.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("An error occurred.");
        }
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward the request to the JSP page that displays the form
        request.getRequestDispatcher("/WEB-INF/class_Subject.jsp").forward(request, response);
    }
}