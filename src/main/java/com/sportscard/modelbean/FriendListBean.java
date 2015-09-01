package com.sportscard.modelbean;

import java.util.List;

public class FriendListBean {
	private Long userId;
	
	private List<Long> friendList;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<Long> getFriendList() {
		return friendList;
	}

	public void setFriendList(List<Long> friendList) {
		this.friendList = friendList;
	}

}
