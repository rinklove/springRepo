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
			<h1>게시판</h1>
		</div>
	</div>
	<script>
	const voList = [
		{
			no:'1',
			title:'제목11',
			writerNick:'hello'
		},
		{
			no:'2',
			title:'제목22',
			writerNick:'hello'
		},
		{
			no:'3',
			title:'제목33',
			writerNick:'hello'
		},
		{
			no:'4',
			title:'제목44',
			writerNick:'hello'
		}.
	];
	fetch("/app/board/list?pno=1")
	 const mainDiv = document.querySelector(".main");
     const str    = ''
               + '<table>'
              + '<thead>' 
              + '<tr>'
              + '<th>' + '번호' +'</th>'
              + '<th>' + '제목' +'</th>'
              + '<th>' + '내용' +'</th>'
              + '</tr>'
              + '</thead>' 
              + '<tbody>' 
              + '<tr>'
              + '<td>' + '11' +'</td>'
              + '<td>' + '제목입니다ㅋㅋ' +'</td>'
              + '<td>' + '내용입니다ㅋㅋ' +'</td>'
              + '</tr>'
              + '<tr>'
              + '<td>' + '12' +'</td>'
              + '<td>' + '제목입니다ㅋㅋ222' +'</td>'
              + '<td>' + '내용입니다ㅋㅋ222' +'</td>'
              + '</tr>'
              + '<tr>'
              + '<td>' + '13' +'</td>'
              + '<td>' + '제목입니다ㅋㅋ333' +'</td>'
              + '<td>' + '내용입니다ㅋㅋ333' +'</td>'
              + '</tr>'
              + '</tbody>' 
                + '</table>';
     mainDiv.innerHTML += str;

</script>
</body>
</html>