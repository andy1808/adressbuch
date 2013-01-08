package com.schelke.andreas.project.adressbuch;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.schelke.andreas.mysql.MySQL;

public class Adressbuch {
	private MySQL connection;

	public Adressbuch() {
		connection = new MySQL("java", "password", "localhost/java");
	}

	public boolean add(Person person) {
		String query = "INSERT INTO adressbuch (name, vorname, strasse, plz, ort, handy, festnetz, email, gebdate) VALUES (\""
				+ person.getName()
				+ "\", \""
				+ person.getVorname()
				+ "\", \""
				+ person.getStrasse()
				+ "\", \""
				+ person.getPlz()
				+ "\", \""
				+ person.getOrt()
				+ "\", \""
				+ person.getHandy()
				+ "\", \""
				+ person.getFestnetz()
				+ "\", \""
				+ person.getEmail()
				+ "\", \"" + person.getGebdate() + "\" " + ")";
		return connection.runQuery(query);
		// INSERT INTO `java`.`adressbuch` (`name`, `vorname`, `strasse`, `plz`,
		// `ort`, `handy`, `festnetz`, `email`, `gebdate`) VALUES ();
	}

	public void delete(Person person) {
		int id = 0;
		ResultSet rs = connection.returnQuery("SELECT id FROM adressbuch WHERE name = \""
				+ person.getName() + "\" AND vorname = \""
				+ person.getVorname() + "\"");
		try {
			while(rs.next()) id = rs.getInt("id");
			System.out.println("Personen ID: " + id);
		} catch (SQLException e) {
			System.err.println("FAIL: " + e.getMessage());
			return;
		}
		connection.runQuery("DELETE FROM adressbuch WHERE id = "+id);

	}

	public LinkedList<Person> list() {
		try {
			ResultSet rs = connection
					.returnQuery("SELECT * FROM adressbuch ORDER BY name ASC");
			LinkedList<Person> returnAll = new LinkedList<Person>();
			while (rs.next()) {
				returnAll.add(new Person(rs.getString("name"), rs
						.getString("vorname"), rs.getString("strasse"), rs
						.getString("plz"), rs.getString("ort"), rs
						.getString("handy"), rs.getString("festnetz"), rs
						.getString("email"), rs.getString("gebdate")));
			}
			return returnAll;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	public void print(char c) {
		for (Person p : this.list()) {
			// System.out.println("Eintrag");
			if (p.nameStartsWith(c, p))
				System.out.println(p.toString());
		}
	}

	public static void main(String[] args) {
		//@SuppressWarnings("unused")
		Adressbuch ab = new Adressbuch();
		System.out.println("");
		ab.delete(new Person("Mustermann", "Max", null, null, null, null, null, null, null));
		// System.out.println(ab.add(new Person("Mustermann", "Max",
		// "Musterstr", "12345", "Musterhausen", "0123 - 4567890",
		// "09876 - 54321", "max@mustermann.de", "01.01.1970")));

		// System.out.println(ab.connection.isConnected());

	}
}
