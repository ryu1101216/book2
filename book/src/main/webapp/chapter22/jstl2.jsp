<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<c:choose>
    <c:when test="${point >= 90}">
        <p>90以上です。</p>
    </c:when>
    <c:when test="${point >= 80}">
        <p>80以上です。</p>
    </c:when>
    <c:when test="${point >= 70 && kyouka == \"国語\"}">
        <p>国語が70以上です。</p>
    </c:when>
    <c:when test="${point >= 70}">
        <p>70以上です。</p>
    </c:when>
    <c:when test="${point >= 60}">
        <p>60以上です。</p>
    </c:when>
    <c:when test="${point >= 50}">
        <p>50以上です。</p>
    </c:when>
</c:choose>
<c:if test="${age >= 18}" var="isAdult">
    <p>このコンテンツは表示されます。</p>
</c:if>
<p>成人: ${isAdult}</p>

<%@include file="../footer.html" %>
