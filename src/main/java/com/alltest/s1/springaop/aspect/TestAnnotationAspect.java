/**
 * 
 */
package com.alltest.s1.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 
 * @author Evan
 * @date 2018年1月11日 下午3:17:48
 */
@Aspect
public class TestAnnotationAspect {
	
	@Pointcut("execution(* com.alltest.s1.springaop.service.*.*(..))")
	private void pointCutMethod() {
		
	}

	@Before("pointCutMethod()")
	public void doBefore() {
		System.out.println("前置通知");
	}
	
	@After("pointCutMethod()")
	public void doAfter() {
		System.out.println("最终通知");
	}
	
	@AfterReturning(pointcut = "pointCutMethod()", returning = "result")
	public void doAfterReturning(String result) {
		System.out.println("后置通知");
		System.out.println("---" + result + "---");
	}
	
	@AfterThrowing(pointcut = "pointCutMethod()", throwing = "e")
	public void doThrowing(Exception e) {
		System.out.println("例外通知");
		System.out.println(e.getMessage());
	}
	
	@Around("pointCutMethod()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("进入方法---环绕通知");
		Object o = pjp.proceed();
		System.out.println("退出方法---环绕通知");
		return o;
	}
	
	
}
