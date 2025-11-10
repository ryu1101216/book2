<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<p>検索キーワードを入力してください。</p>
<form action="search" method="post">
<p>商品：<input type="text" name="keyword1"></p>
<p>価格：<input type="text" name="keyword2"></p>
<p><input type="submit" value="検索">
</form>

<p>削除する商品IDを入力してください。</p>
<form action="delete" method="post">
    商品ID<input type="text" name="id"> <input type="submit" value="削除">
</form>

<p>更新する商品IDと価格を入力してください。</p>
<form action="update" method="post">
<p>商品ID：<input type="text" name="id"></p>
<p>価格：<input type="text" name="price"></p>
<p><input type="submit" value="更新">
</form>

<%@include file="../footer.html" %>
