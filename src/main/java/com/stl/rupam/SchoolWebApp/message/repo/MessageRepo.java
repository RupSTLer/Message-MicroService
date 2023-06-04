package com.stl.rupam.SchoolWebApp.message.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stl.rupam.SchoolWebApp.message.entity.Message;

public interface MessageRepo extends JpaRepository<Message, Long>{

	public List<Message> findBySenderId(String senderId);
	
	public List<Message> findByReceiverId(String receiverId);
	
	public List<Message> findBySenderIdAndReceiverId(String senderId, String receiverId);
}
