package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {
	
	@Autowired
	private SimpMessagingTemplate template;


//    @MessageMapping("/hello")
//    @SendTo("/topic/greetings")
//    public Greeting greeting(HelloMessage message) throws Exception {
//        Thread.sleep(3000); // simulated delay
//        return new Greeting("Hello, abcd ...." + message.getName() + "!");
//    }
	
	
	
	 @MessageMapping("/hello")
	    @SendTo("/topic/greetings")
	    public void greeting(HelloMessage message) throws Exception {
	        Thread.sleep(3000); // simulated delay
//	        return new Greeting("Hello, abcd ...." + message.getName() + "!");
	        
//	        System.err.println("** Sending messages...");
//	        template.convertAndSend("/app/message", 
//	                new MessageController().Message(1L, "Hello Server", System.currentTimeMillis()));
//
//	        messageTemplate.convertAndSend("/topic/message", 
//	                new MessageController.Message(1L, "Hello Server", System.currentTimeMillis()));
//
//	        messageTemplate.convertAndSend("/queue/message", 
//	                new MessageController.Message(1L, "Hello Server", System.currentTimeMillis()));
//
//	        messageTemplate.convertAndSend("/message", 
//	                new MessageController.Message(1L, "Hello Server", System.currentTimeMillis()));
//	        System.err.println("** Messages send!");
	        
	        for( int i = 0 ; i < 5 ; i++ ) {
	        	String text = "msg-"+i;
	        	Thread.sleep(300);
	        	
	        	Greeting greet = new Greeting("Hello, abcd ...."+i + message.getName() + "!");
	        	
//	        	this.template.convertAndSend("/topic/greetings", text);
	        	
	        	this.template.convertAndSend("/topic/greetings", greet);
	        	
	        	
//	        	this.template.send("/topic/greetings", "s");
	        	
	        	
	        }
	        
	        
	    }

}
