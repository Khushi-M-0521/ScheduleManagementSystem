package myswingobjects;

import java.awt.Color;

import javax.swing.JButton;

public class MyButton extends JButton{
	public MyButton(String title,int x,int y, int width, int height){
		super(title);
		this.setBackground(Color.WHITE);
		this.setForeground(Color.BLACK);
		this.setBounds(x, y, width, height);
		this.setFont(new myFont(12));
		this.setFocusable(false);
	}
}
