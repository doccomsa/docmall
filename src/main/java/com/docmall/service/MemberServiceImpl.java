package com.docmall.service;

import org.springframework.stereotype.Service;

import com.docmall.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
	//자동주입
	// @RequiredArgsConstructor : memberMapper필드를 매개변수로 하는 생성자메서드가 생성
	private final MemberMapper memberMapper;
	/*
	private MemberServiceImpl(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	*/

	@Override
	public String idCheck(String mbsp_id) {
		// TODO Auto-generated method stub
		return memberMapper.idCheck(mbsp_id);
	}
}
