package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {

	private  static final String userName = "root";
	private static final String password = "";
	private static final String url = "jdbc:mysql://localhost/projeto_reciclagem?useSSL=false&useTimezone=true&serverTimezone=UTC&useS";
	
	public static Connection getConection () {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, userName, password); // Realiza a conexao com o banco; Retorna true (se conectar) e false(se não conectar)
			return conn;
			
		} catch (SQLException ex) {
			System.out.println("Erro ao conectar com o banco. \n Erro: " + ex.getMessage());
		}
		return conn;
	}
	
	public static void  FecharConexao(Connection conn) {
		
		try {
			if(conn != null) {
				conn.close();
				System.out.println("Conexão com o banco encerrada com sucesso!");
			}
		} catch (Exception e) {
			System.out.println("Falha em finalizar a conexão com o banco. \n Erro: " + e.getMessage());
		}
	}
	
	public static void FecharConexao(Connection conn, PreparedStatement pstmt) {
		
		try {
			if(conn != null) {
				FecharConexao(conn);
			}
			if(pstmt != null) {
				pstmt.close();
				System.out.println("PreparedStatement finalizado com sucesso!");
			}
		} catch (Exception e) {
			System.out.println("Falha ao finalizar o PreparedStatement! \n Erro: " + e.getMessage());
		}
	}
	
	public static void FecharConexao(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		
		try {
			if(conn != null || pstmt != null) {
				FecharConexao(conn, pstmt);
			}
			if(rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			System.out.println("Falha ao finalizar o ResultSet! \n Erro: " + e.getMessage());
		}
	}
}