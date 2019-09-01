package Principal;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import Beans.PerfilBean;
import Dao.PerfilFornecedorDao;
import ResizeImage.RedimencionarImagemPerfil;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PerfilFornecedor extends JFrame {
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
	JLabel lblImagemPerfil = new JLabel("");
	private JTextField txtPath;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilFornecedor frame = new PerfilFornecedor();
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
	public PerfilFornecedor() {
		setBounds(100, 100, 682, 670);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		this.setExtendedState(MAXIMIZED_BOTH);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1012, 639);
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
		rdbtnMasc.setBackground(Color.WHITE);
		rdbtnMasc.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		rdbtnMasc.setBounds(447, 152, 80, 23);
		panel.add(rdbtnMasc);

		buttonGroup.add(rdbtnFem);
		rdbtnFem.setBackground(Color.WHITE);
		rdbtnFem.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		rdbtnFem.setBounds(529, 150, 88, 23);
		panel.add(rdbtnFem);

		JButton btnAlterarDados = new JButton("");
		btnAlterarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pb.setId_fornecedor(Integer.parseInt(txtid.getText()));
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

		JButton btnCarregarImagem = new JButton("Carregar Imagem");
		btnCarregarImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BuscarImg();
			}
		});
		btnCarregarImagem.setBounds(560, 429, 89, 23);
		panel.add(btnCarregarImagem);

		txtPath = new JTextField();
		txtPath.setBounds(447, 516, 213, 20);
		panel.add(txtPath);
		txtPath.setColumns(10);

		lblImagemPerfil.setBackground(Color.GRAY);
		lblImagemPerfil.setBounds(320, 284, 150, 200);
		panel.add(lblImagemPerfil);

		JLabel lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon(PerfilFornecedor.class.getResource("/Imagens/TelaPerfil.png")));
		lblImagem.setBounds(0, 0, 1012, 706);
		panel.add(lblImagem);

	}

	public void BuscarImg() {
		JFileChooser filechooser = new JFileChooser();
		filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Abrir Imagem", "jpg", "png");
		filechooser.setFileFilter(filtro);
		filechooser.addChoosableFileFilter(filtro);
		filechooser.setAcceptAllFileFilterUsed(false);

		int i = filechooser.showSaveDialog(null);

		if (i == 1) {
			txtPath.setText("");
		} else {
			File arquivo = filechooser.getSelectedFile();

			String InputImagePath = arquivo.getPath();
			String outputImagePath = "C:/Users/Alunos/Desktop/ImagemRedimencionada.png";
			RedimencionarImagemPerfil Resize = new RedimencionarImagemPerfil();

			try {
				int scaledWidth = 150;
				int scaledHeight = 200;
				Resize.resize(InputImagePath, outputImagePath, scaledWidth, scaledHeight);
				;

			} catch (IOException ex) {
				System.out.println("Erro ao redimencionar a imagem! \n Erro: " + ex.getMessage());
				ex.printStackTrace();
			}
			lblImagemPerfil.setIcon(new ImageIcon(outputImagePath));
		}
	}
}
