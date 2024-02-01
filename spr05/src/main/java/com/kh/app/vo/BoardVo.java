package com.kh.app.vo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BoardVo {

	private String no;
	private String title;
	private String content;
	private String enrollDate;
}
