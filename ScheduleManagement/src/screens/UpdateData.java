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

public class UpdateData extends ScreenTemplate {

	public UpdateData() {
		super("UPDATE DATA");
		JLabel label1 = new JLabel("UPDATE DATA");
		label1.setFont(new myFont(40));
		label1.setBounds(10, 10, 480, 50);
		label1.setHorizontalAlignment(JLabel.CENTER);
		this.getContentPane().add(label1);

	        JPanel buttonPanel = new JPanel(new GridLayout(8, 1, 10, 10));
	        buttonPanel.setBackground(Color.WHITE);
	        buttonPanel.setBounds(10,50,470,420);
	        buttonPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
	        this.getContentPane().add(buttonPanel);
	        String[] buttonNames = { "BLOCK", "CLASSROOM",  "DEPARTMENT","FACULTY", "SUBJECT",
	                 "SECTION"};
	        for (String name : buttonNames) {
	            MyButton button = new MyButton(name, 5, 5, 70, 70);
//	            button.setMargin(new Insets(40, 40, 40, 40));
	            button.addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    // Perform action based on the button's name
	                    switch (name) {
	                        case "BLOCK":
//	                            System.out.println("ADD DATA button clicked");
	                        	JPanel panel = new JPanel(new GridLayout(1, 2));
	                            JTextField blockIdField = new JTextField(10);
	                            panel.add(new JLabel("Block ID:"));
	                            panel.add(blockIdField);
	                            int result = JOptionPane.showConfirmDialog(null, panel, "Enter respective Block_id to update", JOptionPane.OK_CANCEL_OPTION);
	                            if (result == JOptionPane.OK_OPTION) {
	                                String blockId = blockIdField.getText();
	                                if (blockId.isEmpty()) {
	                                    JOptionPane.showMessageDialog(null, "Block ID cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
	                                    return;
	                                }
	                                JPanel editPanel = new JPanel(new GridLayout(2, 2));
	                                JTextField blockNameField = new JTextField(10);
	                                blockNameField.setText(database.Database.getBlk(blockId)[0]);
	                                editPanel.add(new JLabel("Block Name:"));
	                                editPanel.add(blockNameField);
	                                int editResult = JOptionPane.showConfirmDialog(null, editPanel, "Edit Block Details", JOptionPane.OK_CANCEL_OPTION);
	                                if (editResult == JOptionPane.OK_OPTION) {
	                                    String[] updatedBlock = {blockNameField.getText()};
//	                                     Update the block details in the database
	                                    int updateResult = database.Database.upBlk(blockId, updatedBlock);
	                                    if (updateResult != -1) {
	                                        JOptionPane.showMessageDialog(null, "Block details updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
	                                    } else {
	                                        JOptionPane.showMessageDialog(null, "Failed to update block details", "Error", JOptionPane.ERROR_MESSAGE);
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
	                            int result1 = JOptionPane.showConfirmDialog(null, panel1, "Enter respective Classroom_id to update", JOptionPane.OK_CANCEL_OPTION);
	                            if (result1 == JOptionPane.OK_OPTION) {
	                                String classroomId = classroomIdField.getText();
	                                if (classroomId.isEmpty()) {
	                                    JOptionPane.showMessageDialog(null, "Classroom ID cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
	                                    return;
	                                }
	                                String[] classrd=database.Database.getClassr(classroomId);
	                                JPanel editPanel = new JPanel(new GridLayout(3, 2));
	                                JTextField hasProjectorField = new JTextField(10);
	                                hasProjectorField.setText(classrd[0]);
	                                JTextField blockIddField = new JTextField(10);
	                                blockIddField.setText(classrd[1]);
	                                editPanel.add(new JLabel("Has Projector:"));
	                                editPanel.add(hasProjectorField);
	                                editPanel.add(new JLabel("Block ID:"));
	                                editPanel.add(blockIddField);
	                                int editResult = JOptionPane.showConfirmDialog(null, editPanel, "Edit Classroom Details", JOptionPane.OK_CANCEL_OPTION);
	                                if (editResult == JOptionPane.OK_OPTION) {
	                                    String updatedHasProjector = hasProjectorField.getText();
	                                    String updatedBlockId = blockIddField.getText();
	                                    // Update the classroom details in the database
	                                    String[] data= {updatedHasProjector,updatedBlockId};
	                                    int updateResult = database.Database.upClassr(classroomId, data);
	                                    if (updateResult != -1) {
	                                        JOptionPane.showMessageDialog(null, "Classroom details updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
	                                    } else {
	                                        JOptionPane.showMessageDialog(null, "Failed to update classroom details", "Error", JOptionPane.ERROR_MESSAGE);
	                                    }
	                                }
	                            }
	                        	
	                            break;
	                        case "FACULTY":
	                        	JPanel panel2=new JPanel(new GridLayout(1,2));
	                        	JTextField FacultyIdField = new JTextField(10);
	                        	 panel2.add(new JLabel("Faculty Id"));
		                            panel2.add(FacultyIdField);
		                            int result2 = JOptionPane.showConfirmDialog(null, panel2, "Enter respective Faculty_id to update", JOptionPane.OK_CANCEL_OPTION);
		                            if (result2 == JOptionPane.OK_OPTION) {
		                                String facultyId = FacultyIdField.getText();
		                                if (facultyId.isEmpty()) {
		                                    JOptionPane.showMessageDialog(null, "Faculty ID cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
		                                    return;
		                                }
		                                String fd[]=database.Database.getFaculty(facultyId);
		                                JPanel editPanel = new JPanel(new GridLayout(5, 2));
		                                JTextField facultyNameField = new JTextField(10);
		                                facultyNameField.setText(fd[0]);
		                                JTextField emailField = new JTextField(10);
		                                emailField.setText(fd[2]);
		                                JTextField phoneNumberField = new JTextField(10);
		                                phoneNumberField.setText(fd[1]);
		                                JTextField departmentIdField = new JTextField(10);
		                                departmentIdField.setText(fd[4]);
		                                JTextField designationField=new JTextField(10);
		                                designationField.setText(fd[3]);
		                                // Populate other fields with the retrieved details
		                                editPanel.add(new JLabel("Faculty Name:"));
		                                editPanel.add(facultyNameField);
		                                editPanel.add(new JLabel("Email:"));
		                                editPanel.add(emailField);
		                                editPanel.add(new JLabel("Phone Number:"));
		                                editPanel.add(phoneNumberField);
		                                editPanel.add(new JLabel("Department ID:"));
		                                editPanel.add(departmentIdField);
		                                editPanel.add(new JLabel("Designation:"));
		                                editPanel.add(designationField);
		                                // Add other fields to the editPanel
		                                int editResult = JOptionPane.showConfirmDialog(null, editPanel, "Edit Faculty Details", JOptionPane.OK_CANCEL_OPTION);
		                                if (editResult == JOptionPane.OK_OPTION) {
		                                    String updatedFacultyName = facultyNameField.getText();
		                                    String updatedEmail = emailField.getText();
		                                    String updatedPhoneNumber = phoneNumberField.getText();
		                                    String updatedDepartmentId = departmentIdField.getText();
		                                    String updatedDesignation=designationField.getText();
		                                    // Update the faculty details in the database
		                                    String[] data= {updatedFacultyName,updatedPhoneNumber,updatedEmail,updatedDesignation,updatedDepartmentId};
		                                    int updateResult = database.Database.upFaculty(facultyId, data);
		                                    if (updateResult != -1) {
		                                        JOptionPane.showMessageDialog(null, "Faculty details updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
		                                    } else {
		                                        JOptionPane.showMessageDialog(null, "Failed to update faculty details", "Error", JOptionPane.ERROR_MESSAGE);
		                                    }
		                                }
		                            }
		                        	
		                            break;
	                        case "DEPARTMENT":
	                        	JPanel panel3 = new JPanel(new GridLayout(1, 2));
	                            JTextField deptIdField = new JTextField(10);
	                            panel3.add(new JLabel("Department ID:"));
	                            panel3.add(deptIdField);
	                            int result3 = JOptionPane.showConfirmDialog(null, panel3, "Enter respective department_id to update", JOptionPane.OK_CANCEL_OPTION);
	                            if (result3 == JOptionPane.OK_OPTION) {
	                                String deptId = deptIdField.getText();
	                                if (deptId.isEmpty()) {
	                                    JOptionPane.showMessageDialog(null, "Department ID cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
	                                    return;
	                                }
	                                JPanel editPanel = new JPanel(new GridLayout(1, 2));
	                                JTextField departmentNameField = new JTextField(10);
	                                departmentNameField.setText(database.Database.getDept(deptId)[0]);
	                                editPanel.add(new JLabel("Department Name:"));
	                                editPanel.add(departmentNameField);
	                                int editResult = JOptionPane.showConfirmDialog(null, editPanel, "Edit Department Details", JOptionPane.OK_CANCEL_OPTION);
	                                if (editResult == JOptionPane.OK_OPTION) {
	                                    String updatedDepartmentName = departmentNameField.getText();
	                                    // Update the department details in the database
	                                    String[] data= {updatedDepartmentName};
	                                    int updateResult = database.Database.upDept(deptId, data);
	                                    if (updateResult != -1) {
	                                        JOptionPane.showMessageDialog(null, "Department details updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
	                                    } else {
	                                        JOptionPane.showMessageDialog(null, "Failed to update department details", "Error", JOptionPane.ERROR_MESSAGE);
	                                    }
	                                }
	                                
	                            }
	                            	break;
	                            
	                        case "SUBJECT":
	                        	JPanel panel4 = new JPanel(new GridLayout(1, 2));
	                            JTextField subcodeField = new JTextField(10);
	                            panel4.add(new JLabel("Subject Code"));
	                            panel4.add(subcodeField);
	                            int result4 = JOptionPane.showConfirmDialog(null, panel4, "Enter respective Subject code to update", JOptionPane.OK_CANCEL_OPTION);
	                            if (result4 == JOptionPane.OK_OPTION) {
	                                String subcode = subcodeField.getText();
	                                if (subcode.isEmpty()) {
	                                    JOptionPane.showMessageDialog(null, "Subject Code cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
	                                    return;
	                                }
	                                String subd[]=database.Database.getSub(subcode);
	                                JPanel editPanel = new JPanel(new GridLayout(2, 2));
	                                JTextField subjectNameField = new JTextField(10);
	                                subjectNameField.setText(subd[0]);
	                                System.out.println(subd[0]+" "+subd[1]);
	                                JTextField subjectAbbreviationField = new JTextField(10);
	                                subjectAbbreviationField.setText(subd[1]);
	                                editPanel.add(new JLabel("Subject Name:"));
	                                editPanel.add(subjectNameField);
	                                editPanel.add(new JLabel("Subject Abbreviation:"));
	                                editPanel.add(subjectAbbreviationField);
	                                int editResult = JOptionPane.showConfirmDialog(null, editPanel, "Edit Subject Details", JOptionPane.OK_CANCEL_OPTION);
	                                if (editResult == JOptionPane.OK_OPTION) {
	                                    String updatedSubjectName = subjectNameField.getText();
	                                    String updatedSubjectAbbreviation = subjectAbbreviationField.getText();
	                                    String[] data= {updatedSubjectName,updatedSubjectAbbreviation};
	                                    int updateResult = database.Database.upSub(subcode, data);
	                                    if (updateResult != -1) {
	                                        JOptionPane.showMessageDialog(null, "Subject details updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
	                                    } else {
	                                        JOptionPane.showMessageDialog(null, "Failed to update subject details", "Error", JOptionPane.ERROR_MESSAGE);
	                                    }
	                                }
	                            }
	                        	
	                            break; 
	                        
	                        	
	                        case "SECTION":
	                        	JPanel panel6=new JPanel(new GridLayout(1,2));
	                        	JTextField secIdField = new JTextField(10);
	                        	 panel6.add(new JLabel("Section Id"));
		                            panel6.add(secIdField);
		                            int result6 = JOptionPane.showConfirmDialog(null, panel6, "Enter respective Section Details to update", JOptionPane.OK_CANCEL_OPTION);
		                            if (result6 == JOptionPane.OK_OPTION) {
		                                String sectionId = secIdField.getText();
		                                if (sectionId.isEmpty()) {
		                                    JOptionPane.showMessageDialog(null, "Section ID cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
		                                    return;
		                                }
		                                String secd[]=database.Database.getSec(sectionId);
		                                JPanel editPanel = new JPanel(new GridLayout(5, 2));
		                                JTextField sectionNameField = new JTextField(10);
		                                sectionNameField.setText(secd[0]);
		                                JTextField semesterField = new JTextField(10);
		                                semesterField.setText(secd[1]);
		                                JTextField academicYearField = new JTextField(10);
		                                academicYearField.setText(secd[2]);
		                                JTextField facultyIdField = new JTextField(10);
		                                facultyIdField.setText(secd[3]);
		                                editPanel.add(new JLabel("Section Name:"));
		                                editPanel.add(sectionNameField);
		                                editPanel.add(new JLabel("Semester:"));
		                                editPanel.add(semesterField);
		                                editPanel.add(new JLabel("Academic Year:"));
		                                editPanel.add(academicYearField);
		                                editPanel.add(new JLabel("Faculty ID:"));
		                                editPanel.add(facultyIdField);
		                                // Add other fields to the editPanel
		                                int editResult = JOptionPane.showConfirmDialog(null, editPanel, "Edit Section Details", JOptionPane.OK_CANCEL_OPTION);
		                                if (editResult == JOptionPane.OK_OPTION) {
		                                    String updatedSectionName = sectionNameField.getText();
		                                    String updatedSemester = semesterField.getText();
		                                    String updatedAcademicYear = academicYearField.getText();
		                                    String updatedFacultyId = facultyIdField.getText();
		                                    // Update the section details in the database
		                                    String[] data= {updatedSectionName,updatedSemester,updatedAcademicYear,updatedFacultyId};
		                                    int updateResult = database.Database.upSec(sectionId, data);
		                                    if (updateResult != -1) {
		                                        JOptionPane.showMessageDialog(null, "Section details updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
		                                    } else {
		                                        JOptionPane.showMessageDialog(null, "Failed to update section details", "Error", JOptionPane.ERROR_MESSAGE);
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
	        }

//	        mainPanel.add(buttonPanel);
//	        this.getContentPane().add(mainPanel);
	        this.setVisible(true);
	}
	

}
