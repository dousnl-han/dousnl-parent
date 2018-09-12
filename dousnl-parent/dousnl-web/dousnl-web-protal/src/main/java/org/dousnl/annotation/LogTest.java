package org.dousnl.annotation;

@LogConfig(systemType="类日志测试",moudle="LogTest_1")
public class LogTest {

	@Log(value="method-test")
	public void test(){
		
	}
	public static void main(String[] args) {
		LogUtil.log(LogTest.class);
	}
}
