package WORLD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/statelist")

public class StateData  extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
				String countryString =request.getParameter("tableget");
		       String ip = (String)session.getAttribute("ip");
		       String name = (String)session.getAttribute("name");
		       String pass = (String)session.getAttribute("pass");
		       request.setAttribute("country", countryString);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection	con = DriverManager.getConnection("jdbc:mysql://"+ip+":3306/world", name, pass);
			java.sql.Statement st = con.createStatement();
      ResultSet rs = st.executeQuery("select District from city where CountryCode=(select code from country where name='"+countryString+"') group by District;");
      ResultSetMetaData rsmd = rs.getMetaData();
      int columnsNumber = rsmd.getColumnCount();
      
      ArrayList statedatalist = new ArrayList();
      while (rs.next()) {
              for (int i = 1; i <= columnsNumber; i++) {

                      String columnValue = rs.getString(i);
                      statedatalist.add(columnValue);
                      
                 }
      

   }
      ArrayList data = (ArrayList)session.getAttribute("data");
      request.setAttribute("data", data);
      request.setAttribute("statedata", statedatalist);
      
      RequestDispatcher rd = 
              request.getRequestDispatcher("/result.jsp");
      rd.forward(request,response);


			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
