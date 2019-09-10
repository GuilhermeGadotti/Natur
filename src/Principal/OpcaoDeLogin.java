package Principal;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class OpcaoDeLogin extends JFrame {
	
	JButton btnAdministrador = new JButton();
	JButton btnFornecedor = new JButton();
	JButton btnCliente = new JButton();
	JButton btnCatador = new JButton("Catador");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpcaoDeLogin frame = new OpcaoDeLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OpcaoDeLogin() {
		setBounds(100, 100, 450, 304);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		this.setExtendedState(MAXIMIZED_BOTH);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1304, 741);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		btnAdministrador.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginAdministrador loginAdm = new LoginAdministrador();
				loginAdm.setVisible(true);
				dispose();
			}
		});
		btnAdministrador.setContentAreaFilled(false);
		btnAdministrador.setBounds(703, 258, 218, 229);
		panel.add(btnAdministrador);
		
		btnFornecedor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginFornecedor loginFornecedor = new LoginFornecedor();
				loginFornecedor.setVisible(true);
				dispose();
			}
		});
		btnFornecedor.setContentAreaFilled(false);
		btnFornecedor.setBounds(98, 258, 218, 229);
		panel.add(btnFornecedor);
		
		btnCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginCliente loginCliente = new LoginCliente();
				loginCliente.setVisible(true);
				dispose();
			}
		});
		btnCliente.setContentAreaFilled(false);
		btnCliente.setBounds(404, 258, 218, 229);
		panel.add(btnCliente);
		
		btnCatador.setBounds(722, 604, 89, 23);
		
		panel.add(btnCatador);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
				janelaPrincipal.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setBounds(449, 514, 133, 56);
		panel.add(btnVoltar);
		
		JLabel lblImgFundo = new JLabel("");
		lblImgFundo.setIcon(new ImageIcon(OpcaoDeLogin.class.getResource("/Imagens/LogarComo.jpg")));
		lblImgFundo.setBounds(0, 0, 1304, 741);
		panel.add(lblImgFundo);

	}
}
