/**
 * 
 */
package com.alltest.s1.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Author:Evan
 * Mail:Evan@gmail.com
 * Desc:
 * @author Evan
 * @date 2018年1月11日 下午3:08:11
 */
public class TestAspect {

	public void doBefore(JoinPoint jp) {
		System.out.println("AOP doBefore!");
		System.out.println("method: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());
	}

	public void doAfter(JoinPoint jp) {
		System.out.println("AOP doAfter!");
		System.out.println("method: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());
	}

	public void doThrowing(JoinPoint jp) {
		System.out.println("method: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName() + "Throw Exception!");
		System.out.println("AOP doThrowing!");
	}
	
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		long time = System.currentTimeMillis();
		Object retVal = pjp.proceed();
		time = System.currentTimeMillis() - time;
		System.out.println("Process time: " + time + "ms");
		return retVal;
	}

}
