package groupg.mcq;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentSectionFrame extends JInternalFrame {

    TeacherSectionFrame teacherSectionFrame = new TeacherSectionFrame();
    JOptionPane pane = new JOptionPane();
    JDialog dialog,dialogAnswer = new JDialog();

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
                setVisible(false);
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isAnswerSelected()) {
                    pane = new JOptionPane(("Answer Not Selected,Please Select"),JOptionPane.INFORMATION_MESSAGE);
                    dialogAnswer = pane.createDialog(panel.getParent(),"");
                    dialogAnswer.setModal(false);
                    dialogAnswer.setVisible(true);
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

                    if (correctAnswer.get(buttonCount - 1).equals(teacherSectionFrame.correctAnswer.get(buttonCount - 1))) {
                        score++;
                    }

                    if (nextButton.getText().equals("End Exam")) {
                         pane = new JOptionPane( "You Scored: " + score + " out of " + teacherSectionFrame.questionCount
                                + "\n" + "Percentage: " + ((float) score / (float) teacherSectionFrame.questionCount) * 100 + "%",JOptionPane.INFORMATION_MESSAGE);
                         dialog = pane.createDialog(panel.getParent(),"");
                         dialog.setModal(false);
                         dialog.setVisible(true);
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
            correctAnswer.add(answer1Text.getText());
        }
        else if(choiceTwo.isSelected()){
            correctAnswer.add(answer2Text.getText());
        }
        else if(choiceThree.isSelected()){
            correctAnswer.add(answer3Text.getText());
        }
        else if(choiceFour.isSelected()){
            correctAnswer.add(answer4Text.getText());
        }
        else{
            pane = new JOptionPane(("Answer Not Selected,Please Select"),JOptionPane.INFORMATION_MESSAGE);
            dialogAnswer = pane.createDialog(panel.getParent(),"");
            dialogAnswer.setModal(false);
            dialogAnswer.setVisible(true);
        }
    }

    boolean isAnswerSelected(){
        return choiceOne.isSelected() || choiceTwo.isSelected() || choiceThree.isSelected() || choiceFour.isSelected();
    }
}
