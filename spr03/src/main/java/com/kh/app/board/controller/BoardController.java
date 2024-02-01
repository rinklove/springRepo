package com.kh.app.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BoardController {
	
	private final BoardService boardService;

	@GetMapping("board/list")
	public String renderList(Model model) {
		List<BoardVo> boardList = boardService.getBoardList();
		for(BoardVo b : boardList ) {
			System.out.println(b);
		}
		model.addAttribute("list", boardList);
		return "board/list";
	}
	
	@GetMapping("/board/add")
	public String renderAddPage() {
		return "board/add";
	}
	
	@ResponseBody
	@PostMapping("/board/add")
	public String addBoard(BoardVo board) {
		System.out.println(board);
		return "<h1>" + board.toString() + "</h1>";
	}
}
