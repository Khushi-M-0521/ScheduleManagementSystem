package screens;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Database;
import myswingobjects.MyButton;
import myswingobjects.ScreenTemplate;
import myswingobjects.myFont;

public class FirstScreen extends ScreenTemplate{

//	public static database db=new database();
	public FirstScreen(String title) {
		super(title);
		
//		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		
		JLabel scheduleLabel = new JLabel("Schedule Management");
		scheduleLabel.setFont(new myFont(40));
		scheduleLabel.setBounds(10, 10, 480, 100);
		scheduleLabel.setHorizontalAlignment(JLabel.CENTER);
		this.getContentPane().add(scheduleLabel);
//		JPanel labelPanel = new JPanel();
//		labelPanel.add(scheduleLabel);
//		mainPanel.add(labelPanel);
		
		JPanel buttonPanel = new JPanel(new GridLayout(4, 2, 10, 10));
		buttonPanel.setBounds(10,110,470,370);
        buttonPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
        buttonPanel.setBackground(Color.WHITE);
        this.getContentPane().add(buttonPanel);
        String[] buttonNames = { "ADD DATA", "ADD TIMETABLE", "FETCH TIMETABLE", "FETCH CLASSROOM", "DELETE DATA",
                "DELETE TIMETABLE", "UPDATE DATA", "UPDATE TIMETABLE" };
        
        for (String name : buttonNames) {
            MyButton button = new MyButton(name, 10, 10, 70, 70);
//            button.setMargin(new Insets(40, 40, 40, 40));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Perform action based on the button's name
                    switch (name) {
                        case "ADD DATA":
                            //System.out.println("ADD DATA button clicked");
                        	new AddData();
                            break;
                        case "ADD TIMETABLE":
                        	String depts[]= database.Database.deptIds();
                        	String secs[]=database.Database.sections();
                        	String fids[]=database.Database.facultyids();
                        	String subs[]=database.Database.subjects();
                        	new AddTT("ADD TIMETABLE",depts,secs,subs,fids);
                            //System.out.println("ADD TIMETABLE button clicked");
                            break;
                        case "FETCH TIMETABLE":
                        	new SearchTT();
                        	break;
                        case "FETCH CLASSROOM":
                        	new SearchClassroom();
                        	break;
                        case "DELETE DATA":
                        	break;
                        case "DELETE TIMETABLE":
                        	break;
                        case "UPDATE DATA":
                        	break;
                        case "UPDATE TIMETABLE":
                        	break;
                        default:
                            break;
                    }
                }
            });
            buttonPanel.add(button);
        }
        //mainPanel.add(buttonPanel);
        
        //this.getContentPane().add(mainPanel);
        this.setVisible(true);
		
	}

	public static void main(String[] args) {
		database.Database.createConnection();
		database.Database.deptIds();
		database.Database.facultyids();
		database.Database.sections();
		new FirstScreen("Home Screen");

	}
	
	public void dispose(){
		database.Database.closeAll();
	}

}
