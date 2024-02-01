package com.kh.app.member.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.member.vo.MemberVo;

@Repository
public class MemberRepository {

	/**
	 * 회원 강비
	 * @param newMember
	 * @param template
	 * @return
	 */
	public int join(MemberVo newMember, SqlSessionTemplate template) {
		return template.insert("MemberMapper.insertMember", newMember);
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

	/**
	 * 탈퇴
	 * @param no
	 * @param template
	 * @return
	 */
	public int quit(String no, SqlSessionTemplate template) {
		return template.update("MemberMapper.updateDelynByNo", no);
	}

	/**
	 * 
	 * 회원 목록 
	 * @param template
	 * @return
	 */
	public List<MemberVo> findAll(SqlSessionTemplate template) {
		return template.selectList("MemberMapper.getMemberList");
	}

	/**
	 * 
	 * @param member
	 * @param template
	 * @return
	 */
	public int update(MemberVo member, SqlSessionTemplate template) {
		return template.update("MemberMapper.updateMember", member);
	}



}
