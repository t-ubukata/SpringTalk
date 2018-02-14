package com.springTalk.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
  List<Message> findAllByOrderByIdDesc();

  List<Message> findByRoomIdOrderById(Long roomId);

  List<Message> findBySenderIdOrderById(Long senderId);
}