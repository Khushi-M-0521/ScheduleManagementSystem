package screens;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import myswingobjects.MyButton;
import myswingobjects.ScreenTemplate;
import myswingobjects.myFont;

public class SearchTT extends ScreenTemplate{
	public SearchTT() {
		super("Search Timetable");
        myFont font = new myFont(40);
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBounds(0, 0, 500, 500);
        this.getContentPane().add(mainPanel);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(15, 15, 15, 15);
        
        JLabel titleLabel = new JLabel("Search Timetable");
        titleLabel.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(titleLabel, gbc);
        

        String[] deptids=database.Database.deptIds();
        JLabel departmentLabel = new JLabel("Department:");
        JComboBox<String> departmentComboBox = new JComboBox<String>(deptids);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(departmentLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(departmentComboBox, gbc);

        String[] secs=database.Database.sections();
        JLabel sectionLabel = new JLabel("Section:");
        JComboBox sectionComboBox = new JComboBox(secs);
        //sectionComboBox.insertItemAt(null, 0);
        sectionComboBox.setSelectedIndex(-1);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(sectionLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(sectionComboBox, gbc);
        
        String[] fids=database.Database.facultyids();
        JLabel FacultyLabel = new JLabel("FacultyID:");
        JComboBox facultyComboBox = new JComboBox(fids);
        sectionComboBox.insertItemAt(null, 0);
        //sectionComboBox.setSelectedIndex(-1);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(FacultyLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        mainPanel.add(facultyComboBox, gbc);

        MyButton searchButton = new MyButton("Search", 0, 0, 100, 30);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String department =(String) departmentComboBox.getSelectedItem();
                String section = (String) sectionComboBox.getSelectedItem();
                String faculty=(String)facultyComboBox.getSelectedItem();
                if(section==null && faculty==null)
                	JOptionPane.showMessageDialog(null, "Enter either section or faculty", "Invalid", JOptionPane.ERROR_MESSAGE);
                else if(section==null) {
                	String res[][]=database.Database.getTT(faculty);
                	new ResultTT(res,department,faculty,true);
                }
                else if(faculty==null) {
                	String res[][]=database.Database.getSecTT(section);
                	new ResultTT(res,department,section,false);
                }
                else {
                	JOptionPane.showMessageDialog(null, "Enter either section or faculty", "Invalid", JOptionPane.ERROR_MESSAGE);
                }
               
                System.out.println("Searching for department: " + department + ", section: " + section+", faculty: "+faculty);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(searchButton, gbc);

        //this.add(mainPanel);
        this.setVisible(true);
	}
}
