package controleMovimentacao.util;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Connection {

	public static Integer tipo = 1;
	private static DataSource dsMySQL;
	private static DataSource dsMySQLAux;
	private static DataSource dsSQLServer;
	private static DataSource dsSQLServerSA;

	public static Connection getConexaoMySQL() throws SQLException {

		if (dsMySQL == null)
			openMySQL();

		return (Connection) dsMySQL.getConnection();
	}

	public static Connection getConexaoMySQLAux() throws SQLException {

		if (dsMySQLAux == null)
			openMySQLAux();

		return dsMySQLAux.getConnection();
	}

	public static Connection getConexaoSQLServer() throws SQLException {

		if (dsSQLServer == null)
			openSQLServer();

		return dsSQLServer.getConnection();

	}

	public static Connection getConexaoSQLServerSA() throws SQLException {

		if (dsSQLServerSA == null)
			openSQLServerSA();

		return dsSQLServerSA.getConnection();
	}

	private static void openMySQL() {

		try {

			InitialContext ctx = new InitialContext();

			dsMySQL = (DataSource) ctx.lookup("java:comp/env/jdbc/MySQLDB");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void openMySQLAux() {

		try {

			InitialContext ctx = new InitialContext();

			dsMySQLAux = (DataSource) ctx.lookup("java:comp/env/jdbc/MySQLDBAux");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void openSQLServer() {

		try {

			InitialContext ctx = new InitialContext();

			dsSQLServer = (DataSource) ctx.lookup("java:comp/env/jdbc/SQLServerDB");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void openSQLServerSA() {

		try {

			InitialContext ctx = new InitialContext();

			dsSQLServerSA = (DataSource) ctx.lookup("java:comp/env/jdbc/SQLServerSA");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void closeMySQL() {

		try {

			if (dsMySQL != null)
				dsMySQL.close();

			dsMySQL = null;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void closeMySQLAux() {

		try {

			if (dsMySQLAux != null)
				dsMySQLAux.close();

			dsMySQLAux = null;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void closeSQLServer() {

		try {

			if (dsSQLServer != null)
				dsSQLServer.close();

			dsSQLServer = null;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void closeSQLServerSA() {

		try {

			if (dsSQLServerSA != null)
				dsSQLServerSA.close();

			dsSQLServerSA = null;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeAll() {

		closeMySQL();

		closeMySQLAux();

		closeSQLServer();

		closeSQLServerSA();

	}

	public static String getDBNameMySQL() {
		String retorno = "";

		try {
			if (dsMySQL == null)
				openMySQL();

			String url = dsMySQL.getUrl();
			retorno = url.substring(url.lastIndexOf("/") + 1, url.length());

		} catch (Exception e) {
		}

		return retorno;
	}

	public static String getDBNameSQLServer() {
		String retorno = "";

		try {
			if (dsSQLServer == null)
				openSQLServer();

			String url = dsSQLServer.getUrl();
			retorno = url.substring(url.lastIndexOf("/") + 1, url.length());

		} catch (Exception e) {
		}

		return retorno;
	}

	public static String getDBNameSQLServerSA() {
		String retorno = "";

		try {
			if (dsSQLServerSA == null)
				openSQLServerSA();

			String url = dsSQLServerSA.getUrl();
			retorno = url.substring(url.lastIndexOf("/") + 1, url.length());

		} catch (Exception e) {
		}

		return retorno;
	}

	public static boolean testaConexao(int conexao) {
		boolean resultado = false;
		Connection conn = null;
		String msgLog = "";
		try {
			switch (conexao) {
			case VARIAVEIS.CONEXAO_MYSQL:
				msgLog = "jdbc/MySQLDB";
				conn = getConexaoMySQL();
				break;
			case VARIAVEIS.CONEXAO_SQLSERVER:
				msgLog = "jdbc/SQLServerDB";
				conn = getConexaoSQLServer();
				break;
			case VARIAVEIS.CONEXAO_SQLSERVER_ADMIN:
				msgLog = "jdbc/SQLServerSA";
				conn = getConexaoSQLServerSA();
				break;
			}
			PreparedStatement stm = conn.prepareStatement("select 1");
			ResultSet res = stm.executeQuery();
			if (res.next()) {
				if (res.getInt(1) == 1)
					resultado = true;
			}
			res.close();
			stm.close();
		} catch (Exception e) {
			resultado = false;
		} finally {
			METODOS.closeConnection(conn);
			if (resultado)
				msgLog += " ON";
			else
				msgLog += " OFF";

			System.out.println(msgLog);
		}

		return resultado;
	}

}
