package myswingobjects;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.Border;

public class TTTemplate extends ScreenTemplate{
	JLabel header;
	protected JPanel p[][]=new JPanel[6][8];
	protected JTable subList;
	protected JPanel tt;
	public TTTemplate(String title) {
		super(title);
		int w=800;
		int h=820;
		this.getContentPane().setLayout(null);
		this.setBounds(10, 5, w, h);
		
		header=new JLabel(title);
		header.setBounds(w/2-50, 10, 200, 20);
		header.setFont(new myFont(Font.BOLD,20));
		this.getContentPane().add(header);
		
		JLabel dept=new JLabel("Department : ");
		dept.setBounds(240,50,100,20);
		dept.setFont(new myFont(16));
		this.getContentPane().add(dept);
		
		JLabel sec=new JLabel("Section : ");
		sec.setBounds(20,50,60,20);
		sec.setFont(new myFont(16));
		this.getContentPane().add(sec);
		
		JLabel classMentor=new JLabel("Class Mentor : ");
		classMentor.setBounds(460,50,100,20);
		classMentor.setFont(new myFont(16));
		this.getContentPane().add(classMentor);
		
		MyPane TT=new MyPane();
		TT.setBackground(Color.lightGray);
		TT.setBounds(10,80,770,400);
		TT.setLayout(null);
		this.getContentPane().add(TT,JLayeredPane.DEFAULT_LAYER);
		
		tt=new JPanel();
		//tt.setBackground(Color.lightGray);
		tt.setBounds(10,80,770,410);
		tt.setLayout(null);
		this.getContentPane().add(tt,JLayeredPane.DRAG_LAYER);
		
			int v=22;
			JLabel mon = new JLabel("<html>M<br>O<br>N</html>");
			mon.setBounds(10,v,20,63);
			mon.setFont(new myFont(Font.BOLD,14));
			mon.setAlignmentY(CENTER_ALIGNMENT);
			tt.add(mon);
		
			
			v+=2+63;
			JLabel tue = new JLabel("<html>T<br>U<br>E</html>");
			tue.setBounds(10,v,20,63);
			tue.setFont(new myFont(Font.BOLD,14));
			tue.setAlignmentY(CENTER_ALIGNMENT);
			tt.add(tue);
			
			v+=2+63;
			JLabel wed = new JLabel("<html>W<br>E<br>D</html>");
			wed.setBounds(10,v,20,63);
			wed.setFont(new myFont(Font.BOLD,14));
			wed.setAlignmentY(CENTER_ALIGNMENT);
			tt.add(wed);
			
			v+=2+63;
			JLabel thr = new JLabel("<html>T<br>H<br>R</html>");
			thr.setBounds(10,v,20,63);
			thr.setFont(new myFont(Font.BOLD,14));
			thr.setAlignmentY(CENTER_ALIGNMENT);
			tt.add(thr);
			
			v+=2+63;
			JLabel fri = new JLabel("<html>F<br>R<br>I</html>");
			fri.setBounds(10,v,20,63);
			fri.setFont(new myFont(Font.BOLD,14));
			fri.setAlignmentY(CENTER_ALIGNMENT);
			tt.add(fri);
			
			v+=63;
			JLabel sat = new JLabel("<html>S<br>A<br>T</html>");
			sat.setBounds(10,v,20,63);
			sat.setFont(new myFont(Font.BOLD,14));
			sat.setAlignmentY(CENTER_ALIGNMENT);
			tt.add(sat);
		
			int hori=32;
			JLabel t1=new JLabel("<html>8:00-9:00<html>");
			t1.setBounds(hori,0,85,20);
			t1.setFont(new myFont(Font.BOLD,10));
			t1.setHorizontalAlignment(JLabel.CENTER);
			tt.add(t1);
			
			
			hori+=2+85;
			JLabel t2=new JLabel("9:00-10:00");
			t2.setBounds(hori,0,85,20);
			t2.setFont(new myFont(Font.BOLD,10));
			t2.setHorizontalAlignment(JLabel.CENTER);
			tt.add(t2);
			
			hori+=2+85;
			JLabel t3=new JLabel("10:00-11:00");
			t3.setBounds(hori,0,85,20);
			t3.setFont(new myFont(Font.BOLD,10));
			t3.setHorizontalAlignment(JLabel.CENTER);
			tt.add(t3);
			
			hori+=2+20+2+85;
			JLabel t4=new JLabel("11:30-12:30");
			t4.setBounds(hori,0,85,20);
			t4.setFont(new myFont(Font.BOLD,10));
			t4.setHorizontalAlignment(JLabel.CENTER);
			tt.add(t4);
			
			hori+=2+85;
			JLabel t5=new JLabel("12:30-1:30");
			t5.setBounds(hori,0,85,20);
			t5.setFont(new myFont(Font.BOLD,10));
			t5.setHorizontalAlignment(JLabel.CENTER);
			tt.add(t5);
			
			hori+=2+85+2+20;
			JLabel t6=new JLabel("2:00-3:00");
			t6.setBounds(hori,0,85,20);
			t6.setFont(new myFont(Font.BOLD,10));
			t6.setHorizontalAlignment(JLabel.CENTER);
			tt.add(t6);
			
			hori+=2+85;
			JLabel t7=new JLabel("3:00-4:00");
			t7.setBounds(hori,0,85,20);
			t7.setFont(new myFont(Font.BOLD,10));
			t7.setHorizontalAlignment(JLabel.CENTER);
			tt.add(t7);
			
			hori+=2+85;
			JLabel t8=new JLabel("4:00-5:00");
			t8.setBounds(hori,0,85,20);
			t8.setFont(new myFont(Font.BOLD,10));
			t8.setHorizontalAlignment(JLabel.CENTER);
			tt.add(t8);
			
			JLabel brk=new JLabel("<html>B<br><br>R<br><br>E<br><br>A<br><br>K</html>");
			brk.setBounds(30+(2+85)*3+2,20+2,20,400-22);
			brk.setFont(new myFont(Font.BOLD,10));
			brk.setHorizontalAlignment(JLabel.CENTER);
			tt.add(brk);
			
			JLabel lnh=new JLabel("<html>L<br><br>U<br><br>N<br><br>C<br><br>H</html>");
			lnh.setBounds(30+(2+85)*5+20+4,20+2,20,400-22);
			lnh.setFont(new myFont(Font.BOLD,10));
			lnh.setHorizontalAlignment(JLabel.CENTER);
			tt.add(lnh);
			
			
			int x=32;
			int y=22;
			for(int i=0;i<6;i++)
			{	
				x=32;
				for(int j=0;j<8;j++)
				{
					if(j==3 || j==5) x+=22;
					p[i][j]=new JPanel();
					p[i][j].setBounds(x,y,85,63);
					p[i][j].setLayout(null);
					p[i][j].setOpaque(false);
					tt.add(p[i][j]);
					x+=85+2;
				}
				y+=63+2;
			}
		
		JLabel subs=new JLabel("Subject List: ");
		subs.setBounds(10,500,100,20);
		subs.setFont(new myFont(16));
		this.getContentPane().add(subs);
		
		String th[]={"Subcode","Subject","Faculty_id"};
		subList=new JTable(15,3);
		subList.setEnabled(false);
		subList.setRowHeight(20);
		subList.setRowHeight(0, 25);
		for(int i=0;i<3;i++)
			subList.setValueAt(th[i], 0, i);
		subList.setBounds(8,525-2,770+2,250+2);
		subList.setBackground(new Color(238,238,238));
		this.getContentPane().add(subList);
	}
	
	class MyPane extends JLayeredPane{
		MyPane(){
			int v=22;
			JLabel mon = new JLabel("MON");
			mon.setBounds(v,0,30,63);
			mon.setFont(new myFont(Font.BOLD,14));
			this.add(mon);
		}
		public void paint(Graphics g) {
			Graphics2D g2d = (Graphics2D)g;
			g2d.setStroke(new BasicStroke(2));
			g2d.setPaint(Color.black);
			
			
			int v=30;
			g2d.drawLine(v,0,v,400);
			v+=2+85;
			g2d.drawLine(v,0,v,400);
			v+=2+85;
			g2d.drawLine(v,0,v,400);
			v+=2+85;
			g2d.drawLine(v,0,v,400);
			v+=2+20;
			g2d.drawLine(v,0,v,400);
			v+=2+85;
			g2d.drawLine(v,0,v,400);
			v+=2+85;
			g2d.drawLine(v,0,v,400);
			v+=2+20;
			g2d.drawLine(v,0,v,400);
			v+=2+85;
			g2d.drawLine(v,0,v,400);
			v+=2+85;
			g2d.drawLine(v,0,v,400);
			
			int h=20;
			g2d.drawLine(0,h,770,h);
			h+=2+63;
			g2d.drawLine(0,h,770,h);
			h+=2+63;
			g2d.drawLine(0,h,770,h);
			h+=2+63;
			g2d.drawLine(0,h,770,h);
			h+=2+63;
			g2d.drawLine(0,h,770,h);
			h+=2+63;
			g2d.drawLine(0,h,770,h);
			
			g2d.setPaint(new Color(238, 238, 238));
			g2d.drawLine(30+(2+85)*3+2, 20+2+63, 30+(2+85)*3+20, 20+2+63);
			g2d.drawLine(30+(2+85)*5+20+4, 20+2+63, 30+(2+85)*5+20+20+2, 20+2+63);
			
			g2d.drawLine(30+(2+85)*3+2, 20+(2+63)*2, 30+(2+85)*3+20, 20+(2+63)*2);
			g2d.drawLine(30+(2+85)*5+20+4, 20+(2+63)*2, 30+(2+85)*5+20+20+2, 20+(2+63)*2);
			
			g2d.drawLine(30+(2+85)*3+2, 20+(2+63)*3, 30+(2+85)*3+20, 20+(2+63)*3);
			g2d.drawLine(30+(2+85)*5+20+4, 20+(2+63)*3, 30+(2+85)*5+20+20+2, 20+(2+63)*3);
			
			g2d.drawLine(30+(2+85)*3+2, 20+(2+63)*4, 30+(2+85)*3+20, 20+(2+63)*4);
			g2d.drawLine(30+(2+85)*5+20+4, 20+(2+63)*4, 30+(2+85)*5+20+20+2, 20+(2+63)*4);
			
			g2d.drawLine(30+(2+85)*3+2, 20+(2+63)*5, 30+(2+85)*3+20, 20+(2+63)*5);
			g2d.drawLine(30+(2+85)*5+20+4, 20+(2+63)*5, 30+(2+85)*5+20+20+2, 20+(2+63)*5);
			
		}
	}

}
