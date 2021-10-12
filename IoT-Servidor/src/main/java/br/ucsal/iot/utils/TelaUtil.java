package br.ucsal.iot.utils;

import javax.swing.JOptionPane;

public class TelaUtil {

	public static void exibirMensagemInformativa(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Informação", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void exibirMensagemErro(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
	}

	public static void exibirMensagemAlerta(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Atenção", JOptionPane.WARNING_MESSAGE);
	}

}
