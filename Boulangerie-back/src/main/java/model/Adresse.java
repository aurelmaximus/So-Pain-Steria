package model;

import javax.persistence.Embeddable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	@Column(name="number", length =255)
	private String numero;
	@Column(name="street", length =255)
	private String voie;
	@Column(name="city", length =255)
	private String ville;
	@Column(name="zip_code", length =255)
	private String cp;
	
	
	public Adresse(String numero, String voie, String ville, String cp) {
		super();
		this.numero = numero;
		this.voie = voie;
		this.ville = ville;
		this.cp = cp;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getVoie() {
		return voie;
	}


	public void setVoie(String voie) {
		this.voie = voie;
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


}
