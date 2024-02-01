package com.kh.app.board.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardVo {

	private String no;
	private String title;
	private String content;
	private String writerNo;
	private String hit;
	private String writerNick;
	private String enrollDate;
	private String delYn;
	
	
//	private BoardVo BoardVo(BoardTemp tmp) {
//		return builder()
//				.no(tmp.no)
//				.title(tmp.title)
//				.content(tmp.content)
//				.writerNo(tmp.writerNo)
//				.writerNick(tmp.writerNick)
//				.hit("0")
//				.enrollDate(LocalDateTime.now().toString())
//				.delYn("N")
//				.build();
//	}
//	
//	static class BoardTemp {
//		private String no;
//		private String title;
//		private String content;
//		private String writerNo;
//		private String hit;
//		private String writerNick;
//		private String enrollDate;
//		private String delYn;
//	}
}
