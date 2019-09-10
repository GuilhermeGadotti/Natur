package Principal;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Beans.AdministradorLoginBean;
import Dao.AdministradorDao;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class LoginAdministrador extends JFrame {
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private MaskFormatter MaskCpf;
	AdministradorLoginBean alb = new AdministradorLoginBean();
	AdministradorDao ad = new AdministradorDao();
	JButton btnVoltar = new JButton("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAdministrador frame = new LoginAdministrador();
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
	public LoginAdministrador() {
		setBounds(100, 100, 444, 421);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 435, 382);
		getContentPane().add(panel);
		panel.setLayout(null);

		try {
			MaskCpf = new MaskFormatter("###.###.###-##");
		} catch (Exception e) {
			System.out.println("Falha na criação da mascara! \n Erro: " + e.getMessage());
			e.printStackTrace();
		}

		txtUsuario = new JFormattedTextField(MaskCpf);
		txtUsuario.setBounds(67, 163, 299, 20);
		txtUsuario.setOpaque(false);
		txtUsuario.setBorder(BorderFactory.createEmptyBorder());
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(67, 223, 299, 20);
		txtSenha.setOpaque(false);
		txtSenha.setBorder(BorderFactory.createEmptyBorder());
		panel.add(txtSenha);
		txtSenha.setColumns(10);

		JButton btnLogin = new JButton("");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login();
			}
		});
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBounds(127, 288, 79, 35);
		panel.add(btnLogin);

		btnVoltar.setBounds(216, 288, 79, 35);
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				OpcaoDeLogin opcaoLogin = new OpcaoDeLogin();
				opcaoLogin.setVisible(true);
			}
		});
		btnVoltar.setContentAreaFilled(false);
		panel.add(btnVoltar);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LoginAdministrador.class.getResource("/Imagens/LoginProprietario.jpg")));
		label.setBounds(0, 0, 425, 382);
		panel.add(label);
	}

	public void login() {

		String senha = String.valueOf(txtSenha.getPassword());

		if (!(txtUsuario.getText().isEmpty() || senha.isEmpty())) {
			alb.setUsuario_adm(txtUsuario.getText());
			alb.setSenha_adm(senha);

			if (ad.checkLogin(alb)) {
				JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!", "Msg", JOptionPane.PLAIN_MESSAGE);
				dispose();
				txtUsuario.setText("");
				txtUsuario.setText("");
			} else {
				JOptionPane.showMessageDialog(null, "Usuario ou senha inválidos!", "Atenção!",
						JOptionPane.WARNING_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(null, "Preencha os campos!", "Atenção!", JOptionPane.WARNING_MESSAGE);
		}
	}

}
