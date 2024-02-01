package com.kh.app.board.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.board.vo.BoardVo;

@Repository
public class BoardRepository {

	/**
	 * 
	 * @param board
	 * @param template
	 * @return
	 */
	public int insert(BoardVo board, SqlSessionTemplate template) {
		return template.insert("BoardMapper.insertBoard", board);
	}

	/**
	 * 
	 * @param template
	 * @return
	 */
	public List<BoardVo> findAll(SqlSessionTemplate template) {
		return template.selectList("BoardMapper.getBoardList");
	}

	/**
	 * 
	 * @param no
	 * @param template
	 * @return
	 */
	public BoardVo findByNo(String no, SqlSessionTemplate template) {
		return template.selectOne("BoardMapper.getBoardByNo", no);
	}

	/**
	 * 
	 * @param no
	 * @param template
	 * @return
	 */
	public int delete(String no, SqlSessionTemplate template) {
		return template.update("BoardMapper.updateDelYnByNo", no);
	}

	public int update(BoardVo board, SqlSessionTemplate template) {
		return template.update("BoardMapper.updateBoard", board);
	}

}
