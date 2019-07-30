package com.kakaopay.minich.exam.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.kakaopay.minich.exam.vo.TrscHistVO;

@Mapper
public interface TrscHistMapper {
	
	/**
	 * 거래내역 연도 목록
	 * @return
	 * @throws Exception
	 */
	List<Integer> selectTrscHistYearList() throws Exception;
	
	
	/**
	 * 관리점 목록
	 * @return
	 * @throws Exception
	 */
	List<HashMap<String, Object>> selectBrList() throws Exception;
	
	/**
	 * 연도별 합계 금액 가장 많은 고객을 출력
	 * @return
	 * @throws Exception
	 */
	List<TrscHistVO> selectYearSumPriceCstmr() throws Exception;
	
	/**
	 * 연간 거래가 없는 고객을 출력
	 * @return
	 * @throws Exception
	 */
	List<HashMap<String, Object>> selectYearNoTrscCstmr(int year) throws Exception;
	
	/**
	 * 연도별 관리점별 거래금액 합계 목록
	 * @return
	 * @throws Exception
	 */
	List<HashMap<String, Object>> selectYearSumPriceBr(int year) throws Exception;
	
	/**
	 * 관리점별 거래금액 합계 목록
	 * @return
	 * @throws Exception
	 */
	HashMap<String, Object> selectSumPriceBr(HashMap<String, Object> brMap) throws Exception;
}
