package Principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Beans.CatadorBean;
import Dao.CatadorDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LoginCatador extends JFrame {

	private JPanel contentPane;
	private JTextField txtLoginCatador;
	private JPasswordField txtSenhaCatador;
	JButton btnVoltar = new JButton("Voltar");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginCatador frame = new LoginCatador();
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
	public LoginCatador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(90, 75, 46, 14);
		panel.add(lblLogin);

		txtLoginCatador = new JTextField();
		txtLoginCatador.setBounds(154, 72, 141, 20);
		panel.add(txtLoginCatador);
		txtLoginCatador.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(90, 118, 46, 14);
		panel.add(lblSenha);

		txtSenhaCatador = new JPasswordField();
		txtSenhaCatador.setBounds(154, 115, 141, 20);
		panel.add(txtSenhaCatador);
		txtSenhaCatador.setColumns(10);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(90, 190, 89, 23);
		panel.add(btnEntrar);
		btnEntrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Login();
			}
		});
		btnVoltar.setBounds(217, 190, 89, 23);
		panel.add(btnVoltar);
	}

	public void Login() {
		CatadorBean CatadorBean = new CatadorBean();
		String Senha = String.valueOf(txtSenhaCatador.getPassword());

		CatadorBean.setCpf(txtLoginCatador.getText());
		CatadorBean.setSenha(Senha);

		if (!(txtLoginCatador.getText().isEmpty() && Senha.isEmpty())) {
			CatadorDao CatadorDao = new CatadorDao();
			if (CatadorDao.LoginCatador(CatadorBean)) {
				JOptionPane.showMessageDialog(null, "Logado com sucesso!");
				txtLoginCatador.setText("");
				txtSenhaCatador.setText("");
				dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Login ou senha Inválidos!", "Aviso", JOptionPane.WARNING_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Preencha os campos para efetuar o login!");
		}

	}

}
