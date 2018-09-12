package org.dousnl.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

	public enum Level{
		INFO,DEBUG,WARN,ERROR,FATAL
	};
	/**
	 * 方法名
	 */
	public String name() default "";
	/**
	 * 方法描述
	 */
	public String value() default "";
	/**
	 * 操作等级
	 */
	public Level level() default Level.INFO;
	
}
