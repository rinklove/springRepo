package com.kh.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class BoardVo {
 
	private String title;
	private String content;
	private String writer;
}
