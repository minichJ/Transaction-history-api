package com.kakaopay.minich.exam;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.kakaopay.minich.exam.service.TrscHistService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MinichExamApplicationTests {

	@Autowired
	TrscHistService trscHistService;
	
	@Autowired
	private WebApplicationContext webContext;

	private MockMvc mockMvc;

	@Before
	public void setupMockMvc() {
		this.mockMvc = MockMvcBuilders
				.webAppContextSetup(webContext)
				.build();
	}
    @Before
    public void initialize() {
    	log.info("================== Test Start ==================");
    }
    
    @Test
    public void exam01Expect200ok() throws Exception {
        mockMvc.perform(get("/kakaopay/api/v1"))
        		.andExpect(status().isOk())
        		.andExpect(jsonPath("$[0].acctNo").value("11111114"))
        		.andDo(print());
        log.info("*** exam 01 url and acctNo value test ***");
    }
    
    @Test
    public void exam02Expect200ok() throws Exception {
    	mockMvc.perform(get("/kakaopay/api/v2"))
		    	.andExpect(status().isOk())
		    	.andExpect(jsonPath("$[0].acctNo").value("11111115"))
		    	.andDo(print());
    	log.info("*** exam 02 url and acctNo value test ***");
    }
    
    @Test
    public void exam03Expect200ok() throws Exception {
    	mockMvc.perform(get("/kakaopay/api/v3"))
		    	.andExpect(status().isOk())
		    	.andExpect(jsonPath("$[0].dataList.[0].brCode").value("B"))
		    	.andDo(print());
    	log.info("*** exam 03 url and brCode value test ***");
    }
    
    @Test
    public void exam04Expect200ok() throws Exception {
    	mockMvc.perform(post("/kakaopay/api/v4")
    					.contentType(MediaType.APPLICATION_JSON)
    					.content("{\"brName\": \"판교점\"}"))
		    	.andExpect(status().isOk())
		    	.andExpect(jsonPath("$.brCode").value("A"))
		    	.andDo(print());
    	log.info("*** exam 04 url and brCode value test ***");    	
    }
    
    @After
    public void finalize() {
    	log.info("================== Test End ===================\n\n\n");
    }
    
}
