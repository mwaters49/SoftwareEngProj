package groupg.mcq;

import javax.swing.*;

public class studentSectionFrame extends JInternalFrame {

    static final int x = 30, y = 30;

    public studentSectionFrame() {
        super("Student Section", true, true, true, true);
        setSize(350, 350);
        getContentPane().add(new JScrollPane(new JTextArea("Student Section",20,20)));
        setLocation(x , y);
    }
}
