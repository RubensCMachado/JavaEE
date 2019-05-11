package javadb.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class testeConnection {
	public static void main(String[] args) throws SQLException {
		Connection con = new ConnectionFactory().GetConnection();
		System.out.println("Conectado ao banco de dados MariaDB Local");
		con.close();

	}
}
