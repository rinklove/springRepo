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

	private final MemberRepository memberRepository;
	private final SqlSessionTemplate template;
	
	public int join(MemberVo newMember) throws Exception{
		
		String id = newMember.getId();
		if(id.length() < 4) {
			throw new Exception("아이디가 너무 짧아요");
		}
		
		if("admin".contains(id.toLowerCase())) {
			throw new Exception("사용 불가한 아이디");
		}
		
		return memberRepository.join(newMember, template);
	}

	/**
	 * 로그인
	 * @param member
	 * @return
	 */
	public MemberVo login(MemberVo member) {
		return memberRepository.login(member, template);
	}

	/**
	 * 회원 탈퇴
	 * @param no
	 * @return
	 */
	public int quit(String no) {
		return memberRepository.quit(no, template);
	}

	/**
	 * 회원 리스트
	 * @return
	 */
	public List<MemberVo> findAll() {
		return memberRepository.findAll(template);
	}

	/**
	 * 
	 * @param member
	 * @return
	 */
	public int update(MemberVo member) {
		return memberRepository.update(member, template);
	}
}
