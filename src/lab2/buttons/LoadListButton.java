package lab2.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import lab2.globaldata.BackgoundData;
import lab2.shapes.MyShape;

public class LoadListButton extends JButton {

	private static final long serialVersionUID = 6771096436632260266L;

	public LoadListButton() {
		super("Wczytaj listê");
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonClicked();
			}
		});
	}

	protected void buttonClicked() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Otwórz listê");
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Data file", "dat");
		fileChooser.addChoosableFileFilter(fileFilter);
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			BackgoundData.clearList();
			File selectedFile = fileChooser.getSelectedFile();
			FileInputStream  fis ;
			try {
				fis = new FileInputStream(selectedFile.getPath());
		        ObjectInputStream ois = new ObjectInputStream(fis);
		        BackgoundData.addLoadedShapes((DefaultListModel<MyShape>) ois.readObject());
		        ois.close();
		        fis.close();
		        repaint();
			} catch (IOException | ClassNotFoundException e) {
				System.out.println("Cant load list");
				System.out.println(e);
			}

		}
	}
}
