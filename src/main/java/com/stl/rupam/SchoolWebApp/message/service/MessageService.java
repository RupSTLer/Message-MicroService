package com.stl.rupam.SchoolWebApp.message.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stl.rupam.SchoolWebApp.message.entity.Message;
import com.stl.rupam.SchoolWebApp.message.repo.MessageRepo;

@Service
public class MessageService {

	@Autowired 
	private MessageRepo msgRepo;
	
	public Message addMessage(Message msg) {
		
		LocalDateTime datetime = LocalDateTime.now();  
	    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");  
	    String timestamp = datetime.format(format);  
		msg.setTime(timestamp);  
		
//		Message m = new Message();
		
//		msg.setSenderId(m.getSenderId());
		
		return msgRepo.save(msg);  
		
	}   
	
	public List<Message> getAllMessages() 
	{
		return msgRepo.findAll();
	}
	
	public Message updateMessage(Message msg)
	{
		return msgRepo.saveAndFlush(msg);
	}
	
	public List<Message> getMsgListBySenderId(String senderId)
	{
		return msgRepo.findBySenderId(senderId);
	}
	
	public List<Message> getMsgListByReceiverId(String receiverId)
	{
		return msgRepo.findByReceiverId(receiverId);
	}

//	public List<Message> getMsgsByTime() {
//		// TODO Auto-generated method stub
//		List<Message> messages = new ArrayList<>();
//		messages.addAll(msgRepo.findBySenderIdAndReceiverId(msg.getSenderId(), msg.getReceiverId()));
//		messages.addAll(msgRepo.findBySenderIdAndReceiverId(msg.getReceiverId(), msg.getSenderId()));
//		messages.sort(new Comparator<Message>() {
//
//			@Override
//			public int compare(Message o1, Message o2) {
//				return o1.getTime().compareTo(o2.getTime());
//			}	
//		});
//		return messages;
//	}
}

