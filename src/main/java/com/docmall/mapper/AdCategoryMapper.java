package com.docmall.mapper;

import java.util.List;

import com.docmall.domain.CategoryVO;

public interface AdCategoryMapper {

	List<CategoryVO> getFirstCategoryList();
	
	List<CategoryVO> getSecondCategoryList(Integer cg_parent_code);
	
	CategoryVO get(Integer cg_code);
}
