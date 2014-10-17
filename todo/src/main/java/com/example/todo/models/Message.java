package com.example.todo.models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "message", catalog = "mysqldb")
public class Message implements java.io.Serializable {

	private static final long serialVersionUID = -5001640410168279934L;
	
	private Integer messageId;
	private User messageSender;
	private User messageReceiver;
	private String messageContent;

	public Message() {
	}

	public Message(User messageSender, User messageReceiver,
			String messageContent) {
		this.messageSender = messageSender;
		this.messageReceiver = messageReceiver;
		this.messageContent = messageContent;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MESSAGE_ID", unique = true, nullable = false)
	public Integer getMessageId() {
		return this.messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MESSAGE_SENDER", nullable = false)
	public User getMessageSender() {
		return this.messageSender;
	}

	public void setMessageSender(User messageSender) {
		this.messageSender = messageSender;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MESSAGE_RECEIVER", nullable = false)
	public User getMessageReceiver() {
		return this.messageReceiver;
	}

	public void setMessageReceiver(User messageReceiver) {
		this.messageReceiver = messageReceiver;
	}
	
	
	
	@Column(name = "MESSAGE_CONTENT", nullable = false)
	public String getMessageContent() {
		return this.messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
}