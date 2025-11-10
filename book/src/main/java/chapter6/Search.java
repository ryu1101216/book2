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

@WebServlet(urlPatterns={"/chapter6/search"})
public class Search extends HttpServlet {
	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		
		out.println("<p>検索キーワードを入力</p>");

		out.println("<form action=\"search\" method=\"post\">");
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
				"select * from product where product_name like ?");
			st.setString(1, "%"+keyword+"%");
			ResultSet rs=st.executeQuery();

			while (rs.next()) {
				out.println(rs.getInt("product_id"));
				out.println("：");
				out.println(rs.getString("product_name"));
				out.println("：");
				out.println(rs.getInt("unit_price"));
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
