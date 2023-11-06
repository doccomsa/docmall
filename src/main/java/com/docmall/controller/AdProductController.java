package com.docmall.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.docmall.domain.ProductVO;
import com.docmall.dto.Criteria;
import com.docmall.dto.PageDTO;
import com.docmall.service.AdProductService;
import com.docmall.util.FileUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequiredArgsConstructor
@RequestMapping("/admin/product/*")
@Controller
public class AdProductController {

	private final AdProductService adProductService;
	
	// 메인및썸네일 이미지업로드 폴더경로 주입작업
	@Resource(name = "uploadPath") // servlet-context.xml 의 bean이름 참조를 해야 함.
	private String uploadPath;
	
	// CKEditor에서 사용되는 업로드 폴더경로
	@Resource(name = "uploadCKPath") // servlet-context.xml 의 bean이름 참조를 해야 함.
	private String uploadCKPath;
	
	//상품등록 폼
	@GetMapping("/pro_insert")
	public void pro_insert() {
		
		log.info("상품등록 폼");
	}
	
	// 1차카테고리 데이타를 Model로 작업
	/*
	@GetMapping("이름")
	public void aaa(Model model) {
		
		model.addAttribute("cg_code", "1차카테고리정보");
	}
	*/
	
	//상품정보 저장
	// 파일업로드 기능 : 1)스프링에서 내장된 기본라이브러리. servlet-context.xml 에서 MultipartFile 대한 bean등록작업 
	//              2)외부라이브러리(commons-fileupload)를 이용(pom.xml). servlet-context.xml 에서 MultipartFile 대한 bean등록작업 
	// MultipartFile uploadFile : <input type="file" class="form-control" name="uploadFile" id="uploadFile">
	// MultipartFile uploadFile 필드명과 input태그의 name="uploadFile" 이름이 일치.
	@PostMapping("/pro_insert")
	public String pro_insert(ProductVO vo, MultipartFile uploadFile, RedirectAttributes rttr) {
		
		log.info("상품정보: " + vo);
		
		//1)파일업로드 작업. 미리선수작업 : FileUtils 클래스작업
		String dateFolder = FileUtils.getDateFolder();
		String savedFileName = FileUtils.uploadFile(uploadPath, dateFolder, uploadFile);
		
		vo.setPro_img(savedFileName);
		vo.setPro_up_folder(dateFolder);
		
		log.info("상품정보: " + vo);
		
		//2)상품정보 저장
		adProductService.pro_insert(vo);
		
		
		return "redirect:/admin/product/pro_list"; // 상품리스트 주소이동
	}
	
	//CkEdiotr 업로드 탭에서 파일업로드시 동작하는 매핑주소
	// MultipartFile upload : 업로드된 파일을 참조하는 객체
	// MultipartFile upload 변수와 CKEditor의 <input type="file" name="upload" size="38">
	// HttpServletRequest 클래스 : jsp의request객체 클래스. 클라이언트의 요청을 담고 있는 객체
	// HttpServletResponse 클래스 : jsp의 response객체 클래스. 클라이언트로 보낼 서버측의 응답정보를 가지고 있는 객체.
	@PostMapping("/imageUpload")
	public void imageUpload(HttpServletRequest request, HttpServletResponse response, MultipartFile upload) {
		
		// try 코드 사용전에 선언한 목적
		OutputStream out = null;
		PrintWriter printWriter = null; // 클라이언트에게 서버의 응답정보를 보낼때 사용.
		
		//jsp파일
		/*
		 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
		 */
		
		// 클라이언트에게 보내는 응답설정
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		try {
			
			//1) 파일업로드 작업
			String fileName = upload.getOriginalFilename(); // 클라이언트에서 전송한 파일이름
			byte[] bytes = upload.getBytes(); // 업로드 한 파일을 byte배열로 읽어들임.
			
			String ckUploadPath = uploadCKPath + fileName;
			
			log.info("CKEditor파일경로: " + ckUploadPath);
			
			out = new FileOutputStream(new File(ckUploadPath)); // 0kb 파일생성.
			
			out.write(bytes); // 출력스트림작업
			out.flush();
			
			//2) 파일업로드 작업후 파일정보를 CKEditor로 보내는 작업
			printWriter = response.getWriter();
			
			// 브라우저의 CKEditor에서 사용할 업로드한 파일정보를 참조하는 경로설정. 
			// 1)톰캣 Context Path에서 Add External Web Module 작업을 해야 함.
			// Path : /ckupload, Document Base : C:\\dev\\upload\\ckeditor 설정
			// 2)Tomcat server.xml에서 <Context docBase="업로드경로" path="/매핑주소" reloadable="true"/>
			//  <Context docBase="C:\\dev\\upload\\ckeditor" path="/ckupload" reloadable="true"/>
			
			// CKeditor에서 업로드된 파일경로를 보내준다.(매핑주소와 파일명이 포함)
			String fileUrl = "/ckupload/" + fileName; 
			// {"filename":"abc.gif", "uploaded":1, "url":"/upload/abc.gif"}
			printWriter.println("{\"filename\":\"" +  fileName + "\", \"uploaded\":1,\"url\":\"" + fileUrl + "\"}");
			printWriter.flush();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(out != null) {
				try {
					out.close();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
			if(printWriter != null) printWriter.close();
		}
	}
	
	//상품리스트.  (목록과페이징)
	@GetMapping("/pro_list")
	public void pro_list(Criteria cri, Model model) throws Exception {
		
		// this(1, 10);
		// 10 -> 2
		cri.setAmount(2);
		
		
		List<ProductVO> pro_list = adProductService.pro_list(cri);
		
		// 날짜폴더의 역슬래시를 슬래시로 바꾸는 작업.  이유? 역슬래시로 되어있는 정보가 스프링으로 보내는 요청데이타에 사용되면 에러발생.
		// 스프링에서 처리 안하면, 자바스크립에서 처리 할수도 있다.
		pro_list.forEach(vo -> {
			vo.setPro_up_folder(vo.getPro_up_folder().replace("\\", "/"));
		});
		model.addAttribute("pro_list", pro_list);
		
		int totalCount = adProductService.getTotalCount(cri);
		model.addAttribute("pageMaker", new PageDTO(cri, totalCount));
	}
	
	//상품리스트에서 보여줄 이미지.  <img src="매핑주소">
	@ResponseBody
	@GetMapping("/imageDisplay") // /admin/product/imageDisplay?dateFolderName=값1&fileName=값2
	public ResponseEntity<byte[]> imageDisplay(String dateFolderName, String fileName) throws Exception {
		
		return FileUtils.getFile(uploadPath + dateFolderName, fileName);
	}
	
	
}
