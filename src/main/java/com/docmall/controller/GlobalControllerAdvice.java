package com.docmall.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.docmall.domain.CategoryVO;
import com.docmall.service.AdCategoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

/*
  지정한 패키지(com.docmall.controller)에서 반복적으로 사용하는 Model 데이타작업을
  아래 클래스에서 한번만 정의를 해서 사용할 때.
 매번 요청이 발생될 때마다 클래스가 동작된다.(중요)
 */

@RequiredArgsConstructor
@Log4j
@ControllerAdvice(basePackages = {"com.docmall.controller"})
public class GlobalControllerAdvice {
	
	private final AdCategoryService adCategoryService;
	
	@ModelAttribute
	public void getFirstCategoryList(Model model) {
		
		log.info("1차카테고리 리스트");
		
		List<CategoryVO> firstCategoryList = adCategoryService.getFirstCategoryList();
		model.addAttribute("firstCategoryList", firstCategoryList);
	}
}
