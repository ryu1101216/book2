<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<p>検索キーワードを入力してください。</p>
<form action="search_day" method="post">
<p>開始日：<input type="text" name="start_day"></p>
<p>終了日：<input type="text" name="end_day"></p>
<p><input type="submit" value="検索">
</form>

<%@include file="../footer.html" %>
