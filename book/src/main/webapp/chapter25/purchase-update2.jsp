    <%@page contentType="text/html; charset=UTF-8"%>
    <%@include file="../header.jsp"%>
    <%@include file="../chapter25/menu.jsp"%>
	<%@taglib prefix="c" uri="jakarta.tags.core" %>
    
  	<!-- 外部login用CSSファイルをリンク -->
    <link rel="stylesheet" href="../css/login.css">
    <h2>購入履歴修正</h2>
    <div class="wrapper">
    	<div class="email">
    		<form id="Login-form" action="PurchaseUpdate.action" method="post" novalidate>
    		    <input type="hidden" name="id" value="${purchase.id}">
    			<div>
    				<label for="productId">商品ID</label> <input type="number" id="productId" name="productId" value="${purchase.productId}" required readonly>
    			</div>
    			<div>
    				<label for="productName">商品名</label> <input type="text" id="productName" name="productName" value="${purchase.productName}" required>
    			</div>
    			<div>
    				<label for="productPrice">価格</label> <input type="number" id="productPrice" name="productPrice" value="${purchase.productPrice}" required>
    			</div>
    			<div>
    				<label for="productCount">数量</label> <input type="number" id="productCount" name="productCount" value="${purchase.productCount}" min="1" required>
    			</div>    			
     			<div>
    				<label for="customerName">購入者名</label> <input type="text" id="customerName" name="customerName" value="${purchase.customerName}" required>
    			</div>
    			<div>
    				<label for="customerAddress">住所</label> <input type="text" id="customerAddress" name="customerAddress" value="${purchase.customerAddress}" required>
    			</div>   			
    			
    			
    			<div class="align-center">
    				<input class="btn" type="submit" value="更新">
    			</div>
    		</form>
    		<!-- エラーメッセージ表示エリア -->
    		<div id="error-message" class="error-message"></div>
    	</div>
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

