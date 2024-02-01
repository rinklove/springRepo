package com.kh.app.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;
	
	@GetMapping("/list")
	public String renderListPage() {
		List<BoardVo> boardList = boardService.getBoardList();

		for (BoardVo b : boardList) {
			log.info("board = {}", b.toString());
		}
		return "board/list";
	}
	
	@GetMapping("/add")
	public String renderAddPage() {
		return "board/add";
	}
	
	@ResponseBody
	@PostMapping("/add")
	public Map<String, String> addBoard(BoardVo board) {
		
		log.info("board = {}", board);
		int result = boardService.addBoard(board);
		log.info("result = {}", result);
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("msg", "아아앙~!~!~!~!~!");
		return map;
	}
	
}
