<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@include file="../header.html" %>
<%@include file="menu.jsp" %>

<h2>ユーザ一覧</h2>
<p>ログイン名を入力してください。</p>
<form action="UserList.action" method="post">
	<input type="text" name="keyword"> <input type="submit"
		value="検索">
</form>
<hr>
<table style="border-collapse:separate;border-spacing:10px;" border="1">
	<tr>
		<th>ID</th>
		<th>ログイン名</th>
		<th>パスワード</th>
		<th colspan=2>操作</th>
	</tr>
	<c:forEach var="customer" items="${list}">
		<tr>
			<td>${customer.id}</td>
			<td>${customer.login}</td>
			<td>${customer.password}</td>
			<td><a href="UserDelete.action?id=${customer.id}" id="deleteLink">削除</a></td>
			<td><a href="UserUpdate.action?id=${customer.id}">変更</a></td>
		</tr>
	</c:forEach>
</table>

<%@include file="../footer.html" %>
