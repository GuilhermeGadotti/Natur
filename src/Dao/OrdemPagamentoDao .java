package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Beans.PreTriagemBean;
import Beans.PreTriagemTableBean;
import Conexao.Conexao;

public class OrdemPagamentoDao {
	
	public void Inserir(PreTriagemTableBean pttb){
		
		if(pttb != null){
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = Conexao.getConection();
				String sql = "INSERT INTO ordem_pagamento VALUES (default, ?, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, pttb.getId_Fornecedor());
				pstmt.setDouble(2, pttb.getValor_total());
				pstmt.execute();
				Conexao.FecharConexao(conn, pstmt);		
			} catch (Exception e) {
				System.out.println("Erro ao inserir na tabela 'Ordem_Pagamento'! \n Erro: " + e.getMessage());
			}
		}
		else{
			System.out.println("Parâmetro 'pttb' está vazio!");
		}
	}
	

}
