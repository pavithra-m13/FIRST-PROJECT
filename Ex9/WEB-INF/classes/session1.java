import java.io.*;
import javax.servlet.*;  
import javax.servlet.http.*; 
import java.sql.*;
public class session1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn = null;
        PreparedStatement pstmt = null;
        PrintWriter out = response.getWriter();
        HttpSession session= request.getSession();
        String username =(String)session.getAttribute("login_name");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/organicfruits", "root", "");
            System.out.println("Connected to the database");
            String sql = "SELECT * FROM users WHERE username = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("username");
                String emailaddress = rs.getString("emailaddress");
                String dob = rs.getString("dob");
                String gender = rs.getString("gender");
                String contactnumber = rs.getString("contactnumber");
                out.println("<html><head><title>User Information</title></head><body><br><br><br>");
                out.println("<p><center>Name: " + name + "<br>");
                out.println("EmailAddress: " + emailaddress + "<br>");
                out.println("DOB: " + dob + "<br>");
                out.println("Gender: " + gender + "<br>");
                out.println("Contact Number: " + contactnumber + "<br></center></p>");
                out.println("<br><br>");
                out.print("<h3 ><center><button style='color: white; background-color: #007bff; padding: 10px 20px; border: none; border-radius: 4px;' onclick=\"window.location.href='fruits_catalog.html'\">Fruits Catalog</button></center></h3>");
                out.println("</body></html>");
            } else {
                out.println("User not found.");
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}

  