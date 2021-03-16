package groupg.mcq;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentSectionFrameTests {

    StudentSectionFrame studentSectionFrame;
    TeacherSectionFrame teacherSectionFrame;

    @BeforeEach
    void initialise()  {

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
  //  @Test
    void endButtonTest() {      //PASSES
        studentSectionFrame.endButton.doClick();
        assertFalse(studentSectionFrame.isVisible());
    }

   // @DisplayName("Testing initialFrameTest")
  //  @Test
    void initialFrameTest(){        //PASSES
        studentSectionFrame.choiceOne.setSelected(true);

        assertEquals(studentSectionFrame.textArea.getText(),teacherSectionFrame.getQuestion(studentSectionFrame.buttonCount));
        assertEquals(studentSectionFrame.answer1Text.getText(),teacherSectionFrame.getAnswer1(studentSectionFrame.buttonCount));
        assertEquals(studentSectionFrame.answer2Text.getText(),teacherSectionFrame.getAnswer2(studentSectionFrame.buttonCount));
        assertEquals(studentSectionFrame.answer3Text.getText(),teacherSectionFrame.getAnswer3(studentSectionFrame.buttonCount));
        assertEquals(studentSectionFrame.answer4Text.getText(),teacherSectionFrame.getAnswer4(studentSectionFrame.buttonCount));
    }

   // @DisplayName("Testing nextButtonTest")
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

        //studentSectionFrame.dialog.setVisible(false);
    }

    @DisplayName("Testing correct Answer")
    @Test
    void correctAnswerTest(){       /*Passes*/
        teacherSectionFrame.questionText.setText("Test2");
        teacherSectionFrame.answer1Text.setText("Test2");
        teacherSectionFrame.answer2Text.setText("Test2");
        teacherSectionFrame.answer3Text.setText("Test2");
        teacherSectionFrame.answer4Text.setText("Test2");
        teacherSectionFrame.choiceOne.setSelected(true);
        teacherSectionFrame.submitButton.doClick();

        teacherSectionFrame.questionText.setText("Test3");
        teacherSectionFrame.answer1Text.setText("Test3");
        teacherSectionFrame.answer2Text.setText("Test3");
        teacherSectionFrame.answer3Text.setText("Test3");
        teacherSectionFrame.answer4Text.setText("Test3");
        teacherSectionFrame.choiceOne.setSelected(true);
        teacherSectionFrame.submitButton.doClick();

        teacherSectionFrame.questionText.setText("Test4");
        teacherSectionFrame.answer1Text.setText("Test4");
        teacherSectionFrame.answer2Text.setText("Test4");
        teacherSectionFrame.answer3Text.setText("Test4");
        teacherSectionFrame.answer4Text.setText("Test4");
        teacherSectionFrame.choiceOne.setSelected(true);
        teacherSectionFrame.submitButton.doClick();

        studentSectionFrame.choiceOne.setSelected(true);
        studentSectionFrame.nextButton.doClick();
        assertEquals(studentSectionFrame.answer1Text.getText(), studentSectionFrame.correctAnswer.get(0));

        studentSectionFrame.choiceTwo.setSelected(true);
        studentSectionFrame.nextButton.doClick();
        assertEquals(studentSectionFrame.answer2Text.getText(), studentSectionFrame.correctAnswer.get(1));

        studentSectionFrame.choiceThree.setSelected(true);
        studentSectionFrame.nextButton.doClick();
        assertEquals(studentSectionFrame.answer3Text.getText(), studentSectionFrame.correctAnswer.get(2));

        studentSectionFrame.choiceFour.setSelected(true);
        studentSectionFrame.nextButton.doClick();
        assertEquals(studentSectionFrame.answer4Text.getText(), studentSectionFrame.correctAnswer.get(3));
    }

   //  @DisplayName("Testing endExamTest")
   // @Test
    void endExamTest() {        //PASSES
        assertEquals(teacherSectionFrame.getQuestion(studentSectionFrame.buttonCount).equals("endExam"),studentSectionFrame.isClosed());
    }

  //   @DisplayName("Testing correctAnswerSelectedTrueTest")
 //    @Test
    void correctAnswerSelectedTrueTest() {//PASSES
        studentSectionFrame.nextButton.doClick();
        assertTrue(studentSectionFrame.dialogAnswer.isVisible());
    }

  //  @DisplayName("Testing correctAnswerSelectedFalseTest")
   // @Test
    void correctAnswerSelectedFalseTest() {//PASSES
        studentSectionFrame.choiceOne.setSelected(true);
        studentSectionFrame.nextButton.doClick();
        assertFalse(studentSectionFrame.dialogAnswer.isVisible());
    }


    //@DisplayName("Testing scoreTest")
  //  @Test
    void scoreTest() {/*FAILS*/
        studentSectionFrame.nextButton.doClick();
        assertEquals(studentSectionFrame.correctAnswer.get(studentSectionFrame.buttonCount - 1).equals(teacherSectionFrame.correctAnswer.get(studentSectionFrame.buttonCount - 1)),
                (studentSectionFrame.score + 1));
    }

   // @DisplayName("Testing buttonSetTextTest")
   // @Test      //PASSES
    void buttonSetTextTest() {
        studentSectionFrame.nextButton.doClick();
        assertEquals(studentSectionFrame.buttonCount == teacherSectionFrame.questionCount - 1,studentSectionFrame.nextButton.getText().equals("End Exam"));
    }

    @DisplayName("Testing scorePromptTest")
    @Test
    void scorePromptTest() {    /*FAILS*/
        studentSectionFrame.nextButton.doClick();
        studentSectionFrame.nextButton.setText("End Exam");
        assertEquals(studentSectionFrame.nextButton.getText().equals("End Exam"), studentSectionFrame.dialog.isVisible());
    }

    //  @DisplayName("Testing isCorrectAnswerSelectedTest")
    //  @Test
    void isCorrectAnswerSelectedTest() {

    }

}
