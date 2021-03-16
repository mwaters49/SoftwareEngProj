package groupg.mcq;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class TeacherSectionFrameTests {

    Display display;
    TeacherSectionFrame teacherSectionFrame;

    @BeforeEach
    void initialise(){
        display = new Display();
    }

      @Test
    void questionSetTest(){
          teacherSectionFrame = new TeacherSectionFrame();
          JTextField questionSet = teacherSectionFrame.questionText;
          questionSet.setText("Testing");
          String result = questionSet.getText();
        assertFalse(result.isEmpty());
        assertEquals("Testing",result);

    }
    @Test
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

    @Test
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
}
