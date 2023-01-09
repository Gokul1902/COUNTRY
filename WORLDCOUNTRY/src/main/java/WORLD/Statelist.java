
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



@WebServlet("/Checker")
public class Statelist extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String ip = (String)request.getAttribute("ip");
			String name = (String)request.getAttribute("username");
			String pass = (String)request.getAttribute("password");
			HttpSession session = request.getSession();
			String database="";
			session.setAttribute("ip", ip);
			session.setAttribute("name", name);
			session.setAttribute("pass", pass);
			if(ip!="" && name!="" && pass!="") {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection("mysql:jdbc://"+ip+":3306/"+database,name,pass);
				java.sql.Statement st = connection.createStatement();
          ResultSet rs = ((java.sql.Statement) st).executeQuery("show databases;");
          ResultSetMetaData rsmd = rs.getMetaData();
          int columnsNumber = rsmd.getColumnCount();
          
          ArrayList databaselist = new ArrayList();
          while (rs.next()) {
                  for (int i = 1; i <= columnsNumber; i++) {

                          String columnValue = rs.getString(i);
                          databaselist.add(columnValue);
                          
                     }
          
   
       }
          request.setAttribute("data", databaselist);
          session.setAttribute("data",databaselist );
          
          RequestDispatcher rd = 
                  request.getRequestDispatcher("/result.jsp");
          rd.forward(request,response);
          
       
          
				
			} catch (Exception e) {
				
			}
			}
			else {
				
			}
	}

}