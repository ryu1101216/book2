package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.sql.Timestamp;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns={"/chapter14/insertdate"})
public class Insertdate extends HttpServlet {

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
			
			Timestamp timestamp = new Timestamp(System.currentTimeMillis() / 1000 * 1000);
			Date date = new Date(timestamp.getTime());
			Time time = new Time(timestamp.getTime());
						
			PreparedStatement st=con.prepareStatement(
				"insert into SCHEDULE (EVENT_DATE, EVENT_TIME, EVENT_TIMESTAMP) values(?, ?, ?)");
			st.setDate(1, date);
			st.setTime(2, time);
			st.setTimestamp(3, timestamp);
			int line=st.executeUpdate();
			
			if (line>0) {
				out.println("追加に成功しました。");
			}
			
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
