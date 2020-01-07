package tastat;

public class ComandaLinia {
	protected Producte producte;
	protected int quantitat;
	protected double preuVenda;
	
	ComandaLinia(Producte p, int q, double preu) {
		producte = p;
		quantitat = q;
		preuVenda = preu;
	}

	public Producte getProducte() {
		return producte;
	}

	public void setProducte(Producte producte) {
		this.producte = producte;
	}

	public int getQuantitat() {
		return quantitat;
	}

	public void setQuantitat(int quantitat) {
		this.quantitat = quantitat;
	}

	public double getPreuVenda() {
		return preuVenda;
	}

	public void setPreuVenda(double preuVenda) {
		this.preuVenda = preuVenda;
	}
	
	
}