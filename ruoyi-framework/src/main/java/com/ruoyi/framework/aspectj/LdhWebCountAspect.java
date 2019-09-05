package com.ruoyi.framework.aspectj;

import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.ruoyi.common.annotation.LdhWebCount;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysWebCount;
import com.ruoyi.system.mapper.SysWebCountMapper;

@Aspect
@Component
public class LdhWebCountAspect {

	@Resource
	SysWebCountMapper sysWebCountMapper;
	
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
            
            LdhWebCount zj = getAnnotationLdhWebCount(joinPoint);
            
            String apiCode = StringUtils.isEmpty(zj.apiCode()) ? className + "." + methodName : zj.apiCode();
            String apiName = zj.apiName();
            
            SysWebCount swc = sysWebCountMapper.selectSysWebCountById(apiCode);
            
            if(swc == null){
            	
            	swc = new SysWebCount();
            	swc.setCount(1L);
            	swc.setApiName(apiName);
				swc.setApiCode(apiCode);
				
            	if(e != null){
            		swc.setErrorCount(1L);
            	}else {
            		swc.setErrorCount(0L);
            	}
            	
            	sysWebCountMapper.insertSysWebCount(swc);
            }else {
				
            	swc.setCount(swc.getCount() + 1);
            	if(e != null){
            		swc.setErrorCount(swc.getErrorCount() + 1);
            	}
            	sysWebCountMapper.updateSysWebCount(swc);
			}
            
            System.out.println(className + "+++++++++++++" + methodName);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	
	private LdhWebCount getAnnotationLdhWebCount(JoinPoint joinPoint) throws Exception {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method != null)
        {
            return method.getAnnotation(LdhWebCount.class);
        }
        return null;
    }
}
