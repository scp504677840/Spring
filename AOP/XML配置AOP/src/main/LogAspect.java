package main;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;
import java.util.List;

/**
 * 日志切面
 */
public class LogAspect {

    /**
     * 前置通知：在目标方法开始前执行。
     *
     * @param joinPoint 连接点，该参数可以省略。
     */
    public void beforeLog(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("LogAspect 后置通知: " + name + " --- " + args);
    }

    /**
     * 后置通知
     * 1.无论目标执行的方法是否发生异常，后置通知都将执行。
     * 2.在后置通知中还不能获取到目标方法执行的结果，要想获取结果可以在返回通知中获取。
     *
     * @param joinPoint 切面点
     */
    public void afterLog(JoinPoint joinPoint) {
        System.out.println("LogAspect 前置通知");
    }

    /**
     * 返回通知
     * 1.可以获取方法的返回值。
     *
     * @param joinPoint 切面点
     * @param result    返回值
     */
    public void afterReturningLog(JoinPoint joinPoint, Object result) {
        String name = joinPoint.getSignature().getName();
        System.out.println("LogAspect 返回通知: " + name + " --- " + result);
    }

    /**
     * 异常通知
     * 注意：
     * throwing参数可以指定异常。
     * 1.Exception：接受所有异常。
     * 2.NullPointerException：只有接受到NullPointerException才会执行。当不是NullPointerException时不执行。
     *
     * @param joinPoint 切面点
     * @param e         异常
     */
    public void afterThrowingLog(JoinPoint joinPoint, Exception e) {
        String name = joinPoint.getSignature().getName();
        System.out.println("LogAspect 异常通知： " + name + " --- " + e.getMessage());
    }

    /**
     * 环绕通知
     * 1.必须有ProceedingJoinPoint参数
     * 2.环绕通知类似于动态代理当全过程。
     * 3.ProceedingJoinPoint可以决定目标方法是否执行。（proceedingJoinPoint.proceed();）
     * 4.环绕通知必须要有返回值。
     * 5.返回值为目标的方法执行的返回值。
     *
     * @param proceedingJoinPoint 继续执行切面点
     * @return 环绕通知必须要有返回值。返回值为目标的方法执行的返回值。
     */
    /*public Object aroundLog(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;
        String name = proceedingJoinPoint.getSignature().getName();
        try {
            //前置通知
            System.out.println("前置通知： " + name);
            result = proceedingJoinPoint.proceed();
            System.out.println("返回通知： " + name);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            //异常通知
            System.out.println("异常通知： " + name);
            //如遇到异常，可抛。
            throw new RuntimeException(throwable);
        }
        //后置通知
        System.out.println("后置通知： " + name);
        return result;
    }*/


}
