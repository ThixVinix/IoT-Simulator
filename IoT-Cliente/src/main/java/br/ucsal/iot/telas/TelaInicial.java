package br.ucsal.iot.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.WindowConstants;

import br.ucsal.iot.bean.ConfiguracaoConexaoBean;
import br.ucsal.iot.listeners.ListenerConfigurarConexao;
import br.ucsal.iot.listeners.ListenerEnviarRegistros;
import br.ucsal.iot.listeners.ListenerIniciarConexao;
import br.ucsal.iot.model.DadosLixeira;
import br.ucsal.iot.popups.PopUpConfiguracaoConexao;
import br.ucsal.iot.runners.ThreadConexaoCliente;

public class TelaInicial {

	public JFrame frame;
	public JLabel labelConfiguracaoAtual;
	public ConfiguracaoConexaoBean confBean;
	public PopUpConfiguracaoConexao confConect;
	public DadosLixeira dadosLixeira;
	public StringBuilder textoCompletoEncriptado;

	public JComboBox<String> comboBoxGrafico;
	public TextArea textArea;
	public JToggleButton botaoToggleIniciarConexao;
	public JButton botaoConfigurarConexao;
	public List list;
	public JButton botaoEnviarRegistros;
	public ThreadConexaoCliente conexaoCliente;
	public Socket socket;
	public boolean statusConnection;
	public java.util.List<DadosLixeira> dadosList;
	private ImageIcon imagem = new ImageIcon(getClass().getResource("cyber-cliente.jpg"));
	private JLabel imagemMenuInicial = new JLabel(imagem);

	/**
	 * @wbp.parser.entryPoint
	 */
	void initialize() {
		confBean = new ConfiguracaoConexaoBean();
		confConect = new PopUpConfiguracaoConexao(this);
		textoCompletoEncriptado = new StringBuilder();
		dadosList = new ArrayList<>();
		createWindow();
		frame.getContentPane().setLayout(null);
		createLabels();
		createTextsArea();
		createButtons();
		createCombosBox();
		createTextsPane();
		frame.getContentPane().add(imagemMenuInicial);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/ucsal/iot/telas/cyber-cliente.jpg")));
		lblNewLabel.setBounds(0, 0, 453, 581);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}

	private void createWindow() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setTitle("Cliente");
		frame.setBounds(100, 100, 826, 620);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
	}

	private void createLabels() {

	}

	private void createTextsArea() {
		createTextAreaConteudo();
	}

	private void createButtons() {
		createBotaoEnviarRegistros();
		createBotaoConfigurarConexao();
		createBotaoIniciarConexao();
	}

	private void createCombosBox() {
		createComboBoxGrafico();
	}

	private void createBotaoEnviarRegistros() {
		 botaoEnviarRegistros = new JButton("Enviar registros");
		 botaoEnviarRegistros.setForeground(Color.WHITE);
		 botaoEnviarRegistros.setBackground(new Color(153, 0, 0));
		botaoEnviarRegistros.setBounds(97, 471, 126, 23);
		botaoEnviarRegistros.addActionListener(new ListenerEnviarRegistros(this));
		botaoEnviarRegistros.setEnabled(false);
		frame.getContentPane().add(botaoEnviarRegistros);
	}

	private void createBotaoIniciarConexao() {
		botaoToggleIniciarConexao = new JToggleButton("Conectar");
		botaoToggleIniciarConexao.setForeground(Color.WHITE);
		botaoToggleIniciarConexao.setBackground(new Color(153, 0, 0));
		botaoToggleIniciarConexao.addActionListener(new ListenerIniciarConexao(this));
		botaoToggleIniciarConexao.setBounds(169, 71, 149, 23);
		frame.getContentPane().add(botaoToggleIniciarConexao);
	}

	private void createBotaoConfigurarConexao() {
		botaoConfigurarConexao = new JButton("Configurar conex\u00E3o");
		botaoConfigurarConexao.setForeground(Color.WHITE);
		botaoConfigurarConexao.setBackground(new Color(153, 0, 0));
		botaoConfigurarConexao.addActionListener(new ListenerConfigurarConexao(this, confConect));
		botaoConfigurarConexao.setBounds(10, 71, 149, 23);
		frame.getContentPane().add(botaoConfigurarConexao);
	}

	private void createTextsPane() {

		list = new List();
		list.setForeground(Color.WHITE);
		list.setBackground(new Color(153, 0, 0));
//		list.addActionListener(new ListenerListarConfConnection(this));
		list.setVisible(false);
		Font z = new Font("TimesRoman", Font.BOLD, 12);
		list.setFont(z);
		list.setBounds(10, 125, 308, 38);
		frame.getContentPane().add(list);

		 labelConfiguracaoAtual = new JLabel("Configura\u00E7\u00E3o atual para conex\u00E3o do servidor:");
		 labelConfiguracaoAtual.setForeground(Color.WHITE);
		labelConfiguracaoAtual.setBounds(10, 105, 308, 14);
		labelConfiguracaoAtual.setVisible(false);
		frame.getContentPane().add(labelConfiguracaoAtual);

	}

	private void createComboBoxGrafico() {

	}

	private void createTextAreaConteudo() {
		textArea = new TextArea();
		textArea.setForeground(new Color(255, 0, 0));
		textArea.setBackground(Color.BLACK);
		textArea.setBounds(357, 0, 453, 581);
		frame.getContentPane().add(textArea);

	}
}
