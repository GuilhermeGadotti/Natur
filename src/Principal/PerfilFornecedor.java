package Principal;

import java.awt.EventQueue;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import Beans.PerfilBean;
import Conexao.Conexao;
import Dao.PerfilFornecedorDao;
import ResizeImage.RedimencionarImagemPerfil;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.AlphaComposite;
import java.awt.Color;

public class PerfilFornecedor extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField txtNome;
	public JTextField txtCPF;
	public JTextField txtEndereco;
	public JTextField txtCep;
	public JTextField txtEmail;
	public JTextField txtTelefone;
	PerfilBean pb = new PerfilBean();
	PerfilFornecedorDao pfd = new PerfilFornecedorDao();
	JLabel lblImagemPerfil = new JLabel("");
	private JTextField txtPath;
	private JButton btnVoltar;
	File arquivo;

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
		panel.setBounds(0, 0, 1012, 733);
		getContentPane().add(panel);
		panel.setLayout(null);

		txtNome = new JTextField();
		txtNome.setBounds(370, 256, 276, 30);
		panel.add(txtNome);
		txtNome.setColumns(10);
		txtNome.setOpaque(false);
		txtNome.setBorder(BorderFactory.createEmptyBorder());

		txtCPF = new JTextField();
		txtCPF.setBounds(370, 337, 276, 30);
		panel.add(txtCPF);
		txtCPF.setColumns(10);
		txtCPF.setOpaque(false);
		txtCPF.setBorder(BorderFactory.createEmptyBorder());

		txtEndereco = new JTextField();
		txtEndereco.setBounds(370, 417, 169, 30);
		panel.add(txtEndereco);
		txtEndereco.setColumns(10);
		txtEndereco.setOpaque(false);
		txtEndereco.setBorder(BorderFactory.createEmptyBorder());

		txtCep = new JTextField();
		txtCep.setBounds(561, 417, 85, 30);
		panel.add(txtCep);
		txtCep.setColumns(10);
		txtCep.setOpaque(false);
		txtCep.setBorder(BorderFactory.createEmptyBorder());

		txtEmail = new JTextField();
		txtEmail.setBounds(370, 573, 276, 30);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		txtEmail.setOpaque(false);
		txtEmail.setBorder(BorderFactory.createEmptyBorder());

		txtTelefone = new JTextField();
		txtTelefone.setBounds(370, 501, 169, 30);
		panel.add(txtTelefone);
		txtTelefone.setColumns(10);
		txtTelefone.setOpaque(false);
		txtTelefone.setBorder(BorderFactory.createEmptyBorder());

		JButton btnAlterarDados = new JButton("");
		btnAlterarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pfd.PerfilFornecedor(txtCPF.getText(), pb);
				
				pb.setNome_fornecedor(txtNome.getText());
				pb.setCep_fornecedor(txtCep.getText());
				pb.setEndereco_fornecedor(txtEndereco.getText());
				pb.setCpf_fornecedor(txtCPF.getText());
				pb.setTele_fornecedor(txtTelefone.getText());
				pb.setEmail_fornecedor(txtEmail.getText());
				pb.setImagemPerfil(getImage());
				
				pfd.AtualizarDadosFornecedor(pb);
				JOptionPane.showMessageDialog(null, "foi alterado");
			}
		});
		btnAlterarDados.setBounds(410, 645, 109, 42);
		panel.add(btnAlterarDados);
		btnAlterarDados.setBorderPainted(false);
		btnAlterarDados.setFocusPainted(false);
		btnAlterarDados.setContentAreaFilled(false);

		JButton btnCarregarImagem = new JButton("");
		btnCarregarImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BuscarImg();
				getImage();
			}
		});
		btnCarregarImagem.setBorderPainted(false);
		btnCarregarImagem.setFocusPainted(false);
		btnCarregarImagem.setContentAreaFilled(false);
		btnCarregarImagem.setBounds(738, 170, 165, 212);
		panel.add(btnCarregarImagem);

		txtPath = new JTextField();
		txtPath.setBounds(718, 474, 213, 20);
		panel.add(txtPath);
		txtPath.setColumns(10);

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
				janelaPrincipal.btnDeslogar.setVisible(true);
				janelaPrincipal.btnDeslogar.setEnabled(true);
				janelaPrincipal.logado = "Fornecedor";
				janelaPrincipal.CPF = txtCPF.getText();
				janelaPrincipal.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(530, 645, 89, 42);
		panel.add(btnVoltar);

		lblImagemPerfil.setBackground(Color.GRAY);
		lblImagemPerfil.setBounds(738, 170, 165, 212);
		panel.add(lblImagemPerfil);

		JLabel lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon(PerfilFornecedor.class.getResource("/Imagens/PerfilFornecedor.jpg")));
		lblImagem.setBounds(0, 0, 1012, 733);
		panel.add(lblImagem);

	}

	public void BuscarImg() {
		JFileChooser filechooser = new JFileChooser();
		filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Abrir Imagem", "jpg", "png");
		filechooser.setFileFilter(filtro);
		filechooser.addChoosableFileFilter(filtro);
		filechooser.setAcceptAllFileFilterUsed(false);
		filechooser.setDialogType(JFileChooser.OPEN_DIALOG);
		filechooser.setCurrentDirectory(new File("C:/"));

		int i = filechooser.showSaveDialog(null);

		if (i == 1) {
			txtPath.setText("");
		} else {
			arquivo = filechooser.getSelectedFile();

			String InputImagePath = arquivo.getPath();
			/*
			 * String outputImagePath =
			 * "C:\\Users\\Igor Assis\\Desktop\\ImagemRedimencionada.jpg";
			 */
			RedimencionarImagemPerfil Resize = new RedimencionarImagemPerfil();

			try {
				int scaledWidth = lblImagemPerfil.getWidth();
				int scaledHeight = lblImagemPerfil.getHeight();
				Resize.resize(InputImagePath, InputImagePath, scaledWidth, scaledHeight);
			} catch (IOException ex) {
				System.out.println("Erro ao redimencionar a imagem! \n Erro: " + ex.getMessage());
				ex.printStackTrace();
			}
			lblImagemPerfil.setIcon(new ImageIcon(InputImagePath));
		}
	}

	private byte[] getImage() {
		boolean isPng = false;
		if (arquivo != null) {
			JOptionPane.showMessageDialog(null, "aaaaaaaaaa");
			isPng = arquivo.getName().endsWith(".png");
			try {
				BufferedImage image = ImageIO.read(arquivo);
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				int type = BufferedImage.TYPE_INT_RGB;

				if (isPng) {
					type = BufferedImage.BITMASK;
				}
				BufferedImage novaImagem = new BufferedImage(lblImagemPerfil.getWidth(), lblImagemPerfil.getHeight(),
						type);
				Graphics2D g = novaImagem.createGraphics();
				g.setComposite(AlphaComposite.Src);
				g.drawImage(image, 0, 0, lblImagemPerfil.getWidth() - 5, lblImagemPerfil.getHeight() - 10, null);

				if (isPng) {
					ImageIO.write(novaImagem, ".png", out);
				} else {
					ImageIO.write(novaImagem, ".jpg", out);
				}
				out.flush();
				byte[] byteArray = out.toByteArray();
				out.close();

				return byteArray;

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	protected int RecuperarImg(File f){
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "UPDATE fornecedor SET img_fornecedor =? WHERE id_fornecedor =?";
			try {
				conn = Conexao.getConection();
				pstmt = conn.prepareStatement(sql);
				InputStream is = new FileInputStream(f);
				byte[] bytes = new byte[(int)f.length()];

				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		return 0;
		
		
		
		
	}
	
	
}
