package com.cloudnative.OTT.domain;

import com.cloudnative.OTT.jpa.entity.WishList;

public class WishListRequest {

  private Integer id;
  private String userId;

  public WishListRequest(Integer id, String userId) {
    this.id = id;
    this.userId = userId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }
}
