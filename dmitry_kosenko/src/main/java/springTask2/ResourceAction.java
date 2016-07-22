package springTask2;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ResourceAction {
	@Pointcut("execution(* springTask2.Start.start(..))")
	public void start(){
	}
	
	@Before("start()")
	public void open(){
		System.out.println("Before: Божечки мои что-то происходит");
	}
	@After("start()")
	public void close(){
		System.out.println("After: Все нормально, попустило");
	}	
}
