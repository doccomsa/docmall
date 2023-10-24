package com.docmall.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class MemberVO {

	//멤버필드
	private String	mbsp_id;
	private String	mbsp_name;
	private String	mbsp_email;
	private String	mbsp_password;
	private String	mbsp_zipcode;
	private String	mbsp_addr;
	private String	mbsp_deaddr;
	private String	mbsp_phone;
	private int		mbsp_point;
	private Date	mbsp_lastlogin;
	private Date	mbsp_datesub;
	private Date	mbsp_updatedate;
	
}
