package de.atomfrede.jenkins.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class NotificationHelper {

	boolean started = false;
	
	@Autowired
	EchoHandler websocketHandler;
	
	@Async
	public void startNotificationHelper() throws InterruptedException{
		if(!started) {
			started = true;
			while(started) {
				websocketHandler.sendToAll("Notification");
				Thread.sleep(10000);
			}
		}
		
	}
}
