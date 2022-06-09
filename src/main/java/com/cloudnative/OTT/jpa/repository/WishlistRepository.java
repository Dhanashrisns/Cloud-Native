package com.cloudnative.OTT.jpa.repository;

import com.cloudnative.OTT.jpa.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface WishlistRepository extends JpaRepository<WishList,String> {

  List<WishList> findAllByUserId(String userId);
}
