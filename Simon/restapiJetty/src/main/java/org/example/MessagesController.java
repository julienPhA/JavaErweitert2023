package org.example;

import java.util.ArrayList;
import java.util.List;

public class MessagesController {
	
	private List<Message> list = new ArrayList<Message>();

	public MessagesController() { 
		list.add(new Message(1,"Hello World"));
		list.add(new Message(2,"Bonjour le monde"));
	}
	
	public void addMessage(Message m) {
		list.add(m);
		System.out.println("added: "+m);
	}
	
	public Message getMessageByNr(int nr) {
		Message result = null;
		for(Message m : list) {
			if (m.getNr()==nr) {
				result = m; 
				break;
			}
		}
		return result;
	}
	
	public List<Message> getAllMessages() {
		return list;
	}

	public void deleteMessage(int messageNo) {
		list.removeIf(m -> m.getNr() == messageNo); 
		System.out.println("deleted: "+messageNo);
	}

}
