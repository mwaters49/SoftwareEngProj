package groupg.mcq;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DisplayTests {

    Display display;

    @BeforeEach
    void initialise(){
        display = new Display();
    }

    @DisplayName("Test clicking teacher button shows a new teacher frame")
    @Test
    void teacherButtonTest(){
        display.teacherButton.doClick();
        assertTrue(display.newTeacherFrame.isVisible());
    }

    @DisplayName("Test clicking student button shows a new student frame" +
                "with questions set in teacher frame")
    @Test
    void studentButtonTest(){

        display.teacherButton.doClick();
        display.newTeacherFrame.questionText.setText("Test1");
        display.newTeacherFrame.answer1Text.setText("Test1");
        display.newTeacherFrame.answer2Text.setText("Test1");
        display.newTeacherFrame.answer3Text.setText("Test1");
        display.newTeacherFrame.answer4Text.setText("Test1");
        display.newTeacherFrame.choiceOne.setSelected(true);
        display.newTeacherFrame.submitButton.doClick();

        display.studentButton.doClick();
        assertTrue(display.newStudentFrame.isVisible());
    }

    /*@DisplayName("Test clicking student button shows a new student frame" +
                "without questions set in teacher frame")
    @Test
    void noQuestionsSetTest(){
        display = new Display();
        display.studentButton.doClick();
        assertTrue(display.dialog.isVisible());
    }*/

    @DisplayName("Test exit button closes the desktop pane")
    @Test
    void exitButtonTest(){
        display.exitButton.doClick();
        assertFalse(display.isVisible());
    }

}
