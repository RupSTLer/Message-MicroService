package com.stl.rupam.SchoolWebApp.message.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stl.rupam.SchoolWebApp.message.entity.Message;
import com.stl.rupam.SchoolWebApp.message.service.MessageService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageService msgService;
	
	@PostMapping("/addMsg")
	public Message addMessage(@Valid @RequestBody Message msg)
	{	
		System.out.println(msg);
		return msgService.addMessage(msg);
	}
	
	@GetMapping("/getMsg")
	public List<Message> getMessages()
	{	
		return msgService.getAllMessages();
	}
}