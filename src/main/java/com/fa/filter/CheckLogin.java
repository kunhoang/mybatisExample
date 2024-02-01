package com.fa.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class CheckLogin implements WebMvcConfigurer {

	@Autowired
	LoginFilter loginFilter;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginFilter).addPathPatterns("/*").excludePathPatterns("/login");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
