package Principal;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Beans.ClienteBean;
import Dao.ClienteDao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroCliente extends JInternalFrame {
	private JTextField txtNomeCliente;
	private JTextField txtCNPJ;
	private JTextField txtLocalizacao;
	private JTextField txtCEPCliente;
	private JTextField txtEmail;
	private JTextField txtTelefoneCliente;
	ClienteBean cb = new ClienteBean();
	ClienteDao cd = new ClienteDao();
	private JPasswordField txtSenha;
	private JPasswordField txtConfirmarSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCliente frame = new CadastroCliente();
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
	public CadastroCliente() {
		setClosable(true);
		setBounds(100, 100, 598, 509);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 582, 479);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(27, 25, 46, 14);
		panel.add(lblNome);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(27, 42, 178, 20);
		panel.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);

		JLabel lblCNPJ = new JLabel("CNPJ:");
		lblCNPJ.setBounds(27, 73, 46, 14);
		panel.add(lblCNPJ);

		txtCNPJ = new JTextField();
		txtCNPJ.setBounds(27, 95, 178, 20);
		panel.add(txtCNPJ);
		txtCNPJ.setColumns(10);

		JLabel lblNewLabel = new JLabel("Localiza\u00E7\u00E3o:");
		lblNewLabel.setBounds(27, 126, 89, 14);
		panel.add(lblNewLabel);

		txtLocalizacao = new JTextField();
		txtLocalizacao.setBounds(27, 150, 202, 20);
		panel.add(txtLocalizacao);
		txtLocalizacao.setColumns(10);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(247, 126, 46, 14);
		panel.add(lblCep);

		txtCEPCliente = new JTextField();
		txtCEPCliente.setBounds(246, 150, 178, 20);
		panel.add(txtCEPCliente);
		txtCEPCliente.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(27, 195, 46, 14);
		panel.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(27, 220, 202, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone: ");
		lblTelefone.setBounds(247, 195, 65, 14);
		panel.add(lblTelefone);

		txtTelefoneCliente = new JTextField();
		txtTelefoneCliente.setBounds(247, 220, 177, 20);
		panel.add(txtTelefoneCliente);
		txtTelefoneCliente.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(27, 266, 46, 14);
		panel.add(lblSenha);

		JLabel lblConfirmarSenha = new JLabel("Confirmar Senha:");
		lblConfirmarSenha.setBounds(219, 266, 127, 14);
		panel.add(lblConfirmarSenha);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(27, 290, 139, 20);
		panel.add(txtSenha);
		txtSenha.setColumns(10);

		txtConfirmarSenha = new JPasswordField();
		txtConfirmarSenha.setBounds(219, 290, 139, 20);
		panel.add(txtConfirmarSenha);
		txtConfirmarSenha.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastrarCliente();
			}
		});
		btnCadastrar.setBounds(193, 361, 89, 23);
		panel.add(btnCadastrar);
	}

	public void CadastrarCliente() {

		String senha = String.valueOf(txtSenha.getPassword());
		String confirmarSenha = String.valueOf(txtConfirmarSenha.getPassword());

		cb.setNome_cliente(txtNomeCliente.getText());
		cb.setCnpj_cliente(txtCNPJ.getText());
		cb.setSenha_cliente(senha);
		cb.setConfirmarSenha_cliente(confirmarSenha);
		cb.setLocalizacao_cliente(txtLocalizacao.getText());
		cb.setCep_cliente(txtCEPCliente.getText());
		cb.setEmail_cliente(txtEmail.getText());
		cb.setTelefone_cliente(txtTelefoneCliente.getText());

		if (!(senha.equals(confirmarSenha))) {
			JOptionPane.showMessageDialog(null, "Senha inválida!", "Atenção", JOptionPane.ERROR_MESSAGE);
			txtSenha.setText("");
			txtConfirmarSenha.setText("");
		} else {
			if (cd.checkCNPJ(cb)) {
				cd.CadastrarCliente(cb);
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Aviso", JOptionPane.PLAIN_MESSAGE);
				dispose();
			}
			else {
				JOptionPane.showMessageDialog(null, "CNPJ já cadastrado!", "Atenção", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
