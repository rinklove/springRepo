package com.kh.app.member.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/member", produces = "application/json; charset=utf8")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService service;
	
	/**
	 * 회원가입
	 * @param memberVo
	 * @return
	 */
	@PostMapping("/join")
	public String join(MemberVo memberVo) {
		service.join(memberVo);
		return "회원가입이 완료되었습니다";
	}
	
	/**
	 * 목록 조회
	 * @return
	 */
	@GetMapping("/list")
	public List<MemberVo> getMemberList() {
		return service.getMemberList();
	}
	
	/**
	 * 상세 조회
	 * @param no
	 * @return
	 */
	@GetMapping("/detail/{no}")
	public MemberVo getOneByNo(@PathVariable String no) {
		return getOneByNo(no);
	}
	
	/**
	 * 회원 정보 수정
	 * @param no
	 * @param member
	 * @return
	 */
	@PatchMapping("/update/{no}")
	public String updateMember(@PathVariable String no, @RequestBody MemberVo member) {
		service.updateMember(no, member);
		return "회원 정보 수정 완료";
	}
	
	/**
	 * 회원 삭제
	 * @param no
	 * @return
	 */
	@DeleteMapping("/delete/{no}")
	public String deleteMember(@PathVariable String no) {
		service.deleteMember(no);
		return "삭제 되었습니다";
	}
}
