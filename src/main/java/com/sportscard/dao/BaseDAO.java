package com.sportscard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sportscard.entity.BaseEntity;

public class BaseDAO {
	
	protected EntityManager entityManager;

	@PersistenceContext(unitName = "persistenceUnit")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends BaseEntity> List<T> getUsersList(Class<? extends T> anytype)
	{
		try{
			String entityName = anytype.getSimpleName();
			String query = "select e from "+ entityName +" e ";
			return entityManager.createQuery(query).getResultList();
		}
		catch(Exception e){
			throw new RuntimeException();
		}
	}
	
	public <T extends BaseEntity> void persist(T anyentity)
	{
		try{
			entityManager.persist(anyentity);
		}
		catch(Exception e){
			throw new RuntimeException();
		}
	}
	
	public <T extends BaseEntity> void update(T anyEntity) {
		try {
			entityManager.merge(anyEntity);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public <T extends BaseEntity, X extends Long> T findById(Class<? extends T> type, X id)
	{
		try{
			return entityManager.find(type, id);
		}
		catch (Exception e) {
			throw new RuntimeException();
		}
	}

}
