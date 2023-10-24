package com.docmall.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.docmall.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequiredArgsConstructor
@Log4j
@RequestMapping("/member/*")
@Controller
public class MemberController {

	// https://dev-coco.tistory.com/70
	
	private final MemberService memberService;
	
	@GetMapping("/join")
	public void join() {
		
		log.info("called... join");
	}
	
	//비동기방식. ajax문법으로 호출
	
	@GetMapping("/idCheck")
	public ResponseEntity<String> idCheck(String mbsp_id) {
		
		log.info("아이디: " + mbsp_id);
		
		ResponseEntity<String> entity = null;
		
		//서비스 메서드 호출구문작업.
		
		return entity;
	}
	
}
