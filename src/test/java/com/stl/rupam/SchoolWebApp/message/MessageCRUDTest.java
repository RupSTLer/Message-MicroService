package com.stl.rupam.SchoolWebApp.message;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

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

@SpringBootTest(classes = { MessageCRUDTest.class })
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MessageCRUDTest {

	@Mock
	MessageRepo messageRepo;

	@InjectMocks
	private MessageService messageService;

	// JUnit test for send message
	@Test
	@Order(1)
	@Rollback(value = false)
	public void sendMessageTest() {
		
		Message msg = new Message(2L, 6L, "use of annotation", "01-05-2023 18:53");
		
		when(messageRepo.save(msg)).thenReturn(msg);
		
		assertEquals(msg, messageService.addMessage(msg));

	}
	

//	@Test
//	@Order(2)
//	@Rollback(value = false)
//	public void getMessageTest() {
//		
//		List<Message> msg = messageRepo.findAll();
//
//		Assertions.assertThat(msg.size()).isEqualTo(10);
//	}

	
	@Test
	@Order(2)
//	@Rollback(value = false)
	public void getListOfMsgsTest() {
		
		List<Message> msgs = new ArrayList<Message>();
		
		msgs.add(new Message(2L, 6L, "use of annotation", "01-05-2023 18:53"));
		msgs.add(new Message(3L, 4L, "use of openfeign", "01-05-2023 18:53"));
		
		when(messageRepo.findAll()).thenReturn(msgs);
		
		assertEquals(2, messageService.getAllMessages().size());
	
	}

	
	@Test
	@Order(3)
	@Rollback(value = false)
	public void updateMsgTest() {
		Message msg = Message.builder().id(4L).receiverId(5L).message("use of openfeign").time("01-05-2023 18:53:54")
				.build();

		msg.setMessage("how to resolve the error");
		
		messageService.updateMessage(msg);

		Assertions.assertThat(msg.getMessage()).isEqualTo("how to resolve the error");
	}

}
