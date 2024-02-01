package com.kh.app.member.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.member.vo.MemberVo;

@Repository
public class MemberRepository {

	/**
	 * 회원가입
	 * @param member
	 * @param template
	 * @return
	 */
	public int join(MemberVo member, SqlSessionTemplate template) {
		return template.insert("MemberMapper.join", member);
	}

	/**
	 * 로그인
	 * @param member
	 * @param template
	 * @return
	 */
	public MemberVo login(MemberVo member, SqlSessionTemplate template) {
		return template.selectOne("MemberMapper.login", member);
	}

}
