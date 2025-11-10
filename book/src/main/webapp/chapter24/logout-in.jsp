<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.jsp"%>
<%@include file="../chapter25/menu.jsp"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<div class="wrapper">
	<div class="message-container">
		<div class="message-box">
			<c:if test="${empty customer.login}">
				<p>すでにログアウトしています。</p>
			</c:if>

			<c:if test="${!empty customer.login}">
				<p>ログアウトしますか？</p>
				<p><a href="Logout.action">ログアウト</a></p>
			</c:if>
		</div>
	</div>
</div>
<%@include file="../footer.jsp"%>
