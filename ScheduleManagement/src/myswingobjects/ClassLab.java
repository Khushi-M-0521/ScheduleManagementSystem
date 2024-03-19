package myswingobjects;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ClassLab extends JPanel{
	public ClassLab(int x,int y){
		this.setBounds(x,y,85,63);
		//this.setBackground(Color.lightGray);
		this.setLayout(null);
		
		MyButton cls=new MyButton("CLASS",5,5,75,14);
		this.add(cls);
		
		MyButton lab=new MyButton("LAB",5,5+19,75,14);
		this.add(lab);
		
		MyButton gap=new MyButton("GAP",5,5+24+14,75,14);
		this.add(gap);
		
	}
}
