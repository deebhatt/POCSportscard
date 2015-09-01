package com.sportscard.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FRIENDS_MASTER")
public class FriendsMaster extends AuditableEntity implements BaseEntity, Serializable{
	

	private static final long serialVersionUID = 1L;

	@Column(name = "USER_ID", unique = true, nullable = false)
	private Long userId;
	
	@Column(name = "FRIEND_LIST", length=1550)
	private String friendList;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFriendList() {
		return friendList;
	}

	public void setFriendList(String friendList) {
		this.friendList = friendList;
	}
}
