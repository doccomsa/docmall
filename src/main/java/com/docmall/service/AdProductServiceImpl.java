package com.docmall.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.docmall.domain.ProductVO;
import com.docmall.dto.Criteria;
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

	@Override
	public List<ProductVO> pro_list(Criteria cri) {
		// TODO Auto-generated method stub
		return adProductMapper.pro_list(cri);
	}
	
	@Override
	public int getTotalCount(Criteria cri) {
		// TODO Auto-generated method stub
		return adProductMapper.getTotalCount(cri);
	}
}
