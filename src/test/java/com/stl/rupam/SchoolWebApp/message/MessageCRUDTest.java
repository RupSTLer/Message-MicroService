package com.stl.rupam.SchoolWebApp.message;

import java.util.List;
import javax.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.stl.rupam.SchoolWebApp.message.entity.Message;
import com.stl.rupam.SchoolWebApp.message.repo.MessageRepo;



//@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@EnableAutoConfiguration(exclude=AutoConfigureTestDatabase.class)
@AutoConfigureTestDatabase(replace= Replace.NONE)
public class MessageCRUDTest {
	
	@Autowired
	private MessageRepo messageRepo;
	
	//JUnit test for save teacher
	@Test
	@Order(1)
	@Rollback(value = false)
	public void payMessageTest()
	{
		Message msg = Message.builder()
				.id(4L)
				.receiverId(5L)
				.message("use of openfeign")
				.time("01-05-2023 18:53:54")
				.build();
				
		messageRepo.save(msg);
		
		Assertions.assertThat(msg.getId()).isGreaterThan(0);
	}
	
	@Test
	@Order(2)
//	@Rollback(value = false)
	public void getMessageTest()
	{
		Message msg = messageRepo.findById(2L).get();
		
		Assertions.assertThat(msg.getId()).isEqualTo(2L);
	}
	
	@Test
	@Order(3)
//	@Rollback(value = false)
	public void getListOfFeesTest()
	{
		
		List<Message> msg = messageRepo.findAll();
		
		Assertions.assertThat(msg.size()).isEqualTo(7);
	}
	
//	@Test
//	@Order(4)
//	@Rollback(value = false)
//	public void updateFeeTest()
//	{
//		Message msg = messageRepo.findById(3L).get();
//		
//		msg.setStudentId("SMS002");
//		
//		Message msgUpdated = messageRepo.save(msg);
//		
//		Assertions.assertThat(msgUpdated.getStudentId()).isEqualTo("SMS005");
//	}
	

}
