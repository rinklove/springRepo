package com.kh.app.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.app.board.repository.BoardRepository;
import com.kh.app.board.vo.BoardVo;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;
	private final SqlSessionTemplate template;
	/**
	 * 
	 * @param board
	 * @return
	 */
	public int insert(BoardVo board) {
		return boardRepository.insert(board, template);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<BoardVo> findAll() {
		return boardRepository.findAll(template);
	}

	/**
	 */
	public BoardVo findByNo(String no) {
		return boardRepository.findByNo(no, template);
	}

	/**
	 * 
	 * @param no
	 * @return
	 */
	public int delete(String no) {
		return boardRepository.delete(no, template);
	}

	/**
	 * 
	 * @param board
	 * @return
	 */
	public int update(BoardVo board) {
		return boardRepository.update(board, template);
	}
}
