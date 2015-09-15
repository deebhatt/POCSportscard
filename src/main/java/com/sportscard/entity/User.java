package com.sportscard.entity;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="SPORTS_USER")
@SequenceGenerator(name = "SEQ_SPORTS_USER")
public class User extends AuditableEntity implements BaseEntity, Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_SPORTS_USER")
	@Column(name = "USER_ID", unique = true, nullable = false)
	private Long userId;
	
	@Column(name = "USER_NAME", length = 35)
	private String userName;
	
	@Column(name = "EMAIL", length = 35)
	private String email;
	
	@Column(name="PROFILE_PICTURE")
	@Lob
	private Blob profilePicture;
	
	public User() {
	}

	@JsonIgnore
	public Blob getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(Blob profilePicture) {
		this.profilePicture = profilePicture;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
