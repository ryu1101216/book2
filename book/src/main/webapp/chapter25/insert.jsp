<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@include file="menu.jsp" %>

<p>追加するユーザをを入力してください。</p>
<form action="Insert.action" method="post">
ユーザ名<input type="text" name="login">
パスワード<input type="text" name="password">
<input type="submit" value="追加">
</form>

<%@include file="../footer.html" %>
