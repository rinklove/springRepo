package com.kh.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;


@Slf4j
//인터페이스로 진행할 시 implements WebSocketHandler로 
public class KhChatServer extends TextWebSocketHandler {
	
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();

	/**
	 *소켓 연결되었을 때 동작할 내용
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.info("연결됨");
		//접속자 연결
		sessionList.add(session);
	}

	/**
	 * 메시지 받았을 때 동작할 내용
	 */
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		log.info("메시지 받음");
		System.out.println(message.getPayload());
		
		//접속해있는 모든 사용자에게 메세지 전송 --> broadcasting
		for (WebSocketSession per : sessionList) {
			per.sendMessage(new TextMessage(message.getPayload().toString()));
		}
	}

	/**
	 * 소켓 연결 끊겼을 때 동작할 내용
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log.info("연결 끝");
		sessionList.remove(session);
	}


	
}
