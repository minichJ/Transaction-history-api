package com.kakaopay.minich.exam.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kakaopay.minich.exam.exception.ApiCustomExceptionHandler;
import com.kakaopay.minich.exam.exception.ErrorVO;
import com.kakaopay.minich.exam.service.TrscHistService;
import com.kakaopay.minich.exam.vo.TrscHistVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "지점 마케팅 API")
@RestController	
@RequestMapping(value="/kakaopay/api")
public class TrscHistController {
	
	@Autowired
	private TrscHistService trscHistService;
	
	@ApiOperation(value="연도별 합계 금액 가장 많은 고객 조회", notes="연도별 합계 금액 가장 많은 고객을 조회한다.")
	@GetMapping("/v1")
	public List<TrscHistVO> ExamResponseV1() throws Exception {
		return trscHistService.getYearSumPriceCstmr(); 
	}

	@ApiOperation(value="연간 거래가 없는 고객 조회", notes="연간 거래가 없는 고객을 조회한다.")
	@GetMapping("/v2")
	public ArrayList<HashMap<String, Object>> ExamResponseV2() throws Exception {
		return trscHistService.selectYearNoTrscCstmr(); 
	}

	@ApiOperation(value="연도별 관리점별 거래금액 합계 목록 조회", notes="연도별 관리점별 거래금액 합계 목록을 조회한다.")
	@GetMapping("/v3")
	public ArrayList<HashMap<String, Object>> ExamResponseV3() throws Exception {
		return trscHistService.selectYearSumPriceBr(); 
	}
	
	@ApiOperation(value="관리점별 거래금액 합계 목록 조회", notes="관리점별 거래금액 합계 목록을 조회한다.")
	@ApiImplicitParams({
        @ApiImplicitParam(
            name = "inputMap",
            value = "{\"brName\" : \"판교점\"}",
            dataType = "object"
    )})	
	@PostMapping("/v4")
	public HashMap<String, Object> ExamResponseV4(@RequestBody HashMap<String, String> inputMap) throws Exception {
		
		// 분당점의 경우 판교점과 통폐합하여 거래가 존재하지 않는다.
		if("분당점".equals(inputMap.get("brName"))) {
			throw new ApiCustomExceptionHandler();
		}
		
		return trscHistService.selectSumPriceBr(inputMap.get("brName")); 
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ApiCustomExceptionHandler.class)
	public @ResponseBody ErrorVO apiCustomExceptionHandler(ApiCustomExceptionHandler e) {
		String errMsg = "br code not found error";
		ErrorVO errorVO = new ErrorVO();
		
		errorVO.setCode(HttpStatus.NOT_FOUND.value());
		errorVO.setMessage(errMsg);
		
		return errorVO;
	}
	
}
