package br.edu.usj.engsoft.agenda;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Principal {

	static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

	public static Integer lerInteiro() throws Exception {
		Integer valor = null;
		while (valor == null) {
			try {
				valor = Integer.parseInt(entrada.readLine());
			} catch (NumberFormatException e) {
				System.out.print(">>> Não entendi. Por favor, digite um número inteiro: ");
			}
		}
		return valor;
	}

	public static void main(String[] args) throws Exception {
		Agenda agenda = new Agenda();
		System.out.println("Seja bem vindo à Agenda!");
		while (true) {
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("Menu principal:");
			System.out.println("1 - Mostrar agenda");
			System.out.println("2 - Marcar evento");
			System.out.print(">>> Digite uma opção (deixe em branco para sair): ");
			String opção = entrada.readLine();
			if (opção.isEmpty()) {
				return;
			} else if (opção.equals("1")) {
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("1 - Mostrar agenda:");

				agenda.mostrarAgenda();
			} else if (opção.equals("2")) {
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("2 - Marcar evento:");

				System.out.print("Título: ");
				String título = entrada.readLine();

				System.out.print("Dia início: ");
				Integer diaInício = lerInteiro();
				System.out.print("Mês início: ");
				Integer mêsInício = lerInteiro();
				System.out.print("Ano início: ");
				Integer anoInício = lerInteiro();
				Data dataInício = new Data();
				dataInício.setDia(diaInício);
				dataInício.setMês(mêsInício);
				dataInício.setAno(anoInício);

				System.out.print("Dia fim: ");
				Integer diaFim = lerInteiro();
				System.out.print("Mês fim: ");
				Integer mêsFim = lerInteiro();
				System.out.print("Ano fim: ");
				Integer anoFim = lerInteiro();
				Data dataFim = new Data(diaFim, mêsFim, anoFim);

				Evento e = new Evento(título, dataInício, dataFim);
				if (agenda.adicionarEvento(e)) {
					System.out.println(">>> Evento marcado com sucesso!");
				} else {
					System.out.println(">>> Evento em conflito!");
				}
			} else {
				System.out.println(">>> Hã?! Não entendi...");
			}
		}
	}

}
