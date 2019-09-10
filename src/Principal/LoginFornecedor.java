package Principal;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Beans.UsuarioBean;
import Dao.LoginDao;
import javax.swing.JProgressBar;

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
	JButton btnLogin = new JButton("");
	PerfilFornecedor perfilFornecedor = new PerfilFornecedor();
	private JProgressBar progressBar = new JProgressBar();
	private JLabel lblBarradeProgresso = new JLabel("");

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
		setBounds(100, 100, 441, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		try {
			MaskCpf = new MaskFormatter("###.###.###-##");
		} catch (Exception e) {
			System.out.println("Falha na criação da mascara! \n Erro: " + e.getMessage());
			e.printStackTrace();
		}

		txtCpf_fornecedor = new JFormattedTextField(MaskCpf);
		txtCpf_fornecedor.setBounds(68, 164, 299, 34);
		contentPane.add(txtCpf_fornecedor);
		txtCpf_fornecedor.setColumns(10);
		txtCpf_fornecedor.setOpaque(false);
		txtCpf_fornecedor.setBorder(BorderFactory.createEmptyBorder());

		passSenha = new JPasswordField();
		passSenha.setBounds(68, 222, 309, 34);
		contentPane.add(passSenha);
		passSenha.setOpaque(false);
		passSenha.setBorder(BorderFactory.createEmptyBorder());

		btnLogin.setBounds(89, 298, 79, 34);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String strSenha = String.valueOf(passSenha.getPassword());
				u.setCPF(txtCpf_fornecedor.getText());
				u.setSenha(strSenha);

				if (!(txtCpf_fornecedor.getText().isEmpty() || strSenha.isEmpty())) {
					LoginDao Dao = new LoginDao();
					if (Dao.checklogin(u)) {
						progressBarRun();
					} else {
						JOptionPane.showMessageDialog(null, "Usuário ou Senha incorretos", "Atenção",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Preencha os campos para efetuar o login!!!");
				}
			}
		});
		btnLogin.setContentAreaFilled(false);
		contentPane.add(btnLogin);

		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				OpcaoDeLogin opcaoLogin = new OpcaoDeLogin();
				opcaoLogin.setVisible(true);
			}
		});
		btnVoltar.setBounds(178, 298, 79, 34);
		contentPane.add(btnVoltar);
		btnVoltar.setContentAreaFilled(false);

		JLabel CPF = new JLabel("");
		CPF.setBackground(Color.PINK);
		CPF.setBounds(22, 339, 67, 28);
		contentPane.add(CPF);

		JButton btnRecuperarSenha = new JButton("Esqueceu a senha?");
		btnRecuperarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaRecuperacaoSenha RecuperarSenha = new TelaRecuperacaoSenha();
				RecuperarSenha.setVisible(true);
				dispose();
			}
		});
		btnRecuperarSenha.setBounds(136, 343, 146, 23);
		contentPane.add(btnRecuperarSenha);

		btnCadastro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				CadastroFornecedor cadastroFornecedor = new CadastroFornecedor();
				cadastroFornecedor.setVisible(true);
			}
		});

		JButton btnIguuuuu = new JButton("Iguuuuu");
		btnIguuuuu.setBounds(155, 48, 114, 28);
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
		btnCadastro.setBounds(267, 298, 80, 32);
		btnCadastro.setContentAreaFilled(false);
		contentPane.add(btnCadastro);
		
				progressBar.setStringPainted(true);
				progressBar.setBounds(52, 410, 314, 28);
				contentPane.add(progressBar);
		
		lblBarradeProgresso.setBounds(84, 434, 272, 22);
		contentPane.add(lblBarradeProgresso);

		JLabel lblImagem = new JLabel("");
		lblImagem.setBounds(0, 0, 425, 400);
		lblImagem.setIcon(new ImageIcon(LoginFornecedor.class.getResource("/Imagens/LoginFornecedor.jpg")));
		contentPane.add(lblImagem);
	}

	private void progressBarRun() {
		PopupLogin popupLogin = new PopupLogin();
		new Thread() {
			public void run() {
				for (int i = 0; i < 101; i++) {
					try {
						popupLogin.setVisible(true);
						sleep(40);
						popupLogin.ConeccaoStatus.setValue(i);
						if(popupLogin.ConeccaoStatus.getValue() <= 25) {
							popupLogin.Status.setText("Abrindo o sistema...");
						}
						else if(popupLogin.ConeccaoStatus.getValue() <= 50) {
							popupLogin.Status.setText("Obtendo conexão...");
						}
						else if(popupLogin.ConeccaoStatus.getValue() <= 75) {
							popupLogin.Status.setText("Comendo o cu de quem ta lendo...");
						}
						else {
							popupLogin.Status.setText("Verificando conta...");
						}
					} catch (InterruptedException ex) {
						ex.getMessage();
					}
				}
				JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!", "Atenção",
						JOptionPane.PLAIN_MESSAGE);
				JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
				janelaPrincipal.CPF = u.getCPF();
				janelaPrincipal.logado = "Fornecedor";
				janelaPrincipal.setVisible(true);
				janelaPrincipal.btnDeslogar.setVisible(true);
				janelaPrincipal.btnDeslogar.setEnabled(true);
				popupLogin.dispose();
				dispose();
			}
		}.start();
	}
}
