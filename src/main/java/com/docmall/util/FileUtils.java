package com.docmall.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

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
	public static String uploadFile(String uploadFolder, String dateFolder, MultipartFile uploadFile) {
		
		String realUploadFileName = ""; // 실제 업로드한 파일이름(파일이름 중복방지)
		
//		File클래스 : 파일과 폴더관련작업하는 기능
		File file = new File(uploadFolder, dateFolder); // 예> "C:/dev/upload"   "2023/11/02" 
		
		//  예> "C:/dev/upload"   "2023/11/02"  폴더경로가 없으면, 폴더명을 생성하라.
		if(file.exists() == false) {
			file.mkdirs();
		}
		
		String clientFileName = uploadFile.getOriginalFilename();
		
		//파일명을 중복방지를 위하여 고유한 이름에 사용하는 UUID사용
		UUID uuid = UUID.randomUUID();
		realUploadFileName = uuid.toString() + "_" + clientFileName;
		
		try {
			// file : "C:/dev/upload/2023/11/02" + realUploadFileName : 업로드할 파일명
			File saveFile = new File(file, realUploadFileName);
			// 파일업로드(파일복사)
			uploadFile.transferTo(saveFile); // 파일업로드의 핵심메서드
		} catch (Exception e) {
			e.printStackTrace(); // 파일 업로드시 예외가 발생되면, 예외정보를 출력
		}
		
		
		
		return realUploadFileName; // 상품테이블에 상품이미지명으로 저장.
	}
}
