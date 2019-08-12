package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Beans.FornecedorBeans;
import Conexao.Conexao;

public class CadastrarDao {

	public void cadastrar(FornecedorBeans pb) {

		if (pb != null) {
			Connection conn = null;

			try {
				conn = Conexao.getConection();

				String sql = "INSERT INTO fornecedor (nome_fornecedor, cpf_fornecedor, senha_fornecedor, dt_nasc_fornecedor, end_fornecedor, cep_fornecedor, tele_fornecedor, sex_fornecedor, email_fornecedor ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement pstmt;	
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, pb.getNmfornecedoor());
				pstmt.setString(2, pb.getCpffornecedor());
				pstmt.setString(3, pb.getSenhafornecedor());
				pstmt.setString(4, pb.getDtnascfornecedor());
				pstmt.setString(5, pb.getEndfornecedor());
				pstmt.setString(6, pb.getCepfornecedor());
				pstmt.setString(7, pb.getTelefornecedor());
				pstmt.setString(8, pb.getSexofornecedor());
				pstmt.setString(9, pb.getEmailfornecedor());
				pstmt.execute();
				
				Conexao.FecharConexao(conn, pstmt);
				
			} catch (Exception e) {
				System.err.print("Falha no cadastro do fornecedor! \n Erro: " + e.getMessage());
			}
		}
		else {
			System.out.println("Fornecedor enviado por parametro está vazio!");
		}
	}

	public boolean checkCPF(FornecedorBeans fb) {
		
		boolean checkCPF = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";

		try {
			conn = Conexao.getConection();
			
			sql = "SELECT cpf_fornecedor FROM fornecedor WHERE cpf_fornecedor = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fb.getCpffornecedor());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				checkCPF = false;
			} else {
				checkCPF = true;
			}
			Conexao.FecharConexao(conn, pstmt, rs);
			
		} catch (Exception e) {
			System.err.print("Erro na validação do CPF. \n Erro: " + e.getMessage());
		}
		return checkCPF;
	}

}