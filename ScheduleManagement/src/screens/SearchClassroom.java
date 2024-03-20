package screens;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import myswingobjects.MyButton;
import myswingobjects.ScreenTemplate;
import myswingobjects.myFont;

public class SearchClassroom extends ScreenTemplate{
	SearchClassroom() {
		super("Search Classroom");
        this.setBounds(0,0,700,700);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0,0,700,700);
        this.getContentPane().add(mainPanel);
        
        JLabel titleLabel = new JLabel("Search Classroom");
        titleLabel.setFont(new myFont(Font.BOLD, 20));
        titleLabel.setBounds(5,5,680,50);
        mainPanel.add(titleLabel);

        JLabel dayLabel = new JLabel("Day:");
        JComboBox<String> dayComboBox = new JComboBox<>(new String[]{"MON", "TUE", "WED", "THR", "FRI", "SAT"});
        dayLabel.setFont(new myFont());
        dayLabel.setBounds(5, 60, 100, 40);
        mainPanel.add(dayLabel);
        
        dayComboBox.setBounds(110,60,100,40);
        mainPanel.add(dayComboBox);
        
        JLabel timelabel=new JLabel("Time:");
        JComboBox<String> timeComboBox = new JComboBox<>(new String[]{"8:00-9:00", "9:00-10:00", "10:00-11:00", "11:30-12:30", "12:30-1:30", "2:00-3:00", "3:00-4:00","4:00-5:00"});
        timelabel.setFont(new myFont());
        timelabel.setBounds(220, 60, 100, 40);
        mainPanel.add(timelabel);
        
        timeComboBox.setBounds(330,60,100,40);
        mainPanel.add(timeComboBox);
        
        MyButton searchButton = new MyButton("Search", 440, 60, 100, 40);
        searchButton.addActionListener(e -> {
            String selectedDay = (String) dayComboBox.getSelectedItem();
            String selectedTime=(String) timeComboBox.getSelectedItem();
            System.out.println("Selected day: " + selectedDay);
            String classr[][]=database.Database.freeClassRooms(selectedDay, selectedTime);
            JTable jt=new JTable(classr.length+1,3);
            jt.setEnabled(false);
            jt.setRowHeight(15);
            jt.setRowHeight(0, 30);
            jt.setValueAt("CLASSROOM_ID", 0, 0);
            jt.setValueAt("HAS_PROJECTOR", 0, 1);
            jt.setValueAt("BLOCK_ID", 0, 2);
            for(int i=1;i<=classr.length;i++)
            {	jt.setValueAt(classr[i-1][0], i, 0);
            	jt.setValueAt(classr[i-1][1], i, 1);
            	jt.setValueAt(classr[i-1][2], i, 2);
            }
            jt.setAlignmentX(JTable.CENTER_ALIGNMENT);
            jt.setBackground(new Color(238,238,238));
            jt.setBounds(5,110,670,570);
            mainPanel.add(jt);
            this.repaint();
        });
        mainPanel.add(searchButton);

        this.setVisible(true);
	}

}
