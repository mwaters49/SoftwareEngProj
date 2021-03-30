package groupg.mcq;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DisplayTests {

    Display display;

    @BeforeEach
    void initialise(){
        display = new Display();
    }
    @AfterEach
    void afterTest(){
        if(display != null) {
            if(display.dialog != null)
                display.dialog.dispose();
            display.dispose();
            display = null;
        }
    }

    @DisplayName("Test clicking teacher button shows a new teacher frame")
    @Test
    void teacherButtonTest(){
        display.teacherButton.doClick();
        assertTrue(display.newTeacherFrame.isVisible());
        display.studentButton.doClick();
        assertTrue(display.dialog.isVisible());

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
        display.newTeacherFrame.dispose();

        display.studentButton.doClick();
        assertTrue(display.newStudentFrame.isVisible());
        display.teacherButton.doClick();
        assertTrue(display.dialog.isVisible());
        assertFalse(display.newTeacherFrame.isVisible());

        display.newStudentFrame.dispose();
        display.teacherButton.doClick();
        display.studentButton.doClick();
        assertTrue(display.dialog.isVisible());
        assertFalse(display.newStudentFrame.isVisible());
    }

    @DisplayName("Test clicking student button shows a new student frame" +
                "without questions set in teacher frame")
    @Test
    void noQuestionsSetTest(){
        TeacherSectionFrame.questionCount = 0;
        display.studentButton.doClick();
        assertTrue(display.dialog.isVisible());
    }

    @DisplayName("Test exit button closes the desktop pane")
    @Test
    void exitButtonTest(){
        display.exitButton.doClick();
        assertFalse(display.isVisible());
    }
}
