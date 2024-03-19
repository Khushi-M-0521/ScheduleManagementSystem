package screens;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import myswingobjects.MyButton;

public class SearchClassroom {
	public static void main(String args []) {
		JFrame frame = new JFrame("Search Classroom");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(300, 200);
//        frame.pack();
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.setLayout(new GridLayout(0, 2));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Search Classroom");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        mainPanel.add(titleLabel);

        JPanel dayPanel = new JPanel();
        JLabel dayLabel = new JLabel("Day:");
        JComboBox<String> dayComboBox = new JComboBox<>(new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"});
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
            System.out.println("Selected day: " + selectedDay);
            // Perform search based on the selected day
        });
        mainPanel.add(searchButton);

        frame.add(mainPanel);
        frame.setVisible(true);
        frame.pack();
	}

}
