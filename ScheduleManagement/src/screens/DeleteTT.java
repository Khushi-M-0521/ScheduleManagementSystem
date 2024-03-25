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
//		ScreenTemplate screen = new ScreenTemplate("DELETE TIMETABLE");
		this.setSize(410, 240);
		this.setLocationRelativeTo(null);
		myFont font=new myFont(30);
		JPanel panel = new JPanel(new GridLayout(3, 1,10,10));
		panel.setBounds(0,0,400,200);
		this.add(panel);
		
		JLabel head = new JLabel("DELETE TIMETABLE");
        head.setFont(font);
        head.setHorizontalAlignment(JLabel.CENTER);
        panel.add(head);

        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel label = new JLabel("Enter Section ID:");
        label.setFont(new myFont());
        JTextField sectionIdField = new JTextField(10);
        inputPanel.add(label);
        inputPanel.add(sectionIdField);
        panel.add(inputPanel);
        

        JPanel buttonPanel = new JPanel(new FlowLayout());
        MyButton deleteButton = new MyButton("Delete Timetable", 0, 0, 130, 35);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sectionId = sectionIdField.getText();
                if (sectionId.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Section ID cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
                    return; 
                }
                int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the timetable for section ID: " + sectionId + "?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirmResult == JOptionPane.YES_OPTION) {
                    int result=database.Database.delTT(sectionId);
                    if (result != -1) {
                        JOptionPane.showMessageDialog(null, "Timetable deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to delete timetable", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        buttonPanel.add(deleteButton);
     
     panel.add(buttonPanel);
     
    
        this.setVisible(true);
    }
}


