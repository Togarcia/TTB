package tastat;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.List;

public class Programa {
	
	public static void main(String[] args) {
		//1.- Generaci� d'un magatzem petit�
		Magatzem elMeuMagatzem = new Magatzem(new ArrayList<Producte>(), new ArrayList<Client>(), new ArrayList<Comanda>(), new ArrayList<Proveidor>());
		generarDadesBasiques(elMeuMagatzem);
		System.out.println("Veure Magatzem:");
		System.out.println(elMeuMagatzem);
		
		//2.- Veure la composici� dels productes del magatzem
		for(Producte p: elMeuMagatzem.getProductes()) 
			if (p.getTipus() == Tipus.VENDIBLE) 
				System.out.println(p.veureComposicio());
	
		//3.- Veure magatzem ordenat per nom producte
		elMeuMagatzem.getProductes().sort(null);
		System.out.println("3.- Magatzem ordenat per nomProducte");
		System.out.println(elMeuMagatzem);
		
		//4.- Veure magatzem ordenat per stock
		
		System.out.println("3.- Magatzem ordenat per Stock");
		elMeuMagatzem.getProductes().sort(new CompararStock());
		System.out.println(elMeuMagatzem);	
	}

	//private
	public static void generarDadesBasiques(Magatzem mgz) {
		
		//Prove�dors
		Proveidor pv1 = new Proveidor("Publipoin");
		Proveidor pv2 = new Proveidor ("Spondylu");
		Proveidor pv3 = new Proveidor ("Mercanobo");
		Proveidor pv4 = new Proveidor ("Elite");
		Proveidor pv5 = new Proveidor ("Nexo");
		Proveidor pv6 = new Proveidor ("Splendid");
		
		// Productes, composici� i lots
		Producte pliv = new Producte("pLiviano", UnitatMesura.UNITAT,4);
		Producte pllim = new Producte("pLLimona", UnitatMesura.UNITAT,6);
	    Date dataCaducitat;
		Producte p = new Producte("sucre",UnitatMesura.GRAMS,100000);
	    dataCaducitat = Tools.sumarDies(new Date(), 10);
		p.afegirLot(40000,dataCaducitat);
		p.afegirLot(30000, dataCaducitat);		
		dataCaducitat = Tools.sumarDies(dataCaducitat,20);
		p.afegirLot(70000, dataCaducitat);
		
		p.setProveidor(pv1);
		mgz.add(p);
		
		Producte sucre = p;
		
		pliv.afegirComponent(p, 115);
		pllim.afegirComponent(p, 4);
		
		p = new Producte("Ous", UnitatMesura.UNITAT,240);
		p.afegirLot(480, dataCaducitat);
		mgz.add(p);
		
		pliv.afegirComponent(p, 4);
		
		Producte farina = new Producte("Farina", UnitatMesura.GRAMS,30000);
		farina.afegirLot(10000, dataCaducitat);
		farina.afegirLot(20000, dataCaducitat);
		
		farina.setProveidor(pv1);
		mgz.add(farina);
		
		pliv.afegirComponent(farina, 115);
		
		p = new Producte("Llevadura", UnitatMesura.GRAMS,5000);
		p.afegirLot(200, (new Date()));
		dataCaducitat = Tools.sumarDies(new Date(), -5);
		p.afegirLot(400, dataCaducitat);
		dataCaducitat = Tools.sumarDies(new Date(), 5);
		p.afegirLot(100, dataCaducitat);
		
		p.setProveidor(pv1);
		mgz.add(p);

		pliv.afegirComponent(p, 10);
		pllim.afegirComponent(p, 8);

		Producte pSec = new Producte("Secret", UnitatMesura.UNITAT,0);
		pSec.setStock(100);

		pliv.afegirComponent(pSec, 1);
		pllim.afegirComponent(pSec, 1);

		p = new Producte("Nabius", UnitatMesura.GRAMS,4000);
		dataCaducitat = Tools.sumarDies(new Date(), 15);
		p.afegirLot(2000, dataCaducitat);
		p.setProveidor(pv2);
		mgz.add(p);
		
		pSec.afegirComponent(p, 100);
		mgz.add(pSec);
		
		p = new Producte("Llimona", UnitatMesura.GRAMS,4000);
		dataCaducitat = Tools.sumarDies(new Date(), 15);
		p.afegirLot(2000, dataCaducitat);
		
		p.setProveidor(pv2);
		mgz.add(p);
		
		pliv.afegirComponent(p, 40);
		pllim.afegirComponent(p, 4);
		
		p = new Producte("Albahaca", UnitatMesura.GRAMS,4000);
		dataCaducitat = Tools.sumarDies(new Date(), 15);
		p.afegirLot(2000, dataCaducitat);
		
		p.setProveidor(pv2);
		mgz.add(p);

		pllim.afegirComponent(pSec, 20);
		
		pliv.setTipus(Tipus.VENDIBLE);
		pllim.setTipus(Tipus.VENDIBLE);
		
		pliv.setPreuVenda(20);
		pllim.setPreuVenda(15);
		pllim.setStock(18);

		mgz.add(pliv);
		mgz.add(pllim);
		
		//Creo productos yo
		
		Producte oli = new Producte("Oli", UnitatMesura.LLITRE, 5);
		oli.afegirLot(10, dataCaducitat);
		oli.afegirLot(6, dataCaducitat);
		oli.setProveidor(pv5);
		oli.setTipus(Tipus.INGREDIENT);
		oli.setStock(15);
		
		mgz.add(oli);
		
		Producte chocolate = new Producte("Xocolata", UnitatMesura.GRAMS, 10000);
		chocolate.afegirLot(20000, dataCaducitat);
		chocolate.afegirLot(60000, dataCaducitat);
		chocolate.setProveidor(pv4);
		chocolate.setTipus(Tipus.INGREDIENT);
		chocolate.setStock(30000);
		
		mgz.add(chocolate);
		
		Producte levadura = new Producte("Llevadura espesa", UnitatMesura.GRAMS, 50000);
		levadura.afegirLot(1000, dataCaducitat);
		levadura.afegirLot(5000, dataCaducitat);
		levadura.setProveidor(pv3);
		levadura.setTipus(Tipus.INGREDIENT);
		levadura.setStock(4500);
		
		mgz.add(levadura);
		
		Producte agua = new Producte("Aigua", UnitatMesura.LLITRE, 60);
		agua.afegirLot(100, dataCaducitat);
		agua.afegirLot(70, dataCaducitat);
		agua.setProveidor(pv6);
		agua.setTipus(Tipus.INGREDIENT);
		agua.setStock(150);
		
		mgz.add(agua);
		
		Producte coulant = new Producte("Coulant", UnitatMesura.UNITAT, 30);
		coulant.afegirLot(20, dataCaducitat);
		coulant.setProveidor(pv3);
		coulant.setTipus(Tipus.VENDIBLE);
		coulant.afegirComponent(chocolate, 100);
		coulant.afegirComponent(farina, 100);
		coulant.afegirComponent(sucre, 40);
		coulant.setStock(20);
		
		mgz.add(coulant);
		
		//clients
		Client c1 = new Client("La Canasta", 39.1174353, -5.7933869);
		Client c2 = new Client("Baires", 41.5442476, 2.0604163);
		Client c3 = new Client("Pierre Herme", 48.8513876, 2.3304912);
		Client c4 = new Client("Aux Pains de Papy", 51.5293753, -0.1903852);
		Client c5 = new Client("La Santiaguesa", 40.9284811, -5.2618384);
		c1.setCIF("47896532G");
		c2.setCIF("47894532A");
		c3.setCIF("47896532L");
		c4.setCIF("47296532F");
		c5.setCIF("47896565J");
		
		c1.setDireccio("Calle de la huerta");
		c2.setDireccio("Calle de la huerta");
		c3.setDireccio("Calle de la huerta");
		c4.setDireccio("Calle de la huerta");
		c5.setDireccio("Calle de la huerta");
		
		c1.setPoblacio("Sabadell");
		c2.setPoblacio("Sabadell");
		c3.setPoblacio("Sabadell");
		c4.setPoblacio("Sabadell");
		c5.setPoblacio("Sabadell");
		
		
		
		mgz.getClients().add(c1);
		mgz.getClients().add(c2);
		mgz.getClients().add(c3);
		mgz.getClients().add(c4);
		mgz.getClients().add(c5);
		
		Comanda m1 = new Comanda(c1);
		m1.getLinies().add(new ComandaLinia (pliv,100,20));
		m1.getLinies().add(new ComandaLinia(pllim,40,12));
		mgz.getComandes().add(m1);

		m1 = new Comanda(c1);
		m1.getLinies().add(new ComandaLinia (pllim,20,15));
		m1.getLinies().add(new ComandaLinia(pllim,4,0));
		mgz.getComandes().add(m1);
		
		m1 = new Comanda(c1);
		m1.getLinies().add(new ComandaLinia (pliv,50,18));
		mgz.getComandes().add(m1);

		m1 = new Comanda(c2);
		m1.getLinies().add(new ComandaLinia (pliv,20,20));
		m1.getLinies().add(new ComandaLinia(pllim,1,0));
		mgz.getComandes().add(m1);
		
	}
	
	//---------------------
	
	public static Magatzem generaMagatzem()
	{
		Magatzem m = new Magatzem(new ArrayList<Producte>(), new ArrayList<Client>(), new ArrayList<Comanda>(), new ArrayList<Proveidor>());
		
		generarDadesBasiques(m);
		
		/*for(Producte p : m.getProductes())
		{
			System.out.println(p.getCodiProducte() + " " + p.getNomProducte() + " " + p.getProveidor().getNomProveidor());
		}*/
		
		
		return m;
	}
}
