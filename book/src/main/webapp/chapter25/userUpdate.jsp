<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@include file="../header.html" %>
<%@include file="menu.jsp" %>

<h2>ユーザー変更</h2>

<form action="UserUpdateExecute.action" method="post">
	<input type="hidden" name="id" value="${customer.id}">
	<table style="border-collapse:separate;border-spacing:10px;">
		<tr>
			<td>ログイン名:</td>
			<td><input type="text" name="login" value="${customer.login}" required></td>
		</tr>
		<tr>
			<td>パスワード:</td>
			<td><input type="text" name="password" value="${customer.password}" required></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="変更">
			</td>
		</tr>
	</table>
</form>

<%@include file="../footer.html" %>
