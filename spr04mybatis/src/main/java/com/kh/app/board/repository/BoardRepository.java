package com.kh.app.board.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.board.vo.BoardVo;

@Repository
public class BoardRepository {

	/**
	 * 게시글 추가
	 * @param template
	 * @param board
	 * @return
	 */
	public int addBoard(SqlSessionTemplate template, BoardVo board) {
		return template.insert("boardMapper.insertBoard", board);
	}

	/**
	 * 게시글 리스트 가져오기
	 * @param template
	 * @return
	 */
	public List<BoardVo> getBoardList(SqlSessionTemplate template) {
		return template.selectList("boardMapper.getBoardList");
	}

}
