package Principal;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Beans.AdministradorLoginBean;
import Dao.AdministradorDao;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginAdministrador extends JFrame {
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	AdministradorLoginBean alb = new AdministradorLoginBean();
	AdministradorDao ad = new AdministradorDao();
	JButton btnVoltar = new JButton("Voltar");

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
		setBounds(100, 100, 244, 342);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 228, 312);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setBounds(29, 56, 60, 14);
		panel.add(lblUsurio);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(29, 81, 145, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(29, 120, 60, 14);
		panel.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(29, 145, 145, 20);
		panel.add(txtSenha);
		txtSenha.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String senha = String.valueOf(txtSenha.getPassword());
				
				alb.setUsuario_adm(txtUsuario.getText());
				alb.setSenha_adm(senha);
				
				if(ad.checkLogin(alb) == true){
					JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!", "Msg", JOptionPane.PLAIN_MESSAGE);
					dispose();
					txtUsuario.setText("");
					txtUsuario.setText("");
				}
				else{
					JOptionPane.showMessageDialog(null, "Usuario ou senha inválidos!", "Atenção!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnLogin.setBounds(24, 208, 89, 23);
		panel.add(btnLogin);
		
		btnVoltar.setBounds(123, 208, 89, 23);
		panel.add(btnVoltar);

	}
}
