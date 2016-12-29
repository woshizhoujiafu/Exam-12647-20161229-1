package hand.zjf.dto;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
//import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;


public class MethodTimeAdvice implements MethodInterceptor {
	//   protected final Log log = LogFactory.getLog(MethodTimeAdvice.class);

	    /**
	     * 拦截要执行的目标方法
	     * @return 
	     */
	    public Object invoke(MethodInvocation invocation) throws Throwable {
	    	//用 commons-lang 提供的 StopWatch 计时，Spring 也提供了一个 StopWatch
	    	StopWatch clock = new StopWatch();
	        clock.start(); //计时开始
	        Object result = invocation.proceed();
	        clock.stop();  //计时结束
	        System.out.println("**************************运行时间***********************************");
	        System.out.println(invocation.getThis().getClass().getName() + "."
	                + invocation.getMethod().getName() + " service runtime："+clock.getTime());
	    	//方法参数类型，转换成简单类型
//	    	Class[] params = invocation.getMethod().getParameterTypes();
//	    	String[] simpleParams = new String[params.length];
//	    	for (int i = 0; i < params.length; i++) {
//				simpleParams[i] = params[i].getSimpleName();
//			}
//
//	        log.debug("Takes:" + clock.getTime() + " ms ["
//	                + invocation.getThis().getClass().getName() + "."
//	                + invocation.getMethod().getName() + "("+StringUtils.join(simpleParams,",")+")] ");
	        return result;

	    }

}
