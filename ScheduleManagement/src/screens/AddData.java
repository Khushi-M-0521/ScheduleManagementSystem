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

import screens.FirstScreen;
import database.Database;

public class AddData extends ScreenTemplate{
	public AddData() {
		super("ADD DATA");
		JLabel label1 = new JLabel("ADD DATA");
		label1.setFont(new myFont(40));
		label1.setBounds(10, 10, 480, 50);
		label1.setHorizontalAlignment(JLabel.CENTER);
		this.getContentPane().add(label1);

	        JPanel buttonPanel = new JPanel(new GridLayout(8, 1, 10, 10));
	        buttonPanel.setBackground(Color.WHITE);
	        buttonPanel.setBounds(10,50,470,420);
	        buttonPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
	        this.getContentPane().add(buttonPanel);
	        String[] buttonNames = { "NEW BLOCK", "NEW CLASSROOM", "NEW FACULTY", "NEW DEPARTMENT", "NEW SUBJECT",
	                "NEW FACULTY HANDLING THE SUBJECT", "NEW SECTION", "NEW BATCH" };
	        for (String name : buttonNames) {
	            MyButton button = new MyButton(name, 5, 5, 70, 70);
	            button.addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    switch (name) {
	                        case "NEW BLOCK":
	                        	JPanel panel = new JPanel(new GridLayout(2, 2));
	                            JTextField blockIdField = new JTextField(10);
	                            JTextField blockNameField = new JTextField(10);
	                            panel.add(new JLabel("Block ID:"));
	                            panel.add(blockIdField);
	                            panel.add(new JLabel("Block Name:"));
	                            panel.add(blockNameField);
	                            int result = JOptionPane.showConfirmDialog(null, panel, "Enter Block Details", JOptionPane.OK_CANCEL_OPTION);
	                            if (result == JOptionPane.OK_OPTION) {
	                                String blockId = blockIdField.getText();
	                                String blockName = blockNameField.getText();
	                                if(blockId.isEmpty() || blockName.isEmpty())
	                                	JOptionPane.showMessageDialog(null, "Missing one or more values", "Failed", JOptionPane.ERROR_MESSAGE);
	                                else {
	                                 	int res=database.Database.addblock(blockId,blockName);
	                                 	if(res!=-1) {
	                                 		JOptionPane.showMessageDialog(null, "Inserted", "Success", JOptionPane.INFORMATION_MESSAGE);
	                                 		//blockIdField.setText("");
	                                 		//blockNameField.setText("");
	                                 	}
	                                 	else {
	                                 		JOptionPane.showMessageDialog(null, "error in value", "Failed", JOptionPane.ERROR_MESSAGE);
	                                 	}
	                                }
	                            
	                                
	                            }
	                            break;
	                        case "NEW CLASSROOM":
	                        	JPanel panel1 = new JPanel(new GridLayout(3, 2));
	                            JTextField classroomIdField = new JTextField(10);
	                            JTextField HasprojectorField = new JTextField(10);
	                            JTextField BlockIdField = new JTextField(10);
	                            panel1.add(new JLabel("Classroom Id"));
	                            panel1.add(classroomIdField);
	                            panel1.add(new JLabel("HasProjector:"));
	                            panel1.add(HasprojectorField);
	                            panel1.add(new JLabel("BlockId:"));
	                            panel1.add(BlockIdField);
	                            int result1 = JOptionPane.showConfirmDialog(null, panel1, "Enter Classroom Details", JOptionPane.OK_CANCEL_OPTION);
	                            if (result1 == JOptionPane.OK_OPTION) {
	                                String classroomId = classroomIdField.getText();
	                                String hasprojector = HasprojectorField.getText();
	                                String Blockid=BlockIdField.getText();
	                                if(classroomId.isEmpty() || hasprojector.isEmpty() || Blockid.isEmpty())
	                                	JOptionPane.showMessageDialog(null, "Missing one or more values", "Failed", JOptionPane.ERROR_MESSAGE);
	                                else {
	                                	int res=database.Database.addclassroom(classroomId,hasprojector,Blockid);
	                                	if(res!=-1) {
	                                		JOptionPane.showMessageDialog(null, "Inserted", "Success", JOptionPane.INFORMATION_MESSAGE);
	                                		//classroomIdField.setText("");
	                                		//HasprojectorField.setText("");
	                                		//BlockIdField.setText("");
	                                	}
	                                	else {
	                                		JOptionPane.showMessageDialog(null, "error in value", "Failed", JOptionPane.ERROR_MESSAGE);
	                                	}
	                                }
	                                
	                            }
	                        	
	                            break;
	                        case "NEW FACULTY":
	                        	JPanel panel2=new JPanel(new GridLayout(5,2));
	                        	JTextField FacultyIdField = new JTextField(10);
	                        	JTextField FacultynameField = new JTextField(10);
	                        	JTextField emailField = new JTextField(10);
	                        	JTextField phonenumberField = new JTextField(10);
	                        	JTextField depatidField = new JTextField(10);
	                        	 panel2.add(new JLabel("Faculty Id"));
		                            panel2.add(FacultyIdField);
		                            panel2.add(new JLabel("Faculty Name:"));
		                            panel2.add(FacultynameField);
		                            panel2.add(new JLabel("Email:"));
		                            panel2.add(emailField);
		                            panel2.add(new JLabel("Phone number:"));
		                            panel2.add(phonenumberField);
		                            panel2.add(new JLabel("Department Id:"));
		                            panel2.add(depatidField);
		                            int result2 = JOptionPane.showConfirmDialog(null, panel2, "Enter Faculty Details", JOptionPane.OK_CANCEL_OPTION);
		                            if (result2 == JOptionPane.OK_OPTION) {
		                                String facultyId = FacultyIdField.getText();
		                                String facultyname = FacultynameField.getText();
		                                String facultyemail = emailField.getText();
		                                String phonenumber = phonenumberField.getText();
		                                String deptid = depatidField.getText();
		                                if(facultyId.isEmpty() || facultyname.isEmpty() || facultyemail.isEmpty() || phonenumber.isEmpty() || deptid.isEmpty())
		                                	JOptionPane.showMessageDialog(null, "Missing one or more values", "Failed", JOptionPane.ERROR_MESSAGE);
		                                else {
		                                	String designation="associate";
		                                	int res=database.Database.addfaculty(facultyId,facultyname,phonenumber,facultyemail, designation,deptid);
		                                	if(res!=-1) {
		                                	JOptionPane.showMessageDialog(null, "Inserted", "Success", JOptionPane.INFORMATION_MESSAGE);
		                                		//FacultyIdField.setText("");
		                                		//FacultynameField.setText("");
		                                		//emailField.setText("");
		                                		//phonenumberField.setText("");
		                                		//depatidField.setText("");
		                                	}
		                                	else {
		                                		JOptionPane.showMessageDialog(null, "error in value", "Failed", JOptionPane.ERROR_MESSAGE);
		                                	}
		                                }
		                                
		                            }
		                        	
		                            break;
	                        case "NEW DEPARTMENT":
	                        	JPanel panel3 = new JPanel(new GridLayout(2, 2));
	                            JTextField deptIdField = new JTextField(10);
	                            JTextField deptNameField = new JTextField(10);
	                            panel3.add(new JLabel("Department ID:"));
	                            panel3.add(deptIdField);
	                            panel3.add(new JLabel("Department Name:"));
	                            panel3.add(deptNameField);
	                            int result3 = JOptionPane.showConfirmDialog(null, panel3, "Enter Department Details", JOptionPane.OK_CANCEL_OPTION);
	                            if (result3 == JOptionPane.OK_OPTION) {
	                                String deptId = deptIdField.getText();
	                                String deptName = deptNameField.getText();
	                                if(deptId.isEmpty() || deptName.isEmpty())
	                                	JOptionPane.showMessageDialog(null, "Missing one or more values", "Failed", JOptionPane.ERROR_MESSAGE);
	                                else {
	                                	int res=database.Database.adddepartment(deptId,deptName);
	                                	if(res!=0) {
	                                		JOptionPane.showMessageDialog(null, "Inserted", "Success", JOptionPane.INFORMATION_MESSAGE);
	                                		//deptIdField.setText("");
	                                		//deptNameField.setText("");
	                                	}
	                                	else {
	                                		JOptionPane.showMessageDialog(null, "error in value", "Failed", JOptionPane.ERROR_MESSAGE);
	                                	}
	                                }
	                                
	                            }
	                            	break;
	                            
	                        case "NEW SUBJECT":
	                        	JPanel panel4 = new JPanel(new GridLayout(3, 2));
	                            JTextField subcodeField = new JTextField(10);
	                            JTextField subnameField = new JTextField(10);
	                            JTextField subabbField = new JTextField(10);
	                            panel4.add(new JLabel("Subject Code"));
	                            panel4.add(subcodeField);
	                            panel4.add(new JLabel("Subject name:"));
	                            panel4.add(subnameField);
	                            panel4.add(new JLabel("Subject abbrevation:"));
	                            panel4.add(subabbField);
	                            int result4 = JOptionPane.showConfirmDialog(null, panel4, "Enter Subject Details", JOptionPane.OK_CANCEL_OPTION);
	                            if (result4 == JOptionPane.OK_OPTION) {
	                                String subcode = subcodeField.getText();
	                                String subname = subnameField.getText();
	                                String subabbrevation=subabbField.getText();
	                                if(subcode.isEmpty() || subname.isEmpty() || subabbrevation.isEmpty())
	                                	JOptionPane.showMessageDialog(null, "Missing one or more values", "Failed", JOptionPane.ERROR_MESSAGE);
	                                else {
	                                	int res=database.Database.addsubject(subcode,subname,subabbrevation);
	                                	if(res!=0) {
	                                		JOptionPane.showMessageDialog(null, "Inserted", "Success", JOptionPane.INFORMATION_MESSAGE);
	                                		//subcodeField.setText("");
	                                		//subnameField.setText("");
	                                		//subabbField.setText("");
	                                	}
	                                	else {
	                                		JOptionPane.showMessageDialog(null, "error in value", "Failed", JOptionPane.ERROR_MESSAGE);
	                                	}
	                                }
	                                
	                            }
	                        	
	                            break; 
	                        case "NEW FACULTY HANDLING THE SUBJECT":
	                        	JPanel panel5 = new JPanel(new GridLayout(2, 2));
	                            JTextField subjcodeField = new JTextField(10);
	                            JTextField facultyyidField = new JTextField(10);
	                            panel5.add(new JLabel("Subject Code:"));
	                            panel5.add(subjcodeField);
	                            panel5.add(new JLabel("Faculty id:"));
	                            panel5.add(facultyyidField);
	                            int result5 = JOptionPane.showConfirmDialog(null, panel5, "Enter Faculty handling subject Details", JOptionPane.OK_CANCEL_OPTION);
	                            if (result5 == JOptionPane.OK_OPTION) {
	                                String subcode =subjcodeField.getText();
	                                String facultyid = facultyyidField.getText();
	                                if(subcode.isEmpty() || facultyid.isEmpty())
	                                	JOptionPane.showMessageDialog(null, "Missing one or more values", "Failed", JOptionPane.ERROR_MESSAGE);
	                                else {
	                                	int res=database.Database.addhandles(facultyid,subcode,facultyid,subcode);
	                                	if(res!=0) {
	                                		JOptionPane.showMessageDialog(null, "Inserted", "Success", JOptionPane.INFORMATION_MESSAGE);
	                                		//subjcodeField.setText("");
	                                		//facultyyidField.setText("");
	                                	}
	                                	else {
	                                		JOptionPane.showMessageDialog(null, "error in value", "Failed", JOptionPane.ERROR_MESSAGE);
	                                	}
	                                }
	                                
	                            }
	                        	break;
	                        	
	                        case "NEW SECTION":
	                        	JPanel panel6=new JPanel(new GridLayout(5,2));
	                        	JTextField secIdField = new JTextField(10);
	                        	JTextField secField = new JTextField(10);
	                        	JTextField semField = new JTextField(10);
	                        	JTextField academicyearField = new JTextField(10);
	                        	JTextField facultyidField = new JTextField(10);
	                        	 panel6.add(new JLabel("Section Id"));
		                            panel6.add(secIdField);
		                            panel6.add(new JLabel("Section:"));
		                            panel6.add(secField);
		                            panel6.add(new JLabel("Semester"));
		                            panel6.add(semField);
		                            panel6.add(new JLabel("Academic year"));
		                            panel6.add(academicyearField);
		                            panel6.add(new JLabel("Faculty Id"));
		                            panel6.add(facultyidField);
		                            int result6 = JOptionPane.showConfirmDialog(null, panel6, "Enter Section Details", JOptionPane.OK_CANCEL_OPTION);
		                            if (result6 == JOptionPane.OK_OPTION) {
		                                String sectionId = secIdField.getText();
		                                String secname = secField.getText();
		                                String sem = semField.getText();
		                                String academicyear = academicyearField.getText();
		                                String facultyid = facultyidField.getText();
		                                if(sectionId.isEmpty() || secname.isEmpty() || sem.isEmpty() || academicyear.isEmpty() || facultyid.isEmpty())
		                                	JOptionPane.showMessageDialog(null, "Missing one or more values", "Failed", JOptionPane.ERROR_MESSAGE);
		                                else {
		                                	int res=database.Database.addsection(sectionId,secname,sem,academicyear ,facultyid);
		                                	if(res!=0) {
		                                		JOptionPane.showMessageDialog(null, "Inserted", "Success", JOptionPane.INFORMATION_MESSAGE);
		                                		//secIdField.setText("");
		                                		//secField.setText("");
		                                		//semField.setText("");
		                                		//academicyearField.setText("");
		                                		//facultyidField.setText("");
		                                	}
		                                	else {
		                                		JOptionPane.showMessageDialog(null, "error in value", "Failed", JOptionPane.ERROR_MESSAGE);
		                                	}
		                                }
		                                
		                            }
	                        	
	                        	break;
//	                        case "NEW BATCH":
//	                        	JPanel panel7 = new JPanel(new GridLayout(2, 2));
//	                            JTextField secidField = new JTextField(10);
//	                            JTextField BatchnameField = new JTextField(10);
//	                            panel7.add(new JLabel("Section Id:"));
//	                            panel7.add(secidField);
//	                            panel7.add(new JLabel("Batch Name:"));
//	                            panel7.add(BatchnameField);
//	                            int result7 = JOptionPane.showConfirmDialog(null, panel7, "Enter Batch Details", JOptionPane.OK_CANCEL_OPTION);
//	                            if (result7 == JOptionPane.OK_OPTION) {
//	                                String secId =secidField.getText();
//	                                String BatchName = BatchnameField.getText();
//	                                if(secId.isEmpty() || BatchName.isEmpty())
//	                                	JOptionPane.showMessageDialog(null, "Missing one or more values", "Failed", JOptionPane.ERROR_MESSAGE);
//	                                else {
//	                                	int res=database.Database.addbatch(secId,BatchName);
//	                                	if(res!=0) {
//	                                		JOptionPane.showMessageDialog(null, "Inserted", "Success", JOptionPane.INFORMATION_MESSAGE);
//	                                		dispose();
//	                                	}
//	                                	else {
//	                                		JOptionPane.showMessageDialog(null, "error in value", "Failed", JOptionPane.ERROR_MESSAGE);
//	                                	}
//	                                }
//	                                
//	                            }
//	                            
//	                        	break;
	                    }
	                }
	            });
	            buttonPanel.add(button);
	        }

	        this.setVisible(true);
	}

}
