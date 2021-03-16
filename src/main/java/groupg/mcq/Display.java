package groupg.mcq;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;

public class Display extends JFrame {

    JDesktopPane mainDesktop;
    JOptionPane noQuestionPane;
    JDialog dialog;
    JToolBar toolBar = new JToolBar();

    JButton teacherButton = new JButton("Teacher Section");
    JButton studentButton = new JButton("Student Section");
    JButton exitButton = new JButton("Exit");
    TeacherSectionFrame newTeacherFrame;
    StudentSectionFrame newStudentFrame;

    public Display(){
        mainDesktop = new JDesktopPane();

        toolBar.add(teacherButton);
        toolBar.addSeparator();
        toolBar.add(studentButton);
        toolBar.addSeparator();
        toolBar.add(exitButton);

        Container container = getContentPane();
        container.add(mainDesktop, BorderLayout.CENTER);
        container.add(toolBar, BorderLayout.NORTH);

        Toolkit toolkit = getToolkit();
        Dimension dimension = toolkit.getScreenSize();

        setBounds(100, 100, dimension.width - 700, dimension.height - 400);
        setVisible(true);

        teacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newTeacherFrame = new TeacherSectionFrame();
                mainDesktop.add(newTeacherFrame);
                newTeacherFrame.setVisible(true);
            }
        });

        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (TeacherSectionFrame.questionCount > 0) {
                    newStudentFrame = new StudentSectionFrame();
                    mainDesktop.add(newStudentFrame);
                    newStudentFrame.setVisible(true);
                } else {
                    noQuestionPane = new JOptionPane("Teacher has not set a question", JOptionPane.INFORMATION_MESSAGE);
                    dialog = noQuestionPane.createDialog(mainDesktop, "ERROR");
                    dialog.setModal(false);
                    dialog.setVisible(true);
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}

