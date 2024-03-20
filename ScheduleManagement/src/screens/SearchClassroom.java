package screens;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import myswingobjects.MyButton;
import myswingobjects.ScreenTemplate;
import myswingobjects.myFont;

public class SearchClassroom extends ScreenTemplate{
	SearchClassroom() {
		super("Search Classroom");
		//JFrame frame = new JFrame("Search Classroom");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(300, 200);
//        frame.pack();
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBounds(0,0,700,700);
        
        //frame.setLayout(new GridLayout(0, 2));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        this.getContentPane().add(mainPanel);
        
        JLabel titleLabel = new JLabel("Search Classroom");
        titleLabel.setFont(new myFont(Font.BOLD, 20));
        mainPanel.add(titleLabel);

        JPanel dayPanel = new JPanel();
        JLabel dayLabel = new JLabel("Day:");
        JComboBox<String> dayComboBox = new JComboBox<>(new String[]{"MON", "TUE", "WED", "THR", "FRI", "SAT"});
        dayPanel.add(dayLabel);
        dayPanel.add(dayComboBox);
        
        JPanel timepanel = new JPanel();
        JLabel timelabel=new JLabel("Time:");
        JComboBox<String> timeComboBox = new JComboBox<>(new String[]{"8:00-9:00", "9:00-10:00", "10:00-11:00", "11:30-12:30", "12:30-1:30", "2:00-3:00", "3:00-4:00","4:00-5:00"});
        timepanel.add(timelabel);
        timepanel.add(timeComboBox);
        
        mainPanel.add(dayPanel);
        mainPanel.add(timepanel);
//        JButton searchButton = new JButton("Search");
        MyButton searchButton = new MyButton("Search", 5, 5, 30, 30);
        searchButton.addActionListener(e -> {
            String selectedDay = (String) dayComboBox.getSelectedItem();
            String selectedTime=(String) timeComboBox.getSelectedItem();
            System.out.println("Selected day: " + selectedDay);
            String classr[][]=database.Database.freeClassRooms(selectedDay, selectedTime);
            JTable jt=new JTable(classr,new String[] {"CLASSROOM_ID","HAS_PROJECTOR","BLOCK_ID"});
            jt.setEnabled(false);
            jt.setRowHeight(0, 20);
            jt.setRowHeight(15);
            mainPanel.add(jt);
            this.repaint();
            // Perform search based on the selected day
        });
        mainPanel.add(searchButton);


        this.setVisible(true);
        //this.pack();
	}

}
