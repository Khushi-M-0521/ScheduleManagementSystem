package screens;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import myswingobjects.MyButton;
import myswingobjects.ScreenTemplate;
import myswingobjects.myFont;

public class FirstScreen {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScreenTemplate screen = new ScreenTemplate("HomeScreen");
		myFont font=new myFont(40);

        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel labelPanel = new JPanel();
        JLabel scheduleLabel = new JLabel("Schedule Management");
        scheduleLabel.setFont(font);
        labelPanel.add(scheduleLabel);
//        labelPanel.setBorder(new EmptyBorder(0, 0, 10, 0)); 

        mainPanel.add(labelPanel);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        buttonPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
        String[] buttonNames = { "ADD DATA", "ADD TIMETABLE", "FETCH TIMETABLE", "FETCH CLASSROOM", "DELETE DATA",
                "DELETE TIMETABLE", "UPDATE DATA", "UPDATE TIMETABLE" };
        for (String name : buttonNames) {
            MyButton button = new MyButton(name, 10, 10, 70, 70);
//            button.setMargin(new Insets(40, 40, 40, 40));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Perform action based on the button's name
                    switch (name) {
                        case "ADD DATA":
                            System.out.println("ADD DATA button clicked");
                        	AddData.main(new String[]{});
                            break;
                        case "ADD TIMETABLE":
                            System.out.println("ADD TIMETABLE button clicked");
                            break;
                        default:
                            break;
                    }
                }
            });
            buttonPanel.add(button);
        }

        mainPanel.add(buttonPanel);

        screen.getContentPane().add(mainPanel);
        screen.setVisible(true);

	}

}
