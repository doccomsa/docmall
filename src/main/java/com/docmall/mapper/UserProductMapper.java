package com.docmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.docmall.domain.ProductVO;
import com.docmall.dto.Criteria;

public interface UserProductMapper {

	// 2차카테고리별 상품리스트(페이징정보사용, 검색제외)
	List<ProductVO> pro_list(@Param("cg_code") Integer cg_code, @Param("cri") Criteria cri);
	
	int getTotalCount(Integer cg_code);
}
