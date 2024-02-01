package com.kh.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.app.member.repository.MemberRepository;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository repository;
	private final SqlSessionTemplate template;
	private final BCryptPasswordEncoder encoder;
	
	/**
	 * 회원가입
	 * @param member
	 * @return
	 */
	public int join(MemberVo member) {
		member.setPwd(encoder.encode(member.getPwd()));
		return repository.join(member, template);
	}

	/**
	 * 로그인
	 * @param member
	 * @return
	 */
	public MemberVo login(MemberVo member) {
		MemberVo loginMember = repository.login(member, template);
		log.info("loginMember = {}", loginMember);
		if(!encoder.matches(member.getPwd(), loginMember.getPwd())) {
			throw new NullPointerException("로그인 실패");
		}
		return loginMember;
	}
	
//	private boolean checkPwd(String raw, String enc) {
//		return raw.equals(enc);
//	}

}
