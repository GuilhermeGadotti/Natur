package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Beans.PreTriagemBean;
import Conexao.Conexao;

public class PreTriagemDao {

	public void InserirDados(PreTriagemBean ptb) {

		if (ptb != null) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "";

			try {
				conn = Conexao.getConection();

				sql = "INSERT INTO pre_triagem VALUES (default, ?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, ptb.getId_material());
				pstmt.setInt(2, ptb.getId_fornecedor());
				pstmt.setDouble(3, ptb.getPeso());
				pstmt.execute();

				Conexao.FecharConexao(conn, pstmt);
			} catch (Exception e) {
				System.out.println("Erro na inserção na tabela pre_triagem! \n Erro: " + e.getMessage());
			}
		} else {
			System.out.println("Valor passado por parametro(ptb) é nulo!");
		}
	}

	public void BuscarIDPreTriagem(int Linhas) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = Conexao.getConection();
			String sql = "SELECT pt.id_pre_triagem FROM pre_triagem as pt ORDER BY pt.id_pre_triagem DESC LIMIT ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Linhas);
			rs = pstmt.executeQuery();

			Conexao.FecharConexao(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("Erro ao selecionar ID_PreTriagem! \n Erro: " + e.getMessage());
		}
	}
	public void InserirTableFornPreTriagem(int ID_Fornecedor,int ID_PreTriagem){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = Conexao.getConection();
			String sql = "INSERT INTO fornecedor_pretriagem VALUES (default, ?, ?, now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ID_Fornecedor);
			pstmt.setInt(2,ID_PreTriagem);
			pstmt.execute();
			
			Conexao.FecharConexao(conn, pstmt);
		} catch (Exception e) {
			System.out.println("Erro ao inserir na tabela Fornecedor_PreTriagem! \n Erro: " + e.getMessage());
		}
	}
	public ArrayList<Integer> BuscaIDPreTriagem(int Linhas) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Integer> Id_PreTriagem = new ArrayList<Integer>();
		
		try {
			conn = Conexao.getConection();
			String sql = "SELECT pt.id_pre_triagem FROM pre_triagem as pt ORDER BY pt.id_pre_triagem DESC LIMIT ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Linhas);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Id_PreTriagem.add(rs.getInt("pt.id_pre_triagem"));
			}
			Conexao.FecharConexao(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("Erro ao selecionar ID_PreTriagem! \n Erro: " + e.getMessage());
		}
		return Id_PreTriagem;	
	}
}
