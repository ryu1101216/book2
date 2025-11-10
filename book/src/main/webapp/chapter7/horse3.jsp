<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<!DOCTYPE html>
<%@page import="java.util.Objects"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.sql.DataSource"%>

<%@page import="jakarta.servlet.ServletException"%>
<%@page import="jakarta.servlet.annotation.WebServlet"%>
<%@page import="jakarta.servlet.http.HttpServlet"%>
<%@page import="jakarta.servlet.http.HttpServletRequest"%>
<%@page import="jakarta.servlet.http.HttpServletResponse"%>

<html>
<head>
<title>キーワード検索</title>
</head>
<body>
	<h2>キーワード検索</h2>
	<form action="horse2.jsp" method="post">
		実績：<input type="text" name="keyword">
		<button type="submit">検索</button>
	</form>
	<%
	// 最後に送信されたデータを取得
	// 検索キーワード
	String keyword = request.getParameter("keyword");
	keyword = Objects.toString(keyword, ""); // NULLは空文字に置き換え

	if (keyword != "") {
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup(
			"java:/comp/env/jdbc/book");
			Connection con = ds.getConnection();

			// File file = new File("C:\\Users\\training4\\Desktop\\result_SQL2.txt");

			// String sql = "";

			// FileReader fileReader = new FileReader(file);
			// int data;
			// while ((data = fileReader.read()) != -1) {
			// 	sql = sql + ((char) data);
			// }

			// 4.最後にファイルを閉じてリソースを開放する
			// fileReader.close();
			
			
			PreparedStatement st;
			String sql;
			int distance;
			
			try {
				distance = Integer.parseInt(keyword);
				sql = "select * from result_view where 距離 = ?";
				st = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				st.setInt(1, distance);
			}
			catch(Exception e) {
				sql = "select * from result_view where 優勝馬 like ? or レース名 like ? or 競馬場 like ?";
				st = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				st.setString(1, "%"+keyword+"%");
				st.setString(2, "%"+keyword+"%");
				st.setString(3, "%"+keyword+"%");
			}
					
			//PreparedStatement st = con.prepareStatement(sql.replace("?", keyword),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//st.setString(.replace(置換される文字列, 置換文字列));
			ResultSet rs = st.executeQuery();
			rs.last();
			int rownum = rs.getRow();
			rs.beforeFirst();
			out.println("<p>" + rownum + "件ヒットしました</p>");
	%>

	<table border="1">
		<thead>
			<tr>
				<th scope=\"col\">回</th>
				<th scope=\"col\">レース名</th>
				<th scope=\"col\">開催日</th>
				<th scope=\"col\">グレード</th>
				<th scope=\"col\">競馬場</th>
				<th scope=\"col\">コース</th>
				<th scope=\"col\">距離</th>
				<th scope=\"col\">条件</th>
				<th scope=\"col\">優勝馬</th>
				<th scope=\"col\">性齢</th>
				<th scope=\"col\">毛色</th>
			</tr>
		</thead>
		<tbody>

			<%
			while (rs.next()) {
				out.println("    <tr>");
				out.println("      <th scope=\"col\">" + rs.getString("回") + "</th>");
				out.println("      <th scope=\"col\">" + rs.getString("レース名") + "</th>");
				Timestamp raceday = rs.getTimestamp("開催日");
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
			%>
		
		</tfoot>
	</table>

	<%
		st.close();
		con.close();
		} catch (Exception e) {
			out.println(e.getMessage());
		}
	}
	%>
</body>
</html>
