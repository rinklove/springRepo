package com.kh.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@GetMapping("/list")
	public String renderListPage() {
		return "board/list";
	}
	
	@GetMapping("/add")
	public String renderAddPage() {
		return "board/add";
	}

	@PostMapping("add")
	public String addBoardBoard(BoardVo board) {
		System.out.println(board);
		return "redirect:/board/list";
	}
}
