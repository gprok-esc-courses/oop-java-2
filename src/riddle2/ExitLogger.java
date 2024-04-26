package riddle2;

import riddle.ErrorLogger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ExitLogger extends ErrorLogger implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        error(new Date() + ", Exit Button, program terminated");
    }
}
