package screens;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import myswingobjects.ClassLab;
import myswingobjects.MyButton;
import myswingobjects.TTTemplate;
import myswingobjects.myFont;

public class AddTT extends TTTemplate {

	public AddTT(String title,String[] depts,String[] secs,String[] subs,String[] fids) {
		super(title);
		// TODO Auto-generated constructor stub
		JComboBox dept=new JComboBox(depts);
		dept.setBounds(130,50,100,20);
		dept.setFont(new myFont());
		dept.setFocusable(false);
		dept.setBackground(Color.white);
		this.getContentPane().add(dept);
		
		JLabel classMentor=new JLabel();
		classMentor.setBounds(570,50,100,20);
		classMentor.setFont(new myFont());
		this.getContentPane().add(classMentor);
		
		JComboBox sec=new JComboBox(secs);
		sec.setBounds(350,50,100,20);
		sec.setFont(new myFont());
		sec.setFocusable(false);
		sec.setBackground(Color.white);
		this.getContentPane().add(sec);
		
		for(int i=0;i<6;i++)
			for(int j=0;j<8;j++)
			{ p[i][j].add( new ClassLab(0,0,p[i][j],tt,this));
				tt.add(p[i][j]);
			//super.repaint();
			}
		
		JPanel subp=new JPanel();
		subp.setLayout(null);
		subp.setBounds(0,0,257,15);
		
		JComboBox sub=new JComboBox(secs);
		sub.setBounds(2,2,253/2,11);
		sub.setFont(new myFont(10));
		sub.setFocusable(false);
		sub.setBackground(Color.white);
		subp.add(sub);
		
		MyButton subb=new MyButton("Done",253/2+5,50,50,11);
		subb.setFont(new myFont(10));
		subp.add(sub);
		
		JLabel subj=new JLabel();
		subj.setBounds(660,50,50,20);
		subj.setFont(new myFont(10));
		
		JComboBox<String> fid=new JComboBox<String>(fids);
		fid.setBounds(2,2,253/2,11);
		fid.setFont(new myFont(10));
		fid.setFocusable(false);
		fid.setBackground(Color.white);
		
//		for(int i=1;i<=10;i++) {
//			try {
//			subList.setValueAt(subp, i, 0);
//			subList.setValueAt(subj, i, 1);
//			subList.setValueAt(fid, i, 2);
//			}catch(Exception e) {
//				System.out.println(e);
//			}
//		}
		
		MyButton submit=new MyButton("SUBMIT",680,50,100,20);
		this.getContentPane().add(submit);
		
		this.setVisible(true);
	}

	public void repaint() {
		super.repaint();
	}
}
