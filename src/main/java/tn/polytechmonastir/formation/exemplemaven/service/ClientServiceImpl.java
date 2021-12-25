package tn.polytechmonastir.formation.exemplemaven.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.polytechmonastir.formation.exemplemaven.data.Client;
import tn.polytechmonastir.formation.exemplemaven.data.ClientRepository;
import tn.polytechmonastir.formation.exemplemaven.exception.NonUniqueEmailException;

@Service
public class ClientServiceImpl implements ClientService{

	
	@Autowired
	private ClientRepository clientRepository;
	
	
	@Override
	public Client addNewClient(Client c)  {
		
		// Custom Control
			
			Optional<Client> found = clientRepository.findByEmail(c.getEmail());
			if(found.isPresent())
			{
				throw new NonUniqueEmailException();
			}
		//
		return clientRepository.save(c);
	}


	@Override
	public List<Client> getAll() {
		return clientRepository.findAll();
	}

}
