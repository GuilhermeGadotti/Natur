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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class LoginCliente extends JFrame {
	public JFormattedTextField txtCNPJ;
	public JPasswordField txtSenhaCliente;
	JButton btnVoltar = new JButton("");
	public MaskFormatter CNPJMask;
	JButton btnLogin = new JButton("");
	JButton btnCadastrar = new JButton("");
	ClienteLoginBean CliLogBean = new ClienteLoginBean();

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
		setBounds(100, 100, 441, 432);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 425, 401);
		getContentPane().add(panel);
		panel.setLayout(null);

		try {
			CNPJMask = new MaskFormatter("##.###.###/####-##");
		} catch (Exception e) {
			System.out.println("Erro ao criar a mascara! \n Erro: " + e.getMessage());
		}

		txtCNPJ = new JFormattedTextField(CNPJMask);
		txtCNPJ.setBounds(68, 166, 294, 26);
		txtCNPJ.setOpaque(false);
		txtCNPJ.setBorder(BorderFactory.createEmptyBorder());
		panel.add(txtCNPJ);
		txtCNPJ.setColumns(10);

		txtSenhaCliente = new JPasswordField();
		txtSenhaCliente.setBounds(68, 227, 294, 26);
		txtSenhaCliente.setOpaque(false);
		txtSenhaCliente.setBorder(BorderFactory.createEmptyBorder());
		panel.add(txtSenhaCliente);
		txtSenhaCliente.setColumns(10);

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login();
			}
		});
		btnLogin.setBounds(91, 297, 78, 35);
		btnLogin.setContentAreaFilled(false);
		panel.add(btnLogin);

		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				OpcaoDeLogin opcaoLogin = new OpcaoDeLogin();
				opcaoLogin.setVisible(true);
			}
		});
		btnVoltar.setBounds(179, 297, 78, 35);
		btnVoltar.setContentAreaFilled(false);
		panel.add(btnVoltar);

		btnCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				CadastroCliente cadastroCliente = new CadastroCliente();
				cadastroCliente.setVisible(true);
			}
		});
		btnCadastrar.setBounds(269, 297, 78, 35);
		btnCadastrar.setContentAreaFilled(false);
		panel.add(btnCadastrar);
		
		JLabel lblImgFundo = new JLabel("");
		lblImgFundo.setIcon(new ImageIcon(LoginCliente.class.getResource("/Imagens/LoginCliente.jpg")));
		lblImgFundo.setBounds(0, 0, 429, 400);
		panel.add(lblImgFundo);
	}

	public void Login() {
		String password = String.valueOf(txtSenhaCliente.getPassword());
		CliLogBean.setCnpj_cliente(txtCNPJ.getText());
		CliLogBean.setSenha_cliente(password);

		if (!(txtCNPJ.getText().isEmpty() || password.isEmpty())) {
			ClienteDao CliDao = new ClienteDao();
			if (CliDao.checkLoginCliente(CliLogBean)) {
				JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!");
				txtCNPJ.setText("");
				txtSenhaCliente.setText("");
				dispose();
				JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
				janelaPrincipal.CNPJ = CliLogBean.getCnpj_cliente();
				janelaPrincipal.logado = "Cliente";
				janelaPrincipal.btnDeslogar.setVisible(true);
				janelaPrincipal.btnDeslogar.setEnabled(true);
				janelaPrincipal.setVisible(true);

			} else {
				JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos", "Atenção",
						JOptionPane.WARNING_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Preencha os campos para efetuar o Login!", "Erro",
					JOptionPane.WARNING_MESSAGE);
		}
	}
}
