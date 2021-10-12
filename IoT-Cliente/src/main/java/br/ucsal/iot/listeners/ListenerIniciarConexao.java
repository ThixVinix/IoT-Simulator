package br.ucsal.iot.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

import br.ucsal.iot.telas.TelaInicial;
import br.ucsal.iot.utils.TelaUtil;
import br.ucsal.iot.utils.Util;

public class ListenerIniciarConexao implements ActionListener {

	private TelaInicial telaInicial;

	public ListenerIniciarConexao(TelaInicial telaInicial) {
		this.telaInicial = telaInicial;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (Util.isNullOrEmpty(telaInicial.confBean.confConnect.getIp())
				|| Util.isNullOrEmpty(telaInicial.confBean.confConnect.getPorta())) {
			telaInicial.botaoToggleIniciarConexao.setSelected(false);
			TelaUtil.exibirMensagemInformativa("Configure a conexão para o servidor.");
			return;
		}

		if (telaInicial.botaoToggleIniciarConexao.isSelected()) {
			telaInicial.botaoToggleIniciarConexao.setText("Encerrar Conexão");
			telaInicial.botaoConfigurarConexao.setEnabled(false);
			telaInicial.botaoEnviarRegistros.setEnabled(true);
			try {
				telaInicial.socket = new Socket(telaInicial.confBean.confConnect.getIp(),
						Integer.parseInt(telaInicial.confBean.confConnect.getPorta()));
			} catch (NumberFormatException | IOException e1) {
				e1.printStackTrace();
			}
		} else {
			telaInicial.botaoToggleIniciarConexao.setText("Conectar");
			telaInicial.botaoConfigurarConexao.setEnabled(true);
			telaInicial.botaoEnviarRegistros.setEnabled(false);
//			try {
//				telaInicial.socket.close();
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
		}

	}

}
