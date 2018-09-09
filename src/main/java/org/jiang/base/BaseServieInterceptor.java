package org.jiang.base;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BaseServieInterceptor {

	@Before("execution(public String org.jiang.base.BaseService.getUserNameById(String))")
	public void methodCallLog() {
		System.out.println("===========================================UserService method is called!");
	}
}
