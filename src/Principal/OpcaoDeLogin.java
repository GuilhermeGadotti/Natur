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

public class OpcaoDeLogin extends JFrame {
	
	JButton btnAdministrador = new JButton("Administrador");
	JButton btnFornecedor = new JButton("Fornecedor");
	JButton btnCliente = new JButton("Cliente");
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
		panel.setBounds(0, 0, 1012, 705);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblLogarComo = new JLabel("Logar como:");
		lblLogarComo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogarComo.setBounds(351, 187, 175, 50);
		panel.add(lblLogarComo);
		
		btnAdministrador.setBounds(188, 335, 124, 23);
		panel.add(btnAdministrador);
		
		btnFornecedor.setBounds(371, 335, 89, 23);
		panel.add(btnFornecedor);
		
		btnCliente.setBounds(489, 335, 89, 23);
		panel.add(btnCliente);
		
		btnCatador.setBounds(613, 335, 89, 23);
		
		panel.add(btnCatador);

	}
}
