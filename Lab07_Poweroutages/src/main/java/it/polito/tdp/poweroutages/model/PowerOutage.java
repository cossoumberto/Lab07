package it.polito.tdp.poweroutages.model;

import java.time.LocalDateTime;

public class PowerOutage {
	
	private int id;
	private int colpiti;
	private LocalDateTime dataInizio;
	private LocalDateTime dataFine;
	
	public PowerOutage(int id, int colpiti, LocalDateTime dataInizio, LocalDateTime dataFine) {
		super();
		this.id = id;
		this.colpiti = colpiti;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getColpiti() {
		return colpiti;
	}

	public void setColpiti(int colpiti) {
		this.colpiti = colpiti;
	}

	public LocalDateTime getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDateTime dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDateTime getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDateTime dataFine) {
		this.dataFine = dataFine;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PowerOutage other = (PowerOutage) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return dataInizio + " " + dataFine + " " + (dataFine.minusHours(dataInizio.getHour())).getHour() + " "+ colpiti;
	}

	public int getDurata() {
		return (dataFine.minusHours(dataInizio.getHour())).getHour();
	}
	
	
}
