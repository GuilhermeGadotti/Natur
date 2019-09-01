package Principal;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Beans.CatadorBean;
import Dao.CatadorDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class CadastroCatador extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeCatador;
	private JTextField txtCpfCatador;
	private JTextField txtCidadeCatador;
	private JTextField txtUfCatador;
	private JTextField txtTelefoneCatador;
	private JTextField txtEmailCatador;
	private JPasswordField txtSenhaCatador;
	private JPasswordField txtConfirmarSenhaCatador;
	private MaskFormatter MaskCpf;
	private MaskFormatter MaskTelefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCatador frame = new CadastroCatador();
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
	public CadastroCatador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setLocationRelativeTo(null);
		this.setExtendedState(MAXIMIZED_BOTH);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1012, 733);
		contentPane.add(panel);
		panel.setLayout(null);

		try {
			MaskCpf = new MaskFormatter("###.###.###-##");
			MaskTelefone = new MaskFormatter("(##) #####-##");
		} catch (Exception e) {
			System.out.println("Erro ao criar a mascara! \n Erro: " + e.getMessage());
			e.printStackTrace();
		}
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(199, 79, 46, 14);
		panel.add(lblNome);

		txtNomeCatador = new JTextField();
		txtNomeCatador.setBounds(266, 76, 330, 20);
		panel.add(txtNomeCatador);
		txtNomeCatador.setColumns(10);

		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setBounds(199, 119, 46, 14);
		panel.add(lblCpf);

		txtCpfCatador = new JFormattedTextField(MaskCpf);
		txtCpfCatador.setBounds(266, 107, 330, 26);
		panel.add(txtCpfCatador);
		txtCpfCatador.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(199, 156, 46, 14);
		panel.add(lblCidade);

		txtCidadeCatador = new JTextField();
		txtCidadeCatador.setBounds(266, 153, 330, 20);
		panel.add(txtCidadeCatador);
		txtCidadeCatador.setColumns(10);

		JLabel lblUf = new JLabel("Uf:");
		lblUf.setBounds(199, 189, 46, 14);
		panel.add(lblUf);

		txtUfCatador = new JTextField();
		txtUfCatador.setBounds(266, 186, 330, 20);
		panel.add(txtUfCatador);
		txtUfCatador.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(187, 225, 58, 14);
		panel.add(lblTelefone);

		txtTelefoneCatador = new JFormattedTextField(MaskTelefone);
		txtTelefoneCatador.setBounds(266, 222, 330, 20);
		panel.add(txtTelefoneCatador);
		txtTelefoneCatador.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(187, 259, 46, 14);
		panel.add(lblEmail);

		txtEmailCatador = new JTextField();
		txtEmailCatador.setBounds(266, 256, 330, 20);
		panel.add(txtEmailCatador);
		txtEmailCatador.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(187, 330, 46, 14);
		panel.add(lblSenha);

		JLabel lblConfirmarSenha = new JLabel("Confirmar Senha:");
		lblConfirmarSenha.setBounds(434, 330, 108, 14);
		panel.add(lblConfirmarSenha);

		txtSenhaCatador = new JPasswordField();
		txtSenhaCatador.setBounds(187, 355, 138, 20);
		panel.add(txtSenhaCatador);
		txtSenhaCatador.setColumns(10);

		txtConfirmarSenhaCatador = new JPasswordField();
		txtConfirmarSenhaCatador.setBounds(434, 355, 162, 20);
		panel.add(txtConfirmarSenhaCatador);
		txtConfirmarSenhaCatador.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(335, 470, 89, 23);
		panel.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CadastrarCatador();	
			}
		});
	}
	public void CadastrarCatador() {
		CatadorBean CatadorBean = new CatadorBean();
		String Senha = String.valueOf(txtSenhaCatador.getPassword());
		String ConfirmarSenha = String.valueOf(txtConfirmarSenhaCatador.getPassword());

		CatadorBean.setNome(txtNomeCatador.getText());
		CatadorBean.setCpf(txtCpfCatador.getText());
		CatadorBean.setCidade_Atuação(txtCidadeCatador.getText());
		CatadorBean.setUF(txtUfCatador.getText());
		CatadorBean.setEmail(txtEmailCatador.getText());
		CatadorBean.setTelefone(txtTelefoneCatador.getText());

		if (!(txtNomeCatador.getText().isEmpty() || txtCpfCatador.getText().isEmpty()
				|| txtCidadeCatador.getText().isEmpty() || txtUfCatador.getText().isEmpty())) {
			if (Senha.equals(ConfirmarSenha)) {
				CatadorBean.setSenha(Senha);
				CatadorDao CatadorDao = new Dao.CatadorDao();
				if (CatadorDao.VerificarContaExistente(CatadorBean)) {
					JOptionPane.showMessageDialog(null, "CPF já cadastrado", "Atenção", JOptionPane.WARNING_MESSAGE);
				} else {
					CatadorDao.CadastrarCatador(CatadorBean);
					JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Confirmação",
							JOptionPane.PLAIN_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Senha inválida!", "Atenção", JOptionPane.WARNING_MESSAGE);
				txtSenhaCatador.setText("");
				txtConfirmarSenhaCatador.setText("");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Por favor, preencha os campos obrigatórios");
		}
	}
}
