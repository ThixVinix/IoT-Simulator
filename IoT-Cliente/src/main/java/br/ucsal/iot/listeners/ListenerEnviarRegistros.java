package br.ucsal.iot.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import br.ucsal.iot.runners.ThreadConexaoCliente;
import br.ucsal.iot.telas.TelaInicial;
import br.ucsal.iot.utils.CryptographyUtil;
import br.ucsal.iot.utils.DadosLixeiraUtil;
import br.ucsal.iot.utils.TelaUtil;
import br.ucsal.iot.utils.Util;

public class ListenerEnviarRegistros implements ActionListener {

	private TelaInicial tela;

	public ListenerEnviarRegistros(TelaInicial tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {

		if (Util.isNullOrEmpty(tela.confBean.confConnect.getIp())
				&& Util.isNullOrEmpty(tela.confBean.confConnect.getPorta())) {
			TelaUtil.exibirMensagemInformativa("Configure a conexão com o servidor.");
			return;
		}

		if (!tela.botaoToggleIniciarConexao.isSelected()) {
			TelaUtil.exibirMensagemInformativa("Inicie a conexão com o servidor.");
			return;
		}

		if (tela.textArea.getText() == null || tela.textArea.getText().trim().isEmpty()) {
			TelaUtil.exibirMensagemInformativa("Registre os dados coletados do arduíno para enviá-los ao servidor.");
			return;
		}

		tela.textoCompletoEncriptado = new StringBuilder();

		List<String> listCapacidade = new ArrayList<>();
		List<String> listGas = new ArrayList<>();
		List<String> listTemperatura = new ArrayList<>();
		List<String> listMagnetismo = new ArrayList<>();
		List<String> listPeriodo = new ArrayList<>();

		String textoDados = tela.textArea.getText();
		StringTokenizer st = new StringTokenizer(textoDados, "\n");

		while (st.hasMoreTokens()) {
			String line = st.nextToken();
			String capacidadeCapturada = DadosLixeiraUtil.capturarCapacidades(line);

			if (Util.isNotNullOrEmpty(capacidadeCapturada))
				listCapacidade.add(capacidadeCapturada);

			String nivelGasCapturado = DadosLixeiraUtil.capturarNiveisGas(line);

			if (Util.isNotNullOrEmpty(nivelGasCapturado))
				listGas.add(nivelGasCapturado);

			String temperaturaCapturada = DadosLixeiraUtil.capturarTemperaturas(line);

			if (Util.isNotNullOrEmpty(temperaturaCapturada))
				listTemperatura.add(temperaturaCapturada);

			String nivelMagnetismoCapturado = DadosLixeiraUtil.capturarNiveisMagnetismo(line);

			if (Util.isNotNullOrEmpty(nivelMagnetismoCapturado))
				listMagnetismo.add(nivelMagnetismoCapturado);

			String periodoCapturado = DadosLixeiraUtil.capturarPeriodos(line);

			if (Util.isNotNullOrEmpty(periodoCapturado))
				listPeriodo.add(periodoCapturado);

		}

		if (listCapacidade.isEmpty() && listGas.isEmpty() && listPeriodo.isEmpty()) {
			TelaUtil.exibirMensagemAlerta("Não existem dados para enviar ao servidor.");
			return;
		} else if (listCapacidade.size() < 2 || listGas.size() < 2 || listTemperatura.size() < 2
				|| listMagnetismo.size() < 2 || listPeriodo.size() < 2) {
			TelaUtil.exibirMensagemAlerta("Dados insuficientes para enviar ao servidor.");
			return;
		} else if (listCapacidade.size() != listGas.size() || listCapacidade.size() != listPeriodo.size()
				|| listGas.size() != listPeriodo.size() || listTemperatura.size() != listCapacidade.size()
				|| listTemperatura.size() != listGas.size() || listTemperatura.size() != listPeriodo.size()
				|| listTemperatura.size() != listMagnetismo.size() || listMagnetismo.size() != listCapacidade.size()
				|| listMagnetismo.size() != listGas.size() || listMagnetismo.size() != listPeriodo.size()) {
			TelaUtil.exibirMensagemAlerta("Os dados necessários para enviar ao servidor não estão sincronizados.");
			return;
		}

		tela.dadosList = new ArrayList<>();

		for (int i = 0; i < listPeriodo.size(); i++) {
			StringBuilder sbc = new StringBuilder();
			StringBuilder sbg = new StringBuilder();
			StringBuilder sbt = new StringBuilder();
			StringBuilder sbm = new StringBuilder();
			StringBuilder sbp = new StringBuilder();

			try {

				String capacidadeEncriptada = CryptographyUtil.encriptar(listCapacidade.get(i));
				sbc.append(capacidadeEncriptada);

				String gasEncriptado = CryptographyUtil.encriptar(listGas.get(i));
				sbg.append(gasEncriptado);

				String temperaturaEncriptada = CryptographyUtil.encriptar(listTemperatura.get(i));
				sbt.append(temperaturaEncriptada);

				String magnetismoEncriptado = CryptographyUtil.encriptar(listMagnetismo.get(i));
				sbm.append(magnetismoEncriptado);

				String periodoEncriptado = CryptographyUtil.encriptar(listPeriodo.get(i));
				sbp.append(periodoEncriptado);

				tela.textoCompletoEncriptado.append(sbc + "\n" + sbg + "\n" + sbt + "\n" + sbm + "\n" + sbp + "\n");

			} catch (Exception e1) {
				System.out.println("Erro ao encriptar o texto: " + e1.toString());
				e1.printStackTrace();
			}
		}

		if (tela.socket.isClosed()) {
			try {
				tela.socket = new Socket(tela.confBean.confConnect.getIp(),
						Integer.parseInt(tela.confBean.confConnect.getPorta()));
			} catch (NumberFormatException | IOException e1) {
				e1.printStackTrace();
			}
		}

		tela.conexaoCliente = new ThreadConexaoCliente(tela);
		tela.conexaoCliente.start();

//		tela.textArea.setText("");
//		tela.textArea.repaint();

	}

//	public void simularGeracaoGraficoIoT() {
//		Random random = new Random();
//		List<Integer> resultsValuesCapacity = new ArrayList<>();
//		List<Integer> timeMillis = new ArrayList<>();
//
//		for (int i = 0; i < 50; i++) {
//			Integer value = random.nextInt(100);
//			resultsValuesCapacity.add(value);
//			timeMillis.add(i);
//		}
//
//		System.out.println("Lista dos valores das capacidades: ");
//		for (Integer value : resultsValuesCapacity) {
//			System.out.println(value);
//		}
//
//		List<byte[]> valoresEncriptados = new ArrayList<>();
//
//		System.out.println("");
//		for (Integer value : resultsValuesCapacity) {
////			StringBuilder sb = new StringBuilder();
//			try {
//
//				byte[] textoencriptado = CryptographyUtil.encrypt(value.toString());
//				for (int i = 0; i < textoencriptado.length; i++) {
//					if (i == 0) {
//						System.out.print("Valor da capacidade encriptado: ");
//					}
//					System.out.print(textoencriptado[i]);
//				}
//				System.out.println("");
//				valoresEncriptados.add(textoencriptado);
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//		}
//
//		List<Integer> valoresDecriptados = new ArrayList<>();
//
//		for (byte[] valorAtual : valoresEncriptados) {
//
//			try {
//				String valorDecriptado = CryptographyUtil.decrypt(valorAtual);
//				valoresDecriptados.add(Integer.parseInt(valorDecriptado));
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//		}
//
//		System.out.println("\nLista dos valores das capacidades decriptados: ");
//		for (Integer valueDecrypt : valoresDecriptados) {
//			System.out.println(valueDecrypt);
//		}
//
//		Grafico grafico = new Grafico(resultsValuesCapacity, timeMillis);
//
//		grafico.criarGraficoLinha();
//	}

}