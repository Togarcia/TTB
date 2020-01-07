package tastat;

import java.util.Set;

public class Client{
	protected int idClient;
	protected String nomClient;
	protected String CIF;
	protected boolean actiu;
	protected String direccio;
	protected String poblacio;
	protected String pais;
	protected String personaContacte;
	protected String telefon;
	protected double latitud;
	protected double longitud;	
	Client(){
		idClient = Generador.getNextClient();
	}
	
	Client(String nom){
		this();
		nomClient = nom;
	}
	
	Client (String nom, double lat, double lon){
		this(nom);
		latitud = lat;
		longitud = lon;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getCIF() {
		return CIF;
	}

	public void setCIF(String cIF) {
		CIF = cIF;
	}

	public String getDireccio() {
		return direccio;
	}

	public void setDireccio(String direccio) {
		this.direccio = direccio;
	}

	public String getPoblacio() {
		return poblacio;
	}

	public void setPoblacio(String poblacio) {
		this.poblacio = poblacio;
	}

	public String getPersonaContacte() {
		return personaContacte;
	}

	public void setPersonaContacte(String personaContacte) {
		this.personaContacte = personaContacte;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public boolean isActiu() {
		return actiu;
	}

	public void setActiu(boolean actiu) {
		this.actiu = actiu;
	}
	
	
	
}