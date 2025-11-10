<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@include file="../header.html"%>
<%@include file="menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<p>検索キーワードを入力してください。</p>
<form action="User.action" method="post">
	<input type="text" name="keyword"> <input type="submit"
		value="検索">
</form>
<hr>

<table align="center" class="table_design09"
	style="border-collapse: separate; border-spacing: 10px;">

	<thead>
		<tr>
			<th scope="col">ID</th>
			<th scope="col">ユーザ名</th>
			<th scope="col">パスワード</th>
			<th scope="col" colspan=2>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="user" items="${list}">
			<tr>
				<td>${user.id}</td>
				<td>${user.login}</td>
				<td>${user.password}</td>
				<td><a href="UserRemove.action?id=${user.id}">削除</a></td>
				<td><a href="UserUpdate.action?id=${user.id}">変更</a></td>
			</tr>
		</c:forEach>
	</tbody>		
</table>

<%@include file="../footer.html"%>
