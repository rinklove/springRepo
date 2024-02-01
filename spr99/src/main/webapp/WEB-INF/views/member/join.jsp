<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="wrap">
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		<div class="main">
			<form action="${pageContext.request.contextPath }/member/join" method="post">
				아이디: <input type="text" name="id"><br>
				비밀번호: <input type="password" name="pwd"> <br>
				닉네임: <input type="text" name="nick"> <br>
				<input type="submit" value="회원가입">
			</form>
		</div>
	</div>
</body>
</html>