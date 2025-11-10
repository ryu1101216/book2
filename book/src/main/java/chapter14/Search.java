package chapter14;

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

@WebServlet(urlPatterns={"/chapter14/search"})
public class Search extends HttpServlet {
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

			String keyword1=request.getParameter("keyword1");
			String keyword2=request.getParameter("keyword2");

			String sql = "select * from product where ";
			
			PreparedStatement st;
			
			if (keyword1 != "") {
				sql += "name like ?";
				if (keyword2 != "") {
					sql += " and price >= ?";
					
					st=con.prepareStatement(sql);
						st.setString(1, "%"+keyword1+"%");
						st.setInt(2, Integer.parseInt(keyword2));
				}
				else {
					st=con.prepareStatement(sql);
					st.setString(1, "%"+keyword1+"%");
				}	
			}
			else {
				sql += "price >= ?";
				st=con.prepareStatement(sql);
				st.setInt(1, Integer.parseInt(keyword2));
			}
			
			
//			PreparedStatement st=con.prepareStatement(
//				"select * from product where name like ? and price >= ?");
//			st.setString(1, "%"+keyword1+"%");
//			st.setInt(2, Integer.parseInt(keyword2));
			ResultSet rs=st.executeQuery();

			while (rs.next()) {
				out.println(rs.getInt("id"));
				out.println("：");
				out.println(rs.getString("name"));
				out.println("：");
				out.println(rs.getInt("price"));
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
