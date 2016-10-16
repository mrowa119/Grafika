package lab2.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import lab2.globaldata.BackgoundData;

public class LoadImageButton extends JButton {

	private static final long serialVersionUID = -8972893899289546248L;

	public LoadImageButton() {
		super("Wczytaj obraz");

		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				buttonClicked();
			}
		});
	}

	public void buttonClicked() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		FileFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
		fileChooser.setFileFilter(imageFilter);
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			BackgoundData.loadAndUpdateBackgroundImageFromFile(selectedFile);
		}
	}
	//
	// public File getSelectedFile() {
	// return selectedFile;
	// }

}
