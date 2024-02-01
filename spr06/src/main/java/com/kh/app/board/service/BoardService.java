package com.kh.app.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.app.board.repository.BoardRepository;
import com.kh.app.board.vo.BoardVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
//메소드에서 예외 발생 시 롤백을 실행해줌
@Transactional
public class BoardService {

	private final BoardRepository repository;
	//트랜젝션을 
	private final SqlSessionTemplate template;
	
	
	public int addBoard(BoardVo board) {
		return repository.addBoard(board, template);
	}


	/**
	 * 게시글 목록 가져오기
	 * @return
	 */
	public List<BoardVo> getBoardList() {
		return repository.getBoardList(template);
	}


	/**
	 * 게시글 상세 조회
	 * @param no
	 * @return
	 */
	public BoardVo getOneByNo(String no) {
		return repository.getOneByNo(no, template);
	}

	/**
	 * 게시글 삭제
	 * @param no
	 */
	public int deleteOneByNo(String no) {
		return repository.deleteOneByNo(no, template);
		
	}


	/**
	 * 게시글 수정
	 * @param no
	 * @param newBoard
	 */
	public int updateBoard(String no, BoardVo newBoard) {
		newBoard.setNo(no);
		return repository.updateBoard(newBoard, template);
	}
}
