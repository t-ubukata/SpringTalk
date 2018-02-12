package com.springTalk.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "users", schema = "app")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "user_id_sequence_generator")
  @SequenceGenerator(name = "user_id_sequence_generator", sequenceName = "user_id_sequence", schema = "app")
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String password;

  @OneToMany(mappedBy = "ownerId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Room> rooms;

  @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Membership> memberships;

  @OneToMany(mappedBy = "senderId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Message> messages;

  // JPA requirement
  protected User() {
  }

  public User(String name, String password) {
    this.name = name;
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
