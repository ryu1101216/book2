package chapter7;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Objects;

import dao.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns = { "/chapter7/horse_name" })
public class horse_name extends HttpServlet {
	public void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);
		Page.spinner_div(out);
		Page.horse_name(out);

		// 最後に送信されたデータを取得
		// 検索キーワード
		String horse_name = request.getParameter("horse_name");
		horse_name = Objects.toString(horse_name, ""); // NULLは空文字に置き換え
		
		String result = request.getParameter("result");
		result = Objects.toString(result, ""); // NULLは空文字に置き換え

		String race = request.getParameter("race");
		race = Objects.toString(race, ""); // NULLは空文字に置き換え
		
		if (horse_name != "") {
			horse_search(out, horse_name);
		}
		else if (result != "") {
			result_search(out, result);
		}
		else if (race != "") {
			race_search(out, race);
		}
		else {
			out.println("<p>検索条件が設定されていません</p>");
		}
		
		Page.spinner_script(out);
		Page.footer(out);
	}
	
	public void horse_search(PrintWriter out, String horse_name)
	{
		
		try {
			Connection con = DAO.getConnection();

			PreparedStatement st;
			String sql;


			sql = "select * from horse_view where 馬名 like ?";
			st = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			st.setString(1, "%" + horse_name + "%");

			ResultSet rs = st.executeQuery();
			rs.last();
			int rownum = rs.getRow();
			rs.beforeFirst();
			out.println("<p>" + rownum + "件ヒットしました</p>");

			out.println("<table class=\"table_design09\">");
			out.println("	<thead>");
			out.println("		<tr>");
			out.println("		<th scope=\"col\">馬名</th>");
			out.println("		<th scope=\"col\">性別</th>");
			out.println("		<th scope=\"col\">毛色 </th>");
			out.println("		<th scope=\"col\">誕生日</th>");
			out.println("	</tr>");
			out.println("</thead>");
			out.println("<tbody>");

			while (rs.next()) {
				out.println("    <tr>");
				out.println("      <th scope=\"col\">" + rs.getString("馬名") + "</th>");
				out.println("      <th scope=\"col\">" + rs.getString("性別") + "</th>");
				out.println("      <th scope=\"col\">" + rs.getString("毛色") + "</th>");
				java.sql.Timestamp birthday = rs.getTimestamp("誕生日");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				out.println("      <th scope=\"col\">" + sdf.format(birthday) + "</th>");
				out.println("    </tr>");
			}

			out.println("</tfoot>");
			out.println("</table>");

			st.close();
			con.close();
		} catch (Exception e) {
			out.println(e.getMessage());
		}
	}

	public void result_search(PrintWriter out, String result)
	{
		
		try {			
			Connection con = DAO.getConnection();

			PreparedStatement st;
			String sql;
			int distance;

			try {
				distance = Integer.parseInt(result);
				sql = "select * from result_view where 距離 = ?";
				st = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				st.setInt(1, distance);
			} catch (Exception e) {
				sql = "select * from result_view where 優勝馬 like ? or レース名 like ? or 競馬場 like ? or グレード like ? or コース like ?";
				st = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				st.setString(1, "%" + result + "%");
				st.setString(2, "%" + result + "%");
				st.setString(3, "%" + result + "%");
				st.setString(4, "%" + result + "%");
				st.setString(5, "%" + result + "%");
			}

			ResultSet rs = st.executeQuery();
			rs.last();
			int rownum = rs.getRow();
			rs.beforeFirst();
			out.println("<p>" + rownum + "件ヒットしました</p>");

			out.println("<table class=\"table_design09\">");
			out.println("	<thead>");
			out.println("		<tr>");
			out.println("			<th scope=\"col\">回</th>");
			out.println("		<th scope=\"col\">レース名</th>");
			out.println("		<th scope=\"col\">開催日</th>");
			out.println("		<th scope=\"col\">グレード</th>");
			out.println("		<th scope=\"col\">競馬場</th>");
			out.println("		<th scope=\"col\">コース</th>");
			out.println("		<th scope=\"col\">距離</th>");
			out.println("		<th scope=\"col\">条件</th>");
			out.println("		<th scope=\"col\">優勝馬</th>");
			out.println("		<th scope=\"col\">性齢</th>");
			out.println("		<th scope=\"col\">毛色</th>");
			out.println("	</tr>");
			out.println("</thead>");
			out.println("<tbody>");

			while (rs.next()) {
				out.println("    <tr>");
				out.println("      <th scope=\"col\">" + rs.getString("回") + "</th>");
				out.println("      <th scope=\"col\">" + rs.getString("レース名") + "</th>");
				java.sql.Timestamp raceday = rs.getTimestamp("開催日");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				out.println("      <th scope=\"col\">" + sdf.format(raceday) + "</th>");
				out.println("      <th scope=\"col\">" + rs.getString("グレード") + "</th>");
				out.println("      <th scope=\"col\">" + rs.getString("競馬場") + "</th>");
				out.println("      <th scope=\"col\">" + rs.getString("コース") + "</th>");
				out.println("      <th scope=\"col\">" + rs.getString("距離") + "</th>");
				out.println("      <th scope=\"col\">" + rs.getString("条件") + "</th>");
				out.println("      <th scope=\"col\">" + rs.getString("優勝馬") + "</th>");
				out.println("      <th scope=\"col\">" + rs.getString("性別") + rs.getString("年齢") + "</th>");
				out.println("      <th scope=\"col\">" + rs.getString("毛色") + "</th>");
				out.println("    </tr>");
			}

			out.println("</tfoot>");
			out.println("</table>");

			st.close();
			con.close();
		} catch (Exception e) {
			out.println(e.getMessage());
		}
	}
	
	public void race_search(PrintWriter out, String race)
	{
		
		try {			
			Connection con = DAO.getConnection();

			PreparedStatement st;
			String sql;
			int distance;
			
			try {
				distance = Integer.parseInt(race);
				sql = "select * from race_view where 距離 = ?";
				st = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				st.setInt(1, distance);
			} catch (Exception e) {
				sql = "select * from race_view where レース名 like ? or 競馬場 like ? or グレード like ? or コース like ?";
				st = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				st.setString(1, "%" + race + "%");
				st.setString(2, "%" + race + "%");
				st.setString(3, "%" + race + "%");
				st.setString(4, "%" + race + "%");
			}

			ResultSet rs = st.executeQuery();
			rs.last();
			int rownum = rs.getRow();
			rs.beforeFirst();
			out.println("<p>" + rownum + "件ヒットしました</p>");

			out.println("<table class=\"table_design09\">");
			out.println("	<thead>");
			out.println("		<tr>");
			out.println("		<th scope=\"col\">レース名</th>");
			out.println("		<th scope=\"col\">グレード</th>");
			out.println("		<th scope=\"col\">競馬場</th>");
			out.println("		<th scope=\"col\">コース</th>");
			out.println("		<th scope=\"col\">距離</th>");
			out.println("		<th scope=\"col\">条件</th>");
			out.println("		<th scope=\"col\">現行</th>");
			out.println("		<th scope=\"col\">創設年</th>");
			out.println("	</tr>");
			out.println("</thead>");
			out.println("<tbody>");

			while (rs.next()) {
				out.println("    <tr>");
				out.println("      <th scope=\"col\">" + rs.getString("レース名") + "</th>");
				out.println("      <th scope=\"col\">" + rs.getString("グレード") + "</th>");
				out.println("      <th scope=\"col\">" + rs.getString("競馬場") + "</th>");
				out.println("      <th scope=\"col\">" + rs.getString("コース") + "</th>");
				out.println("      <th scope=\"col\">" + rs.getInt("距離") + "</th>");
				out.println("      <th scope=\"col\">" + rs.getString("条件") + "</th>");
				out.println("      <th scope=\"col\">" + rs.getString("現行") + "</th>");
				out.println("      <th scope=\"col\">" + rs.getInt("創設年") + "</th>");
				out.println("    </tr>");
			}

			out.println("</tfoot>");
			out.println("</table>");

			st.close();
			con.close();
		} catch (Exception e) {
			out.println(e.getMessage());
		}
	}
	
}
