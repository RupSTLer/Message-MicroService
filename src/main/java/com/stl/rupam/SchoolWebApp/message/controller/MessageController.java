package com.stl.rupam.SchoolWebApp.message.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stl.rupam.SchoolWebApp.message.entity.Message;
import com.stl.rupam.SchoolWebApp.message.service.MessageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/message")
@Api(tags = "Message Service APIs", value = "Message Controller", description = "it will handle the web requests of Message service")
public class MessageController {

	@Autowired
	private MessageService msgService;
	
	@ApiOperation(value = "Send new Message", notes = "returns a new message object")
	@PostMapping("/addMsg")
	public Message addMessage(@Valid @RequestBody Message msg)
	{	
		return msgService.addMessage(msg);
	}
	
	@ApiOperation(value = "Update existing Message details", notes = "returns a new message object")
	@PutMapping("/updateMsg")
	public Message updateMessage(@Valid @RequestBody Message msg)
	{	
		return msgService.updateMessage(msg);
	}
	
	@ApiOperation(value = "List all the sent Messages", notes = "returns a list of Messages")
	@GetMapping("/getAllMsgs")
	public List<Message> getMessages()
	{	
		return msgService.getAllMessages();
	}
	
	@ApiOperation(value = "Get Message details by senderID", notes = "returns a message object")
	@GetMapping("/getMsgBySenderId/{senderId}")
	public List<Message> getMsgListBySenderId(@PathVariable String senderId)
	{	
		return msgService.getMsgListBySenderId(senderId);
	}
	
	@ApiOperation(value = "Get Message details by receiverID", notes = "returns a message object")
	@GetMapping("/getMsgByReceiverId/{receiverId}")
	public List<Message> getMsgListByReceiverId(@PathVariable String receiverId)
	{	
		return msgService.getMsgListByReceiverId(receiverId);
	}
	
	
}