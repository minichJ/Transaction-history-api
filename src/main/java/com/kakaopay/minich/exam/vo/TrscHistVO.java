package com.kakaopay.minich.exam.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data; 

@Data
@Alias("trscHistVO")
public class TrscHistVO {
	private int year;			// 연도
	private String name;		// 계좌명
	private int acctNo;			// 계좌번호
	private int sumAmt;			// 합계
}
