package com.kh.app.member.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVo {

	private String no;
	private String id;
	private String pwd;
	private String nick;
	private String enrollDate;
	private String delYn;
}
