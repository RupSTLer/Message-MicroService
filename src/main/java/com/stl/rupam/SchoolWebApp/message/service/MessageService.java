package com.stl.rupam.SchoolWebApp.message.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
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
		
	public Message updateMessage(Message msg)
	{
		LocalDateTime datetime = LocalDateTime.now();  
	    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");  
	    String timestamp = datetime.format(format);  
		msg.setTime(timestamp);  
		
//		String s = validateMessage(msg);
//		
//		if (s == null) {
//			msgRepo.save(fee);
//			return "Fees paid successfully..";
//		} else {
//			return s;
//		}
		
		return msgRepo.saveAndFlush(msg);
	}
	
	public String validateMessage(Message msg)
	{
		try {
			if(msg.getMessage().length() > 100)
			{
				throw new IllegalArgumentException("Maximum character exceeded");
			}
		}
		catch(Exception ex)
		{
			return ex.getMessage();
		}
		
		
		return null;
	}
	
	public List<Message> getMsgListBySenderId(String senderId)
	{
		List<Message> msgs = msgRepo.findBySenderId(senderId);
		sortMsgsByTime(msgs);
		return msgs;
	}
	
	public List<Message> getAllMessages() 
	{
		List<Message> msgs = msgRepo.findAll();
		sortMsgsByTime(msgs);
		return msgs;
	}
	
	public void sortMsgsByTime(List<Message> msgs)
	{
		Collections.sort(msgs, new Comparator<Message>() {

			@Override
			public int compare(Message msg1, Message msg2) {
				String time1 = msg1.getTime();
				String time2 = msg2.getTime();				
				return time2.compareTo(time1);
			}
		});
	}
	
	public List<Message> getMsgListByReceiverId(String receiverId)
	{
		return msgRepo.findByReceiverId(receiverId);
	}

}

