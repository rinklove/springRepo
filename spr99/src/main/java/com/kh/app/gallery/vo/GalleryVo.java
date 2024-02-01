package com.kh.app.gallery.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GalleryVo {
	private String no;
	private String title;
	private String fullPath;
	private String writerNo;
	private String writerNick;
	private String hit;
	private String enrollDate;
	private String modifyDate;
	private String status;
}
