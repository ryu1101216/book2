<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<p>検索キーワードを入力してください。</p>
<form action="a" method="post">
<input type="text" name="keyword">
<input type="submit" value="検索">
</form>

<%>
List<Product> list=(List<Product>)request.getAttribute("list");
%>

<% for (Product p : list) { %>
	<p><%=p.getId() %>：<%=p.getName() %>：<%=p.getPrice() %></p>
<% } %>

<%@include file="../footer.html" %>
