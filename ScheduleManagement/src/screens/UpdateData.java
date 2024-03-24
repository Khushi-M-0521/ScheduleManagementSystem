package screens;

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
		myFont font=new myFont(40);
		 JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

	        JPanel labelPanel = new JPanel();
	        JLabel label1 = new JLabel("UPDATE DATA");
	        label1.setFont(font);
	        labelPanel.add(label1); 

	        mainPanel.add(labelPanel);
	        JPanel buttonPanel = new JPanel(new GridLayout(8, 1, 10, 10));
	        buttonPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
	        String[] buttonNames = { "BLOCK", "CLASSROOM", "FACULTY", "DEPARTMENT", "SUBJECT",
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
	                                JPanel editPanel = new JPanel(new GridLayout(2, 2));
	                                JTextField blockNameField = new JTextField(10);
	                                // Populate other fields with the retrieved details
	                                editPanel.add(new JLabel("Block Name:"));
	                                editPanel.add(blockNameField);
	                                // Add other fields to the editPanel
	                                int editResult = JOptionPane.showConfirmDialog(null, editPanel, "Edit Block Details", JOptionPane.OK_CANCEL_OPTION);
	                                if (editResult == JOptionPane.OK_OPTION) {
	                                    String updatedBlockName = blockNameField.getText();
//	                                     Update the block details in the database
//	                                    int updateResult = database.Database.updateBlock(blockId, updatedBlockName);
//	                                    if (updateResult != 0) {
//	                                        JOptionPane.showMessageDialog(null, "Block details updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
//	                                    } else {
//	                                        JOptionPane.showMessageDialog(null, "Failed to update block details", "Error", JOptionPane.ERROR_MESSAGE);
//	                                    }
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
	                                JPanel editPanel = new JPanel(new GridLayout(3, 2));
	                                JTextField hasProjectorField = new JTextField(10);
	                                JTextField blockIddField = new JTextField(10);
	                                editPanel.add(new JLabel("Has Projector:"));
	                                editPanel.add(hasProjectorField);
	                                editPanel.add(new JLabel("Block ID:"));
	                                editPanel.add(blockIddField);
	                                int editResult = JOptionPane.showConfirmDialog(null, editPanel, "Edit Classroom Details", JOptionPane.OK_CANCEL_OPTION);
	                                if (editResult == JOptionPane.OK_OPTION) {
	                                    String updatedHasProjector = hasProjectorField.getText();
	                                    String updatedBlockId = blockIddField.getText();
	                                    // Update the classroom details in the database
//	                                    int updateResult = database.Database.updateClassroom(classroomId, updatedHasProjector, updatedBlockId);
//	                                    if (updateResult != 0) {
//	                                        JOptionPane.showMessageDialog(null, "Classroom details updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
//	                                    } else {
//	                                        JOptionPane.showMessageDialog(null, "Failed to update classroom details", "Error", JOptionPane.ERROR_MESSAGE);
//	                                    }
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
		                                JPanel editPanel = new JPanel(new GridLayout(5, 2));
		                                JTextField facultyNameField = new JTextField(10);
		                                JTextField emailField = new JTextField(10);
		                                JTextField phoneNumberField = new JTextField(10);
		                                JTextField departmentIdField = new JTextField(10);
		                                JTextField designationField=new JTextField(10);
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
//		                                    int updateResult = database.Database.updateFaculty(facultyId, updatedFacultyName, updatedEmail, updatedPhoneNumber, updatedDepartmentId);
//		                                    if (updateResult != 0) {
//		                                        JOptionPane.showMessageDialog(null, "Faculty details updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
//		                                    } else {
//		                                        JOptionPane.showMessageDialog(null, "Failed to update faculty details", "Error", JOptionPane.ERROR_MESSAGE);
//		                                    }
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
	                                JPanel editPanel = new JPanel(new GridLayout(1, 2));
	                                JTextField departmentNameField = new JTextField(10);
	                                // Populate other fields with the retrieved details
	                                editPanel.add(new JLabel("Department Name:"));
	                                editPanel.add(departmentNameField);
	                                int editResult = JOptionPane.showConfirmDialog(null, editPanel, "Edit Department Details", JOptionPane.OK_CANCEL_OPTION);
	                                if (editResult == JOptionPane.OK_OPTION) {
	                                    String updatedDepartmentName = departmentNameField.getText();
	                                    // Update the department details in the database
//	                                    int updateResult = database.Database.updateDepartment(deptId, updatedDepartmentName);
//	                                    if (updateResult != 0) {
//	                                        JOptionPane.showMessageDialog(null, "Department details updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
//	                                    } else {
//	                                        JOptionPane.showMessageDialog(null, "Failed to update department details", "Error", JOptionPane.ERROR_MESSAGE);
//	                                    }
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
	                                JPanel editPanel = new JPanel(new GridLayout(1, 2));
	                                JTextField subjectNameField = new JTextField(10);
	                                JTextField subjectAbbreviationField = new JTextField(10);
	                                // Populate other fields with the retrieved details
	                                editPanel.add(new JLabel("Subject Name:"));
	                                editPanel.add(subjectNameField);
	                                editPanel.add(new JLabel("Subject Abbreviation:"));
	                                editPanel.add(subjectAbbreviationField);
	                                // Add other fields to the editPanel
	                                int editResult = JOptionPane.showConfirmDialog(null, editPanel, "Edit Subject Details", JOptionPane.OK_CANCEL_OPTION);
	                                if (editResult == JOptionPane.OK_OPTION) {
	                                    String updatedSubjectName = subjectNameField.getText();
	                                    String updatedSubjectAbbreviation = subjectAbbreviationField.getText();
	                                    // Update the subject details in the database
//	                                    int updateResult = database.Database.updateSubject(subcode, updatedSubjectName, updatedSubjectAbbreviation);
//	                                    if (updateResult != 0) {
//	                                        JOptionPane.showMessageDialog(null, "Subject details updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
//	                                    } else {
//	                                        JOptionPane.showMessageDialog(null, "Failed to update subject details", "Error", JOptionPane.ERROR_MESSAGE);
//	                                    }
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
		                                JPanel editPanel = new JPanel(new GridLayout(5, 2));
		                                JTextField sectionNameField = new JTextField(10);
		                                JTextField semesterField = new JTextField(10);
		                                JTextField academicYearField = new JTextField(10);
		                                JTextField facultyIdField = new JTextField(10);
		                                // Populate other fields with the retrieved details
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
//		                                    int updateResult = database.Database.updateSection(sectionId, updatedSectionName, updatedSemester, updatedAcademicYear, updatedFacultyId);
//		                                    if (updateResult != 0) {
//		                                        JOptionPane.showMessageDialog(null, "Section details updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
//		                                    } else {
//		                                        JOptionPane.showMessageDialog(null, "Failed to update section details", "Error", JOptionPane.ERROR_MESSAGE);
//		                                    }
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

	        mainPanel.add(buttonPanel);
	        this.getContentPane().add(mainPanel);
	        this.setVisible(true);
	}
	

}
