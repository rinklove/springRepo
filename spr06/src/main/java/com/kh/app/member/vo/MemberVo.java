package com.kh.app.member.vo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MemberVo {

	private String no;
	private String id;
	private String pwd;
	private String nick;
	private String enrollDate;
}
