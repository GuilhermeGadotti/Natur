package Principal;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Beans.PerfilBean;
import Dao.PerfilFornecedorDao;

public class JanelaPrincipal extends JFrame {

	public JPanel contentPane;
	CadastroFornecedor CadForn = new CadastroFornecedor();
	LoginFornecedor loginForn = new LoginFornecedor();
	ConsultarPerfil ConsPer = new ConsultarPerfil();
	FornecedorVenda ForVen = new FornecedorVenda();
	PerfilBean pb = new PerfilBean();
	PerfilFornecedorDao pfd = new PerfilFornecedorDao();
	OpcaoDeLogin odl = new OpcaoDeLogin();
	LoginAdministrador LogAdm = new LoginAdministrador();

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
		setBounds(100, 100, 605, 530);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnCadastrar = new JMenu("Cadastrar");
		menuBar.add(mnCadastrar);

		JMenuItem mntmFornecedor = new JMenuItem("Fornecedor");
		mntmFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadForn.setVisible(true);
				contentPane.add(CadForn);
			}
		});
		
		mnCadastrar.add(mntmFornecedor);
		
		JMenuItem mntmCliente_1 = new JMenuItem("Cliente");
		mntmCliente_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroCliente CadCliente = new CadastroCliente();
				CadCliente.setVisible(true);
				contentPane.add(CadCliente);
			}
		});
		mnCadastrar.add(mntmCliente_1);

		JMenu mnLogin = new JMenu("Login");
		menuBar.add(mnLogin);

		JMenuItem mntmFornecedor_1 = new JMenuItem("Fornecedor");
		mntmFornecedor_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginForn.setVisible(true);
				contentPane.add(loginForn);
			}
		});
		
		JMenuItem mntmAdministrador = new JMenuItem("Administrador");
		mnLogin.add(mntmAdministrador);
		mnLogin.add(mntmFornecedor_1);

		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mnLogin.add(mntmCliente);

		JMenu mnConsultar = new JMenu("Consultar");
		menuBar.add(mnConsultar);
		
		JMenu mnPerfil = new JMenu("Perfil");
		mnConsultar.add(mnPerfil);
		
		JMenuItem mntmFornecedor_2 = new JMenuItem("Fornecedor");
		mntmFornecedor_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pfd.PerfilFornecedor(loginForn.u.getCPF(), pb);

				ConsPer.txtid.setText(pb.getId_fornecedor());
				ConsPer.txtNome.setText(pb.getNome_fornecedor());
				ConsPer.txtCPF.setText(pb.getCpf_fornecedor());
				ConsPer.txtDtNasc.setText(pb.getDtNasc_fornecedor());
				ConsPer.txtEndereco.setText(pb.getEndereco_fornecedor());
				ConsPer.txtCep.setText(pb.getCep_fornecedor());
				ConsPer.txtTelefone.setText(pb.getTele_fornecedor());
				ConsPer.txtEmail.setText(pb.getEmail_fornecedor());
				if (pb.getSexo_fornecedor().equals("M")) {
					ConsPer.rdbtnMasc.setSelected(true);
				} else {
					ConsPer.rdbtnFem.setSelected(true);
				}

				ConsPer.setVisible(true);
				contentPane.add(ConsPer);
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
		
		JMenu mnVenda = new JMenu("Venda");
		menuBar.add(mnVenda);
		
		JMenuItem mntmMaterial = new JMenuItem("Material");
		mntmMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pfd.PerfilFornecedor(loginForn.u.getCPF(), pb);
				ForVen.txtNomeCliente.setText(pb.getNome_fornecedor());
				ForVen.setVisible(true);
				contentPane.add(ForVen);
			}
		});
		mnVenda.add(mntmMaterial);
		
		JMenuItem mntmLogarse = new JMenuItem("Logar-se");
		mntmLogarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				odl.btnAdministrador.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						LogAdm.setVisible(true);
						contentPane.add(LogAdm);
						odl.dispose();
					}
				});
				LogAdm.btnVoltar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						LogAdm.dispose();
						odl.setVisible(true);
						contentPane.add(odl);
					}
				});
				odl.btnFornecedor.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						loginForn.setVisible(true);
						contentPane.add(loginForn);	
						odl.setVisible(false);
					}
				});
				loginForn.btnVoltar.addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						loginForn.dispose();
						odl.setVisible(true);
						contentPane.add(odl);
					}
				});	
				
				odl.setVisible(true);
				contentPane.add(odl);
			}
		});
		menuBar.add(mntmLogarse);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(152, 251, 152));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
