<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Custom styles for this template -->
<link href="css/signin.css" rel="stylesheet">

<div class="container">
	<form id="loginForm" name="loginForm" class="form-signin">
		<h2 class="form-signin-heading">Please sign in</h2>
		
		<label for="memberId" class="sr-only">ID</label>
		<input type="text" id="memberId" name="memberId" class="form-control" placeholder="Please enter your ID" required autofocus>
		
		<label for="memberPw" class="sr-only">Password</label>
		<input type="password" id="memberPw" name="memberPw" class="form-control" placeholder="Please enter your Password" required>
		
		<button class="btn btn-lg btn-primary btn-block" type="button" onclick="javascript:fn_signIn();">Sign in</button>
		<button class="btn btn-lg btn-info btn-block" type="button" onclick="javascript:fn_signUp();">Sign up</button>
	</form>
</div><!-- /container -->

<script>
	var submitYN = false;

	<%-- 로그인 --%>
	function fn_signIn(){

		if(document.getElementById("memberId").value.length < 1){
			alert("아이디를 입력하세요.");
			document.getElementById("memberId").focus()
			return;
		}
		
		if(document.getElementById("memberPw").value.length < 1){
			alert("비밀번호를 입력하세요.");
			document.getElementById("memberPw").focus()
			return;
		}
		
		if(!submitYN){
			submitYN = true;
			
			$.ajax({
				 url :"/loginAction.do"
				,type:"post"
				,data:$("#loginForm").serialize()
				,success:function(data){
					if(data != "N"){
						alert(data + "회원님, 환영합니다");
						location.href="/selectMemberList.do?page=0&size=10"
					}else{
						alert("회원정보 가입을 해주세요");
					}
				}
			    ,error: function(xhr, status, error){
			    	alert("에러발생");
			    }
			    ,complete : function() {
			    	submitYN = false;
			    }
			    
			});
			
		}
		
	}

	<%-- 멤버등록화면으로 이동 --%>
	function fn_signUp(){
		location.href = "/fwdMemberReg.do";
	}

</script>