package com.kh.app.board.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor //이거 없으면 NoSuch~Exception 에러남
public class BoardVo {

	private String no;
	private String title;
	private String content;
	private String enrollDate;
	
}
