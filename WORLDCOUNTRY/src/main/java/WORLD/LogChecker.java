
package WORLD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet("/checker")
public class LogChecker extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String ip = (String)request.getParameter("ip");
			String name = (String)request.getParameter("username");
			String pass = (String)request.getParameter("password");
			HttpSession session = request.getSession();
			session.setAttribute("ip", ip);
			session.setAttribute("name", name);
			session.setAttribute("pass", pass);
			if(ip!="" && name!="" && pass!="") {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			Connection	con = DriverManager.getConnection("jdbc:mysql://"+ip+":3306/world", name, pass);
				java.sql.Statement st = con.createStatement();
          ResultSet rs = st.executeQuery("select name from country;");
          ResultSetMetaData rsmd = rs.getMetaData();
          int columnsNumber = rsmd.getColumnCount();
          
          ArrayList databaselist = new ArrayList();
          while (rs.next()) {
                  for (int i = 1; i <= columnsNumber; i++) {

                          String columnValue = rs.getString(i);
                          databaselist.add(columnValue);
                          
                     }
          
   
       }
          session.setAttribute("data",databaselist);
          request.setAttribute("data", databaselist);
          
          RequestDispatcher rd = 
                  request.getRequestDispatcher("/result.jsp");
          rd.forward(request,response);
          
       
          
				
			} catch (Exception e) {
				 RequestDispatcher rd = 
			              request.getRequestDispatcher("logfail.html");
			      rd.forward(request,response);

				
			}
			}
			else {
				 RequestDispatcher rd = 
			              request.getRequestDispatcher("logfail.html");
			      rd.forward(request,response);

			}
	}

}