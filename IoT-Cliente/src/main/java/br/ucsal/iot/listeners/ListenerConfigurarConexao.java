package br.ucsal.iot.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.ucsal.iot.popups.PopUpConfiguracaoConexao;
import br.ucsal.iot.telas.TelaInicial;

public class ListenerConfigurarConexao implements ActionListener {

	private TelaInicial telaInicial;
	private PopUpConfiguracaoConexao confConect;


	public ListenerConfigurarConexao(TelaInicial telaInicial, PopUpConfiguracaoConexao confConect) {
		this.telaInicial = telaInicial;
		this.confConect = confConect;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		confConect = new PopUpConfiguracaoConexao(telaInicial);
		confConect.campoEndereco.setText("");
		confConect.campoPorta.setText("");
		confConect.setVisible(true);
	}

}
