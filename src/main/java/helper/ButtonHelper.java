package helper;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHelper {

    public static JButton createButtonToRedirect(String nameButton, JFrame actualJFrame, JFrame newFrame){
        return new JButton( new AbstractAction(nameButton) {
            @Override
            public void actionPerformed( ActionEvent e ) {
                actualJFrame.setVisible(false);
                newFrame.setVisible(true);
            }
        });
    }

    public static ActionListener buttonToTurnBack(JFrame actualJFrame, JFrame pastFrame) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualJFrame.setVisible(false);
                pastFrame.setVisible(true);
            }
        };
    }
}
