package com.kh.app.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

	private final MemberService memberService;
	
	@GetMapping("/join")
	public String renderJoin() {
		return "member/join";
	}
	
	@PostMapping("/join")
	public String join(MemberVo newMember) throws Exception {
		int result = memberService.join(newMember);
		
		if(result != 1) {
			throw new Exception();
		}
		return "redirect:/home";
	}

	
	@PostMapping("/login")
	public String login(MemberVo member, HttpSession session) throws Exception{
		System.out.println(member);
		MemberVo findMember = memberService.login(member);
		
		if(findMember == null) {
			
			throw new Exception();
		}
		
		session.setAttribute("loginMember", findMember);
		session.setAttribute("alertMsg", "로그인 성공");
		return "redirect:/home";
	}
	
	@GetMapping("/update")
	public String renderUpdate() {
		return "member/update";
	}
	
	@PostMapping("/update")
	public String updateMember(@RequestBody MemberVo member) {
		int result = memberService.update(member);
		return "redirect:/home";
	}
	
	@GetMapping("/quit")
	public String quit(HttpSession session) {
		MemberVo member =(MemberVo) session.getAttribute("loginMember");
		int result = memberService.quit(member.getNo());
		
		return "redirect:/home";
	}
	
	@GetMapping("list")
	public String renderMemberList(Model model) {
		List<MemberVo> list = memberService.findAll();
		model.addAttribute("list", list);
		return "member/list";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home";
	}
	
//	@ExceptionHandler(value = Exception.class)
//	public String handleExcpetion() {
//		
//	}
}
