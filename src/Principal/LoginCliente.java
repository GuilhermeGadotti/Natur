package Principal;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LoginCliente extends JInternalFrame {
	private JTextField txtCNPJ;
	private JTextField txtSenhaCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginCliente frame = new LoginCliente();
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
	public LoginCliente() {
		setBounds(100, 100, 244, 302);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 228, 274);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(28, 52, 46, 14);
		panel.add(lblCnpj);
		
		txtCNPJ = new JTextField();
		txtCNPJ.setBounds(28, 77, 143, 20);
		panel.add(txtCNPJ);
		txtCNPJ.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(28, 108, 46, 14);
		panel.add(lblSenha);
		
		txtSenhaCliente = new JTextField();
		txtSenhaCliente.setBounds(28, 133, 86, 20);
		panel.add(txtSenhaCliente);
		txtSenhaCliente.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(10, 197, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(109, 197, 89, 23);
		panel.add(btnVoltar);

	}
}
