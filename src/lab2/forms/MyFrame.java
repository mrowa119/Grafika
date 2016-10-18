package lab2.forms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import lab2.globaldata.BackgoundData;
import lab2.panels.ImagePanel;
import lab2.panels.MenuPanel;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = -7647936535225394088L;

	public final static int FRAME_WIDTH = 800;
	public final static int FEMAE_HEIGHT = 600;
	public final static int MINIMAL_FRAME_WIDTH = 350;
	public final static int MINIMAL_FEMAE_HEIGHT = 460;

	public MyFrame() {
		super("Zaznaczanie ");
		setSize(FRAME_WIDTH, FEMAE_HEIGHT);
		setMinimumSize(new Dimension(MINIMAL_FRAME_WIDTH, MINIMAL_FEMAE_HEIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setOnScreenCenter();
		
		setLayout(new BorderLayout());
		
		add(new MenuPanel(), BorderLayout.LINE_END);
		BackgoundData.IMAGE_PANEL = new ImagePanel();
		add(BackgoundData.IMAGE_PANEL, BorderLayout.CENTER);

		setVisible(true);
	}

	private void setOnScreenCenter() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		// Determine the new location of the window
		int w = this.getSize().width;
		int h = this.getSize().height;
		int x = (dim.width - w) / 2;
		int y = (dim.height - h) / 2;

		// Move the window
		setLocation(x, y);
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}

}
