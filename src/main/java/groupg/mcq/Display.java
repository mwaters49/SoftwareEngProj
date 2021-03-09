package groupg.mcq;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

public class Display extends JFrame {

    private JDesktopPane mainDesktop;
    JToolBar toolBar = new JToolBar();

    JButton teacherButton = new JButton("Teacher Section");
    JButton studentButton = new JButton("Student Section");
    JButton exitButton = new JButton("Exit");

    public Display() {
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

                TeacherSectionFrame newFrame = new TeacherSectionFrame();

                mainDesktop.add(newFrame);
                newFrame.setVisible(true);
            }
        });

        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                StudentSectionFrame newFrame = null;
                if(TeacherSectionFrame.questionCount > 0) {
                    try {
                        newFrame = new StudentSectionFrame();
                    } catch (PropertyVetoException propertyVetoException) {
                        propertyVetoException.printStackTrace();
                    }

                    mainDesktop.add(newFrame);

                    newFrame.setVisible(true);

                }else {
                    JOptionPane.showMessageDialog(mainDesktop, "Teacher has not set a question");
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               System.exit(0);
            }
        });

    }
}

