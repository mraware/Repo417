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
import com.revature.services.UserService;

@Component
@Aspect
public class UserVerificationAspect {
	Logger log= Logger.getLogger(UserVerificationAspect.class);
	
	@Autowired
	UserService us;
	
	
	//TODO: Test this
	@Around("allVerifiedUser()")
	public Object verifyUser(ProceedingJoinPoint pjp) throws Throwable {
		Object obj = null;
		Object[] args = pjp.getArgs();
		log.trace(Arrays.toString(args));
		if (args[0] instanceof HttpSession) {
			int id;
			if (args[1] instanceof Integer) {
				id = (int) args[1];
			} else if (args[1] instanceof User) {
				id = ((User)args[1]).getUserId();
			} else {
				return null;
			}
			HttpSession session = (HttpSession) args[0];
			User user = (User) session.getAttribute("user");
			if (user != null) {
				if(user.getUserId() == id || "admin".equals(user.getType())) {
					try {
						obj = pjp.proceed();
					} catch (Throwable e) {
						throw e;
					}
					return obj;
				}
			}
			
		}
		return null;
	}
	
	@Around("allVerifiedAdmin()")
	public Object verifyAdmin(ProceedingJoinPoint pjp) throws Throwable {
		Object obj = null;
		Object[] args = pjp.getArgs();
		log.trace(Arrays.toString(args));
		if (args[0] instanceof HttpSession) {
			HttpSession session = (HttpSession) args[0];
			User user = (User) session.getAttribute("user");
			if (user != null) {
				if("admin".equals(user.getType())) {
					try {
						obj = pjp.proceed();
					} catch (Throwable e) {
						throw e;
					}
					return obj;
				}
			}
			
		}
		return null;
	}
	
	@Pointcut("execution(* com.revature.controllers..verifiedUser*(..))")
	public void allVerifiedUser() {}
	
	@Pointcut("execution(* com.revature.controllers..verifiedAdmin*(..))")
	public void allVerifiedAdmin() {}
}
