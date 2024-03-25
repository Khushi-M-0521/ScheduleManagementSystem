package myswingobjects;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import screens.AddTT;

public class Lab1 extends JPanel{
	int n;
	JPanel parent;
	JPanel tt;
	AddTT TT;
	
	public void setLab2Panel() {
		String[] lbhs=database.Database.labHandlers(TT.section);
		String blks[]=database.Database.blks();
		String clrs[]=database.Database.clrs();
		parent.remove(this);
		parent.add(new Lab2(lbhs,blks,clrs,n,0,0));
		tt.add(parent);
		TT.repaint();
	}
	
	public Lab1(int x,int y,JPanel parent,JPanel tt,AddTT TT){
		this.setBounds(x,y,85,63);
		this.setLayout(null);
		this.parent=parent;
		this.TT=TT;
		this.tt=tt;
		//this.setBackground(Color.lightGray);
		
		JLabel nob=new JLabel(" No. of batches");
		nob.setBounds(5,5,75,20);
		nob.setFont(new myFont(10));
		this.add(nob);
		
		JTextField num=new JTextField("Max 4");
		num.setBounds(5,5+19,75,14);
		num.setFont(new myFont(8));
		//num.setFocusable(false);
		//num.setBackground(Color.white);
		this.add(num);
		
		MyButton b=new MyButton("Next",5,5+24+14,75,14);
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				n=Integer.parseInt(num.getText()) ;
				setLab2Panel();
			}
			
		});
		b.setFont(new myFont(8));
		this.add(b);
	}

}
