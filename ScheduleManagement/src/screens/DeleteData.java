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

public class DeleteData extends ScreenTemplate {

	public DeleteData() {
		super("Delete Data");
		myFont font=new myFont(40);
		 JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

	        JPanel labelPanel = new JPanel();
	        JLabel label1 = new JLabel("DELETE DATA");
	        label1.setFont(font);
	        labelPanel.add(label1); 

	        mainPanel.add(labelPanel);
	        JPanel buttonPanel = new JPanel(new GridLayout(8, 1, 10, 10));
	        buttonPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
	        String[] buttonNames = { "BLOCK", "CLASSROOM", "FACULTY", "DEPARTMENT", "SUBJECT",
	                "FACULTY HANDLING THE SUBJECT", "SECTION"};
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
	                            int result = JOptionPane.showConfirmDialog(null, panel, "Enter respective Block_id to delete", JOptionPane.OK_CANCEL_OPTION);
	                            if (result == JOptionPane.OK_OPTION) {
	                                String blockId = blockIdField.getText();
	                                int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the block with ID: " + blockId, "Confirmation", JOptionPane.YES_NO_OPTION);
	                                if (confirmResult == JOptionPane.YES_OPTION) {
	                                    // Delete block
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
	                                int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the classroom with ID: " + classroomId, "Confirmation", JOptionPane.YES_NO_OPTION);
	                                if (confirmResult == JOptionPane.YES_OPTION) {
	                                    // Delete block
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
		                                int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the faculty with ID: " + facultyId, "Confirmation", JOptionPane.YES_NO_OPTION);
		                                if (confirmResult == JOptionPane.YES_OPTION) {
		                                    // Delete block
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
	                                int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the department with ID: " + deptId, "Confirmation", JOptionPane.YES_NO_OPTION);
	                                if (confirmResult == JOptionPane.YES_OPTION) {
	                                    // Delete block
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
	                                int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the Subject with ID: " + subcode, "Confirmation", JOptionPane.YES_NO_OPTION);
	                                if (confirmResult == JOptionPane.YES_OPTION) {
	                                    // Delete block
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
	                                int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the faculty with ID: " + facultyid+"  handling the subject with subject code  "+subcode+"  for the section with Id: "+secid,"Confirmation", JOptionPane.YES_NO_OPTION);
	                                if (confirmResult == JOptionPane.YES_OPTION) {
	                                    // Delete block
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
		                                int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the Section with ID: " + sectionId, "Confirmation", JOptionPane.YES_NO_OPTION);
		                                if (confirmResult == JOptionPane.YES_OPTION) {
		                                    // Delete block
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


