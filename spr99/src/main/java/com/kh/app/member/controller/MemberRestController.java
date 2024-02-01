package com.kh.app.member.controller;

import java.nio.charset.Charset;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.app.member.dto.LoginDto;
import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/rest/member")
@RequiredArgsConstructor
//CORS 정책 오류를 방지하기 위해서 ()에 있는(==origin에서 오는) 요청 경로만 처리하겠다고 선언
//*: 모든 요청을 처리하겠다는 의미, 실무에선 도메인을 정하는 것이 필수
@CrossOrigin("*")
public class MemberRestController {
	
	private final MemberService service;

	@PostMapping("/join")
	public ResponseEntity<String> join(@RequestBody MemberVo newMember) throws Exception {
		
		//3초 이상 기다려야함.
		Thread.sleep(3000);
		
		int result = service.join(newMember);
		if(result != 1) {
			throw new Exception("회원가입 실패");
		}
		
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		return new ResponseEntity<String>("회원가입 완료", headers, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginDto> login(@RequestBody MemberVo member) throws Exception {
		
		MemberVo findMember = service.login(member);
		log.info("findMember = {}", findMember);
		
		if(findMember == null) {
			throw new Exception("아이디 또는 비밀번호가 일치하지 않습니다.");
		}
		LoginDto loginDto = new LoginDto("로그인 성공", findMember);
		
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		return new ResponseEntity<LoginDto>(loginDto, headers, HttpStatus.OK);
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<String> sendError(Exception e) {
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		return new ResponseEntity<String>(e.getLocalizedMessage(), headers, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
