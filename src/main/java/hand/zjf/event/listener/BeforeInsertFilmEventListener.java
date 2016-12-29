package hand.zjf.event.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import hand.zjf.event.BeforeInsertFilmEvent;

public class BeforeInsertFilmEventListener implements ApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if(event instanceof BeforeInsertFilmEvent){
			System.out.println("*****************************************************************");
			System.out.println("*******************"+event.getSource()+"*************************");
			System.out.println("*****************************************************************");
		}
	}

}
