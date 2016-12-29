package hand.zjf.event.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import hand.zjf.event.AfterInsertFilmEvent;

public class AfterInsertFilmEventListener implements ApplicationListener{

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if(event instanceof AfterInsertFilmEvent){
			System.out.println("*****************************************************************");
			System.out.println("**********************"+event.getSource()+"**********************");
			System.out.println("*****************************************************************");
		}
		
	}

}
