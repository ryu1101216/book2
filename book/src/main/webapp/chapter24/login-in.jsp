    <%@page contentType="text/html; charset=UTF-8"%>
    <%@include file="../header.jsp"%>
    <%@include file="../chapter25/menu.jsp"%>
	<%@taglib prefix="c" uri="jakarta.tags.core" %>
    
  	<!-- 外部login用CSSファイルをリンク -->
    <link rel="stylesheet" href="../css/login.css">
    
    <div class="wrapper">
    	<c:if test="${empty customer.login}">
    	<h2 class="heading-large">Login</h2>
    	<div class="email">
    		<form id="login-form" action="Login.action" method="post" novalidate>
    			<div>
    				<label for="login">メールアドレス</label> <input type="text" id="login"
    					name="login" required>
    			</div>
    			<div>
    				<label for="password">パスワード</label> <input type="password"
    					id="password" name="password" required>
    			</div>
    			<div class="align-center">
    				<input class="btn" type="submit" value="ログイン">
    			</div>
    		</form>
    		<!-- エラーメッセージ表示エリア -->
    		<div id="error-message" class="error-message"></div>
    	</div>
    	</c:if>
    	
    	<c:if test="${!empty customer.login}">
		<div class="wrapper">
			<div class="message-container">
				<div class="message-box">ユーザ：${customer.login} で<br>ログインしています。</div>
			</div>
		</div>
		</c:if>  
    </div>
    <script
    	src="https://cdn.jsdelivr.net/npm/validator@13.9.0/validator.min.js"></script>
    <script>
    	// ページ読み込み後に実行
    	const form = document.getElementById('login-form');
    	const errorElement = document.getElementById('error-message');
    
    	// フォーム送信時のイベントリスナーを登録
    	form.addEventListener('submit', function(event) {
    		const emailInput = form.querySelector('input[name="login"]');
    		const passwordInput = form.querySelector('input[name="password"]');
    		const email = emailInput.value.trim();
    		const password = passwordInput.value.trim();
    
    		// エラーメッセージをクリア
    		errorElement.textContent = '';
    
    		// エラーメッセージを格納する配列
    		let errors = [];
    
    		// メールアドレスの必須チェック
    		if (validator.isEmpty(email)) {
    			errors.push('メールアドレスを入力してください。');
    		} else {
    			// メールアドレスの形式チェック
    			if (!validator.isEmail(email)) {
    				errors.push('有効なメールアドレスを入力してください。');
    			}
    		}
    
    		// パスワードの必須チェック
    		if (validator.isEmpty(password)) {
    			errors.push('パスワードを入力してください。');
    		} else {
    			// パスワードの文字数チェック（1文字以上15文字以内）
    			if (!validator.isLength(password, {
    				min : 1,
    				max : 15
    			})) {
    				errors.push('パスワードは15文字以内で入力してください。');
    			}
    
    			// パスワードの半角英数字チェック
    			if (!validator.isAlphanumeric(password)) {
    				errors.push('パスワードは半角英数字で入力してください。');
    			}
    		}
    
    		// エラーが存在する場合
    		if (errors.length > 0) {
    			// エラーメッセージを表示
    			errorElement.innerHTML = errors.join('<br>');
    			event.preventDefault(); // フォーム送信を停止
    		}
    
    		// バリデーションを通過した場合はフォーム送信
    		return errors.length === 0;
    	});
    </script>
    <%@include file="../footer.jsp"%>

