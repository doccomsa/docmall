package com.docmall.mapper;

import java.util.List;

import com.docmall.domain.CategoryVO;

public interface UserCategoryMapper {

	List<CategoryVO> getSecondCategoryList(Integer cg_parent_code);
}
