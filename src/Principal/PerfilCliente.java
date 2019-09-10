package Principal;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class PerfilCliente extends JFrame {
	public JTextField txtId;
	public JTextField txtNomeCliente;
	public JTextField txtCNPJ;
	public JTextField txtEnderecoCliente;
	public JTextField txtCepCliente;
	public JTextField txtTelefoneCliente;
	public JTextField txtEmailCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilCliente frame = new PerfilCliente();
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
	public PerfilCliente() {
		setBounds(100, 100, 699, 438);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		this.setExtendedState(MAXIMIZED_BOTH);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1012, 733);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtId = new JTextField();
		txtId.setBounds(262, 266, 86, 20);
		panel.add(txtId);
		txtId.setColumns(10);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(370, 260, 274, 33);
		panel.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		txtCNPJ = new JTextField();
		txtCNPJ.setBounds(370, 336, 274, 33);
		panel.add(txtCNPJ);
		txtCNPJ.setColumns(10);
		
		txtEnderecoCliente = new JTextField();
		txtEnderecoCliente.setBounds(370, 420, 173, 33);
		panel.add(txtEnderecoCliente);
		txtEnderecoCliente.setColumns(10);
		
		txtCepCliente = new JTextField();
		txtCepCliente.setBounds(553, 418, 91, 36);
		panel.add(txtCepCliente);
		txtCepCliente.setColumns(10);
		
		txtTelefoneCliente = new JTextField();
		txtTelefoneCliente.setBounds(370, 501, 173, 33);
		panel.add(txtTelefoneCliente);
		txtTelefoneCliente.setColumns(10);
		
		txtEmailCliente = new JTextField();
		txtEmailCliente.setBounds(370, 573, 274, 33);
		panel.add(txtEmailCliente);
		txtEmailCliente.setColumns(10);
		
		JButton btnAlterarDados = new JButton("Alterar Dados");
		btnAlterarDados.setBounds(370, 661, 131, 23);
		panel.add(btnAlterarDados);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
				janelaPrincipal.btnDeslogar.setVisible(true);
				janelaPrincipal.btnDeslogar.setEnabled(true);
				janelaPrincipal.logado = "Cliente";
				janelaPrincipal.CNPJ = txtCNPJ.getText();
				janelaPrincipal.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(553, 661, 89, 23);
		panel.add(btnVoltar);
		
		JLabel label = new JLabel("");
		label.setBounds(742, 173, 166, 214);
		panel.add(label);
		
		JLabel lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon(PerfilCliente.class.getResource("/Imagens/PerfilCliente.jpg")));
		lblImagem.setBounds(0, 0, 1012, 733);
		panel.add(lblImagem);
		
		JButton btnImagemPerfil = new JButton("");
		btnImagemPerfil.setBounds(742, 425, 89, 23);
		panel.add(btnImagemPerfil);

	}
}
