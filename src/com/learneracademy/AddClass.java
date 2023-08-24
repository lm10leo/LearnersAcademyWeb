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


//AddClass.java
//... (package, imports, etc.)

@WebServlet("/AddClass")
public class AddClass extends HttpServlet {
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
     int classId = Integer.parseInt(request.getParameter("classId"));
     String className = request.getParameter("className");

     try (Connection connection = DatabaseUtil.getConnection()) {
         String sql = "INSERT INTO classes (class_id, class_name) VALUES (?, ?)";
         PreparedStatement statement = connection.prepareStatement(sql);
         statement.setInt(1, classId);
         statement.setString(2, className);

         int rowsAffected = statement.executeUpdate();
         if (rowsAffected > 0) {
             response.getWriter().println("Class added successfully.");
         } else {
             response.getWriter().println("Failed to add class.");
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
     request.getRequestDispatcher("/WEB-INF/setupClass.jsp").forward(request, response);
 }
}

