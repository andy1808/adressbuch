package com.schelke.andreas.project.adressbuch;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 
 * @author Andreas Schelke
 * @version 0.1
 */
public class AdressbuchGUI {
	private Adressbuch adressbuch;
	private JFrame frame;
	private JPanel panel;
	public AdressbuchGUI(){
		adressbuch = new Adressbuch();
		frame = new JFrame("Adressbuch");
		panel = new JPanel();
		frame.add(panel);
		show(adressbuch);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void show(Adressbuch adressbuch){
		try{
			for (Person p : adressbuch.list()) {
				//System.out.println(p.toString());
				this.panel.add(new JLabel(p.toString()));
			}
		} catch (Exception e){
			System.err.println(e.getMessage());
		}
	}
	public static void main(String[] args) {
		new AdressbuchGUI();
	}
}
