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
        TeacherSectionFrame.questionArray.clear();
        TeacherSectionFrame.correctAnswer.clear();
        TeacherSectionFrame.answerArray1.clear();
        TeacherSectionFrame.answerArray2.clear();
        TeacherSectionFrame.answerArray3.clear();
        TeacherSectionFrame.answerArray4.clear();
        TeacherSectionFrame.questionCount = 0;
        TeacherSectionFrame.correctAnswerCount = 0;
        teacherSectionFrame = new TeacherSectionFrame();

        teacherSectionFrame.questionText.setText("Test");
        teacherSectionFrame.answer1Text.setText("Test");
        teacherSectionFrame.answer2Text.setText("Test");
        teacherSectionFrame.answer3Text.setText("Test");
        teacherSectionFrame.answer4Text.setText("Test");

        teacherSectionFrame.choiceOne.setSelected(true);

        teacherSectionFrame.submitButton.doClick();
    }

    @DisplayName("Testing endButton in Student Test")
    @Test
    void endButtonTest() {      //PASSES
        studentSectionFrame = new StudentSectionFrame();

        studentSectionFrame.endButton.doClick();
        assertFalse(studentSectionFrame.isVisible());
    }

    @DisplayName("Testing initialFrameTest")
    @Test
    void initialFrameTest(){        //PASSES
        studentSectionFrame = new StudentSectionFrame();

        studentSectionFrame.choiceOne.setSelected(true);

        assertEquals(studentSectionFrame.textArea.getText(),teacherSectionFrame.getQuestion(studentSectionFrame.buttonCount));
        assertEquals(studentSectionFrame.answer1Text.getText(),teacherSectionFrame.getAnswer1(studentSectionFrame.buttonCount));
        assertEquals(studentSectionFrame.answer2Text.getText(),teacherSectionFrame.getAnswer2(studentSectionFrame.buttonCount));
        assertEquals(studentSectionFrame.answer3Text.getText(),teacherSectionFrame.getAnswer3(studentSectionFrame.buttonCount));
        assertEquals(studentSectionFrame.answer4Text.getText(),teacherSectionFrame.getAnswer4(studentSectionFrame.buttonCount));
    }

    @DisplayName("Testing nextButtonTest")
    @Test
    void nextButtonTest(){      //PASSES
        studentSectionFrame = new StudentSectionFrame();

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

    }

    @DisplayName("Testing correct Answer")
    @Test
    void correctAnswerTest(){       /*Passes*/
        studentSectionFrame = new StudentSectionFrame();

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

     @DisplayName("Testing endExamTest")
    @Test
    void endExamTest() {        //PASSES

         teacherSectionFrame.questionText.setText("Test2");
         teacherSectionFrame.answer1Text.setText("Test2");
         teacherSectionFrame.answer2Text.setText("Test2");
         teacherSectionFrame.answer3Text.setText("Test2");
         teacherSectionFrame.answer4Text.setText("Test2");
         teacherSectionFrame.choiceOne.setSelected(true);
         teacherSectionFrame.submitButton.doClick();

         studentSectionFrame = new StudentSectionFrame();

         studentSectionFrame.choiceOne.setSelected(true);
        studentSectionFrame.nextButton.doClick();

         studentSectionFrame.choiceOne.setSelected(true);
        studentSectionFrame.nextButton.doClick();

        assertFalse(studentSectionFrame.isVisible());
    }

     @DisplayName("Testing correctAnswerSelectedTrueTest")
    @Test
    void correctAnswerSelectedTrueTest() {//PASSES
         studentSectionFrame = new StudentSectionFrame();

        studentSectionFrame.nextButton.doClick();
        assertTrue(studentSectionFrame.dialogAnswer.isVisible());
    }

    @DisplayName("Testing correctAnswerSelectedFalseTest")
    @Test
    void correctAnswerSelectedFalseTest() {//PASSES
        studentSectionFrame = new StudentSectionFrame();

        studentSectionFrame.choiceOne.setSelected(true);
        studentSectionFrame.nextButton.doClick();
        assertFalse(studentSectionFrame.dialogAnswer.isVisible());
    }
    
    @DisplayName("Testing buttonSetTextTest")
    @Test      //PASSES
    void buttonSetTextTest() {
        studentSectionFrame = new StudentSectionFrame();

        assertTrue(studentSectionFrame.nextButton.getText().equals("End Exam"));
    }
}
