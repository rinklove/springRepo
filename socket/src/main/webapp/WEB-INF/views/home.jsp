<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>


	<h1>채팅팅~</h1>
	<form id="formTag">
		<input type="text" name="msg" id="msg">
		<input type="submit" value="전송">
	</form>
	
	<div id="msgArea">
	</div>
	<script type="text/javascript">
		
		const socket = new WebSocket("ws://127.0.0.1:8888/app/chatserver");
		socket.onopen = () => {console.log("open")}
		socket.onclose = () => {console.log("close")}
		socket.onerror = () => {console.log("error")}
		socket.onmessage = (msg) => {
			const msgP = document.createElement("p");
			msgP.innerText = msg.data;
			msgArea.appendChild(msgP);
			
			
		}

		
		formTag.addEventListener("submit", (event) => {
			event.preventDefault();
			
			socket.send(msg.value);
			msg.value = "";
		});

	</script>
</body>
</html>
