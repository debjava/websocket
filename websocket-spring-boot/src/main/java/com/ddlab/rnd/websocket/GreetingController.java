package com.ddlab.rnd.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {

	@Autowired
	private SimpMessagingTemplate template;

	@RequestMapping("/")
	String home() {
//		return "check.html";
		
		return "aptimusPage.html";
	}

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public void greeting() throws Exception {
		System.out.println("------------------==========================");

		for (int i = 0; i < 5; i++) {
			String text = "msg-" + i;
			Thread.sleep(300);
//			Greeting greet = new Greeting("Hello, abcd ...." + i + "=========" + "!");
			
			Greeting greet = new Greeting("ABCD~" +i, "name-"+i);
			this.template.convertAndSend("/topic/greetings", greet);
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
