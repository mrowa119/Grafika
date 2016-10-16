package lab2.buttons;

import javax.swing.JButton;
import javax.swing.JSpinner;

public class AcceptColourButton extends JButton {

	private static final long serialVersionUID = 7690089614652881027L;

	private JSpinner redSpinner;
	private JSpinner greenSpinner;
	private JSpinner blueSpinner;

	public AcceptColourButton(JSpinner redSpinner, JSpinner greenSpinner, JSpinner blueSpinner) {
		super("Akceptuj kolor");
		this.redSpinner = redSpinner;
		this.greenSpinner = greenSpinner;
		this.blueSpinner = blueSpinner;
	}

}
