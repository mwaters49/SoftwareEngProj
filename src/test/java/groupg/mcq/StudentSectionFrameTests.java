package groupg.mcq;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.beans.PropertyVetoException;

import static org.junit.jupiter.api.Assertions.*;

public class StudentSectionFrameTests {

    StudentSectionFrame studentSectionFrame;
    TeacherSectionFrame teacherSectionFrame;

    @BeforeEach
    void initialise() throws PropertyVetoException {

        teacherSectionFrame = new TeacherSectionFrame();

        teacherSectionFrame.questionText.setText("Test");
        teacherSectionFrame.answer1Text.setText("Test");
        teacherSectionFrame.answer2Text.setText("Test");
        teacherSectionFrame.answer3Text.setText("Test");
        teacherSectionFrame.answer4Text.setText("Test");

        teacherSectionFrame.choiceOne.setSelected(true);

        teacherSectionFrame.submitButton.doClick();
        studentSectionFrame = new StudentSectionFrame();
    }

    //@DisplayName("Testing endButton in Student Test")
   // @Test
    void endButtonTest() {      //PASSES
        studentSectionFrame.endButton.doClick();
        assertTrue(studentSectionFrame.isClosed());
    }

    //@DisplayName("Testing initialFrameTest")
  //  @Test
    void initialFrameTest(){        //PASSES
        studentSectionFrame.choiceOne.setSelected(true);

        assertEquals(studentSectionFrame.textArea.getText(),teacherSectionFrame.getQuestion(studentSectionFrame.buttonCount));
        assertEquals(studentSectionFrame.answer1Text.getText(),teacherSectionFrame.getAnswer1(studentSectionFrame.buttonCount));
        assertEquals(studentSectionFrame.answer2Text.getText(),teacherSectionFrame.getAnswer2(studentSectionFrame.buttonCount));
        assertEquals(studentSectionFrame.answer3Text.getText(),teacherSectionFrame.getAnswer3(studentSectionFrame.buttonCount));
        assertEquals(studentSectionFrame.answer4Text.getText(),teacherSectionFrame.getAnswer4(studentSectionFrame.buttonCount));
    }

    //@DisplayName("Testing nextButtonTest")
   // @Test
    void nextButtonTest(){      //PASSES
        teacherSectionFrame.questionText.setText("Test2");
        teacherSectionFrame.answer1Text.setText("Test2");
        teacherSectionFrame.answer2Text.setText("Test2");
        teacherSectionFrame.answer3Text.setText("Test2");
        teacherSectionFrame.answer4Text.setText("Test2");

        teacherSectionFrame.choiceTwo.setSelected(true);
        teacherSectionFrame.submitButton.doClick();

        studentSectionFrame.choiceTwo.setSelected(true);
        studentSectionFrame.nextButton.doClick();

        assertEquals(studentSectionFrame.textArea.getText(),teacherSectionFrame.getQuestion(studentSectionFrame.buttonCount));
        assertEquals(studentSectionFrame.answer1Text.getText(),teacherSectionFrame.getAnswer1(studentSectionFrame.buttonCount));
        assertEquals(studentSectionFrame.answer2Text.getText(),teacherSectionFrame.getAnswer2(studentSectionFrame.buttonCount));
        assertEquals(studentSectionFrame.answer3Text.getText(),teacherSectionFrame.getAnswer3(studentSectionFrame.buttonCount));
        assertEquals(studentSectionFrame.answer4Text.getText(),teacherSectionFrame.getAnswer4(studentSectionFrame.buttonCount));

        studentSectionFrame.dialog.setVisible(false);
    }

   // @DisplayName("Testing correct Answer")
 //   @Test
    void correctAnswerTest(){       /*FAILS*/
        teacherSectionFrame.questionText.setText("Test3");
        teacherSectionFrame.answer1Text.setText("Test3");
        teacherSectionFrame.answer2Text.setText("Test3");
        teacherSectionFrame.answer3Text.setText("Test3");
        teacherSectionFrame.answer4Text.setText("Test3");

        teacherSectionFrame.choiceOne.setSelected(true);
        teacherSectionFrame.submitButton.doClick();

        if(studentSectionFrame.choiceOne.isSelected()){
            studentSectionFrame.correctAnswerCount = 1;
        }

        if (studentSectionFrame.correctAnswerCount == 1) {
            studentSectionFrame.correctAnswer.add(studentSectionFrame.answer1Text.getText());
        }

        assertEquals(studentSectionFrame.answer1Text.getText(), studentSectionFrame.correctAnswer.get(0));
    }

   //  @DisplayName("Testing endExamTest")
   // @Test
    void endExamTest() {        //PASSES
        assertEquals(teacherSectionFrame.getQuestion(studentSectionFrame.buttonCount).equals("endExam"),studentSectionFrame.isClosed());
    }

    // @DisplayName("Testing correctAnswerSelectedTest")
   //  @Test
    void correctAnswerSelectedTest() {      //PASSES
        assertEquals(studentSectionFrame.isCorrectAnswerSelected(), studentSectionFrame.dialogAnswer.isVisible());
    }


    @DisplayName("Testing scoreTest")
    @Test
    void scoreTest() {      /*FAILS*/
        assertEquals(studentSectionFrame.correctAnswer.get(studentSectionFrame.buttonCount - 1).equals(teacherSectionFrame.correctAnswer.get(studentSectionFrame.buttonCount - 1)),
                (studentSectionFrame.score + 1));
    }

    //@DisplayName("Testing buttonSetTextTest")
   // @Test      //PASSES
    void buttonSetTextTest() {
        assertEquals(studentSectionFrame.buttonCount == teacherSectionFrame.questionCount - 1,studentSectionFrame.nextButton.getText().equals("End Exam"));
    }

   // @DisplayName("Testing scorePromptTest")
   // @Test
    void scorePromptTest() {    /*FAILS*/
        studentSectionFrame.nextButton.setText("End Exam");
        assertEquals(studentSectionFrame.nextButton.getText().equals("End Exam"), studentSectionFrame.dialog.isVisible());
    }

    //  @DisplayName("Testing studentAnswerCheckTest")
    //  @Test
    void studentAnswerCheckTest() {

    }

    //  @DisplayName("Testing isCorrectAnswerSelectedTest")
    //  @Test
    void isCorrectAnswerSelectedTest() {

    }

}
