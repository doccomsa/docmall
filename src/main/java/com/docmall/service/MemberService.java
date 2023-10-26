package com.docmall.service;

import com.docmall.domain.MemberVO;

public interface MemberService {
	
	String idCheck(String mbsp_id);
	
	void join(MemberVO vo);
	
	MemberVO login(String mbsp_id);
}
