package com.sportscard.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "POSTS")
@SequenceGenerator(name = "POST_SEQ")
public class Posts extends AuditableEntity implements BaseEntity, Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "POST_SEQ")
	@Column(name = "POST_ID", unique = true, nullable = false)
	private Long postId;
	
	@Column(name = "USER_ID")
	private Long userId;
	
	@Column(name = "POST_DATA", length=1550)
	private String post;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "POST_DATE")
	private Date postDate;

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
}
