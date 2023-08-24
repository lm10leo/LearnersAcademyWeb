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

@WebServlet("/ListSubjects")
public class ListSubjects extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection connection = DatabaseUtil.getConnection()) {
            String sql = "SELECT * FROM subjects";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            StringBuilder htmlBuilder = new StringBuilder();
            htmlBuilder.append("<html><head><title>Subject List</title></head><body>");
            htmlBuilder.append("<h1>Subject List</h1>");
            htmlBuilder.append("<table border='1'>");
            htmlBuilder.append("<tr><th>subject_id</th><th>subject_name</th><th>subject_description</th></tr>");

            while (resultSet.next()) {
                int subject_id = resultSet.getInt("subject_id");
                String subject_name = resultSet.getString("subject_name");
                String subject_description = resultSet.getString("subject_description");
              

                htmlBuilder.append("<tr><td>").append(subject_id).append("</td>");
                htmlBuilder.append("<td>").append(subject_name).append("</td>");
                htmlBuilder.append("<td>").append(subject_description).append("</td>");
            }

            htmlBuilder.append("</table></body></html>");

            response.setContentType("text/html");
            response.getWriter().write(htmlBuilder.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
