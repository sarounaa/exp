package tn.polytechmonastir.formation.exemplemaven.service;

import java.util.List;

import tn.polytechmonastir.formation.exemplemaven.data.Client;

public interface ClientService {

	Client addNewClient (Client c);
	
	List<Client> getAll();
}
