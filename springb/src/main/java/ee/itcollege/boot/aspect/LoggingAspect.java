package ee.itcollege.boot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

//	@Pointcut("execution(* *..ProductController.list())")
	@Pointcut("execution(* *..*.list())")
	public void list() {}
	
//	@Pointcut("execution(* *..ProductController.list())")
	@Pointcut("execution(public * *..*.*(..))")
	public void pub() {}
	
	@Pointcut("execution(* *..*Repository.*(..))")
	public void repo() {}
	
	@Before("list() && pub()")
	public void tere(JoinPoint jp) {
		// log
		System.out.println("tere " + jp.getTarget().getClass().getName());
	}
	
	@Before("execution(* *..ProductController.*(..))")
	public void log (JoinPoint jp) {
		// log
//		System.out.println("tere " + jp.toLongString());	
		System.out.println("tere " + jp.toShortString());
	
	}
	
	@Around("repo()")
	public Object timer (ProceedingJoinPoint jp) throws Throwable {
		// log
		long t = System.currentTimeMillis();
		
		Object result = jp.proceed();
		
		System.out.format("call to %s took %dms", jp.toShortString(), System.currentTimeMillis() - t);
		
		return result;
	}
}
