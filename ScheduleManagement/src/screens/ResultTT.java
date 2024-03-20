package screens;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import myswingobjects.ClassLab;
import myswingobjects.TTTemplate;
import myswingobjects.myFont;

public class ResultTT extends TTTemplate {

	public ResultTT(String[][] TT,String dept,String f_or_sec,boolean isFaculty) {
		super("Time Table");
		this.setBounds(0,0,800,500);
		JLabel d=new JLabel(dept);
		d.setBounds(130,50,100,20);
		d.setFont(new myFont());
		//d.setFocusable(false);
		//d.setBackground(Color.white);
		this.getContentPane().add(d);
		
		if(isFaculty) {
			JLabel faculty=new JLabel(f_or_sec);
			faculty.setBounds(570,50,100,20);
			faculty.setFont(new myFont());
			this.getContentPane().add(faculty);
		}
		else {
			JLabel sec=new JLabel(f_or_sec);
			sec.setBounds(350,50,100,20);
			sec.setFont(new myFont());
			//sec.setFocusable(false);
			//sec.setBackground(Color.white);
			this.getContentPane().add(sec);
		}
		
		String[] day={"MON", "TUE", "WED", "THR", "FRI", "SAT"};
		String[] time={"8:00-9:00", "9:00-10:00", "10:00-11:00", "11:30-12:30", "12:30-1:30", "2:00-3:00", "3:00-4:00","4:00-5:00"};
		for(int i=0;i<6;i++)
			for(int j=0;j<8;j++)
			{ 
				if(TT!=null) {
				for(int k=0;k<TT.length;k++)
				{
					if(TT[k][4]==day[i] && TT[k][5]==time[j]) {
						JLabel class_lab=new JLabel("<html>"+TT[k][0]+" "+TT[k][1]+"<br>"+TT[k][2]+" "+TT[k][3]+"<br>"+TT[k][4]+" "+TT[k][5]+"</html>");
						if(TT[k][6]=="1")
							class_lab.setBounds(0, 0, 85, 63);
						else
							class_lab.setBounds(0, 0, 85+2+85, 63);
						class_lab.setFont(new myFont());
						class_lab.setHorizontalAlignment(JLabel.CENTER);
						p[i][j].add(class_lab);
						tt.add(p[i][j]);
					}
				}
				
			
			//super.repaint();
			}
			}
		//this.getContentPane().remove(subList);
		
		this.setVisible(true);
	}

}
