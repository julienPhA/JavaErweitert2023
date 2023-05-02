package org.example;

public class Message {
	private int nr;
	private String content;
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(int nr, String content) {
		super();
		this.nr = nr;
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getNr() {
		return nr;
	}
	public void setNr(int nr) {
		this.nr = nr;
	}
	@Override
	public String toString() {
		return "Message [nr=" + nr + ", content=" + content + "]";
	}
}
