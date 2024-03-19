package myswingobjects;

import java.awt.Font;

public class myFont extends Font {

	public myFont(int fontStyle,int fontSize) {
		super(new Font("Times New Roman",fontStyle,fontSize));
	}
	
	public myFont(int fontSize) {
		super(new Font("Times New Roman",Font.PLAIN,fontSize));
	}
	
	public myFont() {
		super(new Font("Times New Roman",Font.PLAIN,12));
	}
}
