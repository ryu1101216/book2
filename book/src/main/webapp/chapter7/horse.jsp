<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<!DOCTYPE html>
<%@page import="java.util.Objects"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>

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
	<form action="horse.jsp" method="post">
		<input type="text" name="keyword">
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
			"java:/comp/env/jdbc/test");
			Connection con = ds.getConnection();

			PreparedStatement st = con.prepareStatement(
			"select * from horse where horse_name like ?");
			st.setString(1, "%" + keyword + "%");
			ResultSet rs = st.executeQuery();
	%>

	<table border="1">
		<thead>
			<tr>
				<th scope=\"col\">ID</th>
				<th scope=\"col\">馬名</th>
				<th scope=\"col\">毛色</th>
			</tr>
		</thead>
		<tbody>

			<%
			while (rs.next()) {
				out.println("    <tr>");
				out.println("      <th scope=\"col\">" + rs.getInt("HORSE_ID") + "</th>");
				out.println("      <th scope=\"col\">" + rs.getString("HORSE_NAME") + "</th>");
				out.println("      <th scope=\"col\">" + rs.getString("HAIR_COLOR") + "</th>");
				out.println("    </tr>");
			}
			%>
		
		</tfoot>
	</table>

	<%
	st.close();
	con.close();
	} catch (Exception e) {
	out.println("例外発生");
	}
	}
	%>
</body>
</html>
