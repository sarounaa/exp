package tn.polytechmonastir.formation.exemplemaven.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adresse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAdress;
	
	private String rue;
	private String ville;
	private String cp;
	private String pays;
	
	public Adresse()
	{
		super();
	}
	
	
	
	

	public Adresse(String rue, String ville, String cp, String pays) {
		super();
		this.rue = rue;
		this.ville = ville;
		this.cp = cp;
		this.pays = pays;
	}





	public Long getIdAdress() {
		return idAdress;
	}
	public void setIdAdress(Long idAdress) {
		this.idAdress = idAdress;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	
}
