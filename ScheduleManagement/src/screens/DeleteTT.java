package screens;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import myswingobjects.MyButton;
import myswingobjects.ScreenTemplate;
import myswingobjects.myFont;

public class DeleteTT extends ScreenTemplate{

	public DeleteTT() {
		super("DELETE TIMETABLE");
		ScreenTemplate screen = new ScreenTemplate("DELETE TIMETABLE");
		screen.setBounds(0, 0, 400, 200);
		myFont font=new myFont(30);
		JPanel panel = new JPanel(new GridLayout(2, 1));

        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel label = new JLabel("Enter Section ID:");
        label.setFont(font);
        JTextField sectionIdField = new JTextField(10);
        inputPanel.add(label);
        inputPanel.add(sectionIdField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        MyButton deleteButton = new MyButton("Delete Timetable", 0, 0, 130, 35);
//        JButton deleteButton = new JButton("Delete Timetable");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sectionId = sectionIdField.getText();
                int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the timetable for section ID: " + sectionId + "?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirmResult == JOptionPane.YES_OPTION) {
                    // Call a method to delete the timetable based on the section ID
                    int result = 1; // Assuming deletion is successful
                    if (result != 0) {
                        JOptionPane.showMessageDialog(null, "Timetable deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to delete timetable", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        buttonPanel.add(deleteButton);

        panel.add(inputPanel);
        panel.add(buttonPanel);

        screen.add(panel);
        screen.setVisible(true);
    }
	}


