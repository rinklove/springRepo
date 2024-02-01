package com.kh.app.member.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.member.vo.MemberVo;

@Repository
public class MemberRepository {

	/**
	 * 회원 가입
	 * @param memberVo
	 * @param template 
	 * @return
	 */
	public int join(MemberVo memberVo, SqlSessionTemplate template) {
		
		return template.insert("MemberMapper.insertMember", memberVo);
	}

	/**
	 * 상세 조회
	 * @param no
	 * @param template
	 * @return
	 */
	public MemberVo getOneByNo(String no, SqlSessionTemplate template) {
		
		return template.selectOne("MemberMapper.getMemberByNo", no);
	}

	/**
	 * 회원 목록 조회
	 * @param template
	 * @return
	 */
	public List<MemberVo> geteMemberList(SqlSessionTemplate template) {
		return template.selectList("MemberMapper.getMemberList");
	}

	/**
	 * 회원 정보 수정
	 * @param member
	 * @param template
	 * @return
	 */
	public int updateMember(MemberVo member, SqlSessionTemplate template) {
		return template.update("MemberMapper.updateMember", member);
	}

	/**
	 * 회원 삭제
	 * @param no
	 * @param template 
	 * @return
	 */
	public int deleteMember(String no, SqlSessionTemplate template) {
		return template.delete("MemberMapper.deleteOneByNo", no);
	}

}
