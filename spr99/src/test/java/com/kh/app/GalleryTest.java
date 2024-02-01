package com.kh.app;

import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;

import com.kh.app.gallery.service.GallerySerevice;
import com.kh.app.gallery.vo.GalleryVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class GalleryTest {

	private final GallerySerevice service;
	private final SqlSessionTemplate template;
	
	
	@Test
	void insert() {
		GalleryVo galleryVo = new GalleryVo();
		galleryVo.setTitle("제목1");
		galleryVo.setFullPath("이미지 경로로");
		galleryVo.setWriterNo("1");
		

	}
}
