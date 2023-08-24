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

@WebServlet("/addTeacher")
public class AddTeacher extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	int teacher_id = Integer.parseInt(request.getParameter("teacher_id"));
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String email = request.getParameter("email");

        try (Connection connection = DatabaseUtil.getConnection()) {
            String sql = "INSERT INTO teachers (teacher_id, first_name, last_name, email) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, teacher_id);
            statement.setString(2, first_name);
            statement.setString(3, last_name);
            statement.setString(4, email);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                response.getWriter().println("Teacher added successfully.");
            } else {
                response.getWriter().println("Failed to add teacher.");
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
            request.getRequestDispatcher("/WEB-INF/setupTeachers.jsp").forward(request, response);
        }
    

    }

