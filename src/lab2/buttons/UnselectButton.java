package lab2.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import lab2.globaldata.BackgoundData;

public class UnselectButton extends JButton {

	private static final long serialVersionUID = 8456232913790144837L;

	public UnselectButton() {
		super("Odznacz");
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonClicked();
			}
		});
	}

	protected void buttonClicked() {
		BackgoundData.unselect();
	}
}
