package lab2.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import lab2.globaldata.BackgoundData;

public class RemoveShapeButton extends JButton {

	private static final long serialVersionUID = -7252807486473181227L;

	public RemoveShapeButton() {
		super("Usuñ kszta³t");
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				buttonClicked();
			}
		});
	}

	protected void buttonClicked() {
		BackgoundData.removeShape();
	}
}
