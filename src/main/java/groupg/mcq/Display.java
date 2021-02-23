package groupg.mcq;

import javax.swing.*;
import java.awt.*;


public class Display extends JFrame {

    private JDesktopPane mainDesktop;
    JToolBar toolBar = new JToolBar();
    Action teacherAction;

    public Display() {
        mainDesktop = new JDesktopPane();

        toolBar.add(teacherAction);

        Container container = getContentPane();
        container.add(mainDesktop, BorderLayout.CENTER);
        container.add(toolBar, BorderLayout.NORTH);

        Toolkit toolkit = getToolkit();
        Dimension dimension = toolkit.getScreenSize();

        // center window on screen
        setBounds(100, 100, dimension.width - 200, dimension.height - 200);
        setVisible(true);
    }
}
