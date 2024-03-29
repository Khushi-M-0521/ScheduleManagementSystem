package screens;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Database;
import myswingobjects.MyButton;
import myswingobjects.ScreenTemplate;
import myswingobjects.myFont;

public class FirstScreen extends ScreenTemplate{

	public FirstScreen(String title) {
		super(title);
		//this.setDefaultCloseOperation(close());
		JLabel scheduleLabel = new JLabel("Schedule Management");
		scheduleLabel.setFont(new myFont(40));
		scheduleLabel.setBounds(10, 10, 480, 100);
		scheduleLabel.setHorizontalAlignment(JLabel.CENTER);
		this.getContentPane().add(scheduleLabel);
		
		JPanel buttonPanel = new JPanel(new GridLayout(4, 2, 10, 10));
		buttonPanel.setBounds(10,110,470,370);
        buttonPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
        buttonPanel.setBackground(Color.WHITE);
        this.getContentPane().add(buttonPanel);
        String[] buttonNames = { "ADD DATA", "ADD TIMETABLE", "FETCH TIMETABLE", "FETCH CLASSROOM", "DELETE DATA",
                "DELETE TIMETABLE", "UPDATE DATA"};
        
        for (String name : buttonNames) {
            MyButton button = new MyButton(name, 10, 10, 70, 70);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch (name) {
                        case "ADD DATA":
                        	new AddData();
                            break;
                        case "ADD TIMETABLE":
                        	//String depts[]= database.Database.deptIds();
                        	String secs[]=database.Database.sections();
                        	//String fids[]=database.Database.facultyids();
                        	//String subs[]=database.Database.subjects();
                        	new AddTT("ADD TIMETABLE",secs);
                            break;
                        case "FETCH TIMETABLE":
                        	new SearchTT();
                        	break;
                        case "FETCH CLASSROOM":
                        	new SearchClassroom();
                        	break;
                        case "DELETE DATA":
                        	new DeleteData();
//                        	DeleteData deleteDataScreen = new DeleteData();
//                            deleteDataScreen.setVisible(true);
                        	break;
                        case "DELETE TIMETABLE":
                        	new DeleteTT();
                        	break;
                        case "UPDATE DATA":
                        	new UpdateData();
                        	break;
//                        case "UPDATE TIMETABLE":
//                        	break;
                        default:
                            break;
                    }
                }
            });
            buttonPanel.add(button);
        }
        
        this.setVisible(true);
		
	}

	public static void main(String[] args) {
		try {
		database.Database.createConnection();
//		database.Database.deptIds();
//		database.Database.facultyids();
//		database.Database.sections();
		new FirstScreen("Home Screen");
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	public void dispose(){
		database.Database.closeAll();
		super.dispose();
	}

}
