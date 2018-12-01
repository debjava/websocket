package com.ddlab.rnd.websocket;

public class Greeting {
    
    private String content;
    
    private String name;
    
    public Greeting(String content, String name) {
        this.content = content;
        this.name = name;
    }

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

	public String getName() {
		return name;
	}
    
    

}
