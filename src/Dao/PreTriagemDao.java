package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Beans.MaterialBean;
import Conexao.Conexao;

public class PreTriagemDao {

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

			if (rs.next()) {
				mb.setId_material(rs.getInt("id_preco"));
				mb.setPreco(rs.getDouble("preco_material"));
			}

			Conexao.FecharConexao(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("Erro ao consultar dados do material! \n Erro: " + e.getMessage());
		}
	}
}
