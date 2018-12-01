package com.itc.apti.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itc.apti.entity.Processor;
import com.itc.apti.entity.Status;

@Controller
public class WebPageController {

	@Autowired
	private SimpMessagingTemplate template;
	
	@Autowired @Qualifier("StatusProcessor")
	private Processor processor;

	@RequestMapping("/")
	String home() {
		return "aptimusPage.html";
	}

	@MessageMapping("/check")
	@SendTo("/topic/services")
	public void broadcastServicesStatus() throws Exception {
		System.out.println("------------------==========================");
		
		List<Status> statusList = (List<Status>) processor.get(null);
		System.out.println(statusList);
		
		for (int i = 0; i < 5; i++) {
			Thread.sleep(300);
			Status status = new Status();
			status.setHostCanonicalName("Connonical-"+i);
			status.setHostIp("HostIP-"+i);
			status.setHostName("Hostname-"+i);
			
			this.template.convertAndSend("/topic/services", status);
		}

	}

	// @MessageMapping("/hello")
	// @SendTo("/topic/greetings")
	// public Greeting greeting(HelloMessage message) throws Exception {
	// Thread.sleep(3000); // simulated delay
	// return new Greeting("Hello, abcd ...." + message.getName() + "!");
	// }

	// @MessageMapping("/hello")
	// @SendTo("/topic/greetings")
	// public void greeting(HelloMessage message) throws Exception {
	// System.out.println("------------------==========================");
	//
	// for( int i = 0 ; i < 5 ; i++ ) {
	// String text = "msg-"+i;
	// Thread.sleep(300);
	//
	// Greeting greet = new Greeting("Hello, abcd ...."+i + message.getName() +
	// "!");
	//
	//// this.template.convertAndSend("/topic/greetings", text);
	//
	// this.template.convertAndSend("/topic/greetings", greet);
	//
	//
	//// this.template.send("/topic/greetings", "s");
	//
	//
	// }
	//
	//
	// }

}
