<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@include file="../header.html" %>
<%@include file="menu.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h2>購入履歴一覧</h2>

<form action="purchaseList.action" method="post" style="margin-bottom:1em;">
	<label>最低価格: <input type="text" name="minPrice" value="${minPrice}"></label>
	<label>最高価格: <input type="text" name="maxPrice" value="${maxPrice}"></label>
	<label>商品名: <input type="text" name="productName" value="${productName}"></label>
	<input type="submit" value="検索">
</form>

<table align="center" class="table_design09"
	style="border-collapse: separate; border-spacing: 10px;">
	<thead>
	<tr>
		<th>ID</th>
		<th>商品ID</th>
		<th>商品名</th>
		<th>価格</th>
		<th>数量</th>
		<th>購入者名</th>
		<th>住所</th>
		<th>小計</th>
		<th colspan=2>操作</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="purchase" items="${list}">
		<tr>
			<td>${purchase.id}</td>
			<td>${purchase.productId}</td>
			<td>${purchase.productName}</td>
			<td><fmt:formatNumber value="${purchase.productPrice}" pattern="##,###"/>円</td>
			<td><fmt:formatNumber value="${purchase.productCount}" pattern="##,###"/>個</td>
			<td>${purchase.customerName}</td>
			<td>${purchase.customerAddress}</td>
			<td><fmt:formatNumber value="${purchase.productPrice * purchase.productCount}" pattern="##,###"/>円</td>
			<td><a href="PurchaseUpdate.action?id=${purchase.id}">更新</a></td>
			<td><a href="PurchaseDelete.action?id=${purchase.id}">削除</a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>

<c:if test="${empty list}">
	<p>該当する購入履歴はありません。</p>
</c:if>


<%@include file="../footer.html" %>
