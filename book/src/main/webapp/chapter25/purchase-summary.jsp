<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.jsp" %>
<%@include file="../chapter25/menu.jsp" %>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<p>${customer.login}さんの購入履歴サマリー</p>
<table align="center" class="table_design09"
	style="border-collapse: separate; border-spacing: 10px;">
	<thead>
		<tr>
			<th scope="col">ID</th>
			<th scope="col" colspan=2>商品</th>
			<th scope="col">購入数</th>
			<th scope="col">単価</th>
			<th scope="col">合計金額</th>
		</tr>
	</thead>
	<tbody>
		<c:set var="total" value="${0}"/>
		<c:forEach var="purchase_summary" items="${	list}">
			<tr>
				<td>${purchase_summary.product_id}</td>
				<td><img src="image/${purchase_summary.product_id}.jpg" height="64"></td>
				<td>${purchase_summary.product_name}</td>
				<td>${purchase_summary.count}個</td></td>
				<td><fmt:formatNumber value="${purchase_summary.unit_price}" pattern="##,###"/>円</td>
				<td><fmt:formatNumber value="${purchase_summary.total_price}" pattern="##,###"/>円</td>
				<c:set var="total" value="${total + purchase_summary.total_price}"/>
			</tr>
		</c:forEach>
	</tbody>
</table>
<p>合計：<fmt:formatNumber value="${total}" pattern="##,###"/>円<p>
<%@include file="../footer.jsp"%>
