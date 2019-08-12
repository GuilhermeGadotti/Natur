package Principal;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Beans.PerfilBean;
import Dao.PerfilFornecedorDao;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarPerfil extends JInternalFrame {
	public JTextField txtid;
	public JTextField txtNome;
	public JTextField txtCPF;
	public JTextField txtDtNasc;
	public JTextField txtEndereco;
	public JTextField txtCep;
	public JTextField txtEmail;
	public JTextField txtTelefone;
	PerfilBean pb = new PerfilBean();
	PerfilFornecedorDao pfd = new PerfilFornecedorDao();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton rdbtnMasc = new JRadioButton("Masc");
	JRadioButton rdbtnFem = new JRadioButton("Fem");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarPerfil frame = new ConsultarPerfil();
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
	public ConsultarPerfil() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 682, 670);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 675, 639);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtid = new JTextField();
		txtid.setBounds(58, 143, 49, 30);
		panel.add(txtid);
		txtid.setColumns(10);
		txtid.setOpaque(false);
		txtid.setBorder(BorderFactory.createEmptyBorder());
		
		txtNome = new JTextField();
		txtNome.setBounds(141, 143, 294, 30);
		panel.add(txtNome);
		txtNome.setColumns(10);
		txtNome.setOpaque(false);
		txtNome.setBorder(BorderFactory.createEmptyBorder());
		
		txtCPF = new JTextField();
		txtCPF.setBounds(58, 357, 213, 30);
		panel.add(txtCPF);
		txtCPF.setColumns(10);
		txtCPF.setOpaque(false);
		txtCPF.setBorder(BorderFactory.createEmptyBorder());
		
		txtDtNasc = new JTextField();
		txtDtNasc.setBounds(58, 284, 213, 30);
		panel.add(txtDtNasc);
		txtDtNasc.setColumns(10);
		txtDtNasc.setOpaque(false);
		txtDtNasc.setBorder(BorderFactory.createEmptyBorder());
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(248, 208, 396, 36);
		panel.add(txtEndereco);
		txtEndereco.setColumns(10);
		txtEndereco.setOpaque(false);
		txtEndereco.setBorder(BorderFactory.createEmptyBorder());
		
		txtCep = new JTextField();
		txtCep.setBounds(58, 208, 177, 36);
		panel.add(txtCep);
		txtCep.setColumns(10);
		txtCep.setOpaque(false);
		txtCep.setBorder(BorderFactory.createEmptyBorder());
		
		txtEmail = new JTextField();
		txtEmail.setBounds(58, 500, 292, 36);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		txtEmail.setOpaque(false);
		txtEmail.setBorder(BorderFactory.createEmptyBorder());
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(57, 429, 177, 36);
		panel.add(txtTelefone);
		txtTelefone.setColumns(10);
		txtTelefone.setOpaque(false);
		txtTelefone.setBorder(BorderFactory.createEmptyBorder());
		
		buttonGroup.add(rdbtnMasc);
		rdbtnMasc.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		rdbtnMasc.setBounds(447, 152, 80, 23);
		panel.add(rdbtnMasc);

		buttonGroup.add(rdbtnFem);
		rdbtnFem.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		rdbtnFem.setBounds(529, 150, 88, 23);
		panel.add(rdbtnFem);
		
		JButton btnAlterarDados = new JButton("");
		btnAlterarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pb.setId_fornecedor(txtid.getText());
				pb.setNome_fornecedor(txtNome.getText());
				pb.setCep_fornecedor(txtCep.getText());
				pb.setEndereco_fornecedor(txtEndereco.getText());
				pb.setDtNasc_fornecedor(txtDtNasc.getText());
				pb.setCpf_fornecedor(txtCPF.getText());
				pb.setTele_fornecedor(txtTelefone.getText());
				pb.setEmail_fornecedor(txtEmail.getText());
				JOptionPane.showMessageDialog(null, "foi alterado");
				
				pfd.AtualizarDadosFornecedor(pb);
			}
		});
		btnAlterarDados.setBounds(230, 585, 109, 43);
		panel.add(btnAlterarDados);
		btnAlterarDados.setBorderPainted(false);
		btnAlterarDados.setFocusPainted(false);
		btnAlterarDados.setContentAreaFilled(false);
		
		JLabel lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon(ConsultarPerfil.class.getResource("/Imagens/TelaPerfil.png")));
		lblImagem.setBounds(0, 0, 675, 640);
		panel.add(lblImagem);

	}
}
