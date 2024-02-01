package com.kh.app.gallery.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.kh.app.gallery.repository.GalleryRepository;
import com.kh.app.gallery.vo.GalleryVo;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class GallerySerevice {
	
	private final GalleryRepository repository;
	private final SqlSessionTemplate template;

	public int insertGallery(GalleryVo gallery, MultipartFile file) {
		
		if(gallery.getTitle().length() < 1) {
			throw new IllegalStateException("제목을 입력해주세요");
		}
		
		return repository.insertGallery(gallery, template);
	}
	
	public List<GalleryVo> getList() {
		return repository.getList(template);
	}
	
	public GalleryVo getOne(String no) throws IllegalStateException {
		int result = repository.increaseHit(no, template);
		if(result != 1) {
			throw new IllegalStateException("게시글 조회 실패");
		}
		return repository.getOne(no, template);
	}
	
	public int updateGallery(GalleryVo gallery) {
		//다중 조건 검증은 &&이 연산이 빠름.
		if(!(gallery != null && gallery.getTitle() != null && gallery.getTitle().length() < 1)) {
			throw new IllegalStateException("제목을 입력해주세요");
		}
		
		return repository.updateGallery(gallery, template);
	}
	
	public int deleteGallerey(String no) {
		return repository.deleteGallery(no, template);
	}
}
