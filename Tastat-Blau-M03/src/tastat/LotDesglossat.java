package tastat;

import java.util.Calendar;
import java.util.Date;

public class LotDesglossat implements Comparable<LotDesglossat> {
	int quantitat = 1;
	Date dataEntrada = new Date();
	Date dataCaducitat = null;
	int lot;
	
	LotDesglossat(int qLot, int duracio, int quantitat){
		lot = qLot;
		dataEntrada = new Date();
		this.quantitat = quantitat;
		
		if (duracio>0)	{
	      Calendar calendar = Calendar.getInstance();
	      calendar.setTime(dataEntrada); 
	      calendar.add(Calendar.DAY_OF_YEAR, duracio);  
	      dataCaducitat = calendar.getTime();
		}
	}
	
	LotDesglossat(int qLot, Date dataCaducitat, int quantitat){
		lot = qLot;
		dataEntrada = new Date();
		this.dataCaducitat = dataCaducitat;
		this.quantitat = quantitat;
	}

	
	public Date getDataCaducitat() {
		return dataCaducitat;
	};
	
	public Date getDataEntrada() {
		return dataEntrada;
	};
	
	public int getQuantitat() {
		return quantitat;
	}
	
	public void setQuantitat (int q) {
		quantitat = q;
	}
	
	@Override
	public String toString() {
		return ("Lot: " + lot + "\tQuantitat: " + quantitat + "\tData Entrada: " + dataEntrada + "\tData Caducitat: " + dataCaducitat);
	}

	@Override	
	public int compareTo(LotDesglossat l) {
		if (this.getDataCaducitat()==null && l.getDataCaducitat() == null) 
			return (this.getDataEntrada().compareTo(l.getDataEntrada()));
		
		if (this.getDataCaducitat()!=null && l.getDataCaducitat() != null) 
			return (this.getDataCaducitat().compareTo(l.getDataCaducitat()));
		
		if (this.getDataCaducitat() == null) 
				return -1;
		
		return 1;

	}
	
	//AÑADIDO
	public int getIdLot()
	{
		return lot;
	}
}