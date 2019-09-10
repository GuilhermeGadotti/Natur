package Principal;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Beans.CatadorBean;
import Beans.ClienteBean;
import Beans.PerfilBean;
import Dao.CatadorDao;
import Dao.ClienteDao;
import Dao.PerfilFornecedorDao;
import java.awt.Color;

public class JanelaPrincipal extends JFrame {

	public JPanel contentPane;
	CadastroFornecedor CadastroFornecedor = new CadastroFornecedor();
	CadastroCliente CadastroCliente = new CadastroCliente();
	LoginFornecedor LoginFornecedor = new LoginFornecedor();
	PerfilBean PerfilBean = new PerfilBean();
	PerfilFornecedorDao PerfilFornecedorDao = new PerfilFornecedorDao();
	ClienteBean ClienteBean = new ClienteBean();
	OpcaoDeLogin OpcaoLogin = new OpcaoDeLogin();
	LoginAdministrador LoginADM = new LoginAdministrador();
	LoginCliente LoginCliente = new LoginCliente();
	LoginCatador LoginCatador = new LoginCatador();
	CatadorDao CatadorDao = new CatadorDao();
	CatadorBean CatadorBean = new CatadorBean();
	JButton btnDeslogar = new JButton("Deslogar");
	public String logado = "";
	public String CPF = "";
	public String CNPJ = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal frame = new JanelaPrincipal();
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
	public JanelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1065, 772);
		this.setLocationRelativeTo(null);
		this.setExtendedState(MAXIMIZED_BOTH);

		JMenuItem mntmFornecedor_1 = new JMenuItem("Fornecedor");
		mntmFornecedor_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginFornecedor.setVisible(true);
				contentPane.add(LoginFornecedor);
			}
		});

		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnDeslogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeslogar.setEnabled(false);
				btnDeslogar.setVisible(false);
				OpcaoLogin.setVisible(true);
				dispose();
			}
		});
		btnDeslogar.setBounds(913, 23, 89, 23);
		btnDeslogar.setVisible(false);
		btnDeslogar.setEnabled(false);
		contentPane.add(btnDeslogar);

		JButton btnLogin = new JButton("");
		btnLogin.setBackground(Color.DARK_GRAY);
		btnLogin.setForeground(Color.DARK_GRAY);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBounds(475, 318, 89, 93);
		contentPane.add(btnLogin);
		btnLogin.setToolTipText("Botão de login.");
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				OpcaoLogin.setVisible(true);
			}
		});
		JButton btnPerfil = new JButton("");
		btnPerfil.setToolTipText("Botão perfil");
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!logado.isEmpty()) {

					if (logado.equals("Fornecedor")) {

						PerfilFornecedorDao.PerfilFornecedor(CPF, PerfilBean);
						PerfilFornecedor PerfilFornecedor = new PerfilFornecedor();
						
						PerfilFornecedor.txtNome.setText(PerfilBean.getNome_fornecedor());
						PerfilFornecedor.txtCPF.setText(PerfilBean.getCpf_fornecedor());
						PerfilFornecedor.txtEndereco.setText(PerfilBean.getEndereco_fornecedor());
						PerfilFornecedor.txtCep.setText(PerfilBean.getCep_fornecedor());
						PerfilFornecedor.txtTelefone.setText(PerfilBean.getTele_fornecedor());
						PerfilFornecedor.txtEmail.setText(PerfilBean.getEmail_fornecedor());

						PerfilFornecedor.setVisible(true);
						CPF = PerfilFornecedor.pb.getCpf_fornecedor();

						dispose();
					}
					if (logado.equals("Cliente")) {
						ClienteDao clienteDao = new ClienteDao();
						PerfilCliente PerfilCliente = new PerfilCliente();

						clienteDao.BuscasDadosCliente(CNPJ, ClienteBean);
						PerfilCliente.txtId.setText(Integer.toString(ClienteBean.getId_cliente()));
						PerfilCliente.txtNomeCliente.setText(ClienteBean.getNome_cliente());
						PerfilCliente.txtCNPJ.setText(ClienteBean.getCnpj_cliente());
						PerfilCliente.txtCepCliente.setText(ClienteBean.getCep_cliente());
						PerfilCliente.txtEmailCliente.setText(ClienteBean.getEmail_cliente());
						PerfilCliente.txtEnderecoCliente.setText(ClienteBean.getLocalizacao_cliente());
						PerfilCliente.txtTelefoneCliente.setText(ClienteBean.getTelefone_cliente());
						CNPJ = PerfilCliente.txtCNPJ.getText();

						PerfilCliente.setVisible(true);
						dispose();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Por favor, efetue o login para acessar essa função!",
							"Atenção!", JOptionPane.WARNING_MESSAGE);
				}
			}

		});
		btnPerfil.setContentAreaFilled(false);
		btnPerfil.setBounds(475, 422, 89, 119);
		contentPane.add(btnPerfil);

		JButton btnVenda = new JButton("");
		btnVenda.setToolTipText("Botao de venda");
		btnVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!logado.isEmpty()) {
					if (logado.equals("Fornecedor")) {
						dispose();
						FornecedorVenda FornecedorVenda = new FornecedorVenda();
						PerfilFornecedorDao.PerfilFornecedor(CPF, PerfilBean);
						FornecedorVenda.txtNomeCliente.setText(PerfilBean.getNome_fornecedor());
						FornecedorVenda.id_fornecedor = PerfilBean.getId_fornecedor();
						FornecedorVenda.setVisible(true);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Faça o login!");

				}
			}
		});
		btnVenda.setContentAreaFilled(false);
		btnVenda.setBounds(475, 538, 97, 107);
		contentPane.add(btnVenda);

		JLabel ImagemTelaPrincipal = new JLabel("");
		ImagemTelaPrincipal.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/Imagens/TelaInicial.jpg")));
		ImagemTelaPrincipal.setBounds(0, -47, 1394, 840);
		contentPane.add(ImagemTelaPrincipal);
	}
}
