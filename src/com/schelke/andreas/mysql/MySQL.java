package com.schelke.andreas.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author andreas
 * 
 */
public class MySQL {
	private String username = "";
	private String password = "";
	private String driver = "com.mysql.jdbc.Driver";
	private String path = "jdbc:mysql://";
	private Connection connection;

	public MySQL() {
		try {
			this.connect();
			System.out.println("Connection hergestellt");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Konstruktor
	 * 
	 * @param username
	 * @param password
	 * @param path
	 *            Pfad: jdbc:mysql:// ist zu ergänzen
	 */
	public MySQL(String username, String password, String path) {
		this.username = username;
		this.password = password;
		this.path += path;
		try {
			this.connect();
			System.out.println("Connection hergestellt zu: "+path);

		} catch (Exception e) {
			System.err.println("Connection failed.. Try again later..");
		}
	}

	/*
	 * Connect registriert den JDBC Treiber und versucht eine Verbindung
	 * herzustellen. Sollte dies nicht möglich sein, wird eine Exception
	 * ausgelöst
	 */
	public void connect() {
		try {
			Class.forName(this.driver);
			this.connection = DriverManager.getConnection(this.path,
					this.username, this.password);
		} catch (Exception e) {
			System.err.println("Trying to connect failed...");
			System.err.println(e.getMessage());
		}

	}

	/*
	 * Die Funktion Close() schließt das Query um den Speicher wieder frei zu
	 * geben
	 */
	public void close() {
		if (this.connection != null) {
			try {
				this.connection.close();
				System.out.println("Connection closed successfully");
			} catch (Exception e) {
				System.err.println("Connection close failed..");
				System.err.println(e.getMessage());
			}

		}
	}

	/*
	 * frägt ein einfaches Query ab, welches "1" zurück liefert, falls man
	 * verbunden ist
	 */
	public boolean isConnected() {
		try {
			ResultSet rs = this.returnQuery("SELECT 1;");
			if (rs == null) {
				return false;
			}
			if (rs.next()) {
				return true;
			}
			return false;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	/* Sendet ein Query und erwartet eine Rückgabe in Form eines ResultSet */
	public ResultSet returnQuery(String query) {
		try {
			Statement stmt = this.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return null;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	/* Führt das query aus, erwartet aber keine Rückantwort des Servers. */
	public boolean runQuery(String query) {
		try {
			Statement stmt = this.connection.createStatement();
			return stmt.execute(query);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
}