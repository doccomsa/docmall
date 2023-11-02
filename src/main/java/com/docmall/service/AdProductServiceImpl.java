package com.docmall.service;

import org.springframework.stereotype.Service;

import com.docmall.domain.ProductVO;
import com.docmall.mapper.AdProductMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdProductServiceImpl implements AdProductService {

	private final AdProductMapper adProductMapper;

	@Override
	public void pro_insert(ProductVO vo) {
		// TODO Auto-generated method stub
		adProductMapper.pro_insert(vo);
	}
}
