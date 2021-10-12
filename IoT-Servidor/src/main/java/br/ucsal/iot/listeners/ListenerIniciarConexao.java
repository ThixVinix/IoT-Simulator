package br.ucsal.iot.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

import br.ucsal.iot.audios.InicializadorSom;
import br.ucsal.iot.runners.ThreadConexaoServidor;
import br.ucsal.iot.telas.TelaInicial;
import br.ucsal.iot.utils.TelaUtil;
import br.ucsal.iot.utils.Util;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class ListenerIniciarConexao implements ActionListener {

	private Player player;
	private TelaInicial telaInicial;
	private Musica musica;
	InicializadorSom som = new InicializadorSom("C:\\Users\\tvaso\\IoTSimulator\\IoT-Servidor\\src\\main\\resources\\nightcallLondon.mp3");

	public ListenerIniciarConexao(TelaInicial telaInicial) {
		this.telaInicial = telaInicial;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (Util.isNullOrEmpty(telaInicial.confBean.confConnect.getIp())
				|| Util.isNullOrEmpty(telaInicial.confBean.confConnect.getPorta())) {
			TelaUtil.exibirMensagemInformativa("Configure a conexão do servidor.");
			telaInicial.botaoToggleIniciarConexao.setSelected(false);
			return;
		}

		if (telaInicial.botaoToggleIniciarConexao.isSelected()) {
			telaInicial.botaoToggleIniciarConexao.setText("Encerrar Conexão");
			telaInicial.botaoConfigurarConexao.setEnabled(false);
			musica = new Musica();
			musica.start();
			if (telaInicial.conexaoServidor == null || !telaInicial.conexaoServidor.isAlive()) {
				telaInicial.conexaoServidor = new ThreadConexaoServidor(telaInicial);
				telaInicial.conexaoServidor.start();
			}

		} else {
			telaInicial.botaoToggleIniciarConexao.setText("Iniciar Conexão");
			telaInicial.botaoConfigurarConexao.setEnabled(true);
			player.close();
			musica.interrupt();
			telaInicial.conexaoServidor.interrupt();
		}

	}

	class Musica extends Thread {

		@Override
		public synchronized void run() {
			InputStream input = null;

			try {
//				Random r = new Random();

//				int number = r.nextInt(2);

//				switch (number) {
//				case 0:
				input = this.getClass().getResourceAsStream("/musicas/nightcallLondon.mp3");
//					break;
//				case 1:
//					input = this.getClass().getResourceAsStream("/musicas/cyberpunk20771.mp3");
//					break;
//				case 2:
//					input = this.getClass().getResourceAsStream("/musicas/cyberpunk20772.mp3");
//					break;
//				default:
//					return;
//				}

//				input.reset();
				player = new Player(input);
				player.play();

			} catch (JavaLayerException e) {
				e.printStackTrace();
			}
		}

	}

}
