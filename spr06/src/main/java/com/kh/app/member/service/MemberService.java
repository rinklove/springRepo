package com.kh.app.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.app.member.repository.MemberRepository;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository repository;
	private final SqlSessionTemplate template;
	
	public int join(MemberVo memberVo) {
		return repository.join(memberVo, template);
	}

	/**
	 * 멤버 상세 조회
	 */
	public MemberVo getOneByNo(String no) {
		return repository.getOneByNo(no, template);
	}

	/**
	 * 회원 목록 조회
	 * @return
	 */
	public List<MemberVo> getMemberList() {
		return repository.geteMemberList(template);
	}

	/**
	 * 회원 정보 수정
	 * @param no
	 * @param member
	 */
	public int updateMember(String no, MemberVo member) {
		member.setNo(no);
		return repository.updateMember(member, template);
	}

	/**
	 * 회원 정보 삭제
	 * @param no
	 * @return
	 */
	public int deleteMember(String no) {
		return repository.deleteMember(no, template);
	}
}
