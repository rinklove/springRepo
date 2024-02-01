package com.kh.app.gallery.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.gallery.vo.GalleryVo;

@Repository
public class GalleryRepository {

	public List<GalleryVo> getList(SqlSessionTemplate template) {
		return template.selectList("GalleryMapper.getList");
	}
	
	public int insertGallery(GalleryVo gallery, SqlSessionTemplate template) {
		return template.insert("GalleryMapper.insertGallery", gallery);
	}
	
	public int increaseHit(String no, SqlSessionTemplate template) {
		return template.update("GalleryMapper.increaseHit", no);
	}
	
	public GalleryVo getOne(String no, SqlSessionTemplate template) {
		return template.selectOne("GalleryMappe.getOne", no);
	}
	
	public int updateGallery(GalleryVo gallery, SqlSessionTemplate template) {
		return template.update("GalleryMapper.updateGallery", gallery);
	}
	
	public int deleteGallery(String no, SqlSessionTemplate template) {
		return template.delete("GalleryMapper.deleteGallery", no);
	}
	
}
