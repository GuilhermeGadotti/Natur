package Principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Beans.FornecedorBeans;
import Dao.CadastrarDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class CadastroFornecedor extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtnmfornecedor;
	private JTextField txtcpf;
	private JTextField txtdtnasc;
	private JTextField txtend;
	private JTextField txtcep;
	private JTextField txttele;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField txtsenha;
	private JPasswordField txtconfsenha;
	private JTextField txtemail;
	public JFormattedTextField txtCPF;
	public JFormattedTextField txtCEP;
	public JFormattedTextField txtTelefone;
	public JFormattedTextField txtDtNasc;
	private MaskFormatter MaskCPF;
	private MaskFormatter MaskCEP;
	private MaskFormatter MaskTelefone;
	private MaskFormatter MaskDtNasc;
	JRadioButton rdbtnM = new JRadioButton("M");
	JRadioButton rdbtnF = new JRadioButton("F");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFornecedor frame = new CadastroFornecedor();
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
	public CadastroFornecedor() {
		setFont(null);
		setTitle("Cadastro Fornecedor \r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 741);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		try {
			MaskCPF = new MaskFormatter("###.###.###-##");
			MaskCEP = new MaskFormatter("#####-###");
			MaskDtNasc = new MaskFormatter("####-##-##");
			MaskTelefone = new MaskFormatter("(##)#####-####");
		} catch (Exception e) {
			e.printStackTrace();
		}

		txtnmfornecedor = new JTextField();
		txtnmfornecedor.setBounds(53, 133, 286, 32);
		contentPane.add(txtnmfornecedor);
		txtnmfornecedor.setColumns(10);
		txtnmfornecedor.setOpaque(false);
		txtnmfornecedor.setBorder(BorderFactory.createEmptyBorder());

		txtcpf = new JFormattedTextField(MaskCPF);
		txtcpf.setBounds(55, 346, 219, 32);
		contentPane.add(txtcpf);
		txtcpf.setColumns(10);
		txtcpf.setOpaque(false);
		txtcpf.setBorder(BorderFactory.createEmptyBorder());

		txtdtnasc = new JFormattedTextField(MaskDtNasc);
		txtdtnasc.setBounds(55, 271, 217, 39);
		contentPane.add(txtdtnasc);
		txtdtnasc.setColumns(10);
		txtdtnasc.setOpaque(false);
		txtdtnasc.setBorder(BorderFactory.createEmptyBorder());

		txtend = new JTextField();
		txtend.setToolTipText("Ex.:Numero, Apto, Bloco");
		txtend.setBounds(244, 200, 403, 39);
		contentPane.add(txtend);
		txtend.setColumns(10);
		txtend.setOpaque(false);
		txtend.setBorder(BorderFactory.createEmptyBorder());

		txtcep = new JFormattedTextField(MaskCEP);
		txtcep.setBounds(55, 200, 183, 39);
		contentPane.add(txtcep);
		txtcep.setColumns(10);
		txtcep.setOpaque(false);
		txtcep.setBorder(BorderFactory.createEmptyBorder());

		txttele = new JFormattedTextField(MaskTelefone);
		txttele.setBounds(63, 423, 175, 32);
		contentPane.add(txttele);
		txttele.setColumns(10);
		txttele.setOpaque(false);
		txttele.setBorder(BorderFactory.createEmptyBorder());
	
		rdbtnM.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		rdbtnM.setBackground(Color.WHITE);
		buttonGroup.add(rdbtnM);
		rdbtnM.setBounds(376, 133, 49, 32);
		contentPane.add(rdbtnM);
		
		rdbtnF.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		rdbtnF.setBackground(Color.WHITE);
		buttonGroup.add(rdbtnF);
		rdbtnF.setBounds(460, 133, 49, 32);
		contentPane.add(rdbtnF);

		JButton botcadastrar = new JButton("");
		botcadastrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				CadastrasFornecedor();
			}
		});
		botcadastrar.setBounds(110, 656, 79, 39);
		botcadastrar.setBorderPainted(false);
		botcadastrar.setContentAreaFilled(false);
		botcadastrar.setFocusPainted(false);
		contentPane.add(botcadastrar);

		JButton botseguir = new JButton("Seguir");
		botseguir.setBounds(324, 668, 89, 23);
		contentPane.add(botseguir);

		JButton botsair = new JButton("Sair");
		botsair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botsair.setBounds(547, 668, 89, 23);
		contentPane.add(botsair);

		txtsenha = new JPasswordField();
		txtsenha.setBounds(53, 568, 295, 32);
		txtsenha.setOpaque(false);
		txtsenha.setBorder(BorderFactory.createEmptyBorder());
		contentPane.add(txtsenha);

		txtconfsenha = new JPasswordField();
		txtconfsenha.setBounds(358, 568, 300, 32);
		txtconfsenha.setOpaque(false);
		txtconfsenha.setBorder(BorderFactory.createEmptyBorder());
		contentPane.add(txtconfsenha);

		txtemail = new JTextField();
		txtemail.setBounds(55, 496, 296, 32);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		txtemail.setOpaque(false);
		txtemail.setBorder(BorderFactory.createEmptyBorder());

		JLabel lblImagemTela = new JLabel("");
		lblImagemTela.setIcon(
				new ImageIcon(CadastroFornecedor.class.getResource("/Imagens/TelaDeCadastro(final- 720p) (22).png")));
		lblImagemTela.setBounds(0, 0, 668, 700);
		contentPane.add(lblImagemTela);
	}
		
	public void CadastrasFornecedor() {
		FornecedorBeans fb = new FornecedorBeans();

		String senha = String.valueOf(txtsenha.getPassword());
		String ConfirmarSenha = String.valueOf(txtconfsenha.getPassword());

		fb.setNmfornecedoor(txtnmfornecedor.getText());
		fb.setCpffornecedor(txtcpf.getText());
		fb.setSenhafornecedor(senha);
		fb.setConfsenhafornecedor(ConfirmarSenha);
		fb.setDtnascfornecedor(txtdtnasc.getText());
		fb.setEndfornecedor(txtend.getText());
		fb.setCepfornecedor(txtcep.getText());
		fb.setTelefornecedor(txttele.getText());
		String valorbot = null;
		if (rdbtnM.isSelected()) {
			valorbot = "M";
		} else if (rdbtnF.isSelected()) {
			valorbot = "F";
		}
		fb.setSexofornecedor(valorbot);
		fb.setEmailfornecedor(txtemail.getText());
		
		if (!(fb.getSenhafornecedor().equals(fb.getConfsenhafornecedor()))) {
			JOptionPane.showMessageDialog(null, "Senha inválida!", "Atenção", JOptionPane.ERROR_MESSAGE);
			txtsenha.setText(null);
			txtconfsenha.setText(null);

		} else if (fb.getSenhafornecedor().equals(fb.getConfsenhafornecedor())) {
			CadastrarDao cd = new CadastrarDao();
			if (cd.checkCPF(fb)) {
				cd.cadastrar(fb);
				JOptionPane.showMessageDialog(null, "Cadastro Efetuado Com Sucesso! ", "Atenção",
						JOptionPane.PLAIN_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "CPF ja cadastrado.", "Atenção",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}	
}
