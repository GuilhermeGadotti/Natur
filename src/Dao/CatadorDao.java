package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Beans.CatadorBean;
import Conexao.Conexao;

public class CatadorDao {

	public void CadastrarCatador(CatadorBean CatadorBean) {

		if (CatadorBean != null) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = Conexao.getConection();
				String sql = "INSERT INTO catador VALUES (default, ?, ?, ?, ?, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, CatadorBean.getNome());
				pstmt.setString(2, CatadorBean.getCpf());
				pstmt.setString(3, CatadorBean.getSenha());
				pstmt.setString(4, CatadorBean.getCidade_Atuação());
				pstmt.setString(5, CatadorBean.getUF());
				pstmt.setString(6, CatadorBean.getTelefone());
				pstmt.setString(7, CatadorBean.getEmail());
				pstmt.execute();

				Conexao.FecharConexao(conn, pstmt);
			} catch (Exception e) {
				System.out.println("Erro ao cadastrar Catador! \n Erro: " + e.getMessage());
				e.printStackTrace();
			}
		} else {
			System.out.println("Parametro 'CatadorBean' está vazio!");
		}
	}

	public boolean VerificarContaExistente(CatadorBean CatadorBean) {
		boolean CheckConta = false;
		if (CatadorBean != null) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				conn = Conexao.getConection();
				String sql = "SELECT * FROM catador AS c WHERE c.cpf_catador = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, CatadorBean.getCpf());
				rs = pstmt.executeQuery();

				if (rs.next()) {
					CheckConta = true;
				}
				Conexao.FecharConexao(conn, pstmt, rs);
			} catch (Exception e) {
				System.out.println("Erro na verificação da conta do Catador! \n Erro: " + e.getMessage());
				e.printStackTrace();
			}
		} else {
			System.out.println("Parametro CatadorBean está vazio!");
		}

		return CheckConta;
	}

	public boolean LoginCatador(CatadorBean CatadorBean) {
		boolean CheckLogin = false;
		if (CatadorBean != null) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				conn = Conexao.getConection();
				String sql = "SELECT * FROM catador AS c WHERE c.cpf_catador = ? AND c.sen_catador = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, CatadorBean.getCpf());
				pstmt.setString(2, CatadorBean.getSenha());
				rs = pstmt.executeQuery();

				if (rs.next()) {
					CheckLogin = true;
				}
				Conexao.FecharConexao(conn, pstmt, rs);
			} catch (Exception e) {
				System.out.println();
			}
		} else {
			System.out.println("Parametro CatadorBean está vazio! ");
		}
		return CheckLogin;
	}

	public void BuscarDadosCatador(String CPF, CatadorBean CatadorBean) {
		if (CPF != null) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = Conexao.getConection();
				String sql = "SELECT * FROM catador AS c WHERE c.cpf_catador = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, CPF);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					CatadorBean.setID(rs.getInt(""));
					CatadorBean.setNome(rs.getString(""));
					CatadorBean.setCpf(rs.getString(""));
					CatadorBean.setCidade_Atuação(rs.getString(""));
					CatadorBean.setUF(rs.getString(""));
					CatadorBean.setEmail(rs.getString(""));
					CatadorBean.setTelefone(rs.getString(""));
				}
				Conexao.FecharConexao(conn, pstmt, rs);
			} catch (Exception e) {
				System.out.println("Erro ao buscar dados do Catador! \n Erro: " + e.getMessage());
				e.printStackTrace();
			}
		} else {
			System.out.println("Parametro 'CPF' está vazio!");
		}
	}
}
