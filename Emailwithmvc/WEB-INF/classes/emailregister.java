package pack;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class emailregister
 extends HttpServlet {
	    PreparedStatement ps;
		Connection con;
		ResultSet rs;

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");
        String nam = req.getParameter("nam");
        boolean valid =false;

        MyBean bean = new MyBean();
		bean.setEmail(email);
		bean.setPass(pass);
		bean.setNam(nam);
		
		
			if(bean.getUser())
			{
			out.print("<html><font color=red><b>");
			out.print("already exist");
			out.print("</b></font></html>");
			RequestDispatcher rd= req.getRequestDispatcher("logre2.html");
			rd.include(req,res);
			}
			else{
            res.sendRedirect("index.html");
			}
        } 
}