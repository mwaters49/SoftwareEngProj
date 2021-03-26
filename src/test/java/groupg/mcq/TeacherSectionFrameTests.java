package groupg.mcq;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class TeacherSectionFrameTests {

    TeacherSectionFrame teacherSectionFrame;

    //@Disabled
    @BeforeEach
    void initialise() { //broken
        TeacherSectionFrame.questionArray.clear();
        TeacherSectionFrame.correctAnswer.clear();
        TeacherSectionFrame.answerArray1.clear();
        TeacherSectionFrame.answerArray2.clear();
        TeacherSectionFrame.answerArray3.clear();
        TeacherSectionFrame.answerArray4.clear();
        TeacherSectionFrame.questionCount = 0;
        TeacherSectionFrame.correctAnswerCount = 0;
    }


   // @Disabled
    @Test
    @DisplayName("Testing questions are set")
    void questionSetTest(){
          teacherSectionFrame = new TeacherSectionFrame();
          JTextField questionSet = teacherSectionFrame.questionText;
          questionSet.setText("Testing");
          String result = questionSet.getText();
        assertFalse(result.isEmpty());
        assertEquals("Testing",result);
    }

    //@Disabled
    @Test
    @DisplayName("Testing questions are added to array")
    void questionArrayTest(){
        teacherSectionFrame = new TeacherSectionFrame();
        JTextField questionSet = teacherSectionFrame.questionText;
        questionSet.setText("Testing");
        teacherSectionFrame.answer1Text.setText("question1");
        teacherSectionFrame.answer2Text.setText("question2");
        teacherSectionFrame.answer3Text.setText("question3");
        teacherSectionFrame.answer4Text.setText("question4");
        teacherSectionFrame.choiceOne.setSelected(true);

        teacherSectionFrame.submitButton.doClick();
        int arraySize = teacherSectionFrame.questionArray.size();
        String arrayindexMessage = teacherSectionFrame.questionArray.get(0);
        assertEquals(1,arraySize);
        assertEquals("Testing",arrayindexMessage);
    }

    //@Disabled
    @Test
    @DisplayName("Testing answers are set")
    void answerSetTest(){

        teacherSectionFrame = new TeacherSectionFrame();
        JTextField questionSet = teacherSectionFrame.questionText;
        questionSet.setText("Testing");
        teacherSectionFrame.answer1Text.setText("question1");
        teacherSectionFrame.answer2Text.setText("question2");
        teacherSectionFrame.answer3Text.setText("question3");
        teacherSectionFrame.answer4Text.setText("question4");
        teacherSectionFrame.choiceOne.setSelected(true);
        teacherSectionFrame.submitButton.doClick();

        int questionOneArraySize = teacherSectionFrame.answerArray1.size();
        int questionTwoArraySize = teacherSectionFrame.answerArray2.size();
        int questionThreeArraySize = teacherSectionFrame.answerArray3.size();
        int questionFourArraySize = teacherSectionFrame.answerArray4.size();

        String  questionOneArrayMessage = teacherSectionFrame.answerArray1.get(0);
        String questionTwoArrayMessage = teacherSectionFrame.answerArray2.get(0);
        String questionThreeArrayMessage= teacherSectionFrame.answerArray3.get(0);
        String  questionFourArrayMessage= teacherSectionFrame.answerArray4.get(0);

        assertEquals(1,questionOneArraySize);
        assertEquals(1,questionTwoArraySize);
        assertEquals(1,questionThreeArraySize);
        assertEquals(1,questionFourArraySize);

        assertEquals("question1",questionOneArrayMessage);
        assertEquals("question2",questionTwoArrayMessage);
        assertEquals("question3",questionThreeArrayMessage);
        assertEquals("question4",questionFourArrayMessage);

    }

    //@Disabled
    @Test
    @DisplayName("Testing no question set failure") //broken
    void submitButtonFailOneTest(){

        teacherSectionFrame = new TeacherSectionFrame();
        teacherSectionFrame.submitButton.doClick();
        assertTrue(teacherSectionFrame.pane.isVisible());
        teacherSectionFrame.dialog.setVisible(false);
    }

    //@Disabled
    @Test
    @DisplayName("Testing no answers set failure") //broken
    void submitButtonFailTwoTest(){
        teacherSectionFrame = new TeacherSectionFrame();
        JTextField questionSet = teacherSectionFrame.questionText;
        questionSet.setText("Testing");
        teacherSectionFrame.submitButton.doClick();
        assertTrue(teacherSectionFrame.pane.isVisible());
        teacherSectionFrame.dialog.setVisible(false);
    }

    //@Disabled
    @Test
    @DisplayName("Testing no correct answer selected failure") //broken
    void submitButtonFailThreeTest(){
        teacherSectionFrame = new TeacherSectionFrame();
        JTextField questionSet = teacherSectionFrame.questionText;
        questionSet.setText("Testing");
        teacherSectionFrame.answer1Text.setText("question1");
        teacherSectionFrame.answer2Text.setText("question2");
        teacherSectionFrame.answer3Text.setText("question3");
        teacherSectionFrame.answer4Text.setText("question4");
        teacherSectionFrame.submitButton.doClick();
        assertTrue(teacherSectionFrame.pane.isVisible());
        teacherSectionFrame.dialog.setVisible(false);
    }

    //@Disabled
    @Test
    @DisplayName("Testing clear all button") //broken
    void clearAllButtonPassTest(){

        teacherSectionFrame = new TeacherSectionFrame();
        JTextField questionSet = teacherSectionFrame.questionText;
        questionSet.setText("Testing");
        teacherSectionFrame.answer1Text.setText("question1");
        teacherSectionFrame.answer2Text.setText("question2");
        teacherSectionFrame.answer3Text.setText("question3");
        teacherSectionFrame.answer4Text.setText("question4");
        teacherSectionFrame.choiceOne.setSelected(true);
        teacherSectionFrame.submitButton.doClick();


        teacherSectionFrame.clearAllButton.doClick();
        assertTrue(teacherSectionFrame.noClearPane.isVisible());
        teacherSectionFrame.dialog.setVisible(false);

        int arraySize = teacherSectionFrame.questionArray.size();
        assertEquals(0,arraySize);
    }

    //@Disabled
    @Test
    @DisplayName("Testing clear last button") //broken
    void clearLastButtonPassTest(){

        teacherSectionFrame = new TeacherSectionFrame();
        JTextField questionSet = teacherSectionFrame.questionText;
        questionSet.setText("Testing");
        teacherSectionFrame.answer1Text.setText("question1");
        teacherSectionFrame.answer2Text.setText("question2");
        teacherSectionFrame.answer3Text.setText("question3");
        teacherSectionFrame.answer4Text.setText("question4");
        teacherSectionFrame.choiceOne.setSelected(true);
        teacherSectionFrame.submitButton.doClick();


        int arraySizeBefore = teacherSectionFrame.questionArray.size();
        teacherSectionFrame.clearLastButton.doClick();
        int arraySizeAfter = teacherSectionFrame.questionArray.size();
        assertEquals(arraySizeBefore - 1, arraySizeAfter);
    }

    //@Disabled
    @Test
    @DisplayName("Testing no questions to clear") //broken
    void noQuestionToClearTest(){
        teacherSectionFrame = new TeacherSectionFrame();
        teacherSectionFrame.clearLastButton.doClick();
        assertTrue(teacherSectionFrame.dialog.isVisible());

        teacherSectionFrame.clearAllButton.doClick();
        assertTrue(teacherSectionFrame.dialog.isVisible());
    }

    //@Disabled
    @DisplayName("Testing endButton in teacher Test")
    @Test
    void endButtonTest() {      //PASSES broken
        teacherSectionFrame = new TeacherSectionFrame();
        teacherSectionFrame.cancelButton.doClick();
        assertFalse(teacherSectionFrame.isVisible());
    }

    //@Disabled
    @DisplayName("Testing correct Answer")
    @Test
    void correctAnswerTest(){       /*Passes*/ //broken
        teacherSectionFrame = new TeacherSectionFrame();

        teacherSectionFrame.questionText.setText("Test1");
        teacherSectionFrame.answer1Text.setText("Test1");
        teacherSectionFrame.answer2Text.setText("Test1");
        teacherSectionFrame.answer3Text.setText("Test1");
        teacherSectionFrame.answer4Text.setText("Test1");
        teacherSectionFrame.choiceOne.setSelected(true);
        String answer1Check = teacherSectionFrame.answer1Text.getText();
        teacherSectionFrame.submitButton.doClick();
        assertEquals(answer1Check, teacherSectionFrame.correctAnswer.get(0));

        teacherSectionFrame.questionText.setText("Test2");
        teacherSectionFrame.answer1Text.setText("Test2");
        teacherSectionFrame.answer2Text.setText("Test2");
        teacherSectionFrame.answer3Text.setText("Test2");
        teacherSectionFrame.answer4Text.setText("Test2");
        teacherSectionFrame.choiceTwo.setSelected(true);
        String answer2Check = teacherSectionFrame.answer2Text.getText();
        teacherSectionFrame.submitButton.doClick();
        assertEquals(answer2Check, teacherSectionFrame.correctAnswer.get(1));

        teacherSectionFrame.questionText.setText("Test3");
        teacherSectionFrame.answer1Text.setText("Test3");
        teacherSectionFrame.answer2Text.setText("Test3");
        teacherSectionFrame.answer3Text.setText("Test3");
        teacherSectionFrame.answer4Text.setText("Test3");
        teacherSectionFrame.choiceThree.setSelected(true);
        String answer3Check = teacherSectionFrame.answer3Text.getText();
        teacherSectionFrame.submitButton.doClick();
        assertEquals(answer3Check, teacherSectionFrame.correctAnswer.get(2));

        teacherSectionFrame.questionText.setText("Test4");
        teacherSectionFrame.answer1Text.setText("Test4");
        teacherSectionFrame.answer2Text.setText("Test4");
        teacherSectionFrame.answer3Text.setText("Test4");
        teacherSectionFrame.answer4Text.setText("Test4");
        teacherSectionFrame.choiceFour.setSelected(true);
        String answer4Check = teacherSectionFrame.answer4Text.getText();
        teacherSectionFrame.submitButton.doClick();
        assertEquals(answer4Check, teacherSectionFrame.correctAnswer.get(3));
    }

    //@Disabled
    @DisplayName("Test teacherAnswerCheck with error in selection") //broken
    @Test
    void teacherAnswerCheckWithNoSelectionTest(){
        teacherSectionFrame = new TeacherSectionFrame();
        teacherSectionFrame.teacherAnswerCheck();
        assertTrue(teacherSectionFrame.dialog.isVisible());
    }

    //@Disabled
    @Test
    @DisplayName("Testing no questions to clear")
    void isAnswersFilledTest(){
        teacherSectionFrame = new TeacherSectionFrame();
        teacherSectionFrame.answer1Text.setText("Test1");
        teacherSectionFrame.answer2Text.setText("Test1");
        teacherSectionFrame.answer3Text.setText("Test1");
        assertFalse(teacherSectionFrame.isAnswersFilled());

        teacherSectionFrame = new TeacherSectionFrame();
        teacherSectionFrame.answer2Text.setText("Test1");
        teacherSectionFrame.answer3Text.setText("Test1");
        teacherSectionFrame.answer4Text.setText("Test1");
        assertFalse(teacherSectionFrame.isAnswersFilled());

        teacherSectionFrame = new TeacherSectionFrame();
        teacherSectionFrame.answer1Text.setText("Test1");
        teacherSectionFrame.answer3Text.setText("Test1");
        teacherSectionFrame.answer4Text.setText("Test1");
        assertFalse(teacherSectionFrame.isAnswersFilled());

        teacherSectionFrame = new TeacherSectionFrame();
        teacherSectionFrame.answer1Text.setText("Test1");
        teacherSectionFrame.answer2Text.setText("Test1");
        teacherSectionFrame.answer4Text.setText("Test1");
        assertFalse(teacherSectionFrame.isAnswersFilled());
    }
}
