package br.edu.usj.engsoft.agenda;

import java.util.ArrayList;

public class Agenda {
	
	private ArrayList<Evento> listaDeEventos = new ArrayList<>();
	
	public Boolean existeConflitoCom(Evento e) {
		for (Evento eventoMarcado : listaDeEventos)
			if (e.conflitaCom(eventoMarcado))
				return true;
		return false;
	}
	
	public Boolean adicionarEvento(Evento e) {
		if(existeConflitoCom(e)) {
			return !existeConflitoCom(e);
		}
		listaDeEventos.add(e);
		return existeConflitoCom(e);
	}
	
	public void mostrarAgenda() {
		for (int i = 0; i < listaDeEventos.size(); i++) {
			Evento e = listaDeEventos.get(i);
			System.out.println((i + 1) + ") " + e.getTítulo());
			System.out.println("Início: \t" + e.getDataInício());
			System.out.println("Fim: \t\t" + e.getDataFim());
		}
		System.out.println();
		System.out.println("Total de eventos: " + listaDeEventos.size());
	}

}
