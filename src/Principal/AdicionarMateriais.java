package Principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.AdministradorDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdicionarMateriais extends JDialog {

	private JPanel contentPane;
	public JTextField txtMaterial;
	public JTextField txtPreco;
	public String material = "";
	public double preco = 0;
	JButton btnAdicionar = new JButton("Adicionar");
	JButton btnCancelar = new JButton("Cancelar");
	AdministradorDao admDao = new AdministradorDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionarMateriais frame = new AdicionarMateriais();
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
	public AdicionarMateriais() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		this.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMaterial = new JLabel("Material:");
		lblMaterial.setBounds(53, 44, 72, 14);
		contentPane.add(lblMaterial);

		txtMaterial = new JTextField();
		txtMaterial.setBounds(181, 41, 204, 20);
		contentPane.add(txtMaterial);
		txtMaterial.setColumns(10);

		JLabel lblPreoPor = new JLabel("Pre\u00E7o por Kg:");
		lblPreoPor.setBounds(53, 91, 97, 14);
		contentPane.add(lblPreoPor);

		txtPreco = new JTextField();
		txtPreco.setBounds(181, 88, 204, 20);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);

		btnAdicionar.setBounds(101, 182, 89, 23);
		contentPane.add(btnAdicionar);

		btnCancelar.setBounds(223, 182, 89, 23);
		contentPane.add(btnCancelar);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAdicionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnAdd();
			}
		});
	}

	public void btnAdd() {
		if (!(txtMaterial.getText().isEmpty() || txtPreco.getText().isEmpty())) {
			Object[] botoes = { "Sim", "Não" };
			int resposta = JOptionPane.showOptionDialog(null, "Deseja concluir esta operação? ", "Confirmação",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botoes, botoes[0]);

			if (resposta == 0) {

				int ID = 0;
				String Material = txtMaterial.getText();
				double PrecoKG = Double.parseDouble(txtPreco.getText());
				admDao.InserirNovoMaterial(ID, Material, PrecoKG);

				dispose();

				txtMaterial.setText("");
				txtPreco.setText("");
			} else {
				JOptionPane.showMessageDialog(null, "Interrompido!", "Atenção", JOptionPane.PLAIN_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Preencha os campos para adicionar um novo material!", "Aviso!",
					JOptionPane.WARNING_MESSAGE);
		}
	}
}
