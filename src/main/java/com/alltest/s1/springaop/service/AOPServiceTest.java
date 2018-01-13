/**
 * 
 */
package com.alltest.s1.springaop.service;

import org.junit.Test;
import org.junit.runner.RunWith;
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
	@Autowired
	private AOPService aopService;
	
	@Test
	public void test() {
		System.out.println(aopService.aopTest());
		System.out.println(System.getProperty("machine"));
	}

}
