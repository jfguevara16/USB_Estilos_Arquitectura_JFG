package com.example.p2p;

public class Mensaje {
	
	private String from;
    private String content;

    public Mensaje() {
    }

    public Mensaje(String from, String content) {
        this.from = from;
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
	
	
}
