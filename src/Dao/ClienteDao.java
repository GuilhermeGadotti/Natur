package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Beans.ClienteBean;
import Beans.ClienteLoginBean;
import Conexao.Conexao;

public class ClienteDao {

	public void CadastrarCliente(ClienteBean cb) {
		
		if(cb != null) {
			Connection conn = null;
			
			try {
				conn = Conexao.getConection();
				
				String sql = "INSERT INTO clientes (nm_cliente, cnpj_cliente, sen_cliente, cep_cliente, local_cliente, tele_cliente, email_cliente) VALUES (?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, cb.getNome_cliente());
				pstmt.setString(2, cb.getCnpj_cliente());
				pstmt.setString(3, cb.getSenha_cliente());
				pstmt.setString(4, cb.getCep_cliente());
				pstmt.setString(5, cb.getLocalizacao_cliente());
				pstmt.setString(6, cb.getTelefone_cliente());
				pstmt.setString(7, cb.getEmail_cliente());
				
				pstmt.execute();
				
				Conexao.FecharConexao(conn, pstmt);
				
			} catch (Exception e) {
				System.out.println("Falha ao cadastrar cliente! \n ERRO: " + e.getMessage());
			}
		}
		else {
			System.out.println("Parâmetro 'ClienteBean cb' está vazio.");
		}
	}
	
	public void AlterarDadosCliente(ClienteBean cb) {
		
		if(cb != null) {
			Connection conn = null;
			
			try {
				conn = Conexao.getConection();
				
				String sql = "UPDATE clientes SET nm_cliente = ?, cnpj_cliente = ?, cep_cliente = ?, local_cliente = ?, tele_cliente = ?, email_cliente = ? WHERE id_cliente = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, cb.getNome_cliente());
				pstmt.setString(2, cb.getCnpj_cliente());
				pstmt.setString(3, cb.getCep_cliente());
				pstmt.setString(4, cb.getLocalizacao_cliente());
				pstmt.setString(5, cb.getTelefone_cliente());
				pstmt.setString(6, cb.getEmail_cliente());
				pstmt.setInt(7, cb.getId_cliente());
				
				pstmt.executeUpdate();
				
				Conexao.FecharConexao(conn, pstmt);
				
			} catch (Exception e) {
				System.out.println("Falha ao atualizar dados do cliente! \n ERRO: " + e.getMessage());
			}
		}
		else {
			System.out.println("Parâmetro 'ClienteBean cb' está vazio.");
		}
	}
	public boolean checkLoginCliente(ClienteLoginBean clb) {
		
		boolean check = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			conn = Conexao.getConection();
			sql = "SELECT cnpj_cliente, sen_cliente FROM clientes WHERE cnpj_cliente = ? AND sen_cliente = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, clb.getCnpj_cliente());
			pstmt.setString(2, clb.getSenha_cliente());
			rs = pstmt.executeQuery();		
			if(rs.next()) {
				check = true;
			}
			Conexao.FecharConexao(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("Erro na validação do Login Cliente. \n Erro: " + e.getMessage());
		}
		return check;
	}
	
	public boolean checkCNPJ(ClienteBean cb) {
		
		boolean checkCNPJ = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			conn = Conexao.getConection();
			
			sql = "SELECT cnpj_cliente FROM clientes WHERE cnpj_cliente = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cb.getCnpj_cliente());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				checkCNPJ = false;
			}
			else {
				checkCNPJ = true;
			}
			Conexao.FecharConexao(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("Falha na Verificação do CNPJ! \n Erro: " + e.getMessage());
		}
		return checkCNPJ;
	}
}
