package com.kh.app.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;
	
	
	@PostMapping("/insert")
	public String insert(@RequestBody BoardVo board, HttpSession session) throws Exception{
		MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
		board.setWriterNo(loginMember.getNo());
		
		int result = boardService.insert(board);
		
		if(result != 1) {
			throw new Exception();
		}
		return "";
	}
	
	@GetMapping("/list")
	public String renderList() {
		return "board/list";
	}
	
	/**
	 * 데이터만 전달
	 * @param pno
	 * @return
	 */
	@ResponseBody
	@GetMapping("/rest/list")
	public List<BoardVo> list(@RequestParam String pno) {
		return boardService.findAll();
	}
	
	@GetMapping("/detail/{no}")
	public String getOne(@PathVariable String no, Model model) {
		BoardVo findBoard = boardService.findByNo(no);
		
		model.addAttribute("board", findBoard);
		return "board/detail";
	}
	
	@GetMapping("/delete/{no}")
	public String delete(@PathVariable String no) throws Exception{
		int result = boardService.delete(no);
		
		if(result != 1) {
			throw new Exception();
		}
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/update")
	public String update(@RequestBody BoardVo board) throws Exception {
		int result = boardService.update(board);
		
		if(result != 1) {
			throw new Exception();
		}
		
		return "redirect:/board/detail/"+board.getNo();
	}
}
