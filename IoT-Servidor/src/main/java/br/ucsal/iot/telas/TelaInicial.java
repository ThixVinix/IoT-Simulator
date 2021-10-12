package br.ucsal.iot.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.WindowConstants;

import br.ucsal.iot.bean.ConfiguracaoConexaoBean;
import br.ucsal.iot.listeners.ListenerConfigurarConexao;
import br.ucsal.iot.listeners.ListenerGerarGrafico;
import br.ucsal.iot.listeners.ListenerIniciarConexao;
import br.ucsal.iot.model.DadosLixeira;
import br.ucsal.iot.popups.PopUpConfiguracaoConexao;
import br.ucsal.iot.runners.ThreadConexaoServidor;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class TelaInicial {

	public JFrame frame;
	public JLabel labelConfiguracaoAtual;
	public ConfiguracaoConexaoBean confBean;
	public PopUpConfiguracaoConexao confConect;
	public JComboBox<String> comboBoxGrafico;
	public JButton botaoGerarGrafico;
	public TextArea textArea;
	public JToggleButton botaoToggleIniciarConexao;
	public JButton botaoConfigurarConexao;
	public List list;
	public ThreadConexaoServidor conexaoServidor;
	public ServerSocket servidor;
	public Socket socketServidor;
	public InputStream inputServidor;
	public OutputStream outputServidor;
	public BufferedReader readerServidor;
	public PrintStream printServidor;
	public DadosLixeira dadosLixeira;
	private JLabel lblNewLabel;

	/**
	 * 
	 * @wbp.parser.entryPoint
	 */
	void initialize() {
		confBean = new ConfiguracaoConexaoBean();
		confConect = new PopUpConfiguracaoConexao(this);
		dadosLixeira = new DadosLixeira();

		createWindow();
		frame.getContentPane().setLayout(null);
		createLabels();
		createTextsArea();
		createButtons();
		createCombosBox();
		createTextsPane();
		frame.setVisible(true);
	}

	private void createWindow() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 204, 102));
		frame.setTitle("Servidor");
		frame.setResizable(false);
		frame.setBounds(100, 100, 826, 620);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}

	private void createLabels() {

	}

	private void createTextsArea() {
		createTextAreaConteudo();
		createTextAreaEgg();
	}

	private void createButtons() {
		createBotaoGerarGrafico();
		createBotaoConfigurarConexao();
		createBotaoIniciarConexao();
	}

	private void createCombosBox() {
		createComboBoxGrafico();
	}

	private void createBotaoGerarGrafico() {
		JButton botaoGerarGrafico = new JButton("Exibir gr\u00E1fico");
		botaoGerarGrafico.setForeground(Color.WHITE);
		botaoGerarGrafico.setBackground(new Color(0, 128, 0));

		botaoGerarGrafico.setBounds(97, 471, 126, 23);
		botaoGerarGrafico.addActionListener(new ListenerGerarGrafico(this));
		botaoGerarGrafico.setEnabled(true);
		frame.getContentPane().add(botaoGerarGrafico);
	}

	private void createBotaoIniciarConexao() {
		botaoToggleIniciarConexao = new JToggleButton("Iniciar Conexão");
		botaoToggleIniciarConexao.setForeground(Color.WHITE);
		botaoToggleIniciarConexao.setBackground(new Color(0, 128, 0));
		botaoToggleIniciarConexao.addActionListener(new ListenerIniciarConexao(this));
		botaoToggleIniciarConexao.setBounds(169, 71, 149, 23);
		frame.getContentPane().add(botaoToggleIniciarConexao);
	}

	private void createBotaoConfigurarConexao() {
		botaoConfigurarConexao = new JButton("Configurar conex\u00E3o");
		botaoConfigurarConexao.setForeground(Color.WHITE);
		botaoConfigurarConexao.setBackground(new Color(0, 128, 0));
		botaoConfigurarConexao.addActionListener(new ListenerConfigurarConexao(this, confConect));
		botaoConfigurarConexao.setBounds(10, 71, 149, 23);
		frame.getContentPane().add(botaoConfigurarConexao);
	}

	private void createTextsPane() {

		list = new List();
		list.setForeground(Color.WHITE);
		list.setBackground(new Color(0, 128, 0));
//		list.addActionListener(new ListenerListarConfConnection(this));
		list.setVisible(false);
		Font z = new Font("TimesRoman", Font.BOLD, 12);
		list.setFont(z);
		list.setBounds(10, 125, 308, 38);
		frame.getContentPane().add(list);

		 labelConfiguracaoAtual = new JLabel("Configura\u00E7\u00E3o atual do servidor:");
		 labelConfiguracaoAtual.setFont(new Font("Tahoma", Font.BOLD, 11));
		 labelConfiguracaoAtual.setBackground(Color.BLACK);
		 labelConfiguracaoAtual.setForeground(Color.WHITE);
		labelConfiguracaoAtual.setBounds(10, 105, 213, 14);
		labelConfiguracaoAtual.setVisible(false);
		frame.getContentPane().add(labelConfiguracaoAtual);
		{
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/ucsal/iot/telas/crop.jpg")));
			lblNewLabel.setBounds(0, 0, 820, 591);
			frame.getContentPane().add(lblNewLabel);
		}

	}

	private void createComboBoxGrafico() {

	}

	private void createTextAreaConteudo() {
		textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setForeground(Color.GREEN);
		textArea.setBackground(Color.BLACK);
		textArea.setBounds(357, 0, 453, 581);
		frame.getContentPane().add(textArea);
	}

	private void createTextAreaEgg() {
	}
}
