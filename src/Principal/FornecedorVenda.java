package Principal;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Beans.MaterialBean;
import Beans.PreTriagemBean;
import Beans.PreTriagemTableBean;
import Conexao.Conexao;
import Dao.MaterialDao;
import Dao.OrdemPagamentoDao;
import Dao.PreTriagemDao;
import Model.VendaTableModel;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class FornecedorVenda extends JFrame {
	public JTextField txtNomeCliente;
	public JTextField txtData;
	public JTextField txtNomeMaterial;
	public JTextField txtPesoMaterial;
	public JTextField txtVlrKilo;
	public JTable tablePesquisa;
	public JTable tableItensVenda;
	MaterialBean mb = new MaterialBean();
	VendaTableModel ItemTableModel = new VendaTableModel();
	ArrayList<PreTriagemBean> Dados = new ArrayList<>();
	public int id_fornecedor;
	public double SomaDoValorTotal = 0;
	ArrayList<Integer> ID_PreTriagem = new ArrayList<>();
	JButton btnCancelar = new JButton("");

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
		getContentPane().setBackground(SystemColor.inactiveCaptionText);
		setBounds(100, 100, 1015, 658);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		this.setExtendedState(MAXIMIZED_BOTH);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.desktop);
		panel.setBounds(0, -163, 1012, 944);
		getContentPane().add(panel);
		panel.setLayout(null);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(105, 339, 171, 29);
		panel.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);
		txtNomeCliente.setOpaque(false);
		txtNomeCliente.setBorder(BorderFactory.createEmptyBorder());

		txtNomeMaterial = new JTextField();
		txtNomeMaterial.setBounds(105, 520, 171, 20);
		panel.add(txtNomeMaterial);
		txtNomeMaterial.setColumns(10);
		txtNomeMaterial.setOpaque(false);
		txtNomeMaterial.setBorder(BorderFactory.createEmptyBorder());

		JButton btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mb.setMaterial(txtNomeMaterial.getText());
				/* ConsultarDadosMaterial(mb); */
				preencherTableMateriais();

			}
		});
		btnBuscar.setBounds(297, 502, 77, 43);
		panel.add(btnBuscar);
		btnBuscar.setBorder(BorderFactory.createEmptyBorder());
		btnBuscar.setBorderPainted(false);
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setFocusPainted(false);

		txtPesoMaterial = new JTextField();
		txtPesoMaterial.setBounds(103, 394, 77, 29);
		panel.add(txtPesoMaterial);
		txtPesoMaterial.setColumns(10);
		txtPesoMaterial.setOpaque(false);
		txtPesoMaterial.setBorder(BorderFactory.createEmptyBorder());

		txtVlrKilo = new JTextField();
		txtVlrKilo.setBounds(190, 394, 86, 29);
		panel.add(txtVlrKilo);
		txtVlrKilo.setColumns(10);
		txtVlrKilo.setOpaque(false);
		txtVlrKilo.setBorder(BorderFactory.createEmptyBorder());

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(438, 317, 454, 156);
		panel.add(scrollPane);

		tablePesquisa = new JTable();
		tablePesquisa.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Descri\u00E7\u00E3o", "Pre\u00E7o / KG" }) {
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tablePesquisa);
		tablePesquisa.setBackground(Color.LIGHT_GRAY);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(438, 583, 547, 216);
		panel.add(scrollPane_1);

		tableItensVenda = new JTable(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nome", "Material", "Pre\u00E7o/Kg", "Peso", "Valor Total" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(tableItensVenda);
		tableItensVenda.setBackground(Color.GRAY);
		tableItensVenda.setModel(ItemTableModel);
		tableItensVenda.getColumnModel().getColumn(0).setPreferredWidth(15);
		tableItensVenda.getColumnModel().getColumn(2).setPreferredWidth(5);
		tableItensVenda.getColumnModel().getColumn(4).setPreferredWidth(3);
		tableItensVenda.getColumnModel().getColumn(5).setPreferredWidth(5);

		JButton btnFinalizar = new JButton("");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] botoes = { "Sim", "Não" };
				int resposta = JOptionPane.showOptionDialog(null, "Deseja concluir esta operação? ", "Confirmação",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botoes, botoes[0]);

				if (resposta == 0) {
					if (Dados.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Selecione pelo menos um item para concluir a transação",
								"Aviso!", JOptionPane.WARNING_MESSAGE);
					} else {
						PreTriagemDao ptd = new PreTriagemDao();
						for (int i = 0; i < Dados.size(); i++) {
							System.out.println(Dados.get(i).getDados());
							ptd.InserirDados(Dados.get(i));
						}
						PreTriagemTableBean pttb = new PreTriagemTableBean();
						pttb.setId_Fornecedor(id_fornecedor);
						pttb.setValor_total(SomaDoValorTotal);

						OrdemPagamentoDao opd = new OrdemPagamentoDao();
						opd.Inserir(pttb);

						JOptionPane.showMessageDialog(null, "Finalizado com sucesso!");
						int Linhas = tableItensVenda.getRowCount();

						System.out.println(ptd.BuscaIDPreTriagem(Linhas));

						for (int i = 0; i < Linhas; i++) {
							ptd.InserirTableFornPreTriagem(id_fornecedor, ID_PreTriagem.get(i));
						}
					}

				} else if (resposta == 1) {
					JOptionPane.showMessageDialog(null, "Interrompido");
				}
			}
		});
		btnFinalizar.setBounds(389, 832, 126, 43);
		panel.add(btnFinalizar);
		btnFinalizar.setBorder(BorderFactory.createEmptyBorder());
		btnFinalizar.setBorderPainted(false);
		btnFinalizar.setContentAreaFilled(false);
		btnFinalizar.setFocusPainted(false);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancelar.setBounds(520, 832, 89, 42);
		panel.add(btnCancelar);
		btnCancelar.setBorder(BorderFactory.createEmptyBorder());
		btnCancelar.setBorderPainted(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setFocusPainted(false);

		JButton btnAdd = new JButton("");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (txtPesoMaterial.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, informe o peso", "Atenção!",
							JOptionPane.WARNING_MESSAGE);
					txtVlrKilo.setText("");
				} else {
					PreTriagemTableBean pttb = new PreTriagemTableBean();
					PreTriagemBean ptb = new PreTriagemBean();

					int indice = tablePesquisa.getSelectedRow();

					if (indice == -1) {
						JOptionPane.showMessageDialog(null, "Selecione um item para adicionar ao carrinho.");
					} else {

						double Preco_KG = (double) tablePesquisa.getValueAt(tablePesquisa.getSelectedRow(), 2);
						String PrecoKG_ToString = Double.toString(Preco_KG);

						double PesoMaterial = Double.parseDouble(txtPesoMaterial.getText());
						double ValorTotal = (Preco_KG * PesoMaterial);
						int NumLinhas = tableItensVenda.getRowCount();

						String ValorTotal_ToString = Double.toString(ValorTotal);

						int Cod_material = (int) tablePesquisa.getValueAt(tablePesquisa.getSelectedRow(), 0);

						pttb.setId_Fornecedor(id_fornecedor);
						pttb.setNome_Fornecedor(txtNomeCliente.getText());
						pttb.setId_material(Cod_material);
						pttb.setMaterial((String) tablePesquisa.getValueAt(tablePesquisa.getSelectedRow(), 1));
						pttb.setPesoMaterial(Double.parseDouble(txtPesoMaterial.getText()));
						pttb.setPreco_Kg(Preco_KG);
						pttb.setValor_total(ValorTotal);

						ptb.setId_fornecedor(id_fornecedor);
						ptb.setPeso(Double.parseDouble(txtPesoMaterial.getText()));
						ptb.setId_material(Cod_material);

						Dados.add(ptb);

						ItemTableModel.addRow(pttb);

						SomaDoValorTotal = (double) tableItensVenda.getValueAt(0, 6);
						for (int i = 1; i <= NumLinhas; i++) {
							SomaDoValorTotal += (double) tableItensVenda.getValueAt(i, 6);
						}
						System.out.println(tablePesquisa.getSelectedRows());
						System.out.println(SomaDoValorTotal);
						txtVlrKilo.setText(PrecoKG_ToString);
					}
				}
			}
		});
		btnAdd.setBounds(297, 394, 63, 26);
		panel.add(btnAdd);
		btnAdd.setBorder(BorderFactory.createEmptyBorder());
		btnAdd.setBorderPainted(false);
		btnAdd.setContentAreaFilled(false);
		btnAdd.setFocusPainted(false);

		JButton btnExcluirItem = new JButton("");
		btnExcluirItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (tableItensVenda.getSelectedRow() != -1) {
					int posicao = tableItensVenda.getSelectedRow();
					Dados.remove(posicao);

					double Valor = (double) tableItensVenda.getValueAt(tableItensVenda.getSelectedRow(), 6);
					SomaDoValorTotal = SomaDoValorTotal - Valor;

					VendaTableModel ItemTableModel = (VendaTableModel) tableItensVenda.getModel();
					ItemTableModel.removeRow(tableItensVenda.getSelectedRow());
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um item para excluir", "Aviso!",
							JOptionPane.WARNING_MESSAGE);
				}
			}

		});

		btnExcluirItem.setBounds(526, 538, 31, 23);
		panel.add(btnExcluirItem);
		btnExcluirItem.setBorder(BorderFactory.createEmptyBorder());
		btnExcluirItem.setBorderPainted(false);
		btnExcluirItem.setContentAreaFilled(false);
		btnExcluirItem.setFocusPainted(false);

		JLabel lblImagemFundo = new JLabel("");
		lblImagemFundo.setIcon(
				new ImageIcon(FornecedorVenda.class.getResource("/Imagens/material(diminuido) (2) (1) (1) (1).jpg")));
		lblImagemFundo.setBounds(0, -219, 1155, 1530);
		panel.add(lblImagemFundo);
	}

	public void BuscarIDPreTriagem(int Linhas) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int NumeroLinhas = tableItensVenda.getRowCount();

		try {
			conn = Conexao.getConection();
			String sql = "SELECT pt.id_pre_triagem FROM pre_triagem as pt ORDER BY pt.id_pre_triagem DESC LIMIT ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Linhas);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ID_PreTriagem.add(rs.getInt("pt.id_pre_triagem"));
			}
			Conexao.FecharConexao(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("Erro ao selecionar ID_PreTriagem! \n Erro: " + e.getMessage());
		}
	}

	public void preencherTableMateriais() {

		DefaultTableModel modelo = (DefaultTableModel) tablePesquisa.getModel();
		MaterialDao materialdao = new MaterialDao();

		for (MaterialBean matbean : materialdao.PesquisarDadosMaterial(mb)) {
			modelo.addRow(new Object[] { matbean.getId_material(), matbean.getMaterial(), matbean.getPreco() });
		}
	}
}
