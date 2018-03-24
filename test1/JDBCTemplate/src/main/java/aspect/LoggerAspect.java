package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect/*@Aspect 注解表示这是一个切面*/
@Component/*@Component 表示这是一个bean,由Spring进行管理*/
public class LoggerAspect {
    @Around(value = "execution(* service.TeacherService.*(..))")
    //        @Around(value = "execution(* *** *(..))") 表示对*** 这个类中的所有方法进行切面操作
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("start log:" + joinPoint.getSignature().getName());
        Object object = joinPoint.proceed();
        System.out.println("end log:" + joinPoint.getSignature().getName());
        return object;
    }
}
