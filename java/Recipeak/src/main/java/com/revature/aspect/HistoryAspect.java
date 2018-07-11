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

import com.revature.beans.History;
import com.revature.beans.Recipe;
import com.revature.beans.User;
import com.revature.services.HistoryService;
import com.revature.services.RecipeService;
import com.revature.services.UserService;

@Component
@Aspect
public class HistoryAspect {
	Logger log= Logger.getLogger(UserVerificationAspect.class);
	
	@Autowired
	HistoryService hs;
	@Autowired
	RecipeService rs;
	@Autowired
	UserService us;
	
	
	//TODO: Test this
	@Around("addHistory()")
	public Object addToHistory(ProceedingJoinPoint pjp) throws Throwable {
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
				if(args[1] instanceof Integer) {
					int id = (int) args[1];
					Recipe recipe = rs.getRecipeById(id);
					User user = (User) session.getAttribute("user");
					if (user != null && recipe != null) {
						hs.addHistory(user,recipe);
					}
				}
			}
		}

		return obj;
	}

	
	@Pointcut("execution(* com.revature.controllers.RecipeController.getRecipe(..))")
	public void addHistory() {}
}

