<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Board</h1>
	<form action="/app/board/add" method="post">
		<input type="text" name="title" placeholder="제목"><br>
		<textarea rows="" cols="" name="content" placeholder="내용"></textarea><br>
		<input type="text" name="writer" placeholder="작성자">
		<input type="submit" value="등록">
	</form>
</body>
</html>