package tastat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Producte implements Comparable<Producte> {
	protected int codiProducte;
	protected String nomProducte;
	protected int stock;
	protected int stockMinim;
	protected UnitatMesura unitat;
	protected Map<Producte, Integer> composicio;	
	protected List <LotDesglossat> lots;
	protected Tipus tipus;
	protected Proveidor proveidor;
	protected double preuVenda;
	protected double pes;
	
	public void afegirLot (int quantitat, Date dataCaducitat) {
		int qLot = Generador.getNextLot();
		lots.add(new LotDesglossat(qLot,dataCaducitat,quantitat));
	}
	
	public String veureLots() {
		String cadena = "";
		for(LotDesglossat ld: lots) {
			cadena+="   "+ ld + "\n";
		}
		return cadena;
	}
	
	public String getNomProducte() {
		return nomProducte;
	}

	public void setNomProducte(String nom) {
		nomProducte = nom;
	}

	@Override
	public String toString() {
		String cadena = "Producte: " + codiProducte + "\t - " + nomProducte + "\tStock Total: " + getStock() + " " + unitat ;
		cadena = cadena + "\tStockMínim:" + stockMinim + "\t" + tipus;
		
		//-------------
		//cadena = cadena + "\tProveidor:" + proveidor.getNomProveidor().toString();
		
		return cadena;
	}

	Producte() {
		codiProducte = Generador.getNextProducte();
		lots = new ArrayList<LotDesglossat>();
		composicio = new HashMap<Producte,Integer>();
		tipus = Tipus.INGREDIENT;
		stockMinim = 0;
		stock = 0;
	}

	Producte(String nomProducte){
		this();
		this.nomProducte = nomProducte;
	}
	
	Producte(String nomProducte, UnitatMesura u, int sm){
		this(nomProducte);
		this.setUnitatMesura(u);
		this.stockMinim = sm;
	}
	
	//NUEVO
	Producte(Producte p)
	{
		this.codiProducte = p.getCodiProducte();
		this.composicio = p.getComposicio();
		this.lots = p.lots;
		this.nomProducte = p.getNomProducte();
		this.pes = p.pes;
		this.preuVenda = p.getPreuVenda();
		this.proveidor = p.getProveidor();
		this.stock = p.getStock();
		this.stockMinim = p.getStockMinim();
		this.tipus = p.getTipus();
		this.unitat = p.getUnitatMesura();
	}
	
	
	public void setTipus(Tipus tipus) {
		this.tipus = tipus;
	}
	
	public Tipus getTipus() {
		return tipus;
	}
	
	public void setProveidor(Proveidor pv) {
		this.proveidor = pv;
	}
	
	public Proveidor getProveidor() {
		return proveidor;
	}
	
	
	public UnitatMesura getUnitatMesura() {
		return unitat;
	}

	public void setUnitatMesura(UnitatMesura unitatm) {
		unitat = unitatm;
	}

	void setStock(int q) {
		stock = q;
	}

	public void setStockMinim(int stockM) {
		stockMinim = stockM;
	}

	public int getStockMinim() {
		return stockMinim;
	}

	public void setPreuVenda(double preuVenda) {
		this.preuVenda = preuVenda;
	}

	public double getPreuVenda() {
		return preuVenda;
	}

	public Map <Producte,Integer> getComposicio() {
		return composicio;
	}

	public void afegirComponent(Producte p, int q) {
		composicio.put(p, q);
	}

	public String veureComposicio() {
		String cadena = "";
		Set<Producte> claus = composicio.keySet();
		cadena = getNomProducte() + " --> ";
		for(Producte p: claus)  
			cadena += p.getNomProducte() + "(" + composicio.get(p) + ") ";
		return cadena;
	}
	
	@Override
	public int compareTo(Producte p) {
		return (getNomProducte().compareTo(p.getNomProducte()));
	}

	public int getCodiProducte() {
		return codiProducte;
	}

	private int calcularStockLote() {
		int q =0;
		for(LotDesglossat l:lots) {
			q+=l.getQuantitat();
		}
		return q;
	}
	
	
	public int getStock() {
		return(stock + this.calcularStockLote());
	}
	
	public String veureLotsOrdenats() {
		lots.sort(null);
		String cadena = "";
		for(LotDesglossat ld: lots) {
			cadena+="   "+ ld + "\n";
		}
		return cadena;
	}
	
}