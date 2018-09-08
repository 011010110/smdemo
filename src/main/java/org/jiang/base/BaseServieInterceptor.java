package org.jiang.base;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Aspect
@Component
public class BaseServieInterceptor {

//	@Before("execution(public * *(String))")
	public void methodCallLog() {
		System.out.println("UserService method is called!");
	}
}
