package screens;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import myswingobjects.ClassLab;
import myswingobjects.MyButton;
import myswingobjects.TTTemplate;
import myswingobjects.myFont;

public class AddTT extends TTTemplate {

	public String section;
	public AddTT(String title,String[] secs) {
		super(title);
		JLabel dept=new JLabel();
		dept.setBounds(330,50,120,20);
		dept.setFont(new myFont());
		dept.setFocusable(false);
		dept.setBackground(Color.white);
		this.getContentPane().add(dept);
		
		JLabel classMentor=new JLabel();
		classMentor.setBounds(570,50,100,20);
		classMentor.setFont(new myFont());
		this.getContentPane().add(classMentor);
		
		JComboBox sec=new JComboBox(secs);
		sec.setBounds(80,50,70,20);
		sec.setFont(new myFont());
		sec.setFocusable(false);
		sec.setBackground(Color.white);
		this.getContentPane().add(sec);
		
		MyButton submit=new MyButton("SUBMIT",680,50,100,20);
		submit.setEnabled(false);
		this.getContentPane().add(submit);
		
		MyButton done=new MyButton("Done",160,50,70,20);
		done.setFont(new myFont(10));
		done.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				section=(String) sec.getSelectedItem();
				done.setEnabled(false);
				
				submit.setEnabled(true);
				
				for(int i=0;i<6;i++)
					for(int j=0;j<8;j++){ 
						p[i][j].add(getClassLab(i,j));
						tt.add(p[i][j]);
						repaint();
					}
				
				String d=database.Database.deptOfSection(section);
				dept.setText(d);
				
				String f=database.Database.classMentor(section);
				classMentor.setText(f);
				
				String[][] subs=database.Database.subjAndHandlers(section);
				int n=subs.length;
				for(int i=1;i<=n;i++) {
					subList.setValueAt(subs[i-1][0], i, 0);
					subList.setValueAt(subs[i-1][1]+" - "+subs[i-1][2], i, 1);
					subList.setValueAt(subs[i-1][3], i, 2);
				}
				repaint();
			}
			
		});
		this.getContentPane().add(done);
		
		
//		JPanel subp=new JPanel();
//		subp.setLayout(null);
//		subp.setBounds(0,0,257,15);
//		
//		JComboBox sub=new JComboBox(secs);
//		sub.setBounds(2,2,253/2,11);
//		sub.setFont(new myFont(10));
//		sub.setFocusable(false);
//		sub.setBackground(Color.white);
//		subp.add(sub);
//		
//		MyButton subb=new MyButton("Done",253/2+5,50,50,11);
//		subb.setFont(new myFont(10));
//		subp.add(sub);
//		
//		JLabel subj=new JLabel();
//		subj.setBounds(660,50,50,20);
//		subj.setFont(new myFont(10));
//		
//		JComboBox<String> fid=new JComboBox<String>(fids);
//		fid.setBounds(2,2,253/2,11);
//		fid.setFont(new myFont(10));
//		fid.setFocusable(false);
//		fid.setBackground(Color.white);
		
		
		
		this.setVisible(true);
	}
	
	ClassLab getClassLab(int i,int j) {
		if(j!=2 && j!=4 && j!=7) {
			return new ClassLab(0,0,p[i][j],tt,this,true);
		}
		else {
			return new ClassLab(0,0,p[i][j],tt,this,false);
		}
	}

	public void repaint() {
		super.repaint();
	}
}
