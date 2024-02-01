package com.kh.app.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.app.board.dao.BoardRepository;
import com.kh.app.board.vo.BoardVo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;
	//SqlSessionTemplate => 자동으로 close()해줌 + 공용으로 사용하는 객체이기 때문에 필드 변수로 선
	private final SqlSessionTemplate template;
	
	@Transactional
	public List<BoardVo> getBoardList() {		
		//Repository
		return boardRepository.getBoardList(template);
	}

	
}
