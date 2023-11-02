package com.docmall.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.docmall.domain.CategoryVO;
import com.docmall.mapper.AdCategoryMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequiredArgsConstructor
@Log4j
@Service
public class AdCategoryServiceImpl implements AdCategoryService {

	private final AdCategoryMapper adCategoryMapper;

	@Override
	public List<CategoryVO> getFirstCategoryList() {
		// TODO Auto-generated method stub
		return adCategoryMapper.getFirstCategoryList();
	}

	@Override
	public List<CategoryVO> getSecondCategoryList(Integer cg_parent_code) {
		// TODO Auto-generated method stub
		return adCategoryMapper.getSecondCategoryList(cg_parent_code);
	}
}
