/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Женя
 */
public class ConnectorDB {

	private Connection connection;

	public ConnectorDB() {
		ResourceBundle resource = ResourceBundle.getBundle("props/database");
		String url = resource.getString("db.url");
		String user = resource.getString("db.user");
		String password = resource.getString("db.password");

		try {/*
				 * До появления JDBC 4.0 объект
				 * драйвера СУБД нужно было
				 * создавать явно с помощью вызова
				 * соответственно:
				 * Class.forName("com.mysql.jdbc.Driver");
				 * Class.forName("oracle.jdbc.OracleDriver"); или
				 * зарегистрировать драйвер
				 * DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				 * DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
				 * В большинстве случаев в этом нет
				 * необходимости, так как экземпляр
				 * драй- вера загружается
				 * автоматически при попытке
				 * получения соединения с БД.
				 * 
				 * Но если этого не сделать, то--
				 * ошибка !!!!!!!!!
				 */
			Class.forName(resource.getString("db.driver"));
			connection = DriverManager.getConnection(url, user, password);
			if (connection == null) {
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!connection = null");
			}

		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(ConnectorDB.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public Statement getStatement() throws SQLException {
		if (connection != null) {
			Statement st = connection.createStatement();
			if (st != null) {
				return st;
			}
		}
		throw new SQLException("connection or statement is null");
	}

	public PreparedStatement getPreparedStatement(String SQLRequest) throws SQLException {
		if (connection != null) {
			PreparedStatement ps = connection.prepareStatement(SQLRequest);
			if (ps != null) {
				return ps;
			}
		}
		throw new SQLException("connection or statement is null");
	}

	public void closeStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException ex) {
				System.err.println("statement is null: " + ex);
			}
		}
	}

	public void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException ex) {
				System.err.println("connection is wrong: " + ex);
			}
		}
	}
}
