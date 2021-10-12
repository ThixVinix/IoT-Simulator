package br.ucsal.iot.audios;

import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class InicializadorSom extends Thread {

	private String nomeDoAudio;
	private Player player;

	public InicializadorSom(String nomeDoAudio) {
		this.nomeDoAudio = nomeDoAudio;
	}

	@Override
	public synchronized void run() {
		InputStream input = this.getClass().getResourceAsStream(nomeDoAudio);
		try {
			player = new Player(input);
			player.play();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
	}

}
