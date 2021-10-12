package br.ucsal.iot.aplication;

import java.awt.EventQueue;

import br.ucsal.iot.runners.RunnableAplicacao;

class StartProgramServer {

	private StartProgramServer() {
	}

	public static void main(String[] args) {
		iniciarAplicacao();
	}

	private static synchronized void iniciarAplicacao() {
		EventQueue.invokeLater(new RunnableAplicacao());
	}

}
