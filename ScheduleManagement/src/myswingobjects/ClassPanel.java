package myswingobjects;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ClassPanel extends JPanel{
	public ClassPanel(String subjectCode[],String fids[],String blks[], String clrs[],int x,int y){
		this.setBounds(x,y,85,63);
		this.setLayout(null);
		this.setBackground(Color.lightGray);
		
		JComboBox<String> subcode=new JComboBox<String>(subjectCode);
		subcode.setBounds(5,5,75,14);
		subcode.setFont(new myFont(8));
		subcode.setFocusable(false);
		subcode.setBackground(Color.white);
		this.add(subcode);
		
		JComboBox<String> fid=new JComboBox<String>(fids);
		fid.setBounds(5,5+19,75,14);
		fid.setFont(new myFont(8));
		fid.setFocusable(false);
		fid.setBackground(Color.white);
		this.add(fid);
		
		JComboBox<String> blk=new JComboBox<String>(blks);
		blk.setBounds(5,5+24+14,75/2,14);
		blk.setFont(new myFont(8));
		blk.setFocusable(false);
		blk.setBackground(Color.white);
		this.add(blk);
		
		JComboBox<String> clr=new JComboBox<String>(clrs);
		clr.setBounds(75/2+7,5+24+14,75/2,14);
		clr.setFont(new myFont(8));
		clr.setFocusable(false);
		clr.setBackground(Color.white);
		this.add(clr);
	}
}
