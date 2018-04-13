package br.edu.usj.engsoft.agenda;

public class Evento {

	private String título;
	private Data dataInício;
	private Data dataFim;
	
	public Evento() {
	}
	
	public Evento(String título, Data dataInício, Data dataFim) {
		if (dataInício.compareTo(dataFim) > 0)
			throw new IllegalArgumentException("Data início maior que fim");
		
		this.título = título;
		this.dataInício = dataInício;
		this.dataFim = dataFim;
	}

	public Data getDataFim() {
		return dataFim;
	}

	public void setDataFim(Data dataFim) {
		if (dataInício != null && 
				dataFim.compareTo(dataInício) < 0)
			throw new IllegalArgumentException("Data fim menor que início");
		this.dataFim = dataFim;
	}

	public Data getDataInício() {
		return dataInício;
	}

	public void setDataInício(Data dataInício) {
		if (dataFim != null &&
				dataInício.compareTo(dataFim) > 0)
			throw new IllegalArgumentException("Data início maior que fim");
		this.dataInício = dataInício;
	}

	public String getTítulo() {
		return título;
	}

	public void setTítulo(String título) {
		this.título = título;
	}

	public Boolean conflitaCom(Evento outroEvento) {
		return dataInício.compareTo(outroEvento.dataFim) <= 0 
				&& dataFim.compareTo(outroEvento.dataInício) >= 0;
	}

}
