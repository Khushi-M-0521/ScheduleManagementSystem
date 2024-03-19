package myswingobjects;

import java.awt.Color;

import javax.swing.JButton;

public class MyButton extends JButton{
	MyButton(String title,int x,int y, int width, int height){
		super(title);
		this.setBackground(Color.WHITE);
		this.setForeground(Color.BLACK);
		this.setBounds(x, y, width, height);
		this.setFocusable(false);
	}
}
