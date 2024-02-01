package com.kh.app.board.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/board", produces = "application/json; charset=utf8")
@RequiredArgsConstructor
public class BoardController {

	private final BoardService service;
	
	/**
	 * 게시글 목록 가져오기
	 * @return
	 */
	@GetMapping("/list")
	public List<BoardVo> renderAdd() {
		return service.getBoardList();
	}
	
	/**
	 * 게시글 작성하기
	 * @return
	 */
	@PostMapping("/add")
	public String addBoard(BoardVo board) {
		int result = service.addBoard(board);
		return  result + "개의 게시글 작성되었습니다.";
	}
	
	/**
	 * 게시글 상세정보
	 * @param no
	 * @return
	 */
	@GetMapping("/detail/{no}")
	public BoardVo getOne(@PathVariable String no) {
		log.info("no = {}", no);
		return service.getOneByNo(no);
	}
	
	/**
	 * 게시글 수정
	 * Patch 메소드는 전달하려는 데이터를 json형태로 보내야한다(?)
	 * @param no
	 * @param newBoard
	 * @return
	 */
	@PatchMapping("/update/{no}")
	public BoardVo updateOne(@PathVariable String no, @RequestBody BoardVo newBoard) {
		log.info("newBoard = {}", newBoard);
		int result = service.updateBoard(no, newBoard);
		log.info("result = {}", result);
		return service.getOneByNo(no);
	}
	
	/**
	 * 게시글 삭제
	 * @param no
	 * @return
	 */
	@DeleteMapping("/delete/{no}")
	public String deleteOne(@PathVariable String no) {
		int result = service.deleteOneByNo(no);
		log.info("result = {}", result);
		return "게시글이 삭제되었습니다";
	}
}
