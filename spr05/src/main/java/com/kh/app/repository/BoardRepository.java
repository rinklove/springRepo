package com.kh.app.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.vo.BoardVo;

@Repository
public class BoardRepository {

	/**
	 * 게시글 등록 
	 * @param board
	 * @param template
	 * @return
	 */
	public int addBoard(BoardVo board, SqlSessionTemplate template) {
	
		return template.insert("BoardMapper.insertBoard", board);
	}

	/**
	 * 게시글 목록 가져오기
	 * @param template
	 * @return
	 */
	public List<BoardVo> getBoardList(SqlSessionTemplate template) {
		return template.selectList("BoardMapper.getBoardList");
	}

	/**
	 * 게시글 상세 정보 가져오기
	 * @param no
	 * @param template
	 * @return
	 */
	public BoardVo getOneByNo(String no, SqlSessionTemplate template) {
		return template.selectOne("BoardMapper.getBoardByNo", no);
	}

	/**
	 * 게시글 삭제
	 * @param no
	 * @param template
	 * @return
	 */
	public int deleteOneByNo(String no, SqlSessionTemplate template) {
		return template.delete("BoardMapper.deleteOneByNo", no);
	}

	/**
	 * 게시글 수정
	 * @param newBoard
	 * @param template
	 * @return
	 */
	public int updateBoard(BoardVo newBoard, SqlSessionTemplate template) {
		return template.update("BoardMapper.updateBoard", newBoard);
	}

}
