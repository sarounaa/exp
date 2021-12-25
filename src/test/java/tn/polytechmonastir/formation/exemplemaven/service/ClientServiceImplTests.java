package tn.polytechmonastir.formation.exemplemaven.service;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import tn.polytechmonastir.formation.exemplemaven.data.Client;
import tn.polytechmonastir.formation.exemplemaven.data.ClientRepository;
import tn.polytechmonastir.formation.exemplemaven.exception.NonUniqueEmailException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RunWith(MockitoJUnitRunner.class)
public class ClientServiceImplTests {

	@InjectMocks
	ClientServiceImpl manager;

	@Mock
	ClientRepository dao;
	
	
	@Test
	public void addClientTest()
	{
		Client toSave = new Client("CHAOUACHI","Ahmed","ahmed@gmail.com","12345678",null);
		Client saved  = new Client(1L,"CHAOUACHI","Ahmed","ahmed@gmail.com","12345678",null); 
		// expected
		
		when(dao.save(toSave)).thenReturn(saved);

		//test
		Client actual = manager.addNewClient(toSave);

		assertEquals(saved.getId().longValue(), actual.getId().longValue());
	}
	
	
	@Test(expected = NonUniqueEmailException.class)
	public void addClient_Test()
	{
		Client toSave = new Client("CHAOUACHI","Ahmed","ahmed@gmail.com","12345678",null);
		
		Client saved  = new Client(1L,"CHAOUACHI","Ahmed","ahmed@gmail.com","12345678",null);
		
		/*
		Client old  = new Client(2L,"foo","bar","ahmed@gmail.com","22558899",null); 
		
		List<Client> l = new ArrayList<Client>();
		l.add(old);
		l.add(saved);
		*/
		// expected
		
		//when(dao.save(toSave)).thenReturn(saved);
		when(dao.findByEmail(toSave.getEmail())).thenReturn(Optional.of(toSave));
		//when (dao.findAll()).thenReturn(l);

		//test
		Client actual = manager.addNewClient(toSave);

		//assertEquals(1L, actual.getId().longValue());
		//assertEquals(2,manager.getAll().size());
	}

}
