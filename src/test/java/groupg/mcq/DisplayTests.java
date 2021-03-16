package groupg.mcq;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DisplayTests {

    Display display;
    TeacherSectionFrame teacherSectionFrame;


    @BeforeEach
    void initialise(){
        display = new Display();
    }

  //  @Test
    void teacherButtonTest(){
        display.teacherButton.doClick();
        assertTrue(display.newTeacherFrame.isVisible());
    }

   // @Test
    void studentButtonTest(){
        teacherSectionFrame = new TeacherSectionFrame();
        teacherSectionFrame.questionCount += 1;
        teacherSectionFrame.questionArray.add("Test1");
        teacherSectionFrame.answerArray1.add("Test1");
        teacherSectionFrame.answerArray2.add("Test1");
        teacherSectionFrame.answerArray3.add("Test1");
        teacherSectionFrame.answerArray4.add("Test1");
        teacherSectionFrame.choiceOne.setSelected(true);
        display.studentButton.doClick();
        assertTrue(display.newStudentFrame.isVisible());
    }

    //@Test
    void exitButtonTest(){
        display.exitButton.doClick();
        //assertTrue(display.newFrame.isVisible());
    }

}
