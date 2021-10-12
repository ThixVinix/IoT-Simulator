package br.ucsal.iot.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

import br.ucsal.iot.graficos.Grafico;
import br.ucsal.iot.model.DadosLixeira;
import br.ucsal.iot.telas.TelaInicial;
import br.ucsal.iot.utils.CryptographyUtil;
import br.ucsal.iot.utils.DadosLixeiraUtil;
import br.ucsal.iot.utils.TelaUtil;
import br.ucsal.iot.utils.Util;

public class ListenerGerarGrafico implements ActionListener {

	private TelaInicial tela;

	public ListenerGerarGrafico(TelaInicial tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {

		if (Util.isNullOrEmpty(tela.confBean.confConnect.getIp())
				|| Util.isNullOrEmpty(tela.confBean.confConnect.getPorta())) {
			TelaUtil.exibirMensagemInformativa("Configure a conexão do servidor.");
			return;
		}

		if (!tela.botaoToggleIniciarConexao.isSelected()) {
			TelaUtil.exibirMensagemInformativa("Inicie a conexão do servidor.");
			return;
		}

		if (Util.isNullOrEmpty(tela.textArea.getText())) {
			TelaUtil.exibirMensagemInformativa("O cliente não enviou nenhum registro.");
			return;
		}

		String textoDados = tela.textArea.getText();
		StringTokenizer st = new StringTokenizer(textoDados, "\n");

		StringBuilder sb = new StringBuilder();

		while (st.hasMoreTokens()) {
			String line = st.nextToken();

			try {
				String registroDecriptografado = CryptographyUtil.decrypt(line);
				sb.append(registroDecriptografado + "\n");
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		List<DadosLixeira> dadosList = new ArrayList<>();

		st = new StringTokenizer(sb.toString(), "\n");

		List<Integer> listaCapacidade = new ArrayList<>();
		List<Integer> listaGas = new ArrayList<>();
		List<Integer> listaTemperatura = new ArrayList<>();
		List<Integer> listaMagnetismo = new ArrayList<>();
		List<Integer> listaPeriodo = new ArrayList<>();

		while (st.hasMoreTokens()) {
			String line = st.nextToken();
			Integer c = DadosLixeiraUtil.capturarCapacidades(line);
			Integer g = DadosLixeiraUtil.capturarNiveisGas(line);
			Integer t = DadosLixeiraUtil.capturarTemperaturas(line);
			Integer m = DadosLixeiraUtil.capturarNiveisMagnetismo(line);
			Integer p = DadosLixeiraUtil.capturarPeriodos(line);

			if (Util.isNotNullOrEmpty(c))
				listaCapacidade.add(c);

			if (Util.isNotNullOrEmpty(g))
				listaGas.add(g);

			if (Util.isNotNullOrEmpty(t))
				listaTemperatura.add(t);

			if (Util.isNotNullOrEmpty(m))
				listaMagnetismo.add(m);

			if (Util.isNotNullOrEmpty(p))
				listaPeriodo.add(p);
		}

		for (int i = 0; i < listaPeriodo.size(); i++) {
			tela.dadosLixeira = new DadosLixeira(listaCapacidade.get(i), listaGas.get(i), listaTemperatura.get(i),
					listaMagnetismo.get(i), listaPeriodo.get(i));
			dadosList.add(tela.dadosLixeira);
		}

		Grafico grafico = new Grafico(dadosList);

		grafico.criarGraficoLinha();

//		simularGeracaoGraficoIoT();

	}

	public void simularGeracaoGraficoIoT() {
		Random random = new Random();
		Random random2 = new Random();
		List<Integer> resultsValuesCapacity = new ArrayList<>();
		List<Integer> timeMillis = new ArrayList<>();
		List<Integer> resultsValuesGas = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			Integer value = random.nextInt(334);
			Integer value2 = random.nextInt(100);
			resultsValuesCapacity.add(value);
			resultsValuesGas.add(value2);
			timeMillis.add(i);
		}

//		System.out.println("Lista dos valores das capacidades: ");
//		for (Integer value : resultsValuesCapacity) {
//			System.out.println(value);
//		}

//		List<byte[]> valoresEncriptados = new ArrayList<>();

//		System.out.println("");
//		for (Integer value : resultsValuesCapacity) {
//			StringBuilder sb = new StringBuilder();
//			try {

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

//		List<Integer> valoresDecriptados = new ArrayList<>();

//		for (byte[] valorAtual : valoresEncriptados) {
//
//			try {
//				String valorDecriptado = CryptographyUtil.decrypt(valorAtual);
//				valoresDecriptados.add(Integer.parseInt(valorDecriptado));
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//		}

//		System.out.println("\nLista dos valores das capacidades decriptados: ");
//		for (Integer valueDecrypt : valoresDecriptados) {
//			System.out.println(valueDecrypt);
//		}

		Grafico grafico = new Grafico(resultsValuesCapacity, resultsValuesGas, timeMillis);

		grafico.criarGraficoLinhaExemplo();
	}

}