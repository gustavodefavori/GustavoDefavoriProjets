package controleMovimentacao;

import java.sql.*;

public class Connection {
	java.sql.Connection connection;
	String driveName;
	String serverName;
	String myDatabase;
	String url;
	String username;
	String passwoard;
	
	public Connection () {
		this.connection = null;
		this.serverName = "localhost";
		this.myDatabase = "Controle_Movimentacao";
		this.url = "jdbc:mysql://" + this.serverName + "/" + this.myDatabase;
		this.username = "root";
		this.passwoard = "jma123366";
		
	}
	
	public java.sql.Connection getConection () {
		try {
			this.connection = DriverManager.getConnection(this.url, this.username, this.passwoard);
			if (connection != null) {
				return connection;
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
		}
	}
	public boolean closeConection () {
		try {
			getConection().close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
		}
	}

}