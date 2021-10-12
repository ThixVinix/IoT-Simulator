package br.ucsal.iot.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.ucsal.iot.popups.PopUpConfiguracaoConexao;
import br.ucsal.iot.telas.TelaInicial;

public class ListenerCancelConfiguration implements ActionListener {

	private TelaInicial tela;
	private PopUpConfiguracaoConexao confConect;

	public ListenerCancelConfiguration(TelaInicial tela, PopUpConfiguracaoConexao confConect) {
		this.tela = tela;
		this.confConect = confConect;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		confConect.campoEndereco.setText("");
		confConect.campoPorta.setText("");
		confConect.setVisible(false);
		confConect.repaint();

	}

}
