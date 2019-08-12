package Principal;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;

import Beans.MaterialBean;
import Conexao.Conexao;
import Dao.PreTriagemDao;

import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FornecedorVenda extends JInternalFrame {
	public JTextField txtNomeCliente;
	public JTextField txtData;
	public JTextField txtNomeMaterial;
	public JTextField txtPesoMaterial;
	public JTextField txtVlrKilo;
	public JTextField txtValorTot;
	public JTable tablePesquisa;
	public JTable tableItensVenda;
	MaterialBean mb = new MaterialBean();
	PreTriagemDao ptd = new PreTriagemDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FornecedorVenda frame = new FornecedorVenda();
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
	public FornecedorVenda() {
		setBounds(100, 100, 502, 775);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 486, 692);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNomeCliente = new JLabel("Nome:");
		lblNomeCliente.setBounds(10, 11, 46, 14);
		panel.add(lblNomeCliente);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(10, 36, 171, 20);
		panel.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(297, 67, 46, 14);
		panel.add(lblData);
		
		txtData = new JTextField();
		txtData.setBounds(297, 92, 165, 20);
		panel.add(txtData);
		txtData.setColumns(10);
		
		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setBounds(191, 11, 46, 14);
		panel.add(lblProduto);
		
		txtNomeMaterial = new JTextField();
		txtNomeMaterial.setBounds(191, 36, 147, 20);
		panel.add(txtNomeMaterial);
		txtNomeMaterial.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mb.setMaterial(txtNomeMaterial.getText());
				ConsultarDadosMaterial(mb);
			}
		});
		btnBuscar.setBounds(348, 35, 70, 23);
		panel.add(btnBuscar);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(12, 67, 46, 14);
		panel.add(lblPeso);
		
		txtPesoMaterial = new JTextField();
		txtPesoMaterial.setBounds(10, 92, 86, 20);
		panel.add(txtPesoMaterial);
		txtPesoMaterial.setColumns(10);
		
		JLabel lblValorPKg = new JLabel("Valor p/ Kg:");
		lblValorPKg.setBounds(107, 67, 78, 14);
		panel.add(lblValorPKg);
		
		txtVlrKilo = new JTextField();
		txtVlrKilo.setBounds(106, 92, 86, 20);
		panel.add(txtVlrKilo);
		txtVlrKilo.setColumns(10);
		
		JLabel lblValorTotal = new JLabel("Valor Total:");
		lblValorTotal.setBounds(217, 553, 78, 14);
		panel.add(lblValorTotal);
		
		txtValorTot = new JTextField();
		txtValorTot.setBounds(305, 550, 171, 20);
		panel.add(txtValorTot);
		txtValorTot.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 179, 454, 156);
		panel.add(scrollPane);
		
		tablePesquisa = new JTable();
		scrollPane.setViewportView(tablePesquisa);
		tablePesquisa.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblTabelaDePesquisa = new JLabel("Tabela de Pesquisa:");
		lblTabelaDePesquisa.setBounds(10, 154, 120, 14);
		panel.add(lblTabelaDePesquisa);
		
		JLabel lblItensDeVenda = new JLabel("Itens de Venda:");
		lblItensDeVenda.setBounds(10, 346, 120, 14);
		panel.add(lblItensDeVenda);
		
		tableItensVenda = new JTable();
		tableItensVenda.setBackground(Color.GRAY);
		tableItensVenda.setBounds(10, 371, 452, 168);
		panel.add(tableItensVenda);
		
		JButton btnFechar = new JButton("Finalizar Venda");
		btnFechar.setBounds(81, 639, 131, 23);
		panel.add(btnFechar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(239, 639, 89, 23);
		panel.add(btnCancelar);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				double VlrDaTable = (double) tablePesquisa.getValueAt(tablePesquisa.getSelectedRow(), 2);
				String ConvVlr = Double.toString(VlrDaTable);
				
				if(txtPesoMaterial.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, informe o peso", "Atenção!", JOptionPane.WARNING_MESSAGE);
					txtValorTot.setText("");
					txtVlrKilo.setText("");
				}
				else {
					double PesoMaterial = Double.parseDouble(txtPesoMaterial.getText());
					double valorTotal = (VlrDaTable * PesoMaterial);
					String SetVlrTot = Double.toString(valorTotal);
					
					txtValorTot.setText(SetVlrTot);
					txtVlrKilo.setText(ConvVlr);
				}
	
			}
		});
		btnAdd.setBounds(201, 91, 51, 23);
		panel.add(btnAdd);
	}
	
	public void ConsultarDadosMaterial(MaterialBean mb) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";

		try {
			conn = Conexao.getConection();
			sql = "SELECT (id_preco)ID, (material) Material, (preco_material)Preço FROM precos WHERE material like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + mb.getMaterial() + "%");
			rs = pstmt.executeQuery();
			tablePesquisa.setModel(DbUtils.resultSetToTableModel(rs));

			if (rs.next()) {
				mb.setId_material(rs.getInt("id_preco"));
				mb.setMaterial(rs.getString("material"));
				mb.setPreco(rs.getDouble("preco_material"));
			}
			Conexao.FecharConexao(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("Erro ao selecionar materiais. zn Erro: " + e.getMessage());
		} 
	}
}
