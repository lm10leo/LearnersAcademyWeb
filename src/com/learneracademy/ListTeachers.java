package com.learneracademy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListTeachers")
public class ListTeachers extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection connection = DatabaseUtil.getConnection()) {
            String sql = "SELECT * FROM teachers";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            StringBuilder htmlBuilder = new StringBuilder();
            htmlBuilder.append("<html><head><title>Teachers List</title></head><body>");
            htmlBuilder.append("<h1>Teachers List</h1>");
            htmlBuilder.append("<table border='1'>");
            htmlBuilder.append("<tr><th>ID</th><th>First Name</th><th>Last Name</th><th>Email</th></tr>");

            while (resultSet.next()) {
                int teacherId = resultSet.getInt("teacher_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");

                htmlBuilder.append("<tr><td>").append(teacherId).append("</td>");
                htmlBuilder.append("<td>").append(firstName).append("</td>");
                htmlBuilder.append("<td>").append(lastName).append("</td>");
                htmlBuilder.append("<td>").append(email).append("</td></tr>");
            }

            htmlBuilder.append("</table></body></html>");

            response.setContentType("text/html");
            response.getWriter().write(htmlBuilder.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
