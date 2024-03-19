package myswingobjects;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClassLab extends JPanel{
	JPanel parent;
	JPanel tt;
	JFrame TT;
	public void setClassPanel() {
		String s[]= {"hello","hi"};
		//System.out.println("ok");
		parent.remove(this);
		parent.add(new ClassPanel(s,s,s,s,0,0));
		tt.add(parent);
		TT.repaint();
	}
	
	public ClassLab(int x,int y,JPanel parent,JPanel tt,JFrame TT){
		this.setBounds(x,y,85,63);
		//this.setBackground(Color.lightGray);
		this.setLayout(null);
		this.parent=parent;
		this.TT=TT;
		this.tt=tt;
		
		MyButton cls=new MyButton("CLASS",5,5,75,14);
		cls.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				setClassPanel();
				
				
			}
			
		});
		this.add(cls);
		
		MyButton lab=new MyButton("LAB",5,5+19,75,14);
		this.add(lab);
		
		MyButton gap=new MyButton("GAP",5,5+24+14,75,14);
		this.add(gap);
		
	}
}
