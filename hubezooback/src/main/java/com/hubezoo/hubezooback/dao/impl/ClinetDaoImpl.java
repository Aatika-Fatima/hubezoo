package com.hubezoo.hubezooback.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hubezoo.hubezooback.dao.ClientDao;
import com.hubezoo.hubezooback.model.Client;

@Repository("clientDao")
public class ClinetDaoImpl implements ClientDao{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addClient(Client client) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateClient(Client client) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteClient(Client client) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Client getClient(Long clientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> allClients() {
		// TODO Auto-generated method stub
		return null;
	}

}
