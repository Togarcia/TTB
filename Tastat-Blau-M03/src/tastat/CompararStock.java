package tastat;

import java.util.Comparator;

public class CompararStock implements Comparator<Producte> {
	@Override
	public int compare(Producte p1, Producte p2) {
		return (p1.getStock() - p2.getStock());
	}
}
