package br.ucsal.iot.popups;

import java.awt.Dialog.ModalExclusionType;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Font;

public class PopUpCarregamento {

	public static JFrame frmCarregamento;
	public static JProgressBar progressBar;
	private static EventQueue eventQueue;
	private static int valorAtual;
//	protected Thread threadPrincipal = programStart.currentThread();

	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize() {
		valorAtual = 0;
		frmCarregamento = new JFrame();
		frmCarregamento.setBackground(Color.BLACK);
		frmCarregamento.getContentPane().setBackground(Color.BLACK);
		frmCarregamento.setForeground(Color.BLACK);
		frmCarregamento.getContentPane().setForeground(Color.BLACK);
		frmCarregamento.setResizable(false);
		frmCarregamento.setTitle("Carregando");
		frmCarregamento.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frmCarregamento.setBounds(100, 100, 459, 127);
		frmCarregamento.setLocationRelativeTo(null);
		frmCarregamento.getContentPane().setLayout(null);

	    progressBar = new JProgressBar();
	    progressBar.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    progressBar.setBackground(Color.LIGHT_GRAY);
	    progressBar.setStringPainted(true);
	    progressBar.setBorderPainted(true);
	    progressBar.setDoubleBuffered(true);
	    progressBar.setForeground(new Color(50, 205, 50));
		progressBar.setBounds(10, 11, 424, 69);
		frmCarregamento.getContentPane().add(progressBar);
		frmCarregamento.setVisible(true);

	}
	
	public void finalizarPopUp() {
		frmCarregamento.setVisible(false);
		frmCarregamento.dispose();
	}
	
	public void atualizarProgressBar(int value) {
		valorAtual = valorAtual + value;
		progressBar.setValue(valorAtual);
	}

	public static EventQueue getEventQueue() {
		return eventQueue;
	}

	public static void setEventQueue(EventQueue eventQueue) {
		PopUpCarregamento.eventQueue = eventQueue;
	}
	
}
