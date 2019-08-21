package com.ruoyi.framework.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LdhWebCountAspect {

	
	@Pointcut("@annotation(com.ruoyi.common.annotation.LdhWebCount)")
    public void pointCut() {
    }
	
	@Before("pointCut()")
    public void begin() {
        System.out.println("==@Before== lingyejun blog logger : begin");
    }
	
	
	@After("pointCut()")
	public void after(){
		System.out.println("==@after== 111");
	}
	
	@AfterReturning(pointcut = "pointCut()")
    public void doBefore(JoinPoint joinPoint) {
		handle(joinPoint, null);
    }
	
	@AfterThrowing(value = "pointCut()", throwing = "e")
    public void doAfter(JoinPoint joinPoint, Exception e) {
        handle(joinPoint, e);
    }
	
	
	protected void handle(final JoinPoint joinPoint, final Exception e) {
		try {
			
			String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            
            System.out.println(className + "+++++++++++++" + methodName);
		} catch (Exception e1) {
			
		}
	}
}
