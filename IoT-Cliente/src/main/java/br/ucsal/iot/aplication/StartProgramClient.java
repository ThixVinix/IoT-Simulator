package br.ucsal.iot.aplication;

import java.awt.EventQueue;

import br.ucsal.iot.runners.RunnableAplicacao;

class StartProgramClient {

	private StartProgramClient() {
	}

	public static void main(String[] args) {
		iniciarAplicacao();
	}

	private static synchronized void iniciarAplicacao() {
		EventQueue.invokeLater(new RunnableAplicacao());
	}

}
