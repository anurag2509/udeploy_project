package com.signup.service;

import com.signup.dao.DAO;
import com.signup.dao.DAOInterface;
import com.signup.entity.Entity;

public class Service implements ServiceInterface{
	
	private Service(){}

	public static ServiceInterface createServiceObject(String s) {
		
		return new Service();
	}

	@Override
	public int createProfile(Entity e) {
		DAOInterface di=DAO.createDAOObject();
		
		return di.createProfile(e);
	}

}
