/*SET USERNAME AS COOKIE AND REDIRECT TO INBOX*/

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class cookie1 extends HttpServlet {
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
     try{
        response.setContentType("text/html");
        PrintWriter pwriter = response.getWriter();
        String in_uname = request.getParameter("name");
        Cookie c = new Cookie("UserCookie",in_uname);      
        response.addCookie(c);
        pwriter.print("<h1><center>Hii "+in_uname+"</center></h1>");
        pwriter.println("<br><br>");
        pwriter.println("<p style='text-align: center; font-size: 18px; color: green;'>Thank you for contacting us. Your message has been submitted successfully!</p>");
        pwriter.println("</body></html>");
        pwriter.print("<h3 ><center><button style='color: white; background-color: #007bff; padding: 10px 20px; border: none; border-radius: 4px;' onclick=\"window.location.href='fruits_catalog.html'\">Fruits Catalog</button></center></h3>");
      }
     catch(Exception exp){
       System.out.println(exp);
     }
  }
}