package com.springTalk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springTalk.domain.Membership;
import com.springTalk.domain.MembershipRepository;

@Service
public class MembershipService {

  @Autowired
  private MembershipRepository repository;

  public List<Membership> getMembershipByMembershipIDOrderByRoomId(Long membershipId) {
    return repository.findByMembershipIdOrderByRoomId(membershipId);
  }

  public List<Membership> getMembershipByRoomIdOrderByUserId(Long roomId) {
    return repository.findByRoomIdOrderByUserId(roomId);
  }

  public List<Membership> getMembershipByUserIdOrderByUserId(Long userId) {
    return repository.findByRoomIdOrderByUserId(userId);
  }

  @Transactional
  public void save(Membership membership) {
    repository.save(membership);
  }
}