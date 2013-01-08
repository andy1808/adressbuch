package com.schelke.andreas.project.adressbuch;


public class Person {
	private int id;
	private String name;
	private String vorname;
	private String strasse;
	private String plz;
	private String ort;
	private String handy;
	private String festnetz;
	private String email;
	private String gebdate;
	
	public Person(String name, String vorname, String strasse, String plz, String ort, String handy, String festnetz, String email, String gebdate){
		this.name = name;
		this.vorname = vorname;
		this.strasse = strasse;
		this.plz = plz;
		this.ort = ort;
		this.handy = handy;
		this.email = email;
		this.festnetz = festnetz;
		this.gebdate = gebdate;
	}
	public int getID(){
		return this.id;
	}
	
	public void setID(int id){
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the vorname
	 */
	public String getVorname() {
		return vorname;
	}
	/**
	 * @param vorname the vorname to set
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	/**
	 * @return the strasse
	 */
	public String getStrasse() {
		return strasse;
	}
	/**
	 * @param strasse the strasse to set
	 */
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	/**
	 * @return the plz
	 */
	public String getPlz() {
		return plz;
	}
	/**
	 * @param plz the plz to set
	 */
	public void setPlz(String plz) {
		this.plz = plz;
	}
	/**
	 * @return the ort
	 */
	public String getOrt() {
		return ort;
	}
	/**
	 * @param ort the ort to set
	 */
	public void setOrt(String ort) {
		this.ort = ort;
	}
	/**
	 * @return the handy
	 */
	public String getHandy() {
		return handy;
	}
	/**
	 * @param handy the handy to set
	 */
	public void setHandy(String handy) {
		this.handy = handy;
	}
	/**
	 * @return the festnetz
	 */
	public String getFestnetz() {
		return festnetz;
	}
	/**
	 * @param festnetz the festnetz to set
	 */
	public void setFestnetz(String festnetz) {
		this.festnetz = festnetz;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the gebdate
	 */
	public String getGebdate() {
		return gebdate;
	}
	/**
	 * @param gebdate the gebdate to set
	 */
	public void setGebdate(String gebdate) {
		this.gebdate = gebdate;
	}
	
	public boolean nameStartsWith(char c, Person p){
		if(c == p.getName().charAt(0)){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean vornameStartsWith(char c, Person p){
		if(c == p.getVorname().charAt(0)){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean equals(Person p){
		if(this.getName().equals(p.getName()) && this.getVorname().equals(p.getVorname())){
			return true;
		}
		return false;
	}
	
	public String toString(){
		return this.name+", "+this.vorname+" - "+this.ort;
	}
	
}
