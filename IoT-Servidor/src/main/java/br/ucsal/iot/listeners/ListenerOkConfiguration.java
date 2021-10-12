package br.ucsal.iot.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;

import br.ucsal.iot.enums.ConfiguracaoConexaoEnum;
import br.ucsal.iot.popups.PopUpConfiguracaoConexao;
import br.ucsal.iot.telas.TelaInicial;
import br.ucsal.iot.utils.TelaUtil;

public class ListenerOkConfiguration implements ActionListener {

	private TelaInicial tela;
	private PopUpConfiguracaoConexao confConect;

	public ListenerOkConfiguration(TelaInicial tela, PopUpConfiguracaoConexao confConect) {
		this.tela = tela;
		this.confConect = confConect;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		ConfiguracaoConexaoEnum result = tela.confBean
				.validarCamposConfiguracaoConexao(confConect.campoEndereco.getText(), confConect.campoPorta.getText());

		switch (result) {
		case IP_OBRIGATORIO:
			TelaUtil.exibirMensagemAlerta(ConfiguracaoConexaoEnum.IP_OBRIGATORIO.getDescricao());
			return;
		case IP_INVALIDO:
			TelaUtil.exibirMensagemErro(ConfiguracaoConexaoEnum.IP_INVALIDO.getDescricao());
			return;
		case PORTA_OBRIGATORIA:
			TelaUtil.exibirMensagemAlerta(ConfiguracaoConexaoEnum.PORTA_OBRIGATORIA.getDescricao());
			return;
		case PORTA_INVALIDA:
			TelaUtil.exibirMensagemErro(ConfiguracaoConexaoEnum.PORTA_INVALIDA.getDescricao());
			return;
		case SUCESSO:
			TelaUtil.exibirMensagemInformativa(ConfiguracaoConexaoEnum.SUCESSO.getDescricao());
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + result);
		}

		tela.confBean.confConnect.setIp(confConect.campoEndereco.getText().trim());

		tela.confBean.confConnect.setPorta(confConect.campoPorta.getText().trim());

		tela.list.removeAll();
		tela.list.add("IP: " + tela.confBean.confConnect.getIp());
		tela.list.add("Porta: " + tela.confBean.confConnect.getPorta());

		try {
			tela.servidor = new ServerSocket(Integer.parseInt(tela.confBean.confConnect.getPorta().trim()));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		tela.list.repaint();
		tela.list.setVisible(true);
		tela.labelConfiguracaoAtual.setVisible(true);

		confConect.setVisible(false);

		confConect.campoEndereco.setText("");
		confConect.campoPorta.setText("");

		confConect.repaint();
	}

}
