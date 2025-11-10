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
<link rel="stylesheet" href="./style.css">
</head>
<body>
	<form action="horse_name" method="post">
	<p>馬名　：<input type="text" name="horse_name"></p>
	<p>実績　：<input type="text" name="result"></p>
	<p>レース：<input type="text" name="race"></p>
	<p><input type="submit" value="検索" class="button">
	</form>

	
</body>
</html>
