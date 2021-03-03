package groupg.mcq;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

public class TeacherSectionFrame extends JInternalFrame {

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

    public static ArrayList<String> questionArray = new ArrayList<String>();
    public static ArrayList<String> answerArray1 = new ArrayList<String>();
    public static ArrayList<String> answerArray2 = new ArrayList<String>();
    public static ArrayList<String> answerArray3 = new ArrayList<String>();
    public static ArrayList<String> answerArray4 = new ArrayList<String>();
    public static ArrayList<ArrayList<String>> arrayListAnswers = new ArrayList<ArrayList<String>>();

    public static int questionCount;
    public static int correctAnswerCount;
    public static String correctAnswer;

    static final int x = 30, y = 30;

    public TeacherSectionFrame() {
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

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAnswers(answer1Text.getText(), answer2Text.getText(), answer3Text.getText(), answer4Text.getText());
                setQuestion(questionText.getText());


                questionCount++;

                teacherAnswerCheck();
                switch(correctAnswerCount){
                    case 1:
                        correctAnswer = answer1Text.getText();
                        choiceTwo.setSelected(false);
                        choiceThree.setSelected(false);
                        choiceFour.setSelected(false);
                        break;
                    case 2:
                        correctAnswer = answer2Text.getText();
                        choiceOne.setSelected(false);
                        choiceThree.setSelected(false);
                        choiceFour.setSelected(false);
                        break;
                    case 3:
                        correctAnswer = answer3Text.getText();
                        choiceOne.setSelected(false);
                        choiceTwo.setSelected(false);
                        choiceFour.setSelected(false);
                        break;
                    case 4:
                        correctAnswer = answer4Text.getText();
                        choiceOne.setSelected(false);
                        choiceTwo.setSelected(false);
                        choiceThree.setSelected(false);
                        break;
                }
                System.out.println(correctAnswer);

                questionText.setText(null);
                answer1Text.setText(null);
                answer2Text.setText(null);
                answer3Text.setText(null);
                answer4Text.setText(null);

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
}
