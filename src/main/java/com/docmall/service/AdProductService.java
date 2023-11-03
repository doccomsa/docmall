package com.docmall.service;

import java.util.List;

import com.docmall.domain.ProductVO;
import com.docmall.dto.Criteria;

public interface AdProductService {
	void pro_insert(ProductVO vo);
	
	List<ProductVO> pro_list(Criteria cri);
	
	int getTotalCount(Criteria cri);
}
