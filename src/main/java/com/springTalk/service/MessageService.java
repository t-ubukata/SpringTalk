package com.springTalk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springTalk.domain.Message;
import com.springTalk.domain.MessageRepository;

@Service
public class MessageService {

  @Autowired
  private MessageRepository repository;

  public List<Message> getFirstMessageOfRoomOrderByIdDesc() {
    return repository.findFirstMessageOfRoomOrderByIdDesc();
  }

  public List<Message> getMessagesByRoomIdOrderById(Long roomId) {
    return repository.findByRoomIdOrderById(roomId);
  }

  @Transactional
  public void save(Message message) {
    repository.save(message);
  }
}