package br.ucsal.iot.popups;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import br.ucsal.iot.listeners.ListenerCancelConfiguration;
import br.ucsal.iot.listeners.ListenerOkConfiguration;
import br.ucsal.iot.telas.TelaInicial;
import net.miginfocom.swing.MigLayout;

public class PopUpConfiguracaoConexao extends JDialog {

	private TelaInicial tela;
	private static final long serialVersionUID = 9107419782418345780L;
	private final JPanel contentPanel = new JPanel();
	public JTextField campoEndereco;
	public JTextField campoPorta;

	/**
	 * Create the dialog.
	 */
	public PopUpConfiguracaoConexao(TelaInicial tela) {
		this.tela = tela;
		setResizable(false);
		setTitle("Configurar Conex\u00E3o");
		setBounds(100, 100, 407, 207);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//		setAlwaysOnTop(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[344px]", "[14px][33px][14px][33px]"));

		JLabel labelEndereco = new JLabel("Endere\u00E7o (IP):");
		contentPanel.add(labelEndereco, "cell 0 0,alignx left,aligny top");

		campoEndereco = new JTextField();
		contentPanel.add(campoEndereco, "cell 0 1,grow");
		campoEndereco.setColumns(10);

		JLabel labelPorta = new JLabel("Porta:");
		contentPanel.add(labelPorta, "cell 0 2,alignx left,aligny top");

		campoPorta = new JTextField();
		contentPanel.add(campoPorta, "cell 0 3,grow");
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
