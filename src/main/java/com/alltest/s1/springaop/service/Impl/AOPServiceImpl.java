/**
 * 
 */
package com.alltest.s1.springaop.service.Impl;

import org.springframework.stereotype.Service;

import com.alltest.s1.springaop.service.AOPService;

/**
 * 
 * @author Evan
 * @date 2018年1月11日 下午3:29:45
 */
@Service
public class AOPServiceImpl implements AOPService {

	/* (non-Javadoc)
	 * @see com.alltest.s1.springaop.service.AOPService#aopTest()
	 */
	public String aopTest() {
		return "AOP Test";
	}

}
