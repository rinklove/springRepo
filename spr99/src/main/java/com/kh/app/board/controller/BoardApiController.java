package com.kh.app.board.controller;

import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardApiController {

	private final BoardService service;
	
	@GetMapping("/list")
	public ResponseEntity<List<BoardVo>> getBoardList() {
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		return new ResponseEntity<List<BoardVo>>(service.findAll(), headers, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addBoard(@RequestBody BoardVo board, HttpSession session) throws Exception {
		
		log.info("board = {}", board);
		int result = service.insert(board);
		
		if(result != 1) {
			throw new Exception("게시글 작성 실패");
		}
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		return new ResponseEntity<String>("ok", headers, HttpStatus.OK);
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<String> boardExceptionHandler(Exception e) {
		e.printStackTrace();
		HttpHeaders headers = new HttpHeaders();
		 headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		return new ResponseEntity<String>(e.getMessage(), headers, HttpStatus.OK);
	}
}
