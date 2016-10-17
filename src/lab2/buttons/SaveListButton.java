package lab2.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import lab2.globaldata.BackgoundData;
import lab2.shapes.MyShape;

public class SaveListButton extends JButton {

	private static final long serialVersionUID = 8909873722727362788L;

	public SaveListButton() {
		super("Zapisz listê");

		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (BackgoundData.haveShapes()) {
					buttonClicked();
				}
			}
		});
	}

	protected void buttonClicked() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Zapisz listê");
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Data file", "dat");
		fileChooser.addChoosableFileFilter(fileFilter);
		int result = fileChooser.showSaveDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			FileOutputStream fos;
			try {
				fos = new FileOutputStream(selectedFile.getPath().replace(".dat", "") + ".dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(BackgoundData.SHAPES_LIST);
				oos.flush();
				oos.close();
				fos.close();
			} catch (IOException e) {
				System.out.println("Cant save list");
				System.out.println(e);
			}

		}
	}
}
