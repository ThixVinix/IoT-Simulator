package br.ucsal.iot.runners;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import br.ucsal.iot.telas.TelaInicial;

public class ThreadConexaoServidor extends Thread {

	TelaInicial tela;
	private StringBuilder sb = new StringBuilder();

	public ThreadConexaoServidor(TelaInicial tela) {
		this.tela = tela;
	}

	@Override
	public synchronized void run() {

		try {
			tela.socketServidor = tela.servidor.accept();
			tela.inputServidor = tela.socketServidor.getInputStream();
			tela.outputServidor = tela.socketServidor.getOutputStream();
			tela.readerServidor = new BufferedReader(new InputStreamReader(tela.inputServidor));
			tela.printServidor = new PrintStream(tela.outputServidor);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		while (this.isAlive() && !this.isInterrupted()) {
			String mensagem = null;
			try {
				while (tela.readerServidor.ready()) {
					mensagem = tela.readerServidor.readLine();

					sb.append(mensagem + "\n");

					tela.textArea.setText(sb.toString());
					Thread.sleep(100);
					tela.textArea.repaint();
				}

				if (sb.length() != 0) {
					sb = new StringBuilder();
				}

			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
