import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
public class session extends HttpServlet {  
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{  
        try{  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        String n=request.getParameter("username");  
        out.print("<h1>Welcome "+n+ "</h1>");  
        HttpSession session=request.getSession(); 
        session.setAttribute("login_name",n);  
        out.print("<a href='session1'>Profile</a><br/>");   
        out.print("<a href='fruits_catalog.html'>Fruits Catalog</a>");        
        out.close(); 
        }catch(Exception e){System.out.println(e);}  
    }
}  