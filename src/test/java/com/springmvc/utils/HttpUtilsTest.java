package com.springmvc.utils;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HttpUtilsTest {

	String code, msg, info;

	//执行次序是@BeforeClass -> @Before -> @Test -> @After -> @Before -> @Test -> @After -> @AfterClass。@Ignore会被忽略
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	//在每个test运行之前运行
	@Before
	public void setUp() throws Exception {
		code = "0";
		msg = "success";
		info = "data";
	}

	//在每个test运行之后运行
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGenerateResponse() {
		Map<String, Object> res = HttpUtils.generateResponse(code, msg, info);
		
		
		assertEquals("0", res.get("code"));
//		fail("Not yet implemented");
	}

}
