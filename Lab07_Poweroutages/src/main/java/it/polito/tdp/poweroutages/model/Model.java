package it.polito.tdp.poweroutages.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.poweroutages.DAO.PowerOutageDAO;

public class Model {
	
	private PowerOutageDAO podao;
	 List<PowerOutage> poListNerc;
	private List<PowerOutage> soluzione;
	private int colpitiMax;
	private int oreTot;
	
	public Model() {
		podao = new PowerOutageDAO();
	}
	
	public List<Nerc> getNercList() {
		return podao.getNercList();
	}
	
	public int getColpitiMax() {
		return this.colpitiMax;
	}
	
	public int getOreTot() {
		return this.oreTot;
	}
	
	public List<PowerOutage> trova(Nerc nerc, int x, int y) {
		List<PowerOutage> parziale = new ArrayList<>();
		soluzione = new ArrayList<>();
		colpitiMax = 0;
		oreTot = 0;
		poListNerc = podao.getPowerOutageforNerc(nerc);
		cerca(parziale, 0, 0, 0, x-1, y);
		return this.soluzione;
	}
	
	private void cerca(List<PowerOutage> parziale, int livello, int colpiti, int sommaOre, int x, int y) {
		//casi terminali
		int differenzaAnni = -1;
		if(parziale.size()>0)
			differenzaAnni = parziale.get(parziale.size()-1).getDataFine().getYear() - parziale.get(0).getDataInizio().getYear();
		if(x<differenzaAnni)
			return;
		if(y<sommaOre)
			return;
		if(colpiti > colpitiMax) {
				soluzione = new ArrayList<>(parziale);
				colpitiMax = colpiti;
				oreTot = sommaOre;
		}
		if(livello>poListNerc.size()-1)
			return;
		parziale.add(poListNerc.get(livello));
		cerca(parziale, livello+1, colpiti+poListNerc.get(livello).getColpiti(), sommaOre+poListNerc.get(livello).getDurata(), x, y);
		parziale.remove(parziale.size()-1);
		 
		cerca(parziale, livello+1, colpiti, sommaOre, x, y);
	}

}
