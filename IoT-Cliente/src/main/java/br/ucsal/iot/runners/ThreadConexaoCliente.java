package br.ucsal.iot.runners;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import br.ucsal.iot.popups.PopUpCarregamento;
import br.ucsal.iot.telas.TelaInicial;
import br.ucsal.iot.utils.TelaUtil;
import br.ucsal.iot.utils.Util;

public class ThreadConexaoCliente extends Thread {

	private int DELAY = 100;

	TelaInicial tela;

	public ThreadConexaoCliente(TelaInicial tela) {
		this.tela = tela;
	}

	@Override
	public synchronized void run() {
		tela.botaoToggleIniciarConexao.setEnabled(false);
		tela.botaoEnviarRegistros.setEnabled(false);
		try {
//			InputStream inputCliente = socket.getInputStream();
			OutputStream outputCliente = tela.socket.getOutputStream();
//			BufferedReader readerCliente = new BufferedReader(new InputStreamReader(inputCliente));
			PrintStream printCliente = new PrintStream(outputCliente);

			if (Util.isNotNullOrEmpty(tela.textoCompletoEncriptado.toString())) {
				printCliente.println(tela.textoCompletoEncriptado.toString().trim());
//					for (DadosLixeira list : tela.dadosList) {
//						printCliente
//								.println(list.getCapacidade() + "\n" + list.getSensorGas() + "\n" + list.getTempo());
//					}
				tela.textoCompletoEncriptado = new StringBuilder();
//					TelaUtil.exibirMensagemInformativa("Registros enviados com sucesso!");
				outputCliente.flush();
				printCliente.flush();
			}

//			tela.socket.close();

			PopUpCarregamento viewCarregamento = new PopUpCarregamento();
			viewCarregamento.initialize();

			int minimum = 0;
			int maximum = 50;
			int value = minimum;

			for (int i = minimum; i < maximum; i++) {
				Thread.sleep(DELAY);
				viewCarregamento.atualizarProgressBar(2);
			}

			viewCarregamento.finalizarPopUp();
//		        PopUpCarregamento.frmCarregamento.dispose();

//			Thread.sleep(6000);
			tela.botaoToggleIniciarConexao.setEnabled(true);
			tela.botaoEnviarRegistros.setEnabled(true);
			
			TelaUtil.exibirMensagemInformativa("Registros enviados com sucesso!");
		} catch (NumberFormatException | IOException | InterruptedException e1) {
			e1.printStackTrace();
			tela.botaoToggleIniciarConexao.setEnabled(true);
			tela.botaoEnviarRegistros.setEnabled(true);

		}
	}
}
