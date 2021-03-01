package groupg.mcq;

import javax.swing.*;
import java.awt.*;

public class teacherSectionFrame extends JInternalFrame {

    JButton submitButton = new JButton("Submit");
    JButton cancelButton = new JButton("Cancel");
    JRadioButton choiceOne = new JRadioButton("Answer 1");
    JRadioButton choiceTwo = new JRadioButton("Answer 2");
    JRadioButton choiceThree = new JRadioButton("Answer 3");
    JRadioButton choiceFour = new JRadioButton("Answer 4");
    JTextField questionText = new JTextField("");
    JTextField answer1Text = new JTextField("");
    JTextField answer2Text = new JTextField("");
    JTextField answer3Text = new JTextField("");
    JTextField answer4Text = new JTextField("");
    JPanel panel = new JPanel();
    JLabel questionLabel = new JLabel("Please Enter your questions here");
    static final int x = 30, y = 30;


    public teacherSectionFrame() {
        super("Teacher Section", false, true, false, true);

        setSize(350, 350);
        getContentPane().add(panel);

        panel.setLayout(null);

        questionText.setBounds(20,30,300,30);
        submitButton.setBounds(200,255,90,50);
        cancelButton.setBounds(45,255,90,50);
        questionLabel.setBounds(20, 1, 250, 40);

        choiceOne.setBounds(15,80,90,30);
        choiceTwo.setBounds(15,120,90,30);
        choiceThree.setBounds(15,160,90,30);
        choiceFour.setBounds(15,200,90,30);

        answer1Text.setBounds(105,80,215,30);
        answer2Text.setBounds(105,120,215,30);
        answer3Text.setBounds(105,160,215,30);
        answer4Text.setBounds(105,200,215,30);

        panel.add(questionLabel);
        panel.add(questionText);
        panel.add(submitButton);
        panel.add(cancelButton);

        panel.add(choiceOne);
        panel.add(choiceTwo);
        panel.add(choiceThree);
        panel.add(choiceFour);

        panel.add(answer1Text);
        panel.add(answer2Text);
        panel.add(answer3Text);
        panel.add(answer4Text);

        setLocation(x , y);
    }
}
