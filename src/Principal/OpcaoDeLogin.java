package Principal;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpcaoDeLogin extends JInternalFrame {
	
	JButton btnAdministrador = new JButton("Administrador");
	JButton btnFornecedor = new JButton("Fornecedor");
	JButton btnCliente = new JButton("Cliente");

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
		setClosable(true);
		setBounds(100, 100, 450, 301);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 270);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblLogarComo = new JLabel("Logar como:");
		lblLogarComo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogarComo.setBounds(120, 21, 175, 50);
		panel.add(lblLogarComo);
		
		btnAdministrador.setBounds(37, 114, 124, 23);
		panel.add(btnAdministrador);
		
		btnFornecedor.setBounds(171, 114, 89, 23);
		panel.add(btnFornecedor);
		
		btnCliente.setBounds(270, 114, 89, 23);
		panel.add(btnCliente);

	}
}
