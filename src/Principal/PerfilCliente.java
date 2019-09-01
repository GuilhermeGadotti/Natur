package Principal;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PerfilCliente extends JInternalFrame {
	public JTextField txtId;
	public JTextField txtNomeCliente;
	public JTextField txtCNPJ;
	public JTextField txtEnderecoCliente;
	public JTextField txtCepCliente;
	public JTextField txtTelefoneCliente;
	public JTextField txtEmailCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilCliente frame = new PerfilCliente();
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
	public PerfilCliente() {
		setBounds(100, 100, 699, 438);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 681, 408);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(21, 11, 46, 14);
		panel.add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(21, 36, 86, 20);
		panel.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(148, 11, 46, 14);
		panel.add(lblNome);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(148, 36, 272, 20);
		panel.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(21, 74, 46, 14);
		panel.add(lblCnpj);
		
		txtCNPJ = new JTextField();
		txtCNPJ.setBounds(21, 99, 215, 20);
		panel.add(txtCNPJ);
		txtCNPJ.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(21, 138, 86, 14);
		panel.add(lblEndereo);
		
		txtEnderecoCliente = new JTextField();
		txtEnderecoCliente.setBounds(21, 163, 242, 20);
		panel.add(txtEnderecoCliente);
		txtEnderecoCliente.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(281, 138, 46, 14);
		panel.add(lblCep);
		
		txtCepCliente = new JTextField();
		txtCepCliente.setBounds(279, 163, 156, 20);
		panel.add(txtCepCliente);
		txtCepCliente.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(21, 210, 86, 14);
		panel.add(lblTelefone);
		
		txtTelefoneCliente = new JTextField();
		txtTelefoneCliente.setBounds(21, 237, 173, 20);
		panel.add(txtTelefoneCliente);
		txtTelefoneCliente.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(223, 210, 46, 14);
		panel.add(lblEmail);
		
		txtEmailCliente = new JTextField();
		txtEmailCliente.setBounds(223, 237, 197, 20);
		panel.add(txtEmailCliente);
		txtEmailCliente.setColumns(10);
		
		JButton btnAlterarDados = new JButton("Alterar Dados");
		btnAlterarDados.setBounds(94, 336, 131, 23);
		panel.add(btnAlterarDados);

	}

}
