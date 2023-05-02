package de.lbbw;

public class Message {
	private String material;
	
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(String material) {
		super();
		this.material = material;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "Message [material=" + material + "]";
	}
}
