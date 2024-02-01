<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
	body {
		padding: 0%;
		margin: 0%;
		box-sizing: border-box;
	}
	
	.wrap {
		width: 100vw;
		height:100vh;
		display: grid;
		grid-template-rows: 20vh 10vh 60vh 10vh;
		grid-template-columns: 1fr;
		place-items: center center;
	}
	
	.logo {
		display: flex;
		justify-content: center;
		width:100%
	}
	
	.header {
		width:60%;
		height: 100%;
		display: grid;
		grid-template-columns: 1fr 3fr 1fr;
		grid-template-rows: 1fr;
	}
	
	.navi {
		width:60%;
		height: 60%;
		display:grid;
		background-color: gray;
		grid-template-rows: 1fr;
		grid-template-columns: repeat(4, 1fr);
		place-items: center center;
	}
	
	.navi > div > a {
		text-decoration: none;
		color: white;
		font-size: 1.3em;
		font-weight: 600;
	}
	
	.loginArea {
		width: 100%;
		height: 100%; 
	}
	.loginArea > form {
		width:100%;
		height: 100%;
		display: grid;
		grid-template-columns: 1fr 1fr;
		grid-template-rows: 1fr 1fr 1fr;
	}
	
	.loginArea > form > input:nth-child(1), .loginArea > form > input:nth-child(2) {
		grid-column: span 2;
	}
	
</style>
<div class='header'>
	<div>
		<img alt="" src="${pageContext.request.contextPath }/resources/img/logo.png" style="width: 100%; height:20vh;">
	</div>
	<div class="logo">
		<img alt="" src="${pageContext.request.contextPath }/resources/img/main.png" style=" width: 70%; height:20vh;">
	</div>
	<div class="loginArea">
		<c:choose>
			<c:when test="${empty loginMember }">
				<form action="/app/member/login" method="post" enctype="application/x-www-form-urlencoded">
					<input type="text" placeholder="아이디" name="id">
					<input type="password" placeholder="비밀번호" name="pwd">
					<input type="button" value="회원가입" onclick="location.href='/app/member/join' ">
					<input type="submit" value="로그인">
				</form>
			</c:when>
			<c:otherwise>
			 ${loginMember.nick }님 하이연
			 <input type="button" value="로그아웃" onclick="location.href='/app/member/logout' ">
			</c:otherwise>
		</c:choose>
	</div>

	
</div>

<div class="navi">
	<div><a href="${pageContext.request.contextPath}/board/list">개시판</a></div>
	<div>공사지항</div>
	<div>갤리러</div>
	<div>페이마이지</div>
</div>


