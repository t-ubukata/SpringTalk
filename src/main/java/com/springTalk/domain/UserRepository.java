package com.springTalk.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  List<User> findById(Long id);

  List<User> findByNameOrderById(String name);
}