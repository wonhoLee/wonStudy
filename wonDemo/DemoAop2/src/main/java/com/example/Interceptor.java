package com.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@Aspect
@ConfigurationProperties("interceptor")
public class Interceptor {

	private static final Logger logger = LoggerFactory.getLogger(Interceptor.class);

	/**
	 * Message to print on startup
	 */
	private String message = "Startup";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

//	@Around("execution(* *(..)) && !within(com.example.Interceptor)"
//			+ " && (within(org.springframework.context.annotation.Condition+) || within(com.example..*))")
//	public Object intercept(ProceedingJoinPoint joinPoint) throws Throwable {
//		Object result = joinPoint.proceed();
//		logger.debug("AspectJ intercept: " + joinPoint.toShortString() + ": " + result);
//		return result;
//	}

	@Around("execution(* *(..)) && within(com.example..*) && !within(com.example.Interceptor+)")
	public Object stack(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.debug("AspectJ stack: " + joinPoint.toShortString());
		return joinPoint.proceed();
	}
	
	@Pointcut("@annotation(MaskingAnno)")
    public void callAt(MaskingAnno secured) {
    }
 
    @Around("callAt(MaskingAnno)")
    public Object around(ProceedingJoinPoint pjp, 
    		MaskingAnno secured) throws Throwable {
    	logger.info("WON!!!!!!!!!!!!!");
        return pjp.proceed();
    }
    
    @Pointcut("@annotation(MaskingFieldAnno)")
    public void callAt2(MaskingFieldAnno secured) {
    }
 
    @Around("callAt2(MaskingFieldAnno)")
    public Object around2(ProceedingJoinPoint pjp, 
    		MaskingFieldAnno secured) throws Throwable {
    	logger.info(pjp.toShortString());
    	
    	logger.info("WON2222222222");
        return pjp.proceed();
    }

	@EventListener
	public void started(ContextRefreshedEvent event) {
		logger.debug("AspectJ started: " + message + ": " + event);
	}

}
