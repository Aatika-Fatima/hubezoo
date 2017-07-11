package com.hubezoo.hubezooback.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hubezoo.hubezooback.model.Client;

@Component
public interface ClientDao {
	boolean addClient(Client client);
	boolean updateClient(Client client);
	boolean deleteClient(Client client);
	Client getClient(Long clientId);
	List<Client> allClients();

}
