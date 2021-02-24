package groupg.mcq;

import javax.swing.*;
import java.awt.*;

public class teacherSectionFrame extends JInternalFrame {

    JButton submitButton = new JButton("Submit");
    JTextField textArea = new JTextField("Test");
    JPanel panel = new JPanel();
    JLabel questionLabel = new JLabel("Please Enter your questions here");
    static final int x = 370, y = 30;


    public teacherSectionFrame() {
        super("Teacher Section", false, true, false, true);

        setSize(350, 350);
        getContentPane().add(panel);

        panel.setLayout(null);

        textArea.setBounds(20,30,300,30);
        submitButton.setBounds(120,255,90,50);
        questionLabel.setBounds(20, 1, 250, 40);

        panel.add(questionLabel);
        panel.add(textArea);
        panel.add(submitButton);


        setLocation(x , y);
    }
}
