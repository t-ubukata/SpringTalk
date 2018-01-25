package com.springTalk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springTalk.domain.Room;
import com.springTalk.domain.RoomRepository;

@Service
public class RoomService {

  @Autowired
  private RoomRepository repository;

  public List<Room> getRoomsOrderByIdDesc() {
    return repository.findAllByOrderByIdDesc();
  }

  public List<Room> getRoomsById(Long id) {
    return repository.findById(id);
  }

  @Transactional
  public void save(Room room) {
    repository.save(room);
  }

  @Transactional
  public Room saveAndFlush(Room room) {
    return repository.saveAndFlush(room);
  }
}