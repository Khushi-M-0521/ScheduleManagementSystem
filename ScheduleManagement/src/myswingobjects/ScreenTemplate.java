package myswingobjects;

import java.awt.Color;

import javax.swing.JFrame;

public class ScreenTemplate extends JFrame {
	ScreenTemplate(String title){
		super();
		this.setBounds(100, 100, 500, 500);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle(title);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.WHITE);
	}
}
