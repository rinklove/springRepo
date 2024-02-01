package com.kh.app.gallery.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kh.app.gallery.service.GallerySerevice;
import com.kh.app.gallery.vo.GalleryVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/gallery")
@RequiredArgsConstructor
public class GalleryApiController {
	
	private final GallerySerevice service;

	@PostMapping
	public ResponseEntity<String> insertGallery(GalleryVo gallery, MultipartFile file) throws IOException {
		log.info("gallery = {}", gallery);
		log.info("file = {}", file.getOriginalFilename());
		
		String fullPath = saveFile(file);
		gallery.setFullPath(fullPath);
		
		int result = service.insertGallery(gallery,file);
		if(result != 1) {
			throw new IllegalStateException("게시글 작성 실패");
		}
		
		HttpHeaders headers = createHeaders();
		return new ResponseEntity<String>("작성 완료", headers, HttpStatus.OK);
	}
	
	
	private String saveFile(MultipartFile file) throws IOException {
		String path = "D:\\java\\dev\\springRepo\\spr99\\src\\main\\webapp\\resources\\upload\\gallery\\img\\";
		String origin= path + file.getOriginalFilename();
		File target = new File(origin);
		file.transferTo(target);
		return origin;
	}

	@GetMapping("/list")
	public ResponseEntity<List<GalleryVo>> getList() {
		HttpHeaders headers = createHeaders();
		return new ResponseEntity<List<GalleryVo>>(service.getList(), headers, HttpStatus.OK);
	}
	
	@GetMapping("/detail/{no}")
	public ResponseEntity<GalleryVo> getOne(@PathVariable String no) throws IllegalStateException {
		return new ResponseEntity<GalleryVo>(service.getOne(no), createHeaders(), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<String> updateGallery(@RequestBody GalleryVo gallery) {
		int result = service.updateGallery(gallery);
		if(result != 1) {
			throw new IllegalStateException("게시글 수정 실패");
		}
		return new ResponseEntity<String >("수정 완료", createHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteGallery(String no) {
		int result = service.deleteGallerey(no);
		if(result != 1) {
			throw new IllegalStateException("삭제 실패");
		}
		return new ResponseEntity<String>("삭제 완료", createHeaders(), HttpStatus.OK);
	}
	
	private HttpHeaders createHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		return headers;
	}
	
	
	@ExceptionHandler(value = IllegalStateException.class)
	public ResponseEntity<Map<String, String>> handleIllegalState (IllegalStateException e) {
		Map<String, String> errorMap = new HashMap<String, String>();
		errorMap.put("code", HttpStatus.BAD_REQUEST.toString());
		errorMap.put("message", e.getMessage());
		return new ResponseEntity<Map<String,String>>(errorMap, HttpStatus.BAD_REQUEST);
	}
}
