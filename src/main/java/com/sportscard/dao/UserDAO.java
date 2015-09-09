package com.sportscard.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sportscard.entity.User;

@Service
@Repository
public class UserDAO extends BaseDAO{
	
	public User findByEmail(String email) {
		try {
			Query q = entityManager
					.createQuery("select e from User e where e.email = ?");
			q.setParameter(1, email);
			return (User) q.getSingleResult();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}
