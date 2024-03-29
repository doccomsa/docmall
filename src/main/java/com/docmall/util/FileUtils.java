package com.docmall.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnailator;

// 파일업로드 관련 필요한 메서드를 구성.
public class FileUtils {

	// 날짜폴더 생성을위한 날짜정보
	public static String getDateFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		
		String str = sdf.format(date);  // 예>"2023-11-02"
		
		// File.separator : 각 OS별로 경로구분자를 반환
		// 유닉스, 맥, 리눅스 구분자 /  예>"2023-11-02" -> "2023/11/02"
		// 윈도우즈  구분자 \  예>"2023-11-02"  ->  예>"2023\11\02"
		return str.replace("-", File.separator);
	}
	
	// 서버에 파일업로드 기능및 실제업로드 한 파일명 반환
	/*
	  String uploadFolder : 서버측의 업로드 될 폴더 C:\\dev\\upload\\product\\
	  String dateFolder : 이미지파일을 저장할 날짜 폴더명   2023\11\03
	  MultipartFile uploadFile : 업로드된 파일을 참조하는 객체
	 */
	public static String uploadFile(String uploadFolder, String dateFolder, MultipartFile uploadFile) {
		
		String realUploadFileName = ""; // 실제 업로드한 파일이름(파일이름 중복방지)
		
//		File클래스 : 파일과 폴더관련작업하는 기능
		File file = new File(uploadFolder, dateFolder); // 예> "C:/dev/upload"   "2023/11/02" 
		
		//  예> "C:/dev/upload"   "2023/11/02"  폴더경로가 없으면, 폴더명을 생성하라.
		if(file.exists() == false) {
			file.mkdirs();
		}
		
		String clientFileName = uploadFile.getOriginalFilename();
		
		//파일명 중복방지를 위하여 고유한 문자열을 만들어주는 UUID 클래스
		UUID uuid = UUID.randomUUID();
		
		// d0c64143-121f-406f-8e9e-b055fa5eed5f_abc.PNG
		realUploadFileName = uuid.toString() + "_" + clientFileName;
		
		try {
			// file : "C:/dev/upload/2023/11/02" + realUploadFileName : 업로드할 파일명
			File saveFile = new File(file, realUploadFileName);
			// 파일업로드(파일복사)
			uploadFile.transferTo(saveFile); // 파일업로드의 핵심메서드
			
			// Thumbnail 작업
			// 원본이미지가 파일크기가 커서, 브라우저에 리스트로 사용시 로딩되는 시간이 길어진다
			// 원본이미지를 파일크기와 해상도를 낮추어 작은형태의 이미지로 만드는 것.
			if(checkImageType(saveFile)) { // 첨부된 파일이 이미지 일 경우라면
				
				// 파일출력스트림 클래스
				// 밑에줄만 실행이 되면, 파일이 생성. 0KB.  
				FileOutputStream thumbnail = new FileOutputStream(new File(file, "s_" + realUploadFileName));
				
				// 썸네일 작업기능 라이브러리에서 제공하는 클래스. pom.xml참고.
				// 원본이미지파일의 내용을 스트림방식으로 읽어서, 썸네일이미지파일에 쓰는 작업
				// Thumbnailator.createThumbnail(원본이미지파일의 입력스트림, 썸네일파일객체, 100, 100);
				Thumbnailator.createThumbnail(uploadFile.getInputStream(), thumbnail, 100, 100);
				
				thumbnail.close();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace(); // 파일 업로드시 예외가 발생되면, 예외정보를 출력
		}
		
		
		
		return realUploadFileName; // 상품테이블에 상품이미지명으로 저장.
	}
	
	
	// 자바스크립트로 업로드되는 파일의 확장자를 이용하여, 이미지파일만 파일첨부가능하도록 작업을 할수가 있다.
	// 업로드되는 파일구분(이미지파일 또는 일반파일 구분)
	private static boolean checkImageType(File saveFile) {
		
		boolean isImageType = false; // 변수의 값이 true면 이미지파일, false면 일반파일 구분작업
		
		try {
			// MIME : text/html, text/plain, image/jpeg, ......
			String contentType = Files.probeContentType(saveFile.toPath());
			
			// contentType 변수의 값이 image 문자열로 시작되는지 여부를 true or false 값으로 리턴
			isImageType = contentType.startsWith("image");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		return isImageType;
	}
}
