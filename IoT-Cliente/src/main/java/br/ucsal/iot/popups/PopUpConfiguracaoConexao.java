package br.ucsal.iot.popups;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.ucsal.iot.listeners.ListenerCancelConfiguration;
import br.ucsal.iot.listeners.ListenerOkConfiguration;
import br.ucsal.iot.telas.TelaInicial;

public class PopUpConfiguracaoConexao extends JDialog {

	private static final long serialVersionUID = 2293170273615913993L;

//	private TelaInicial tela;

	private final JPanel contentPanel = new JPanel();
	public JTextField campoEndereco;
	public JTextField campoPorta;

	/**
	 * Create the dialog.
	 */
	public PopUpConfiguracaoConexao(TelaInicial tela) {
//		this.tela = tela;
		setTitle("Configurar Cliente");
		setBounds(100, 100, 450, 237);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel labelEndereco = new JLabel("Endere\u00E7o (IP):");
		labelEndereco.setBounds(26, 25, 129, 14);
		contentPanel.add(labelEndereco);

		campoEndereco = new JTextField();
		campoEndereco.setBounds(26, 50, 398, 31);
		contentPanel.add(campoEndereco);
		campoEndereco.setColumns(10);

		JLabel labelPorta = new JLabel("Porta:");
		labelPorta.setBounds(26, 92, 165, 14);
		contentPanel.add(labelPorta);

		campoPorta = new JTextField();
		campoPorta.setBounds(26, 117, 398, 31);
		contentPanel.add(campoPorta);
		campoPorta.setColumns(10);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ListenerOkConfiguration(tela, this));
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ListenerCancelConfiguration(tela, this));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
