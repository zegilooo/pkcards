package ihm;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window {
	private JFrame window;
	private int width = 0;
	private int height = 0;
	private static Window instance = null;
	
	public Window(){
		this.window = new JFrame("Welcome to your Pokedeck");
		this.window.setResizable(true);
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setSize(this.width, this.height);
		this.centerWindow();
		this.window.setVisible(true);
	}
	public static Window getInstance(){
		if(instance == null)
			instance = new Window();
		return instance;
	}
	private void centerWindow(){
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - this.window.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.window.getHeight()) / 2);
		this.window.setLocation(x, y);
	}
	
	public void changeSize(int w, int h){
		this.width = w;
		this.height = h;
		this.window.setSize(this.width, this.height);
		this.centerWindow();
	}
	
	public void addPanel(JPanel panel){
		this.window.getContentPane().removeAll();
		this.window.add(panel);
	}
	
	public void validate(){
		this.window.validate();
	}
	
}
