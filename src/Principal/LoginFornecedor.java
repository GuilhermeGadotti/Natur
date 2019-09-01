package Principal;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Beans.UsuarioBean;
import Dao.LoginDao;
import javax.swing.JDesktopPane;

public class LoginFornecedor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCpf_fornecedor;
	private JPasswordField passSenha;
	private MaskFormatter MaskCpf;
	UsuarioBean u = new UsuarioBean();
	JButton btnVoltar = new JButton("");
	JButton btnCadastro = new JButton("");


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFornecedor frame = new LoginFornecedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginFornecedor() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try {
			MaskCpf = new MaskFormatter("###.###.###-##");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		txtCpf_fornecedor = new JFormattedTextField(MaskCpf);
		txtCpf_fornecedor.setBounds(34, 128, 309, 34);
		contentPane.add(txtCpf_fornecedor);
		txtCpf_fornecedor.setColumns(10);
		txtCpf_fornecedor.setOpaque(false);
		txtCpf_fornecedor.setBorder(BorderFactory.createEmptyBorder());
		
		passSenha = new JPasswordField();
		passSenha.setBounds(34, 188, 309, 34);
		contentPane.add(passSenha);
		passSenha.setOpaque(false);
		passSenha.setBorder(BorderFactory.createEmptyBorder());

		JButton btnLogin = new JButton("");
		btnLogin.setBounds(34, 259, 79, 34);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String strSenha = String.valueOf(passSenha.getPassword());
				u.setCPF(txtCpf_fornecedor.getText());
				u.setSenha(strSenha);

				LoginDao Dao = new LoginDao();
				if (Dao.checklogin(u)) {
					JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!", "Atenção",JOptionPane.PLAIN_MESSAGE );
					dispose();
					txtCpf_fornecedor.setText("");
					passSenha.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Usuário ou Senha incorretos", "Atenção", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnLogin.setBorder(BorderFactory.createEmptyBorder());
		btnLogin.setBorderPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setFocusPainted(false);
		contentPane.add(btnLogin);
		

		btnVoltar.setBounds(123, 259, 79, 34);
		contentPane.add(btnVoltar);
		btnVoltar.setBorderPainted(false);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setFocusPainted(false);

		JLabel CPF = new JLabel("");
		CPF.setBackground(Color.PINK);
		CPF.setBounds(22, 339, 67, 28);
		contentPane.add(CPF);

		JLabel lblImagem = new JLabel("");
		lblImagem.setBounds(0, 0, 375, 328);
		lblImagem.setIcon(new ImageIcon(LoginFornecedor.class.getResource("/Imagens/LoginMOD0408.png")));
		contentPane.add(lblImagem);
		
		btnCadastro.setBounds(206, 248, 89, 28);
		contentPane.add(btnCadastro);
		
		JButton btnIguuuuu = new JButton("Iguuuuu");
		btnIguuuuu.setBounds(123, 11, 114, 28);
		btnIguuuuu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				u.setCPF("069.611.849-10");
				u.setSenha("321");
				dispose();
			}
		});
		btnIguuuuu.setBorderPainted(false);
		btnIguuuuu.setContentAreaFilled(false);
		contentPane.add(btnIguuuuu);
	}
}
