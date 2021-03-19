package groupg.mcq;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Collections;

public class TeacherSectionFrame extends JInternalFrame {
    JOptionPane noQuestionPane;
    JOptionPane noClearPane;

    JDialog dialog;

    JButton submitButton = new JButton("Submit");
    JButton cancelButton = new JButton("Cancel");
    JButton clearAllButton = new JButton("Clear All");
    JButton clearLastButton = new JButton("Clear Last");
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

    public static ArrayList<String> questionArray = new ArrayList<String>();
    public static ArrayList<String> answerArray1 = new ArrayList<String>();
    public static ArrayList<String> answerArray2 = new ArrayList<String>();
    public static ArrayList<String> answerArray3 = new ArrayList<String>();
    public static ArrayList<String> answerArray4 = new ArrayList<String>();

    ButtonGroup buttonGroup = new ButtonGroup();

    public static int questionCount;
    public static int correctAnswerCount;
    public static ArrayList<String> correctAnswer = new ArrayList<String>();

    static final int x = 30, y = 30;

    public TeacherSectionFrame() {
        super("Teacher Section", false, true, false, true);

        setSize(350, 350);
        getContentPane().add(panel);

        panel.setLayout(null);

        questionText.setBounds(20,30,300,30);
        submitButton.setBounds(200,280,95,25);
        cancelButton.setBounds(45,280,95,25);
        clearAllButton.setBounds(200,245,95,25);
        clearLastButton.setBounds(45,245,95,25);
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
        panel.add(clearAllButton);
        panel.add(clearLastButton);

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

        setLocation(x , y);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isQuestionFilled()) {
//                    JOptionPane.showMessageDialog(panel, "Question Not Filled");
                    noQuestionPane = new JOptionPane("Question Not Filled", JOptionPane.INFORMATION_MESSAGE);
                    dialog = noQuestionPane.createDialog(panel.getParent(), "ERROR");
                    dialog.setModal(false);
                    dialog.setVisible(true);
                } else if (!isAnswersFilled())
                {
//                    JOptionPane.showMessageDialog(panel, "Answers Not Filled");
                    noQuestionPane = new JOptionPane("Answers Not Filled", JOptionPane.INFORMATION_MESSAGE);
                    dialog = noQuestionPane.createDialog(panel.getParent(), "ERROR");
                    dialog.setModal(false);
                    dialog.setVisible(true);
                } else if (!isCorrectAnswerSelected())
                {
//                    JOptionPane.showMessageDialog(panel, "Correct Answer Not Selected");
                    noQuestionPane = new JOptionPane("Correct Answer Not Selected", JOptionPane.INFORMATION_MESSAGE);
                    dialog = noQuestionPane.createDialog(panel.getParent(), "ERROR");
                    dialog.setModal(false);
                    dialog.setVisible(true);
                } else
                    {
                    setAnswers(answer1Text.getText(), answer2Text.getText(), answer3Text.getText(), answer4Text.getText());
                    setQuestion(questionText.getText());

                    questionCount++;

                    teacherAnswerCheck();
                    switch (correctAnswerCount) {
                        case 1:
                            System.out.println(answer1Text.getText());
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

                    questionText.setText(null);
                    answer1Text.setText(null);
                    answer2Text.setText(null);
                    answer3Text.setText(null);
                    answer4Text.setText(null);

                    buttonGroup.clearSelection();
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    setClosed(true);
                } catch (PropertyVetoException propertyVetoException) {
                    propertyVetoException.printStackTrace();
                }
            }
        });

        clearAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(questionCount > 0) {
                    questionArray.clear();
                    correctAnswer.clear();
                    answerArray1.clear();
                    answerArray2.clear();
                    answerArray3.clear();
                    answerArray4.clear();
                    questionCount = 0;
                    correctAnswerCount = 0;

                    if (questionArray.isEmpty() && correctAnswer.isEmpty()) {
//                        JOptionPane.showMessageDialog(panel, "All questions & answers have been cleared");
                        noClearPane = new JOptionPane("All questions & answers have been cleared", JOptionPane.INFORMATION_MESSAGE);
                        dialog = noClearPane.createDialog(panel.getParent(), "ERROR");
                        dialog.setModal(false);
                        dialog.setVisible(true);
                    } else {
//                        JOptionPane.showMessageDialog(panel, "An error occurred while clearing, Try Again");
                        noClearPane = new JOptionPane("An error occurred while clearing, Try Again", JOptionPane.INFORMATION_MESSAGE);
                        dialog = noClearPane.createDialog(panel.getParent(), "ERROR");
                        dialog.setModal(false);
                        dialog.setVisible(true);
                    }

                }else{
//                    JOptionPane.showMessageDialog(panel, "No more questions to clear!?!");
                    noClearPane = new JOptionPane("No more questions to clear!?!", JOptionPane.INFORMATION_MESSAGE);
                    dialog = noClearPane.createDialog(panel.getParent(), "ERROR");
                    dialog.setModal(false);
                    dialog.setVisible(true);
                }
            }
        });

        clearLastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(questionCount > 0) {
                    int oldSize = questionArray.size();
                    int index = questionArray.size() - 1;
                    questionArray.remove(index);
                    correctAnswer.remove(index);
                    answerArray1.remove(index);
                    answerArray2.remove(index);
                    answerArray3.remove(index);
                    answerArray4.remove(index);
                    questionCount -= 1;
                    correctAnswerCount -= 1;

                    if (questionArray.size() == (oldSize - 1)) {
                        JOptionPane.showMessageDialog(panel, "Last question & answers have been cleared");
                    } else {
                        JOptionPane.showMessageDialog(panel, "An error occurred while clearing, Try Again");
                    }
                }else{
                    JOptionPane.showMessageDialog(panel, "No more questions to clear!?!");
                }
            }
        });
    }

    void setQuestion(String question){
        questionArray.add(question);
    }

    void setAnswers(String answer1, String answer2, String answer3, String answer4){
        answerArray1.add(answer1);
        answerArray2.add(answer2);
        answerArray3.add(answer3);
        answerArray4.add(answer4);
    }

    String getAnswer1(int index){
        return answerArray1.get(index);
    }

    String getAnswer2(int index){
        return answerArray2.get(index);
    }

    String getAnswer3(int index){
        return answerArray3.get(index);
    }

    String getAnswer4(int index){
        return answerArray4.get(index);
    }

    String getQuestion(int index){
        if(index < questionArray.size()) {
            return questionArray.get(index);
        }
        else{
            return "endExam";
        }
    }

    void teacherAnswerCheck(){

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

    boolean isAnswersFilled(){
        return (!answer1Text.getText().equals("") && answer1Text.getText() != null) &&
                (!answer2Text.getText().equals("") && answer2Text.getText() != null) &&
                (!answer3Text.getText().equals("") && answer3Text.getText() != null) &&
                (!answer4Text.getText().equals("") && answer4Text.getText() != null);
    }

    boolean isQuestionFilled(){
        return !questionText.getText().equals("") && questionText.getText() != null;
    }
}
