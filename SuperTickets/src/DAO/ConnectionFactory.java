package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection createConnection() throws SQLException, ClassNotFoundException{

		String url = "jdbc:mysql://localhost:3306/loja"; //Nome da base de dados
		String user = "root"; //nome do usuário do MySQL
		String password = "root"; //senha do MySQL

        Class.forName("com.mysql.jdbc.Driver");

		Connection conexao = DriverManager.getConnection(url, user, password);

		return conexao;

	}
}
