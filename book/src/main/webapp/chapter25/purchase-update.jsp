<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@include file="../header.html" %>
<%@include file="menu.jsp" %>

<h2>購入情報更新</h2>

<form action="PurchaseUpdate.action" method="post" style="margin-bottom:1em;">
	<input type="hidden" name="id" value="${purchase.id}">
	
	<table style="border-collapse:separate;border-spacing:10px;" border="1">
		<tr>
			<th>項目</th>
			<th>現在の値</th>
		</tr>
		<tr>
			<td><label for="productId">商品ID:</label></td>
			<td><input type="number" id="productId" name="productId" value="${purchase.productId}" required></td>
		</tr>
		<tr>
			<td><label for="productName">商品名:</label></td>
			<td><input type="text" id="productName" name="productName" value="${purchase.productName}" required></td>
		</tr>
		<tr>
			<td><label for="productPrice">価格:</label></td>
			<td><input type="number" id="productPrice" name="productPrice" value="${purchase.productPrice}" required></td>
		</tr>
		<tr>
			<td><label for="productCount">数量:</label></td>
			<td><input type="number" id="productCount" name="productCount" value="${purchase.productCount}" min="1" required></td>
		</tr>
		<tr>
			<td><label for="customerName">購入者名:</label></td>
			<td><input type="text" id="customerName" name="customerName" value="${purchase.customerName}" required></td>
		</tr>
		<tr>
			<td><label for="customerAddress">住所:</label></td>
			<td><input type="text" id="customerAddress" name="customerAddress" value="${purchase.customerAddress}" required></td>
		</tr>
	</table>
	
	<div style="margin-top:1em;">
		<input type="submit" value="更新">
		<input type="button" value="キャンセル" onclick="history.back()">
	</div>
</form>

<script>
	document.querySelector('form').addEventListener('submit', function(e) {
		const productPrice = document.getElementById('productPrice').value;
		const productCount = document.getElementById('productCount').value;
		
		if (productPrice < 0 || productCount < 1) {
			e.preventDefault();
			alert('価格は0以上、数量は1以上で入力してください。');
		}
	});
</script>

<%@include file="../footer.html" %>
