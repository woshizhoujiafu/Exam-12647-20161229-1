package hand.zjf.dto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationFactory {
	private static ApplicationContext applicationContext;
	private static final ApplicationFactory af = new ApplicationFactory();
	private ApplicationFactory(){}
	public static ApplicationFactory getInstance(){
		return af;
	}
	
	static{
		 applicationContext = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
	}
	
	public ApplicationContext getApplicationContext(){
		return applicationContext;
	}

}
