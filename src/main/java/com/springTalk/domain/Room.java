package com.springTalk.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "rooms", schema = "app")
public class Room {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "room_id_sequence_generator")
  @SequenceGenerator(name = "room_id_sequence_generator", sequenceName = "room_id_sequence", schema = "app")
  private Long id;

  @JoinColumn(name = "owner_id", nullable = false)
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private User ownerId;

  @OneToMany(mappedBy = "roomId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Membership> memberships;

  @OneToMany(mappedBy = "roomId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private List<Message> messages;

  // JPA requirement
  protected Room() {
  }

  public Room(User ownerId) {
    this.ownerId = ownerId;
  }

  public Long getId() {
    return id;
  }

  public User getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(User ownerId) {
    this.ownerId = ownerId;
  }

  public List<Message> getMessages() {
    return messages;
  }
}