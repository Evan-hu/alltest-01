/**
 * 
 */
package com.alltest.s1.springaop.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author Evan
 * @date 2018年1月11日 下午3:31:28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/config/applicationContext.xml")
public class AOPServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(AOPServiceTest.class);

	@Autowired
	private AOPService aopService;
	
	@Test
	public void test() {
		logger.info("test");
		System.out.println(aopService.aopTest());
		String [] strs = System.getenv().entrySet().toString().split(",");
		System.out.println("\n");
		System.out.println(System.getProperties().toString());
		System.out.println("\n");
		for (int i=0; i<strs.length; i++) {
			System.out.println(strs[i]);
		}
	}

}
