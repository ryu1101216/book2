<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html"%>

<%@page import="bean.STUDENTS, java.util.List"%>
<p>受講生検索キーワードを入力してください。</p>
<form action="search_st" method="post">
	<input type="text" name="keyword">
	 <input type="submit"
		value="検索">
</form>
<!-- 下記の@SuppressWarningsはEclipseの警告を消すための記述です。 -->
<%
List<STUDENTS> list = (List<STUDENTS>) request.getAttribute("list");
%>



<%
for (STUDENTS p : list) {
%>
<p><%=p.getStudent_id()%>：<%=p.getName()%>：<%=p.getAge()%></p>
<%
}
%>

<%@include file="../footer.html"%>
