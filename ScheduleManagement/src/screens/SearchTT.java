package screens;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import myswingobjects.MyButton;
import myswingobjects.myFont;

public class SearchTT {
	public SearchTT() {
		JFrame frame = new JFrame("Search Timetable");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFont font = new myFont(40);
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(15, 15, 15, 15);

        JLabel titleLabel = new JLabel("Search Timetable");
        titleLabel.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(titleLabel, gbc);

        JLabel departmentLabel = new JLabel("Department:");
        JTextField departmentTextField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(departmentLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(departmentTextField, gbc);

        JLabel sectionLabel = new JLabel("Section:");
        JTextField sectionTextField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(sectionLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(sectionTextField, gbc);
        
        JLabel FacultyLabel = new JLabel("FacultyID:");
        JTextField facultyTextField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(FacultyLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        mainPanel.add(facultyTextField, gbc);

        MyButton searchButton = new MyButton("Search", 0, 0, 100, 30);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String department = departmentTextField.getText();
                String section = sectionTextField.getText();
                String faculty=facultyTextField.getText();
                System.out.println("Searching for department: " + department + ", section: " + section+", faculty: "+faculty);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(searchButton, gbc);

        frame.add(mainPanel);
        frame.setVisible(true);
	}
}
