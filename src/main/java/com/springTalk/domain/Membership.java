package com.springTalk.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "memberships", schema = "app")
public class Membership {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "membership_id_sequence_generator")
  @SequenceGenerator(name = "membership_id_sequence_generator", sequenceName = "membership_id_sequence", schema = "app")
  private Long membershipId;

  @JoinColumn(name = "room_id", nullable = false)
  @ManyToOne(cascade = CascadeType.ALL)
  private Room roomId;

  @JoinColumn(name = "user_id", nullable = false)
  @ManyToOne(cascade = CascadeType.ALL)
  private User userId;

  // JPA requirement
  protected Membership() {
  }

  public Membership(Room roomId, User userId) {
    this.roomId = roomId;
    this.userId = userId;
  }

  public Long getMembershipId() {
    return membershipId;
  }

  public Room getRoomId() {
    return roomId;
  }

  public void setRoomId(Room roomId) {
    this.roomId = roomId;
  }

  public User getUserId() {
    return userId;
  }

  public void setUserId(User userId) {
    this.userId = userId;
  }
}