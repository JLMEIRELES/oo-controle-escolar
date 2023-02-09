package helper;


import javax.swing.*;
import java.awt.event.ActionEvent;

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

}
