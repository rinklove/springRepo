package com.kh.app.member.controller;

import java.nio.charset.Charset;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService service;
	
	@PostMapping
	public ResponseEntity<String> join(@RequestBody MemberVo member) {
		int result = service.join(member);
		
		if(result != 1) throw new IllegalStateException("회원가입 실패");
		return new ResponseEntity<String>("회원가입 완료" ,getHeaders(), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<MemberVo> login(@RequestBody MemberVo member) {
		log.info("member = {}", member);
		return new ResponseEntity<>(service.login(member), getHeaders(), HttpStatus.OK);
	}
	
	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		return headers;
	}
	
	@ExceptionHandler(value = IllegalStateException.class)
	public ResponseEntity<String> handleIllegal(IllegalStateException e) {
		return new ResponseEntity<String>(e.getMessage(), getHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<String> handleNull(NullPointerException e) {
		e.printStackTrace();
		return new ResponseEntity<String>("로그인 실패", getHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
