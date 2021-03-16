package groupg.mcq;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

public class StudentSectionFrame extends JInternalFrame {


    TeacherSectionFrame teacherSectionFrame = new TeacherSectionFrame();

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
    ButtonGroup buttonGroup = new ButtonGroup();

    int buttonCount, correctAnswerCount, score;
    ArrayList<String> correctAnswer = new ArrayList<String>();


    public StudentSectionFrame() {
        super("Student Section", false, true, false, true);

        setSize(350, 350);
        getContentPane().add(panel);

        panel.setLayout(null);
        textArea.setEditable(false);
        textArea.setText("");

        textArea.setBounds(20, 30, 300, 30);
        nextButton.setBounds(200, 255, 90, 50);
        endButton.setBounds(45, 255, 90, 50);
        questionLabel.setBounds(20, 1, 250, 40);

        choiceOne.setBounds(15, 80, 90, 30);
        choiceTwo.setBounds(15, 120, 90, 30);
        choiceThree.setBounds(15, 160, 90, 30);
        choiceFour.setBounds(15, 200, 90, 30);

        answer1Text.setBounds(105, 80, 215, 30);
        answer2Text.setBounds(105, 120, 215, 30);
        answer3Text.setBounds(105, 160, 215, 30);
        answer4Text.setBounds(105, 200, 215, 30);

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

        buttonGroup.add(choiceOne);
        buttonGroup.add(choiceTwo);
        buttonGroup.add(choiceThree);
        buttonGroup.add(choiceFour);

        panel.add(answer1Text);
        panel.add(answer2Text);
        panel.add(answer3Text);
        panel.add(answer4Text);

        setLocation(x, y);

        if (buttonCount == teacherSectionFrame.questionCount - 1) {
            nextButton.setText("End Exam");
        }

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


                if (!isCorrectAnswerSelected()) {
                    JOptionPane.showMessageDialog(panel, "Correct Answer Not Selected,Please Select");
                }else{

                    buttonCount++;

                    if (!teacherSectionFrame.getQuestion(buttonCount).equals("endExam")) {
                        textArea.setText(teacherSectionFrame.getQuestion(buttonCount));
                        answer1Text.setText(teacherSectionFrame.getAnswer1(buttonCount));
                        answer2Text.setText(teacherSectionFrame.getAnswer2(buttonCount));
                        answer3Text.setText(teacherSectionFrame.getAnswer3(buttonCount));
                        answer4Text.setText(teacherSectionFrame.getAnswer4(buttonCount));
                    } else {
                        setVisible(false);
                    }

                    studentAnswerCheck();
                    switch (correctAnswerCount) {
                        case 1:
                            correctAnswer.add(answer1Text.getText());
                            break;
                        case 2:
                            correctAnswer.add(answer2Text.getText());
                            break;
                        case 3:
                            correctAnswer.add(answer3Text.getText());
                            break;
                        case 4:
                            correctAnswer.add(answer4Text.getText());
                            break;
                    }

                    if (correctAnswer.get(buttonCount - 1).equals(teacherSectionFrame.correctAnswer.get(buttonCount - 1))) {
                        score++;
                    }

                    if (nextButton.getText().equals("End Exam")) {
                        JOptionPane.showMessageDialog(panel, "You Scored: " + score + " out of " + teacherSectionFrame.questionCount
                                + "\n" + "Percentage: " + ((float) score / (float) teacherSectionFrame.questionCount) * 100 + "%");
                    }

                    if (buttonCount == teacherSectionFrame.questionCount - 1) {
                        nextButton.setText("End Exam");
                    }

                    buttonGroup.clearSelection();
                }
            }
        });
        textArea.setText(teacherSectionFrame.getQuestion(buttonCount));
        answer1Text.setText(teacherSectionFrame.getAnswer1(buttonCount));
        answer2Text.setText(teacherSectionFrame.getAnswer2(buttonCount));
        answer3Text.setText(teacherSectionFrame.getAnswer3(buttonCount));
        answer4Text.setText(teacherSectionFrame.getAnswer4(buttonCount));
    }

    void studentAnswerCheck(){

        if(choiceOne.isSelected()){
            correctAnswerCount = 1;
        }
        else if(choiceTwo.isSelected()){
            correctAnswerCount = 2;
        }
        else if(choiceThree.isSelected()){
            correctAnswerCount = 3;
        }
        else if(choiceFour.isSelected()){
            correctAnswerCount = 4;
        }
    }

    boolean isCorrectAnswerSelected(){
        return choiceOne.isSelected() || choiceTwo.isSelected() || choiceThree.isSelected() || choiceFour.isSelected();
    }
}
