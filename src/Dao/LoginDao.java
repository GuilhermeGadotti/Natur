package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Beans.UsuarioBean;
import Conexao.Conexao;

public class LoginDao {

	public boolean checklogin(UsuarioBean u) {

		boolean check = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = Conexao.getConection();

			String sql = "SELECT cpf_fornecedor, senha_fornecedor FROM fornecedor WHERE cpf_fornecedor = ? AND senha_fornecedor = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getCPF());
			pstmt.setString(2, u.getSenha());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				check = true;
			}
			Conexao.FecharConexao(conn, pstmt, rs);
			
		} catch (Exception ex) {
			System.out.println("Erro na validação do login. \n Erro: " + ex.getMessage());
		}
		return check;
	}
}