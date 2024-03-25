package myswingobjects;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ClassPanel extends JPanel{
	public ClassPanel(String[] classes,String blks[],String clrs[],int x,int y){
		this.setBounds(x,y,85,63);
		this.setLayout(null);
		this.setBackground(Color.lightGray);
		
		JComboBox<String> subhandle=new JComboBox<String>(classes);
		subhandle.setBounds(3,2,77,28);
		subhandle.setFont(new myFont(8));
		subhandle.setFocusable(false);
		subhandle.setBackground(Color.white);
		this.add(subhandle);
		
//		JComboBox<String> fid=new JComboBox<String>(fids);
//		fid.setBounds(5,5+19,75,14);
//		fid.setFont(new myFont(8));
//		fid.setFocusable(false);
//		fid.setBackground(Color.white);
//		this.add(fid);
		
		JComboBox<String> blk=new JComboBox<String>(blks);
		blk.setBounds(3,2+28+2,77,14);
		blk.setFont(new myFont(8));
		blk.setFocusable(false);
		blk.setBackground(Color.white);
		this.add(blk);
		
		JComboBox<String> clr=new JComboBox<String>(clrs);
		clr.setBounds(3,4+28+14+2,77,14);
		clr.setFont(new myFont(8));
		clr.setFocusable(false);
		clr.setBackground(Color.white);
		this.add(clr);
	}
}
