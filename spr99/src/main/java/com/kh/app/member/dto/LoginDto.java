package com.kh.app.member.dto;

import com.kh.app.member.vo.MemberVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
	private String result;
	private MemberVo member;
}
