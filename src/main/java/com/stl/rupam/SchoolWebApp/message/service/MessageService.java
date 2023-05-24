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

//	public List<Message> getMessages(Message msg) {
//		// TODO Auto-generated method stub
//		List<Message> messages = new ArrayList<>();
//		messages.addAll(repo.findBySenderIdAndReceiverId(msg.getSenderId(), msg.getReceiverId()));
//		messages.addAll(repo.findBySenderIdAndReceiverId(msg.getReceiverId(), msg.getSenderId()));
//		messages.sort(new Comparator<Message>() {
//
//			@Override
//			public int compare(Message o1, Message o2) {
//				// TODO Auto-generated method stub
////				return o1.getCreationDateTime().compareTo(o2.getCreationDateTime());
//				return o1.getTime().compareTo(o2.getTime());
//			}	
//		});
//		return messages;
//	}
}

