package com.ruoyi.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 网站访问计数器
 * @author Li Dehuan
 * @date 2019年8月21日
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LdhWebCount {

	/**
	 * 编号
	 * @return
	 */
	public String apiCode() default "";
	
	/**
	 * 名称
	 * @return
	 */
	public String apiName() default "";
	
}
