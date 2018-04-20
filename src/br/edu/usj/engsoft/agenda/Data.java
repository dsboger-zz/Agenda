package br.edu.usj.engsoft.agenda;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Data implements Comparable<Data> {

	private Integer dia;
	private Integer mês;
	private Integer ano;

	public Data() {
	}

	public Data(Integer dia, Integer mês, Integer ano) {
		this.dia = dia;
		this.mês = mês;
		this.ano = ano;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Integer getMês() {
		return mês;
	}

	public void setMês(Integer mês) {
		this.mês = mês;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Boolean coincideCom(Data data) {
		return dia.equals(data.dia) 
				&& mês.equals(data.mês) 
				&& ano.equals(data.ano);
	}
	
	public static boolean dataValida(Data data) {
		String dt = data.toString();
		DateFormat dta = new SimpleDateFormat ("dd/MM/yyyy");
		dta.setLenient (false); 
		try {
		dta.parse (dt);
		   return true;
		} catch (ParseException ex) {
		   return false;
		}
		
	}
	
	public static Boolean éPassado(Data data) {
		Date dataAtual = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date data2 = null;
		try {
			data2 = format.parse(data.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dataAtual.after(data2);
	}

	public Boolean estáNoIntevalo(Data início, Data fim) {
		if (ano < início.ano || ano > fim.ano) {
			return false;
		} else if (mês < início.mês || mês > fim.mês) {
			return false;
		} else if (dia < início.dia || dia > fim.dia) {
			return true;
		} else {
			return true;
		}
	}

	@Override
	public String toString() {
		return dia + "/" + mês + "/" + ano;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Data)) {
			return false;
		}
		return coincideCom((Data) obj);
	}

	@Override
	public int hashCode() {
		return (ano * 10000 + mês) * 100 + dia;
	}

	@Override
	public int compareTo(Data o) {
		int comparação = ano - o.ano;
		if (comparação == 0) {
			comparação = mês - o.mês;
		}
		if (comparação == 0) {
			comparação = dia - o.dia;
		}
		return comparação;
	}

}
