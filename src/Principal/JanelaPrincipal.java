package Principal;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Beans.CatadorBean;
import Beans.PerfilBean;
import Dao.CatadorDao;
import Dao.PerfilFornecedorDao;

public class JanelaPrincipal extends JFrame {

	public JPanel 		contentPane;
	CadastroFornecedor 	CadastroFornecedor 	= new CadastroFornecedor();
	CadastroCliente 	CadastroCliente 	= new CadastroCliente();
	LoginFornecedor 	LoginFornecedor 	= new LoginFornecedor();
	PerfilFornecedor 	PerfilFornecedor 	= new PerfilFornecedor();
	FornecedorVenda 	FornecedorVenda		= new FornecedorVenda();
	PerfilBean 			PerfilBean 			= new PerfilBean();
	PerfilFornecedorDao PerfilFornecedorDao = new PerfilFornecedorDao();
	PerfilCliente 		PerfilCliente 		= new PerfilCliente();
	OpcaoDeLogin 		OpcaoLogin 			= new OpcaoDeLogin();
	LoginAdministrador 	LoginADM 			= new LoginAdministrador();
	LoginCliente 		LoginCliente 		= new LoginCliente();
	LoginCatador 		LoginCatador 		= new LoginCatador();
	CatadorDao 			CatadorDao 			= new CatadorDao();
	CatadorBean 		CatadorBean 		= new CatadorBean();
	JButton 			btnDeslogar 		= new JButton("Deslogar");

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

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnCadastrar = new JMenu("Cadastrar");
		menuBar.add(mnCadastrar);

		JMenuItem mntmFornecedor = new JMenuItem("Fornecedor");
		mntmFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroFornecedor.setVisible(true);
			}
		});

		mnCadastrar.add(mntmFornecedor);

		JMenuItem mntmCliente_1 = new JMenuItem("Cliente");
		mntmCliente_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroCliente CadCliente = new CadastroCliente();
				CadCliente.setVisible(true);
			}
		});
		mnCadastrar.add(mntmCliente_1);

		JMenuItem mntmFornecedor_1 = new JMenuItem("Fornecedor");
		mntmFornecedor_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginFornecedor.setVisible(true);
				contentPane.add(LoginFornecedor);
			}
		});
		JMenu mnConsultar = new JMenu("Consultar");
		menuBar.add(mnConsultar);

		JMenu mnPerfil = new JMenu("Perfil");
		mnConsultar.add(mnPerfil);

		JMenuItem mntmFornecedor_2 = new JMenuItem("Fornecedor");
		mntmFornecedor_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (PerfilFornecedorDao.checkEstadoFornecedor(LoginFornecedor.u.getCPF())) {

					PerfilFornecedorDao.PerfilFornecedor(LoginFornecedor.u.getCPF(), PerfilBean);

					PerfilFornecedor.txtid.setText(Integer.toString(PerfilBean.getId_fornecedor()));
					PerfilFornecedor.txtNome.setText(PerfilBean.getNome_fornecedor());
					PerfilFornecedor.txtCPF.setText(PerfilBean.getCpf_fornecedor());
					PerfilFornecedor.txtDtNasc.setText(PerfilBean.getDtNasc_fornecedor());
					PerfilFornecedor.txtEndereco.setText(PerfilBean.getEndereco_fornecedor());
					PerfilFornecedor.txtCep.setText(PerfilBean.getCep_fornecedor());
					PerfilFornecedor.txtTelefone.setText(PerfilBean.getTele_fornecedor());
					PerfilFornecedor.txtEmail.setText(PerfilBean.getEmail_fornecedor());
					if (PerfilBean.getSexo_fornecedor().equals("M")) {
						PerfilFornecedor.rdbtnMasc.setSelected(true);
					} else {
						PerfilFornecedor.rdbtnFem.setSelected(true);
					}
					PerfilFornecedor.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Você não está logado!");
				}
			}
		});

		JMenuItem mntmAdministrador_1 = new JMenuItem("Administrador");
		mntmAdministrador_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		mnPerfil.add(mntmAdministrador_1);
		mnPerfil.add(mntmFornecedor_2);

		JMenuItem mntmCliente_2 = new JMenuItem("Cliente");
		mntmCliente_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
			}
		});
		mnPerfil.add(mntmCliente_2);
		
		JMenuItem mntmCatador = new JMenuItem("Catador");
		mntmCatador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnPerfil.add(mntmCatador);

		JMenu mnVenda = new JMenu("Venda");
		menuBar.add(mnVenda);

		JMenuItem mntmMaterial = new JMenuItem("Material");
		mntmMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PerfilFornecedorDao.PerfilFornecedor(LoginFornecedor.u.getCPF(), PerfilBean);
				FornecedorVenda.txtNomeCliente.setText(PerfilBean.getNome_fornecedor());
				FornecedorVenda.id_fornecedor = PerfilBean.getId_fornecedor();
				FornecedorVenda.setVisible(true);

				FornecedorVenda.btnCancelar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						FornecedorVenda.dispose();
					}
				});
			}
		});
		mnVenda.add(mntmMaterial);

		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel ImagemTelaPrincipal = new JLabel("");
		ImagemTelaPrincipal.setIcon(
				new ImageIcon(JanelaPrincipal.class.getResource("/Imagens/TelaInicial(PRONTA) (2) (1) (1).jpg")));
		ImagemTelaPrincipal.setBounds(0, -47, 1394, 840);
		contentPane.add(ImagemTelaPrincipal);

		btnDeslogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeslogar.setEnabled(false);
				btnDeslogar.setVisible(false);
				LoginCliente.txtCNPJ.setText("");
				LoginCliente.txtSenhaCliente.setText("");

			}
		});
		btnDeslogar.setBounds(913, 23, 89, 23);
		btnDeslogar.setVisible(false);
		btnDeslogar.setEnabled(false);
		contentPane.add(btnDeslogar);

		JButton btnLogin = new JButton("");
		btnLogin.setBounds(475, 318, 89, 93);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// public void actionPerformed(ActionEvent arg0) {
				OpcaoLogin.btnAdministrador.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						LoginADM.setVisible(true);
						OpcaoLogin.dispose();
					}
				});
				LoginADM.btnVoltar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						LoginADM.dispose();
						OpcaoLogin.setVisible(true);
					}
				});
				OpcaoLogin.btnFornecedor.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						LoginFornecedor.setVisible(true);
						OpcaoLogin.dispose();
					}
				});
				LoginFornecedor.btnCadastro.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						LoginFornecedor.setVisible(false);
						CadastroFornecedor.setVisible(true);
					}
				});
				CadastroFornecedor.btnVoltar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						CadastroFornecedor.dispose();
						LoginFornecedor.setVisible(true);

					}
				});
				LoginFornecedor.btnVoltar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						LoginFornecedor.dispose();
						OpcaoLogin.setVisible(true);
					}
				});
				OpcaoLogin.btnCliente.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						LoginCliente.setVisible(true);
						OpcaoLogin.dispose();
					}
				});
				LoginCliente.btnVoltar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						LoginCliente.dispose();
						OpcaoLogin.setVisible(true);
					}
				});
				LoginCliente.btnCadastrar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						CadastroCliente.setVisible(true);
						LoginCliente.dispose();
					}
				});
				OpcaoLogin.btnCatador.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						LoginCatador.setVisible(true);
						OpcaoLogin.dispose();
					}
				});
				LoginCatador.btnVoltar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						LoginCatador.dispose();
						OpcaoLogin.setVisible(true);
					}
				});
				CadastroCliente.btnVoltar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						CadastroCliente.dispose();
						OpcaoLogin.setVisible(true);
					}
				});
				OpcaoLogin.setVisible(true);
			}
		});
		JButton btnPerfil = new JButton("");
		btnPerfil.setBounds(475, 422, 89, 119);
		contentPane.add(btnPerfil);

		JButton btnVenda = new JButton("");
		btnVenda.setBounds(475, 552, 89, 93);
		contentPane.add(btnVenda);
	}
}
