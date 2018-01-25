package com.springTalk.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
  List<Room> findAllByOrderByIdDesc();

  List<Room> findById(Long id);

  // ToDo: find where userId and room pair is in membership

}