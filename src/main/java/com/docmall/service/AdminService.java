package com.docmall.service;

import com.docmall.domain.AdminVO;

public interface AdminService {

	AdminVO admin_ok(String admin_id);
	
	void login_date(String admin_id);
}
