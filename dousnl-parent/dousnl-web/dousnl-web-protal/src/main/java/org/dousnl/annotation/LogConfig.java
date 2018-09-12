package org.dousnl.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogConfig {

	/**
	 * 系统类型
	 */
	public String systemType() default "";
	/**
	 * 所属模块
	 */
	public String moudle() default "";
	/**
	 * 控制器名称
	 */
	public String moudleName() default "";
}
