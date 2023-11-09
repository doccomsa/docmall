package com.docmall.service;

import java.util.List;

import com.docmall.domain.CategoryVO;

public interface UserCategoryService {

	List<CategoryVO> getSecondCategoryList(Integer cg_parent_code);
}
