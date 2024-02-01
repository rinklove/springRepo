package com.kh.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {

		@GetMapping("board/list")
		public String getBoardist() {
			System.out.println("게시 글보여지= ");
			
			return "redirect:board/list";
		}
		
		@GetMapping("board/list2")
		public String getBoardist2(Model model) {
			
			model.addAttribute("board", "board내용용");
			return "board/list";
		}
		
		@GetMapping("board/add")
		public String renderAddPage() {
			return "board/add";
		}
		
		@PostMapping("board/add")
		public String addBoard(BoardVo board) {
			System.out.println(board);
			log.info("title = {}", board.getTitle());
			log.info("content = {}", board.getContent());
			log.info("writer = {}", board.getWriter());
			return "redirect:/list";
		}
}	
