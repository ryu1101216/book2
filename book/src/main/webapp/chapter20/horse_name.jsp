<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<jsp:useBean id="horses" class="bean.Horse" />

<jsp:setProperty name="horses" property="馬名" value="マヤノトップガン" />
<jsp:setProperty name="horses" property="誕生日" value="1991-03-24" />
<jsp:setProperty name="horses" property="性別" value="牡" />
<jsp:setProperty name="horses" property="毛色" value="栗毛" />
<jsp:getProperty name="horses" property="誕生日" />：
<jsp:getProperty name="horses" property="馬名" />：
<jsp:getProperty name="horses" property="性別" />：
<jsp:getProperty name="horses" property="毛色" />

<%@include file="../footer.html" %>
