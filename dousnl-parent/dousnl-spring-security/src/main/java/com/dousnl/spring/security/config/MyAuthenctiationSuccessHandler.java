package com.dousnl.spring.security.config;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import com.dousnl.spring.security.common.slfj;

@Component
@slfj
public class MyAuthenctiationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{

	
	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		super.handle(request, response, authentication);
	}
	
	public void check(){
		
	}
}
