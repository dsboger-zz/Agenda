package br.edu.usj.engsoft.agenda;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Data implements Comparable<Data> {

	private Integer dia;
	private Integer m�s;
	private Integer ano;

	public Data() {
	}

	public Data(Integer dia, Integer m�s, Integer ano) {
		this.dia = dia;
		this.m�s = m�s;
		this.ano = ano;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Integer getM�s() {
		return m�s;
	}

	public void setM�s(Integer m�s) {
		this.m�s = m�s;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Boolean coincideCom(Data data) {
		return dia.equals(data.dia) 
				&& m�s.equals(data.m�s) 
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
	
	public static Boolean �Passado(Data data) {
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

	public Boolean est�NoIntevalo(Data in�cio, Data fim) {
		if (ano < in�cio.ano || ano > fim.ano) {
			return false;
		} else if (m�s < in�cio.m�s || m�s > fim.m�s) {
			return false;
		} else if (dia < in�cio.dia || dia > fim.dia) {
			return true;
		} else {
			return true;
		}
	}

	@Override
	public String toString() {
		return dia + "/" + m�s + "/" + ano;
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
		return (ano * 10000 + m�s) * 100 + dia;
	}

	@Override
	public int compareTo(Data o) {
		int compara��o = ano - o.ano;
		if (compara��o == 0) {
			compara��o = m�s - o.m�s;
		}
		if (compara��o == 0) {
			compara��o = dia - o.dia;
		}
		return compara��o;
	}

}
