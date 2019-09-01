package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Beans.MaterialBean;
import Conexao.Conexao;

public class MaterialDao {

	public List<MaterialBean> PesquisarDadosMaterial(MaterialBean mb) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		List<MaterialBean> Materiais = new ArrayList<MaterialBean>();

		try {
			conn = Conexao.getConection();
			sql = "SELECT (vm.id_material)ID, (vm.material) Material, (vm.preco)Preço FROM view_material as vm WHERE vm.material like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + mb.getMaterial() + "%");
			rs = pstmt.executeQuery();

			while(rs.next()) {
					MaterialBean materialbean = new MaterialBean();
					materialbean.setId_material(rs.getInt("ID"));
					materialbean.setMaterial(rs.getString("Material"));
					materialbean.setPreco(rs.getDouble("Preço"));	
					Materiais.add(materialbean);
			}
			Conexao.FecharConexao(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("Erro ao selecionar materiais. zn Erro: " + e.getMessage());
		}
		return Materiais;
	}
}
