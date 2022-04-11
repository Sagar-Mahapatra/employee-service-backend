package in.nareshit.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CentralizedLogging {
	/*
	 * @Pointcut("execution(public * in.nareshit.rest.EmployeeRestController.*(..))"
	 * ) // public void myPointCut() { };
	 * 
	 * @Around("myPointCut()") public void aroundAdvice(ProceedingJoinPoint p)
	 * throws Throwable { Signature signature = p.getSignature(); String methodName
	 * = signature.getName();
	 * 
	 * log.info(methodName + " method execution started");
	 * 
	 * p.proceed();
	 * 
	 * log.info(methodName + " method execution ended"); }
	 */
}
