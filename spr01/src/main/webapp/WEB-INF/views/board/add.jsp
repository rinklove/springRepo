<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Write board</h1>
<form action="/app01/board/add"  method="post">
	<input type="text" name="title" placeholder="제목">
	<textarea rows="" cols="" name="content" placeholder="내용"></textarea>
	<input type="text" name="writer" placeholder="작성자">
	<input type="submit" value ="게시글 작성">
</form>
</body>
</html>