package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Beans.AdministradorBean;
import Beans.AdministradorLoginBean;
import Conexao.Conexao;

public class AdministradorDao {

	public boolean checkLogin(AdministradorLoginBean alb) {

		boolean check = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";

		try {
			conn = Conexao.getConection();
			sql = "SELECT usuario_adm, senha_adm FROM administrador WHERE usuario_adm = ? AND senha_adm = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, alb.getUsuario_adm());
			pstmt.setString(2, alb.getSenha_adm());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				check = true;
			} else {
				check = false;
			}
			Conexao.FecharConexao(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("Erro na validação do login do Administrador! \n Erro: " + e.getMessage());
		}
		return check;
	}

	public void DadosAdministrador(AdministradorLoginBean alb, AdministradorBean ab) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";

		try {
			conn = Conexao.getConection();
			sql = "SELECT * FROM administrador WHERE usuario_adm = ? AND senha_adm = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, alb.getUsuario_adm());
			pstmt.setString(2, alb.getSenha_adm());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				ab.setId_adm(rs.getInt("id_adm"));
				ab.setusuario_adm(rs.getString("usuario_adm"));
				ab.setSenha_adm(rs.getString("senha_adm"));
				ab.setSex_adm(rs.getString("sex_adm"));
				ab.setCpf_adm(rs.getString("cpf_adm"));
				ab.setEmail_adm(rs.getString("email_adm"));
			}
			Conexao.FecharConexao(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("Falha ao inserir dados do ADM! \n Erro: " + e.getMessage());
		}
	}

	public void AlterarDadosAdministrador(AdministradorBean ab) {

		PreparedStatement pstmt = null;
		String sql = "";
		if (ab != null) {
			Connection conn = null;

			try {
				conn = Conexao.getConection();
				sql = "UPDATE administrador SET usuario_adm = ?, senha_adm = ?, sex_adm = ?, cpf_adm = ?, email_adm = ? WHERE id_adm = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, ab.getusuario_adm());
				pstmt.setString(2, ab.getSenha_adm());
				pstmt.setString(3, ab.getSex_adm());
				pstmt.setString(4, ab.getCpf_adm());
				pstmt.setString(5, ab.getEmail_adm());
				pstmt.setInt(6, ab.getId_adm());
				pstmt.executeUpdate();

				Conexao.FecharConexao(conn, pstmt);
			} catch (Exception e) {
				System.out.println("Falha ao alterar dados do adm! \n Erro: " + e.getMessage());
			}

		}

	}
	public void InserirNovoMaterial(int ID,String Material, double Preco){	//Add um novo material na tabela material
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String addMaterial  = "INSERT INTO material VALUES (default, ?)";
		String buscaId 		= "SELECT id_material FROM material WHERE material = ?";
		String addPrecoMaterial = "INSERT INTO preco_material values(?, ?)";
		
		try {
			conn = Conexao.getConection();
			pstmt = conn.prepareStatement(addMaterial);
			pstmt.setString(1, Material);
			pstmt.execute();
			Conexao.FecharConexao(conn, pstmt);
			
			conn = Conexao.getConection();
			pstmt = conn.prepareStatement(buscaId);
			pstmt.setString(1, Material);
			rs = pstmt.executeQuery();
			if(rs.next()){
				ID = rs.getInt("id_material");
			}
			Conexao.FecharConexao(conn, pstmt, rs);
			
			conn = Conexao.getConection();
			pstmt = conn.prepareStatement(addPrecoMaterial);
			pstmt.setInt(1, ID);
			pstmt.setDouble(2, Preco);
			pstmt.execute();
			Conexao.FecharConexao(conn, pstmt); 
		} catch (Exception e) {
			System.out.println("Falha ao inserir novo material! \n Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
