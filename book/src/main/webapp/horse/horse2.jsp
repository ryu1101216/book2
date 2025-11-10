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

<!doctype html>
<html lang="ja">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="./style.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<title>Hello, world!</title>
</head>
<body>
	<h2>キーワード検索</h2>
	<form action="search2" method="post">
		<div class="form-group">
			<!-- 入力要素ごとにform-group、入力エリアはform-control -->
			<label for="horse_name">馬名</label> <input type="text"
				class="form-control" id="horse_name" name="horse_name"
				placeholder="馬名を入力"> <label for="result">実績</label> <input
				type="text" class="form-control" id="result" name="result"
				placeholder="実績を入力"> <label for="race">レース名</label> <input
				type="text" class="form-control" id="race" name="race"
				placeholder="レース名を入力">
		</div>
		<button type="submit" class="btn btn-primary">送信</button>
	</form>


	<%@taglib prefix="c" uri="jakarta.tags.core"%>

	<c:if test="${not empty list}">
	<table align="center" class="table_design09">
		<thead>
			<tr>
				<th scope="col">馬名</th>
				<th scope="col">性別</th>
				<th scope="col">毛色</th>
				<th scope="col">誕生日</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="p" items="${list}">		
			<tr>
				<th scope="col">${p.馬名}</th>
				<th scope="col">${p.誕生日}</th>
				<th scope="col">${p.性別}</th>
				<th scope="col">${p.毛色}</th>
			</tr>
		</c:forEach>
		</tfoot>
	</table>
	</c:if>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
				integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
				crossorigin="anonymous"></script>
    <script
				src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
				integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
				crossorigin="anonymous"></script>
    <script
				src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
				integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
				crossorigin="anonymous"></script>
  
		</body>
</html>
