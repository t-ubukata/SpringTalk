package com.springTalk.domain;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {
  List<Membership> findByMembershipIdOrderByRoomId(Long membershipId);
  List<Membership> findByRoomIdOrderByUserId(Long roomId);
  List<Membership> findByUserIdOrderByRoomId(Long userId);
}