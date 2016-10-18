package lab2.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JSpinner;

import lab2.globaldata.CoursorData;

public class AcceptColorButton extends JButton {

	private static final long serialVersionUID = 7690089614652881027L;

	public AcceptColorButton(JSpinner redSpinner, JSpinner greenSpinner, JSpinner blueSpinner) {
		super("Akceptuj kolor");

		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CoursorData.RED_COURSOR = (int) redSpinner.getValue();
				CoursorData.GREEN_COURSOR = (int) greenSpinner.getValue();
				CoursorData.BLUE_COURSOR = (int) blueSpinner.getValue();
			}
		});
	}

}
