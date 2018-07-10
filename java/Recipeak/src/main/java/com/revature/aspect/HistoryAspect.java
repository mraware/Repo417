package com.revature.aspect;

import java.util.Arrays;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.User;
import com.revature.services.HistoryService;
import com.revature.services.RecipeService;

@Component
@Aspect
public class HistoryAspect {
	Logger log= Logger.getLogger(UserVerificationAspect.class);
	
	@Autowired
	HistoryService hs;
	@Autowired
	RecipeService rs;
	
	
	//TODO: Test this
	@Around("allVerifiedUser()")
	public Object verifyUser(ProceedingJoinPoint pjp) throws Throwable {
		Object obj = null;
		try {
			obj = pjp.proceed();
		} catch (Throwable e) {
			throw e;
		}
		if (obj != null) {
			Object[] args = pjp.getArgs();
			log.trace(Arrays.toString(args));
			if (args[0] instanceof HttpSession) {
				HttpSession session = (HttpSession) args[0];
			}
		}

		return obj;
	}

	
	@Pointcut("execution(* com.revature.controller.RecipeController.getRecipe(..)")
	public void addHistory() {}
}

