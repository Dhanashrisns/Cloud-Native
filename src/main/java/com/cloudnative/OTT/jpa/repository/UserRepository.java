package com.cloudnative.OTT.jpa.repository;

import com.cloudnative.OTT.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User,String> {

  public User findByEmail(String email);
}
