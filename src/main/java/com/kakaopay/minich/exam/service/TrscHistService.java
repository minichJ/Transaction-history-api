package com.kakaopay.minich.exam.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kakaopay.minich.exam.mapper.TrscHistMapper;
import com.kakaopay.minich.exam.vo.TrscHistVO;

@Service
@Transactional
public class TrscHistService {
	
	@Autowired
	TrscHistMapper trscMapper;
	
	// 거래내역 연도 목록
	public List<Integer> getYearList() throws Exception {
		return trscMapper.selectTrscHistYearList();
	}
	
	// 관리점 목록
	public List<HashMap<String, Object>> selectBrList() throws Exception {
		return trscMapper.selectBrList();
	}

	/**
	 * 거래내역 연도 목록
	 * @return
	 * @throws Exception
	 */
	public List<Integer> selectTrscHistYearList() throws Exception {
		return trscMapper.selectTrscHistYearList();
	}
	
	/**
	 * 연도별 합계 금액 가장 많은 고객을 출력
	 * @return
	 * @throws Exception
	 */
	public List<TrscHistVO> getYearSumPriceCstmr()  throws Exception {
		return trscMapper.selectYearSumPriceCstmr();
	}
	
	/**
	 * 연간 거래가 없는 고객을 출력
	 * @return
	 * @throws Exception
	 */
	public ArrayList<HashMap<String, Object>> selectYearNoTrscCstmr() throws Exception {
		List<Integer> yearList = getYearList();	// 거래내역 연도 목록
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		
		if (yearList != null) {
			for(int i = 0 ; i < yearList.size() ; i++ ) {
				result.addAll(trscMapper.selectYearNoTrscCstmr(yearList.get(i)));
			}
		}
		
		return result;
	}
	
	/**
	 * 연도별 관리점별 거래금액 합계 목록
	 * @return
	 * @throws Exception
	 */
	public ArrayList<HashMap<String, Object>> selectYearSumPriceBr() throws Exception {
		List<Integer> yearList = getYearList();	// 거래내역 연도 목록
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = null;
		
		if (yearList != null) {
			for(int i = 0 ; i < yearList.size() ; i++ ) {
				map = new HashMap<String, Object>();
				int year = yearList.get(i);
				
				map.put("year", year);
				map.put("dataList", trscMapper.selectYearSumPriceBr(year));
				
				result.add(map);
			}
		}
		
		return result;
	}
	
	/**
	 * 관리점별 거래금액 합계 목록
	 * @return
	 * @throws Exception
	 */
	public HashMap<String, Object> selectSumPriceBr(String paramBrName) throws Exception {
		HashMap<String, Object> brMap = null;
		HashMap<String, Object> tempMap = new HashMap<String, Object>();
		
		try {
			List<HashMap<String, Object>> brList = selectBrList();
			
			String brNm = "";
			String brCd = "";
			ArrayList<String> brCdList = new ArrayList<String>();
	
			if (brList != null) {
				for (int i = 0 ; i < brList.size() ; i++) {
					brMap = brList.get(i);
	
					if(paramBrName.equals(brMap.get("BR_NAME"))) {
						brNm = (String) brMap.get("BR_NAME");
						brCd = (String) brMap.get("BR_CODE");
						brCdList.add(brCd);
						
						// 분당점과 판교점 통폐합으로 인하여 판교점(A) 조회시 분당점(B) 데이터까지 함께 조회
						if ("A".equals(brCd)) {
							brCdList.add("B");
						}
						
						tempMap.put("brName", brNm);
						tempMap.put("brCode", brCd);
						tempMap.put("brCdList", brCdList);
						break;
					}
				}
			}
			
		} catch (Exception e) {
			
		}
		
		if(tempMap.size() == 0) {
			tempMap.put("message", "invaild value");
			
			return tempMap;
		} else {
			return trscMapper.selectSumPriceBr(tempMap);
		}
	}
}
