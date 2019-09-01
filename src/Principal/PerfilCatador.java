package Principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PerfilCatador extends JFrame {

	private JPanel contentPane;
	public JTextField txtID;
	public JTextField txtNomeCatador;
	public JTextField txtCpf;
	public JTextField txtCidade;
	public JTextField txtUF;
	public JTextField txtEmail;
	public JTextField txtTelefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilCatador frame = new PerfilCatador();
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
	public PerfilCatador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 303);
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
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(266, 101, 46, 14);
		panel.add(lblId);
		
		txtID = new JTextField();
		txtID.setBounds(266, 126, 73, 20);
		panel.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(364, 101, 46, 14);
		panel.add(lblNome);
		
		txtNomeCatador = new JTextField();
		txtNomeCatador.setBounds(364, 126, 253, 20);
		panel.add(txtNomeCatador);
		txtNomeCatador.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(266, 173, 46, 14);
		panel.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(266, 189, 102, 20);
		panel.add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(266, 228, 46, 14);
		panel.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(266, 253, 86, 20);
		panel.add(txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(382, 228, 46, 14);
		panel.add(lblUf);
		
		txtUF = new JTextField();
		txtUF.setBounds(382, 253, 86, 20);
		panel.add(txtUF);
		txtUF.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setBounds(266, 297, 46, 14);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(266, 322, 202, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(266, 353, 73, 14);
		panel.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(266, 378, 86, 20);
		panel.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(321, 471, 89, 23);
		panel.add(btnAlterar);
	}

}
