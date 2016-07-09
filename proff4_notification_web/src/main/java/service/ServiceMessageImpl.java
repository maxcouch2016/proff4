package service;

import java.util.ArrayList;
import java.util.List;

import domain.Message;

public class ServiceMessageImpl {
	List<Message> list = new ArrayList<Message>();
	public List<Message> getAllMassage(){
		list.add(new Message("text1","12-02-2005","auto"));
		list.add(new Message("text2","13-02-2005","work"));
		list.add(new Message("text3","14-02-2005","auto"));
		list.add(new Message("text4","15-02-2005","auto"));
		return list;
	}
}
