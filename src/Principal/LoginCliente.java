package Principal;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Beans.ClienteLoginBean;
import Dao.ClienteDao;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginCliente extends JFrame {
	public JFormattedTextField txtCNPJ;
	public JPasswordField txtSenhaCliente;
	JButton btnVoltar = new JButton("Voltar");
	public MaskFormatter CNPJMask;
	JButton btnLogin = new JButton("Login");
	public boolean VerificaLogin = false;
	JButton btnCadastrar = new JButton("Cadastrar");

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
		setBounds(100, 100, 325, 353);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 309, 314);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(28, 52, 46, 14);
		panel.add(lblCnpj);

		try {
			CNPJMask = new MaskFormatter("##.###.###/####-##");
		} catch (Exception e) {
			System.out.println("Erro ao criar a mascara! \n Erro: " + e.getMessage());
		}

		txtCNPJ = new JFormattedTextField(CNPJMask);
		txtCNPJ.setBounds(28, 77, 143, 20);
		panel.add(txtCNPJ);
		txtCNPJ.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(28, 108, 46, 14);
		panel.add(lblSenha);

		txtSenhaCliente = new JPasswordField();
		txtSenhaCliente.setBounds(28, 133, 86, 20);
		panel.add(txtSenhaCliente);
		txtSenhaCliente.setColumns(10);

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login();
			}
		});
		btnLogin.setBounds(10, 197, 89, 23);
		panel.add(btnLogin);

		btnVoltar.setBounds(109, 197, 89, 23);
		panel.add(btnVoltar);

		btnCadastrar.setBounds(208, 197, 89, 23);
		panel.add(btnCadastrar);
	}

	public void Login() {
		String password = String.valueOf(txtSenhaCliente.getPassword());
		ClienteLoginBean CliLogBean = new ClienteLoginBean();
		CliLogBean.setCnpj_cliente(txtCNPJ.getText());
		CliLogBean.setSenha_cliente(password);

		if (!(txtCNPJ.getText().isEmpty() || password.isEmpty())) {
			ClienteDao CliDao = new ClienteDao();
			if (CliDao.checkLoginCliente(CliLogBean)) {
				JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!");
				txtCNPJ.setText("");
				txtSenhaCliente.setText("");
				dispose();
				VerificaLogin = true;
			} else {
				JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos", "Atenção",
						JOptionPane.WARNING_MESSAGE);
				VerificaLogin = false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Preencha os campos para efetuar o Login!","Erro", JOptionPane.WARNING_MESSAGE);
		}
	}

}
