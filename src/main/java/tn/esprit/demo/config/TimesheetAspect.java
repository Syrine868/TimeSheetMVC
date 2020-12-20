package tn.esprit.demo.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimesheetAspect {

	
	private static final Logger l = LogManager.getLogger(TimesheetAspect.class);

	@Before("execution(* tn.esprit.demo.services.EmployeServiceImpl.*(..))")
	public void logMethodEntry(JoinPoint joinPoint)
	{
		String name = joinPoint.getSignature().getName();
		l.info("In Method "+name+" : ");
		
	}
	@After("execution(* tn.esprit.demo.services.EmployeServiceImpl.*(..))")
	public void logMethodExit(JoinPoint joinPoint){
		String name = joinPoint.getSignature().getName();
		l.info("Out of Method "+name+" : ");
		
	}
	
	@Around("execution(* tn.esprit.demo.services.*.*(..))")
	public Object profile(ProceedingJoinPoint pjp )throws Throwable{
		long start =System.currentTimeMillis();
		Object obj =pjp.proceed();
		long elapsedTime =System.currentTimeMillis()-start;
		l.info("Method execution time : "+elapsedTime+"milliseconds .");
		return obj;
	}
	
}
