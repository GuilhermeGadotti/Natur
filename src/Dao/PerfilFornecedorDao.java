package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Beans.PerfilBean;
import Conexao.Conexao;

public class PerfilFornecedorDao {

	public void PerfilFornecedor(String cpf, PerfilBean pb) {

		if (cpf != null) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "";

			try {
				conn = Conexao.getConection();

				sql = "SELECT id_fornecedor, nome_fornecedor, cpf_fornecedor, dt_nasc_fornecedor, end_fornecedor, cep_fornecedor, tele_fornecedor, sex_fornecedor, email_fornecedor  ";
				sql += "FROM fornecedor WHERE cpf_fornecedor = ? ";

				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, cpf);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					pb.setId_fornecedor(rs.getInt("id_fornecedor"));
					pb.setNome_fornecedor(rs.getString("nome_fornecedor"));
					pb.setCpf_fornecedor(rs.getString("cpf_fornecedor"));
					pb.setDtNasc_fornecedor(rs.getString("dt_nasc_fornecedor"));
					pb.setEndereco_fornecedor(rs.getString("end_fornecedor"));
					pb.setCep_fornecedor(rs.getString("cep_fornecedor"));
					pb.setTele_fornecedor(rs.getString("tele_fornecedor"));
					pb.setSexo_fornecedor(rs.getString("sex_fornecedor"));
					pb.setEmail_fornecedor(rs.getString("email_fornecedor"));
				}

				Conexao.FecharConexao(conn, pstmt, rs);

			} catch (Exception ex) {
				System.out.println("Erro no perfil do fornecedor. \n Erro: " + ex.getMessage());
			}
		} else {
			System.out.println("Valor 'CPF' enviado por parâmetro é nulo!");
		}
	}

	public void AtualizarDadosFornecedor(PerfilBean pb) {

		PreparedStatement pstmt = null;
		String sql = "";
		if (pb != null) {
			Connection conn = null;

			try {
				conn = Conexao.getConection();

				sql = "UPDATE fornecedor SET nome_fornecedor=?, cpf_fornecedor=?, dt_nasc_fornecedor=?,"
						+ " end_fornecedor=?, cep_fornecedor=?, tele_fornecedor=?, email_fornecedor=? WHERE id_fornecedor = ?";

				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, pb.getNome_fornecedor());
				pstmt.setString(2, pb.getCpf_fornecedor());
				pstmt.setString(3, pb.getDtNasc_fornecedor());
				pstmt.setString(4, pb.getEndereco_fornecedor());
				pstmt.setString(5, pb.getCep_fornecedor());
				pstmt.setString(6, pb.getTele_fornecedor());
				pstmt.setString(7, pb.getEmail_fornecedor());
				pstmt.setInt(8, pb.getId_fornecedor());
				pstmt.executeUpdate();

				Conexao.FecharConexao(conn);
			} catch (Exception ex) {
				System.out.println("Falha na atualição do perfil do fornecedor. \n Erro: " + ex.getMessage());
			}
		} else {
			System.out.println("Perfil enviado por parâmetro está vazio!");
		}
	}

	public boolean checkEstadoFornecedor(String cpf) {
		boolean checkLogado = false;

		if (cpf != null) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "";

			try {
				conn = Conexao.getConection();

				sql = "SELECT id_fornecedor, nome_fornecedor, cpf_fornecedor, dt_nasc_fornecedor, end_fornecedor, cep_fornecedor, tele_fornecedor, sex_fornecedor, email_fornecedor  ";
				sql += "FROM fornecedor WHERE cpf_fornecedor = ? ";

				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, cpf);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					checkLogado = true;
				}

				Conexao.FecharConexao(conn, pstmt, rs);

			} catch (Exception ex) {
				System.out.println("Erro no perfil do fornecedor. \n Erro: " + ex.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Login não efetuado!");
		}
		return checkLogado;
	}
}
