package tastat;

import java.util.Set;

public class Proveidor{
	protected int idProveidor;
	protected String nomProveidor;
	protected String CIF;
	protected boolean actiu;
	protected String direccio;
	protected String poblacio;
	protected String pais;
	protected String personaContacte;
	protected String telefon;
	protected double latitud;
	protected double longitud;	
	Proveidor(){
		idProveidor = Generador.getNextProveidor();
	}
	
	Proveidor(String nom){
		this();
		nomProveidor = nom;
	}

	//----------------------------------
	
	public int getIdProveidor() {
		return idProveidor;
	}

	public void setIdProveidor(int idProveidor) {
		this.idProveidor = idProveidor;
	}

	public String getNomProveidor() {
		return nomProveidor;
	}

	public void setNomProveidor(String nomProveidor) {
		this.nomProveidor = nomProveidor;
	}

	public String getCIF() {
		return CIF;
	}

	public void setCIF(String cIF) {
		CIF = cIF;
	}

	public boolean isActiu() {
		return actiu;
	}

	public void setActiu(boolean actiu) {
		this.actiu = actiu;
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

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
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

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
	
}