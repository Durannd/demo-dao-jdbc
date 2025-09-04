package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	private static Connection conn = null;

	public static Connection getConnection() {
		try {
			if (conn == null) {
				Properties pros = loadProperties();
				String url = pros.getProperty("dburl");
				conn = DriverManager.getConnection(url, pros);
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		return conn;
	}

	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.yml")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}

	}

	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeStatement(Statement s) {
		if(s!=null) {
			try {
				s.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	public static void closeResultSet(ResultSet s) {
		if(s!=null) {
			try {
				s.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
}
