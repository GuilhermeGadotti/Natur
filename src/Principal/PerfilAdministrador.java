package Principal;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PerfilAdministrador extends JInternalFrame {
	private JTextField txtID;
	private JTextField txtUsuario;
	private JTextField txtSexo;
	private JTextField txtCpfAdm;
	private JTextField txtEmailAdm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilAdministrador frame = new PerfilAdministrador();
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
	public PerfilAdministrador() {
		setBounds(100, 100, 450, 464);
		getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(28, 39, 27, 14);
		getContentPane().add(lblId);
		
		txtID = new JTextField();
		txtID.setBounds(28, 61, 46, 20);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setBounds(97, 39, 46, 14);
		getContentPane().add(lblUsurio);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(97, 64, 86, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(220, 39, 46, 14);
		getContentPane().add(lblSexo);
		
		txtSexo = new JTextField();
		txtSexo.setBounds(220, 61, 86, 20);
		getContentPane().add(txtSexo);
		txtSexo.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(28, 114, 46, 14);
		getContentPane().add(lblCpf);
		
		txtCpfAdm = new JTextField();
		txtCpfAdm.setBounds(28, 139, 86, 20);
		getContentPane().add(txtCpfAdm);
		txtCpfAdm.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(141, 114, 46, 14);
		getContentPane().add(lblEmail);
		
		txtEmailAdm = new JTextField();
		txtEmailAdm.setBounds(141, 139, 86, 20);
		getContentPane().add(txtEmailAdm);
		txtEmailAdm.setColumns(10);

	}

}
