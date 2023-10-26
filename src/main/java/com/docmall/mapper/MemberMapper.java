package com.docmall.mapper;

import com.docmall.domain.MemberVO;

public interface MemberMapper {
	
	String idCheck(String mbsp_id);
	
	void join(MemberVO vo);
	
	MemberVO login(String mbsp_id);
}
