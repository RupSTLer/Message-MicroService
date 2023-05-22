package com.stl.rupam.SchoolWebApp.message.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "messages")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@Column(nullable = false)
//	private Long senderId;
	
	@Column(nullable=false)
	private Long receiverId;
	
	@Column(nullable=false)
	@Max(value = 100, message = "character limit is 100")
	private String message;
    
//	@Column(nullable = false)
	private String time;
	
//    private LocalDateTime creationDateTime;
	
}