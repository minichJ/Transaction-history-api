# KAKAOPAY 관계사 사전과제
<hr/>

> 특정 고객 거래내역 조회 서비스 개발. 고객을 타겟팅하기 위한 지점 마케팅 API를 개발한다.

### 데이터
<hr/>
* 고객 거래내역 데이터
* 고객 데이터
* 지점 데이터
* 데이터는 CSV 파일로 저장되어 있음
* 위 각 데이터는 테이블에 insert 되어 있다고 가정한다.

### API 기능 명세
<hr/>
1.2018년, 2019년 각 연도별 합계 금액이 가장 많은 고객을 추출하는 API 개발.(단, 취소여부가 ‘Y’ 거래는 취소된 거래임, 합계 금액은 거래금액에서 수수료를 차감한 금액임)
1.8년 또는 2019년에 거래가 없는 고객을 추출하는 API 개발.(취소여부가 ‘Y’ 거래는 취소된 거래임)
1.연도별 관리점별 거래금액 합계를 구하고 합계금액이 큰 순서로 출력하는 API 개발.( 취소여부가 ‘Y’ 거래는 취소된 거래임)
1.분당점과 판교점을 통폐합하여 판교점으로 관리점 이관을 하였습니다. 지점명을 입력하면 해당지점의 거래금액 합계를 출력하는 API 개발( 취소여부가 ‘Y’ 거래는 취소된 거래임,)

### 기본 제약사항(필수)
* API 기능명세에서 기술된 API를 모두 개발하세요.
* Spring boot 기반의 프레임웍을 사용하세요.
* 단위 테스트(Unit Test) 코드를 개발하여 각 기능을 검증하세요.
* 모든 입/출력은 JSON 형태로 주고 받습니다.
* 단, 각 API에 HTTP Method들(GET|POST|PUT|DEL)은 자유롭게 선택하세요.

### 개발 환경
* Backend
  * Java 8
  * STS 4.2.0
  * Spring Boot 2.1.4
    * spring-boot-starter-web
    * spring-boot-starter-test
    * spring-boot-devtools
  * Lombok 1.18.6
  * H2 1.4.199
  * Mybatis
    * mybatis-spring-boot-starter 2.1.0
  * Swagger
    * springfox-swagger2 2.9.2
    * springfox-swagger-ui 2.9.2
    
### 실행방법
`입력테스트`
```으으으으```
  
  
