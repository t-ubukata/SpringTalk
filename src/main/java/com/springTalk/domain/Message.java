package com.springTalk.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "messages", schema = "app")
public class Message {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "message_id_sequence_generator")
  @SequenceGenerator(name = "message_id_sequence_generator", sequenceName = "message_id_sequence", schema = "app")
  private Long id;

  @JoinColumn(name = "sender_id", nullable = false)
  @ManyToOne(cascade = CascadeType.ALL)
  private User senderId;

  @JoinColumn(name = "room_id", nullable = false)
  @ManyToOne(cascade = CascadeType.ALL)
  private Room roomId;

  @Column(nullable = false)
  private String text;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false)
  private Date createdAt;

  // JPA requirement
  protected Message() {
  }

  public Message(User senderId, Room roomId, String text) {
    this.senderId = senderId;
    this.roomId = roomId;
    this.text = text;
  }

  public Long getId() {
    return id;
  }

  public User getSenderId() {
    return senderId;
  }

  public void setSenderId(User senderId) {
    this.senderId = senderId;
  }

  public Room getRoomId() {
    return roomId;
  }

  public void setRoomId(Room roomId) {
    this.roomId = roomId;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Date getCreatedAt() {
    return createdAt;
  }
}