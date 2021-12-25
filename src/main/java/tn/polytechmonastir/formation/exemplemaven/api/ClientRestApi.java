package tn.polytechmonastir.formation.exemplemaven.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.polytechmonastir.formation.exemplemaven.data.Adresse;
import tn.polytechmonastir.formation.exemplemaven.data.Client;
import tn.polytechmonastir.formation.exemplemaven.dto.ClientDto;
import tn.polytechmonastir.formation.exemplemaven.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientRestApi {

	@Autowired
	private ClientService clientService;

	@PostMapping("")
	public Client addClientApi(@RequestBody ClientDto c) {
		var clt = new Client();
		clt.setPrenom(c.getPrenom());
		clt.setNom(c.getNom());
		clt.setEmail(c.getEmail());
		clt.setId(c.getId());
		clt.setTel(c.getTel());

		var a = new Adresse();
		if (clt.getAdresse() != null) {
			a.setCp(clt.getAdresse().getCp());
			a.setIdAdress(clt.getAdresse().getIdAdress());
			a.setPays(clt.getAdresse().getPays());
			a.setRue(clt.getAdresse().getRue());
			a.setVille(clt.getAdresse().getVille());
		}
		
		clt.setAdresse(a);
		
		return clientService.addNewClient(clt);
	}
}
