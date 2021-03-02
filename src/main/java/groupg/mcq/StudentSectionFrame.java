package groupg.mcq;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

public class StudentSectionFrame extends JInternalFrame {

    JButton nextButton = new JButton("Next");
    JButton endButton = new JButton("EndQuiz");
    JRadioButton choiceOne = new JRadioButton("Answer 1");
    JRadioButton choiceTwo = new JRadioButton("Answer 2");
    JRadioButton choiceThree = new JRadioButton("Answer 3");
    JRadioButton choiceFour = new JRadioButton("Answer 4");
    JTextField textArea = new JTextField("");
    JTextField answer1Text = new JTextField("");
    JTextField answer2Text = new JTextField("");
    JTextField answer3Text = new JTextField("");
    JTextField answer4Text = new JTextField("");
    JPanel panel = new JPanel();
    JLabel questionLabel = new JLabel("Question: ");
    static final int x = 30, y = 30;


    public StudentSectionFrame() {
        super("Student Section", false, true, false, true);

        setSize(350, 350);
        getContentPane().add(panel);

        panel.setLayout(null);
        textArea.setEditable(false);
        textArea.setText("Placeholder");

        textArea.setBounds(20,30,300,30);
        nextButton.setBounds(200,255,90,50);
        endButton.setBounds(45,255,90,50);
        questionLabel.setBounds(20, 1, 250, 40);

        choiceOne.setBounds(15,80,90,30);
        choiceTwo.setBounds(15,120,90,30);
        choiceThree.setBounds(15,160,90,30);
        choiceFour.setBounds(15,200,90,30);

        answer1Text.setBounds(105,80,215,30);
        answer2Text.setBounds(105,120,215,30);
        answer3Text.setBounds(105,160,215,30);
        answer4Text.setBounds(105,200,215,30);

        answer1Text.setEditable(false);
        answer2Text.setEditable(false);
        answer3Text.setEditable(false);
        answer4Text.setEditable(false);

        panel.add(questionLabel);
        panel.add(textArea);
        panel.add(nextButton);
        panel.add(endButton);

        panel.add(choiceOne);
        panel.add(choiceTwo);
        panel.add(choiceThree);
        panel.add(choiceFour);

        panel.add(answer1Text);
        panel.add(answer2Text);
        panel.add(answer3Text);
        panel.add(answer4Text);

        setLocation(x , y);

        endButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    setClosed(true);
                } catch (PropertyVetoException propertyVetoException) {
                    propertyVetoException.printStackTrace();
                }
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        TeacherSectionFrame teacherSectionFrame = new TeacherSectionFrame();
        //System.out.println(teacherSectionFrame.question);
        textArea.setText(teacherSectionFrame.getQuestion());


    }
}
