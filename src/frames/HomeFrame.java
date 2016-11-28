package frames;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import enums.Level;

public class HomeFrame extends JFrame {
	/**
	 * Frame for switch level and create game frames;
	 */
	private static GameFrame gameFrame;
	private static HomeFrame homeFrame;
	private static CustomSetting customFrame;
	
	
	
	
	public static GameFrame getGameFrame(){
		return gameFrame;
	}
	public static HomeFrame getHomeFrame(){
		return homeFrame;
	}
	public static void setGameFrame(GameFrame frame){
		gameFrame = frame;
	}
	public static CustomSetting getCustomFrame() {
		return customFrame;
	}
	public HomeFrame() {
		
		super("MineSweaper");
		
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new GridLayout(4, 1));
		JButton easyButton = new JButton("Easy");
		JButton mediumButton = new JButton("Medium");
		JButton hardButton = new JButton("Hard");
		JButton customButton = new JButton("Custom");
		homeFrame = this;

		easyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				homeFrame.setVisible(false);
				gameFrame = new GameFrame(Level.Easy);

			}
		});
		mediumButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				homeFrame.setVisible(false);
				gameFrame = new GameFrame(Level.Medium);

			}
		});
		hardButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				homeFrame.setVisible(false);
				gameFrame = new GameFrame(Level.Hard);

			}
		});
		customButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				homeFrame.setVisible(false);
				customFrame = new CustomSetting();
				//gameFrame = new GameFrame(Level.Custom);

			}
		});
		add(easyButton);
		add(mediumButton);
		add(hardButton);
		add(customButton);
		setSize(200, 300);
	}


}
