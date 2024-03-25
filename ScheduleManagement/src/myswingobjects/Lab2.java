package myswingobjects;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class Lab2 extends JPanel{
	public Lab2(String[] handlers, String[] blks,String[] crs,int n,int x,int y){
		this.setBounds(x,y,85+2+85,63);
		this.setLayout(new GridLayout(4,n,2,2));
		this.setBackground(Color.lightGray);
		
		
//		JComboBox<String> subcode=new JComboBox<String>(subjectCode);
//		subcode.setBounds(5,5,75+85,14);
//		subcode.setFont(new myFont(8));
//		subcode.setFocusable(false);
//		subcode.setBackground(Color.white);
//		this.add(subcode);
//		
//		JPanel p=new JPanel();
//		p.setLayout(new GridLayout(4,n));
//		p.setBounds(2,20,75+85+2,42);
//		this.add(p);
		//System.out.println(n);
		JComboBox<String>[][] cb=new JComboBox[4][n];
		for(int i=0;i<4;i++) {
			for(int j=0;j<n;j++)
			{	
				//System.out.println(i);
				if(i==0 || i==1)
					cb[i][j]=new JComboBox<String>(handlers);
				else if(i==2)
					cb[i][j]=new JComboBox<String>(handlers);
				else
					cb[i][j]=new JComboBox<String>(crs);
				cb[i][j].setFont(new myFont(8));
				cb[i][j].setFocusable(false);
				cb[i][j].setBackground(Color.white);
				this.add(cb[i][j]);
			}
		}
	}
}
