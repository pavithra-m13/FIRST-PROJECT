import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class profile extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/organicfruits", "root", "");
            System.out.println("Connected to the database");
            String query = "INSERT INTO users (username, emailaddress, password, gender, dob, contactnumber) VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(query);
            System.out.println(request.getParameter("username"));
            pstmt.setString(1, request.getParameter("username"));
            pstmt.setString(2, request.getParameter("emailaddress"));
            pstmt.setString(3, request.getParameter("password"));
            pstmt.setString(4, request.getParameter("gender"));
            pstmt.setString(5, request.getParameter("dob"));
            pstmt.setString(6, request.getParameter("contactnumber"));
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully");
            } else {
                System.out.println("Data insertion failed");
            }
            response.sendRedirect("http://localhost:8080/Ex/fruits_catalog.html");
            pstmt.close();
            String username = request.getParameter("username");
            System.out.println("Username: " + username);
            conn.close();
        } catch (Exception e) {
            System.out.print("Failed to connect to DB - Error: " + e);
        }
    }
}
