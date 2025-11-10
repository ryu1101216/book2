<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<%>
List<Product> list=(List<Product>)request.getAttribute("list");
%>

<% for (Product p : list) { %>

	<p>${p.id}：${p.name}：${p.price}</p>
<% } %>

<%@include file="../footer.html" %>
