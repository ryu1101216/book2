package chapter6;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns={"/chapter6/search2"})
public class Search2 extends HttpServlet {
	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		
		out.println("<p>検索キーワードを入力</p>");

		out.println("<form action=\"search2\" method=\"post\">");
		out.println("<input type=\"text\" name=\"keyword\">");
		out.println("<input type=\"submit\" value=\"検索\">");
		out.println("</form>");
		
		try {
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup(
				"java:/comp/env/jdbc/test");
			Connection con=ds.getConnection();

			String keyword=request.getParameter("keyword");

			PreparedStatement st=con.prepareStatement(
				"select * from horse where horse_name like ?");
			st.setString(1, "%"+keyword+"%");
			ResultSet rs=st.executeQuery();

			out.println("<table  border=\"1\">");
			out.println("<thead>");
			out.println("    <tr>");
			out.println("      <th scope=\"col\">ID</th>");
			out.println("      <th scope=\"col\">馬名</th>");
			out.println("      <th scope=\"col\">毛色</th>");
			out.println("    </tr>");
			out.println("  </thead>");
			out.println("  <tbody>");

			
			while (rs.next()) {		
				out.println("    <tr>");
				out.println("      <th scope=\"col\">" + rs.getInt("HORSE_ID") + "</th>");
				out.println("      <th scope=\"col\">" + rs.getString("HORSE_NAME") + "</th>");
				out.println("      <th scope=\"col\">" + rs.getString("HAIR_COLOR") + "</th>");
				out.println("    </tr>");
			}
			
			out.println("  </tfoot>");
			out.println("</table>");

			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
