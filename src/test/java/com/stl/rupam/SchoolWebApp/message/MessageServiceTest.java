package com.stl.rupam.SchoolWebApp.message;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.stl.rupam.SchoolWebApp.message.entity.Message;
import com.stl.rupam.SchoolWebApp.message.repo.MessageRepo;
import com.stl.rupam.SchoolWebApp.message.service.MessageService;

@SpringBootTest(classes = { MessageServiceTest.class })
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MessageServiceTest {

	@Mock
	MessageRepo messageRepo;

	@InjectMocks
	private MessageService messageService;

	// JUnit test for send message
	@Test
	@Order(1)
	@Rollback(value = false)
	public void sendMessageTest() {
		
		Message mockMsg = new Message(2L, "SMS003", "SMT004", "use of annotation", "01-05-2023 18:53");
		
		when(messageRepo.save(mockMsg)).thenReturn(mockMsg);
		
		assertEquals(mockMsg, messageService.addMessage(mockMsg));
		verify(messageRepo, times(1)).save(mockMsg);

	}
	
	// JUnit test for getMsgDetailsBySenderIdTest
	@Test
	@Order(2)
	@Rollback(value = false)
	public void getMsgDetailsBySenderIdTest() {
		
		String studentId = "SMS002";
		List<Message> mockMsgList = new ArrayList<Message>();
		
		mockMsgList.add(new Message(2L, "SMS002", "SMT004", "use of annotation", "01-05-2023 18:53"));
		mockMsgList.add(new Message(3L, "SMS002", "SMT005", "what is cloud", "01-05-2023 18:53"));
			
		when(messageRepo.findBySenderId(studentId)).thenReturn(mockMsgList);
		
		List<Message> mockService = messageService.getMsgListBySenderId(studentId);
		
		assertEquals(mockMsgList, mockService);
		verify(messageRepo, times(1)).findBySenderId(studentId);
				
	}

	// JUnit test for getListOfMsgsTest
	@Test
	@Order(3)
//	@Rollback(value = false)
	public void getListOfMsgsTest() {
		
		List<Message> mockMsgList = new ArrayList<Message>();
		
		mockMsgList.add(new Message(2L, "SMS003", "SMT004", "use of annotation", "01-05-2023 18:53"));
		mockMsgList.add(new Message(3L, "SMS002", "SMT005", "what is cloud", "01-05-2023 18:53"));
		
		when(messageRepo.findAll()).thenReturn(mockMsgList);
		
		List<Message> mockService = messageService.getAllMessages();
		
		assertEquals(mockMsgList, mockService);
		verify(messageRepo, times(1)).findAll();
	
	}

	// JUnit test for update Message details
	@Test
	@Order(4)
	@Rollback(value = false)
	public void updateMsgTest() {
		Message msg = new Message(2L, "SMS003", "SMT004", "use of annotation", "01-05-2023 18:53");

		msg.setMessage("how to resolve the error");
		
		messageService.updateMessage(msg);

		Assertions.assertThat(msg.getMessage()).isEqualTo("how to resolve the error");
	}

}
