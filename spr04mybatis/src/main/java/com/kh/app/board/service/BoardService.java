package com.kh.app.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.kh.app.board.repository.BoardRepository;
import com.kh.app.board.vo.BoardVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository; 
	private final SqlSessionTemplate template;
	
	/**
	 * 게시글 등록
	 * @param board
	 * @return
	 */
	public int addBoard(BoardVo board) {	
		int result = boardRepository.addBoard(template, board);
		
		return result;
	}

	/**
	 * 리스트 가져오기
	 * @return
	 */
	public List<BoardVo> getBoardList() {
		return boardRepository.getBoardList(template);
	}

}
