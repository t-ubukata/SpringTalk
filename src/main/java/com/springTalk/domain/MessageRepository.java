package com.springTalk.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
  List<Message> findAllByOrderByIdDesc();

  List<Message> findByRoomIdOrderById(Long roomId);

  List<Message> findBySenderIdOrderById(Long senderId);

  // native query dependent on Oracle DB
  @Query(value = "select *" + "from app.messages" + "where id"
      + "in (select min(id) as id from app.messages group by room_id)" + "order by id desc", nativeQuery = true)
  List<Message> findFirstMessageOfRoomOrderByIdDesc();
}