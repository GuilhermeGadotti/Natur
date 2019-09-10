package Principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Beans.MaterialBean;
import Dao.AdministradorDao;
import Dao.MaterialDao;
import Model.MateriaisTableModel;
import javax.swing.JTextPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdministradorMateriais extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeMaterial;
	private JTable TabelaMateriais;
	MaterialBean materialBean = new MaterialBean();
	MateriaisTableModel MaterialModel = new MateriaisTableModel();
	AdicionarMateriais addMat = new AdicionarMateriais();
	AdministradorDao admDao = new AdministradorDao();
	private JButton btnAdicionarMaterial;
	private JButton btnModificarDados;
	public String Material = "";
	public double PrecoKg = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministradorMateriais frame = new AdministradorMateriais();
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
	/**
	 * 
	 */
	public AdministradorMateriais() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setLocationRelativeTo(null);
		this.setExtendedState(MAXIMIZED_BOTH);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMaterial = new JLabel("Material:");
		lblMaterial.setBounds(28, 50, 85, 14);
		contentPane.add(lblMaterial);

		txtNomeMaterial = new JTextField();
		txtNomeMaterial.setBounds(136, 47, 176, 20);
		contentPane.add(txtNomeMaterial);
		txtNomeMaterial.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(94, 111, 89, 23);
		contentPane.add(btnBuscar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(356, 50, 521, 214);
		contentPane.add(scrollPane);

		TabelaMateriais = new JTable();
		TabelaMateriais.setModel(MaterialModel);
		TabelaMateriais.getColumnModel().getColumn(0).setResizable(false);
		TabelaMateriais.getColumnModel().getColumn(0).setPreferredWidth(45);
		TabelaMateriais.getColumnModel().getColumn(2).setResizable(false);
		TabelaMateriais.getColumnModel().getColumn(2).setPreferredWidth(74);
		scrollPane.setViewportView(TabelaMateriais);

		btnAdicionarMaterial = new JButton("Adicionar Material");
		btnAdicionarMaterial.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addMat.setVisible(true);
			}
		});

		btnAdicionarMaterial.setBounds(223, 327, 143, 23);
		contentPane.add(btnAdicionarMaterial);

		btnModificarDados = new JButton("Alterar Dados");
		btnModificarDados.setBounds(396, 327, 136, 23);
		contentPane.add(btnModificarDados);

		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String DescricaoMaterial = txtNomeMaterial.getText();
				MaterialModel.read(DescricaoMaterial);
			}
		});

	}
}
