package com.docmall.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docmall.domain.MemberVO;
import com.docmall.domain.ReviewVO;
import com.docmall.service.ReviewService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequiredArgsConstructor
@Log4j
@RequestMapping("/user/review/*")
@RestController // jsp파일을 사용 안함.
public class ReviewController {

	private final ReviewService reviewService;
	
	// @RequestBody : JSON 데이타를 ReviewVO객체로 변환해주는 기능.. 참고> 반대의미 어노테이션 @ResponseBody
	@PostMapping(value = "/new", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> review_insert(@RequestBody ReviewVO vo, HttpSession session) throws Exception {
		
		log.info("리뷰: " + vo);
		
		String mbsp_id = ((MemberVO) session.getAttribute("loginStatus")).getMbsp_id();
		vo.setMbsp_id(mbsp_id);
		
		ResponseEntity<String> entity = null;
		
		//db저장
		reviewService.review_insert(vo);
		
		entity = new ResponseEntity<String>("success", HttpStatus.OK);
		
		return entity;
	}
	
	// 전통적인 형태의 주소 list?pro_num=10&page=1   -> Rest API개발형태 주소 list/10/1   
	@GetMapping("/list/{pro_num}/{page}")
	public ResponseEntity<Map<String, Object>> list(@PathVariable("pro_num") Integer pro_num, @PathVariable("page") Integer page) throws Exception {
		ResponseEntity<Map<String, Object>> entity = null;
		
		
		
		return entity;
	}
	
}
