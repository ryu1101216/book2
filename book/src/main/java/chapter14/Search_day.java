package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns={"/chapter14/search_day"})
public class Search_day extends HttpServlet {
	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup(
				"java:/comp/env/jdbc/book");
			Connection con=ds.getConnection();
			
			
			String start_day=request.getParameter("start_day");
			String end_day=request.getParameter("end_day");

		
			PreparedStatement st=con.prepareStatement(
					"select * from SCHEDULE WHERE EVENT_DATE BETWEEN ? AND ?");
			
				st.setDate(1, Date.valueOf(start_day));
				st.setDate(2, Date.valueOf(end_day));
			
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
			ResultSet rs=st.executeQuery();

			while (rs.next()) {
				out.println(rs.getDate("EVENT_DATE"));
				out.println("：");
				out.println(rs.getTime("EVENT_TIME"));
				out.println("：");
				out.println(sdf.format(rs.getTimestamp("EVENT_TIMESTAMP")));
				out.println("<br>");
			}

			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
