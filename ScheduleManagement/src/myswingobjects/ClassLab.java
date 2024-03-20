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
		String subs[]=database.Database.subjects();
		String fids[]=database.Database.facultyids();
		String blks[]=database.Database.blks();
		String clrs[]=database.Database.clrs();
		parent.remove(this);
		parent.add(new ClassPanel(subs,fids,blks,clrs,0,0));
		tt.add(parent);
		TT.repaint();
	}
	
	public void setGapPanel() {
		JPanel p1=new JPanel();
		p1.setBounds(0,0,85,63);
		parent.remove(this);
		parent.add(p1);
		tt.add(parent);
		TT.repaint();
	}
	
	public void setLabPanel() {
		parent.remove(this);
		parent.add(new Lab1(4,0,0));
		tt.add(parent);
		TT.repaint();
	}
	
	public ClassLab(int x,int y,JPanel parent,JPanel tt,JFrame TT){
		this.setBounds(x,y,85,63);
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
		lab.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setLabPanel();
			}
			
		});
		this.add(lab);
		
		MyButton gap=new MyButton("GAP",5,5+24+14,75,14);
		gap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setGapPanel();
			}
			
		});
		this.add(gap);
		
	}
}
