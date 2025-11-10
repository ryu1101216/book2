<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<!doctype html>
<html lang="ja">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="./style.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
     <style>
       #loading {
            background: rgba(0, 0, 0, .5);
            z-index: 10000;
      }
    </style>
<title>Hello, world!</title>
</head>
<body>
<div id="loading" class="position-absolute top-0 start-0 w-100 h-100 d-none">
    <div class="text-center position-absolute top-50 start-50 w-100 translate-middle">
        <div class="spinner-border text-light" role="status">
            <span class="sr-only"></span>
        </div>
    </div>
</div>
	<h2>キーワード検索</h2>
	<div class="wrapper">
	<form action="Search.action" method="post">
		<div class="form-group">
			<!-- 入力要素ごとにform-group、入力エリアはform-control -->
			<label for="horse_name">馬名</label> <input type="text"
				class="form-control" id="horse_name" name="horse_name"
				placeholder="馬名を入力"> <label for="result">実績</label> <input
				type="text" class="form-control" id="result" name="result"
				placeholder="実績を入力"> <label for="race">レース名</label> <input
				type="text" class="form-control" id="race" name="race"
				placeholder="レース名を入力">
		</div>
		<button type="submit" class="btn btn-primary">送信</button>
	</form>
	</div>

	<%@taglib prefix="c" uri="jakarta.tags.core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<c:if test="${not empty list}">
		<table align="center" class="table_design09">
			<c:choose>

				<c:when test="${mode == \"horse_name\"}">
					<thead>
						<tr>
							<th scope="col">馬名</th>
							<th scope="col">性別</th>
							<th scope="col">毛色</th>
							<th scope="col">誕生日</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="p" items="${list}">
							<tr>
								<th scope="col">${p.馬名}</th>
								<th scope="col">${p.性別}</th>
								<th scope="col">${p.毛色}</th>
								<th scope="col"><fmt:formatDate value="${p.誕生日}" pattern="yyyy年M月d日" /></th>
							</tr>
						</c:forEach>
					</tfoot>
				</c:when>

				<c:when test="${mode == \"result\"}">
					<thead>
						<tr>
							<th scope="col">回</th>
							<th scope="col">レース名</th>
							<th scope="col">開催日</th>
							<th scope="col">グレード</th>
							<th scope="col">競馬場</th>
							<th scope="col">コース</th>
							<th scope="col">距離</th>
							<th scope="col">条件</th>
							<th scope="col">優勝馬</th>
							<th scope="col">性齢</th>
							<th scope="col">毛色</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="p" items="${list}">
							<tr>
								<th scope="col">${p.回}</th>
								<th scope="col">${p.レース名}</th>
								<th scope="col"><fmt:formatDate value="${p.開催日}" pattern="yyyy年M月d日" /></th>
								<th scope="col">${p.グレード}</th>
								<th scope="col">${p.競馬場}</th>
								<th scope="col">${p.コース}</th>
								<th scope="col"><fmt:formatNumber value="${p.距離}" pattern="##,###" />m<br></th>
								<th scope="col">${p.条件}</th>
								<th scope="col">${p.優勝馬}</th>
								<th scope="col">${p.性別}${p.年齢}</th>
								<th scope="col">${p.毛色}</th>
							</tr>
						</c:forEach>
					</tfoot>
				</c:when>

				<c:when test="${mode == \"race\"}">
					<thead>
						<tr>
							<th scope="col">レース名</th>
							<th scope="col">グレード</th>
							<th scope="col">競馬場</th>
							<th scope="col">コース</th>
							<th scope="col">距離</th>
							<th scope="col">条件</th>
							<th scope="col">現行</th>
							<th scope="col">創設年</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="p" items="${list}">
							<tr>
								<th scope="col">${p.レース名}</th>
								<th scope="col">${p.グレード}</th>
								<th scope="col">${p.競馬場}</th>
								<th scope="col">${p.コース}</th>
								<th scope="col"><fmt:formatNumber value="${p.距離}" pattern="##,###" />m<br></th>
								<th scope="col">${p.条件}</th>
								<th scope="col">${p.現行}</th>
								<th scope="col">${p.創設年}年</th>
							</tr>
						</c:forEach>
					</tfoot>
				</c:when>
			</c:choose>	
		</table>
	</c:if>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script>
    $(function () {
        //ローディング表示
        show_loading();

        //1秒後にローディング非表示
        setTimeout(function () {
            hide_loading();
        }, 1000);
    })

    //ローディング表示
    function show_loading() {
        $('#loading').removeClass('d-none');
    }

    //ローディング非表示
    function hide_loading() {
        $('#loading').addClass('d-none');
    }
</script>

</body>
</html>
