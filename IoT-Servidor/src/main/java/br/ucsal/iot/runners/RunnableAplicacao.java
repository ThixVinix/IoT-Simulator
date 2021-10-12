package br.ucsal.iot.runners;

import br.ucsal.iot.telas.TelaLogin;
import br.ucsal.iot.utils.LayoutPersonalizado;

public class RunnableAplicacao implements Runnable {

	@Override
	public void run() {
		try {
			LayoutPersonalizado.determinarLayoutPersonalizado("Nimbus");
			TelaLogin window = new TelaLogin();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
