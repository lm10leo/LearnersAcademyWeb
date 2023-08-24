package com.learneracademy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/subject")
public class ProcessSubject extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	int subject_id = Integer.parseInt(request.getParameter("subject_id"));
        String subject_name = request.getParameter("subject_name");
        String subject_description = request.getParameter("subject_description");

        try (Connection connection = DatabaseUtil.getConnection()) {
            String sql = "INSERT INTO subjects (subject_id,subject_name,subject_description) VALUES (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, subject_id);
            statement.setString(2, subject_name);
            statement.setString(3, subject_description);
            
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                response.getWriter().println("Subject added successfully.");
            } else {
                response.getWriter().println("Failed to add subject.");
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
        request.getRequestDispatcher("/WEB-INF/addSubject.jsp").forward(request, response);
}}
