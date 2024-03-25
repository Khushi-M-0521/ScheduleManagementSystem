package screens;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import myswingobjects.MyButton;
import myswingobjects.ScreenTemplate;
import myswingobjects.myFont;

public class DeleteData extends ScreenTemplate {

	public DeleteData() {
		super("Delete Data");
		JLabel label1 = new JLabel("DELETE DATA");
		label1.setFont(new myFont(40));
		label1.setBounds(10, 10, 480, 50);
		label1.setHorizontalAlignment(JLabel.CENTER);
		this.getContentPane().add(label1);

	        JPanel buttonPanel = new JPanel(new GridLayout(8, 1, 10, 10));
	        buttonPanel.setBackground(Color.WHITE);
	        buttonPanel.setBounds(10,50,470,420);
	        buttonPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
	        this.getContentPane().add(buttonPanel);
	       
	        String[] buttonNames = { "BLOCK", "CLASSROOM","DEPARTMENT", "FACULTY",  "SUBJECT",
	        		"SECTION","FACULTY HANDLING THE SUBJECT"};
	        for (String name : buttonNames) {
	            MyButton button = new MyButton(name, 5, 5, 70, 70);
//	            button.setMargin(new Insets(40, 40, 40, 40));
	            button.addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    switch (name) {
	                        case "BLOCK":
	                        	JPanel panel = new JPanel(new GridLayout(1, 2));
	                            JTextField blockIdField = new JTextField(10);
	                            panel.add(new JLabel("Block ID:"));
	                            panel.add(blockIdField);
	                            int result = JOptionPane.showConfirmDialog(null, panel, "Enter respective Block_id to delete", JOptionPane.OK_CANCEL_OPTION);
	                            if (result == JOptionPane.OK_OPTION) {
	                                String blockId = blockIdField.getText();
	                                if (blockId.isEmpty()) {
	                                    JOptionPane.showMessageDialog(null, "Block ID cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
	                                    return; 
	                                }
	                                int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the block with ID: " + blockId, "Confirmation", JOptionPane.YES_NO_OPTION);
	                                if (confirmResult == JOptionPane.YES_OPTION) {
		                                int res=database.Database.delBlk(blockId);
		                                if(res!=-1) {
		                                	JOptionPane.showMessageDialog(null, "Inserted", "Success", JOptionPane.INFORMATION_MESSAGE);
		                                }
		                                else {
		                                	JOptionPane.showMessageDialog(null, "error in value", "Failed", JOptionPane.ERROR_MESSAGE);
		                                }
	                                }
//	                                
	                            }
	                            break;
	                        case "CLASSROOM":
	                        	JPanel panel1 = new JPanel(new GridLayout(1, 2));
	                            JTextField classroomIdField = new JTextField(10);
	                            panel1.add(new JLabel("Classroom Id"));
	                            panel1.add(classroomIdField);
	                            int result1 = JOptionPane.showConfirmDialog(null, panel1, "Enter respective Classroom_id to delete", JOptionPane.OK_CANCEL_OPTION);
	                            if (result1 == JOptionPane.OK_OPTION) {
	                                String classroomId = classroomIdField.getText();
	                                if (classroomId.isEmpty()) {
	                                    JOptionPane.showMessageDialog(null, "Classroom ID cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
	                                    return; 
	                                }
	                                int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the classroom with ID: " + classroomId, "Confirmation", JOptionPane.YES_NO_OPTION);
	                                if (confirmResult == JOptionPane.YES_OPTION) {
	                                	int res=database.Database.delClassr(classroomId);
		                                if(res!=-1) {
		                                	JOptionPane.showMessageDialog(null, "Inserted", "Success", JOptionPane.INFORMATION_MESSAGE);
		                                }
		                                else {
		                                	JOptionPane.showMessageDialog(null, "error in value", "Failed", JOptionPane.ERROR_MESSAGE);
		                                }
	                                }
	                            }
	                        	
	                            break;
	                        case "FACULTY":
	                        	JPanel panel2=new JPanel(new GridLayout(1,2));
	                        	JTextField FacultyIdField = new JTextField(10);
	                        	 panel2.add(new JLabel("Faculty Id"));
		                            panel2.add(FacultyIdField);
		                            int result2 = JOptionPane.showConfirmDialog(null, panel2, "Enter respective Faculty_id to delete", JOptionPane.OK_CANCEL_OPTION);
		                            if (result2 == JOptionPane.OK_OPTION) {
		                                String facultyId = FacultyIdField.getText();
		                                if (facultyId.isEmpty()) {
		                                    JOptionPane.showMessageDialog(null, "Faculty ID cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
		                                    return;
		                                }
		                                int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the faculty with ID: " + facultyId, "Confirmation", JOptionPane.YES_NO_OPTION);
		                                if (confirmResult == JOptionPane.YES_OPTION) {
		                                	int res=database.Database.delFaculty(facultyId);
			                                if(res!=-1) {
			                                	JOptionPane.showMessageDialog(null, "Inserted", "Success", JOptionPane.INFORMATION_MESSAGE);
			                                }
			                                else {
			                                	JOptionPane.showMessageDialog(null, "error in value", "Failed", JOptionPane.ERROR_MESSAGE);
			                                }
		                                }
		                            }
		                        	
		                            break;
	                        case "DEPARTMENT":
	                        	JPanel panel3 = new JPanel(new GridLayout(1, 2));
	                            JTextField deptIdField = new JTextField(10);
	                            panel3.add(new JLabel("Department ID:"));
	                            panel3.add(deptIdField);
	                            int result3 = JOptionPane.showConfirmDialog(null, panel3, "Enter respective department_id to delete", JOptionPane.OK_CANCEL_OPTION);
	                            if (result3 == JOptionPane.OK_OPTION) {
	                                String deptId = deptIdField.getText();
	                                if (deptId.isEmpty()) {
	                                    JOptionPane.showMessageDialog(null, "Department ID cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
	                                    return;
	                                }
	                                int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the department with ID: " + deptId, "Confirmation", JOptionPane.YES_NO_OPTION);
	                                if (confirmResult == JOptionPane.YES_OPTION) {
	                                	int res=database.Database.delDept(deptId);
		                                if(res!=-1) {
		                                	JOptionPane.showMessageDialog(null, "Inserted", "Success", JOptionPane.INFORMATION_MESSAGE);
		                                }
		                                else {
		                                	JOptionPane.showMessageDialog(null, "error in value", "Failed", JOptionPane.ERROR_MESSAGE);
		                                }
	                                }
	                                
	                            }
	                            	break;
	                            
	                        case "SUBJECT":
	                        	JPanel panel4 = new JPanel(new GridLayout(1, 2));
	                            JTextField subcodeField = new JTextField(10);
	                            panel4.add(new JLabel("Subject Code"));
	                            panel4.add(subcodeField);
	                            int result4 = JOptionPane.showConfirmDialog(null, panel4, "Enter respective Subject code to delete", JOptionPane.OK_CANCEL_OPTION);
	                            if (result4 == JOptionPane.OK_OPTION) {
	                                String subcode = subcodeField.getText();
	                                if (subcode.isEmpty()) {
	                                    JOptionPane.showMessageDialog(null, "Subject code cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
	                                    return;
	                                }
	                                int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the Subject with ID: " + subcode, "Confirmation", JOptionPane.YES_NO_OPTION);
	                                if (confirmResult == JOptionPane.YES_OPTION) {
	                                	int res=database.Database.delSub(subcode);
		                                if(res!=-1) {
		                                	JOptionPane.showMessageDialog(null, "Inserted", "Success", JOptionPane.INFORMATION_MESSAGE);
		                                }
		                                else {
		                                	JOptionPane.showMessageDialog(null, "error in value", "Failed", JOptionPane.ERROR_MESSAGE);
		                                }
	                                }
	                            }
	                        	
	                            break; 
	                        case "FACULTY HANDLING THE SUBJECT":
	                        	JPanel panel5 = new JPanel(new GridLayout(3, 2));
	                            JTextField subjcodeField = new JTextField(10);
	                            JTextField facultyyidField = new JTextField(10);
	                            JTextField secidField=new JTextField(10);
	                            panel5.add(new JLabel("Subject Code:"));
	                            panel5.add(subjcodeField);
	                            panel5.add(new JLabel("Faculty id:"));
	                            panel5.add(facultyyidField);
	                            panel5.add(new JLabel("Section id:"));
	                            panel5.add(secidField);
	                            int result5 = JOptionPane.showConfirmDialog(null, panel5, "Enter respective Faculty handling subject Details to delete", JOptionPane.OK_CANCEL_OPTION);
	                            if (result5 == JOptionPane.OK_OPTION) {
	                                String subcode =subjcodeField.getText();
	                                String facultyid = facultyyidField.getText();
	                                String secid=secidField.getText();
	                                if (subcode.isEmpty()||facultyid.isEmpty()||secid.isEmpty()) {
	                                    JOptionPane.showMessageDialog(null, "Values cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
	                                    return;
	                                }
	                                int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the faculty with ID: " + facultyid+"  handling the subject with subject code  "+subcode+"  for the section with Id: "+secid,"Confirmation", JOptionPane.YES_NO_OPTION);
	                                if (confirmResult == JOptionPane.YES_OPTION) {
	                                	int res=database.Database.delHandler(facultyid, secid, subcode);
		                                if(res!=-1) {
		                                	JOptionPane.showMessageDialog(null, "Inserted", "Success", JOptionPane.INFORMATION_MESSAGE);
		                                }
		                                else {
		                                	JOptionPane.showMessageDialog(null, "error in value", "Failed", JOptionPane.ERROR_MESSAGE);
		                                }
	                                }
	                            }
	                        	break;
	                        	
	                        case "SECTION":
	                        	JPanel panel6=new JPanel(new GridLayout(1,2));
	                        	JTextField secIdField = new JTextField(10);
	                        	 panel6.add(new JLabel("Section Id"));
		                            panel6.add(secIdField);
		                            int result6 = JOptionPane.showConfirmDialog(null, panel6, "Enter respective Section Details to delete", JOptionPane.OK_CANCEL_OPTION);
		                            if (result6 == JOptionPane.OK_OPTION) {
		                                String sectionId = secIdField.getText();
		                                if (sectionId.isEmpty()) {
		                                    JOptionPane.showMessageDialog(null, "Section Id cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
		                                    return;
		                                }
		                                int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the Section with ID: " + sectionId, "Confirmation", JOptionPane.YES_NO_OPTION);
		                                if (confirmResult == JOptionPane.YES_OPTION) {
		                                	int res=database.Database.delSec(sectionId);
			                                if(res!=-1) {
			                                	JOptionPane.showMessageDialog(null, "Inserted", "Success", JOptionPane.INFORMATION_MESSAGE);
			                                }
			                                else {
			                                	JOptionPane.showMessageDialog(null, "error in value", "Failed", JOptionPane.ERROR_MESSAGE);
			                                }
		                                }
		                            }
	                        	
	                        	break;
	            
	                        	
	                        default:
	                            break;
	                            
	                        
	                    }
	                }
	            });
	            buttonPanel.add(button);
//	            this.getContentPane().add(buttonPanel);
	        }

//	        mainPanel.add(buttonPanel);
//	        this.getContentPane().add(mainPanel);
	        this.setVisible(true);
	}
	}


