package myswingobjects;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Lab1 extends JPanel{
	public Lab1(int n,int x,int y){
		this.setBounds(x,y,85,63);
		this.setLayout(null);
		//this.setBackground(Color.lightGray);
		
		JLabel nob=new JLabel(" No. of batches");
		nob.setBounds(5,5,75,20);
		nob.setFont(new myFont(10));
		this.add(nob);
		
		String[] s=new String[n];
		for(int i=0;i<n;i++)
			s[i]=""+(i+1);
		JComboBox<String> num=new JComboBox<String>(s);
		num.setBounds(5,5+19,75,14);
		num.setFont(new myFont(8));
		num.setFocusable(false);
		num.setBackground(Color.white);
		this.add(num);
		
		MyButton b=new MyButton("Next",5,5+24+14,75,14);
		b.setFont(new myFont(8));
		this.add(b);
	}

}
