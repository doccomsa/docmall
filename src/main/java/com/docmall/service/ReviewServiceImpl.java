package com.docmall.service;

import org.springframework.stereotype.Service;

import com.docmall.domain.ReviewVO;
import com.docmall.mapper.ReviewMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

	private final ReviewMapper reviewMapper;

	@Override
	public void review_insert(ReviewVO vo) {
		// TODO Auto-generated method stub
		reviewMapper.review_insert(vo);
	}
}
