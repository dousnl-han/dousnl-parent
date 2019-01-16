/*package com.dousnl.junit;

import javax.servlet.http.HttpServlet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.codingapi.tx.netty.service.NettyService;

@RunWith(SpringRunner.class)
@SpringBootTest
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class SpringBootJunitTest extends HttpServlet{

	@Autowired
	private NettyService tettyService;
	
	@Test
    public void testGetEntFileById(){
		System.err.println("tettyService:"+tettyService);
		//tettyService.start();
		System.err.println("tettyService is start .....");
    }
	
}
*/