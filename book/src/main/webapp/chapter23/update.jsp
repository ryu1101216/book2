<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<p>更新する商品を入力してください。</p>
<form action="Update.action" method="post">
商品名<select name="name">
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<c:forEach var="p" items="${list}">
	<option value="${p.name}">${p.name}</option>
</c:forEach>
</select>
価格<input type="text" name="price">
<input type="submit" value="追加">
</form>

<%@include file="../footer.html" %>
