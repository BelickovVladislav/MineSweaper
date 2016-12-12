package frames;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import enums.Level;

public class CustomSetting extends JFrame {
	private int columnCount = 9, rowCount = 9, mineCount = 9;
	JLabel labelMine, labelRow, labelColumn;
	JSpinner column, row, mine;
	JButton okButton, cancelButton;
	GridLayout layout;

	public CustomSetting() {
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		layout = new GridLayout(4, 2);
		this.setLayout(layout);
		this.setSize(300, 400);
		labelMine = new JLabel("Количество мин: ");
		labelRow = new JLabel("Количество строк: ");
		labelColumn = new JLabel("Количество столбцов: ");
		okButton = new JButton("Ок");
		cancelButton = new JButton("Отмена");
		final JFrame frame = this;
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				HomeFrame.getHomeFrame().setVisible(true);
				
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent key) {
				// TODO Auto-generated method stub
				HomeFrame.getHomeFrame().setVisible(true);
				frame.dispose();
				
			}
		});
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				columnCount = Integer.parseInt(column.getValue().toString());
				mineCount = Integer.parseInt(mine.getValue().toString());
				rowCount = Integer.parseInt(row.getValue().toString());
				HomeFrame.setGameFrame(new GameFrame(Level.Custom));				
				frame.dispose();
			}
		});

		column = new JSpinner(new SpinnerNumberModel(9, 9, 40, 1));
		row = new JSpinner(new SpinnerNumberModel(9, 9, 40, 1));
		mine = new JSpinner(new SpinnerNumberModel(9, 9, 40, 1));
		ChangeListener listener = new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent event) {
				// TODO Auto-generated method stub
				int rowNow = Integer.parseInt(row.getValue().toString());
				int columnNow = Integer.parseInt(column.getValue().toString());
				int mineNow = Integer.parseInt(mine.getValue().toString());
				mine.setModel(new SpinnerNumberModel(rowNow*columnNow/2>mineNow? mineNow:9,9,rowNow*columnNow/2,1));
				disableEditable(mine);
			}
		};
		column.addChangeListener(listener);
		row.addChangeListener(listener);
		disableEditable(column);
		disableEditable(row);
		disableEditable(mine);
		
		this.add(labelRow);
		this.add(row);
		this.add(labelColumn);
		this.add(column);
		this.add(labelMine);
		this.add(mine);		
		this.add(okButton);
		this.add(cancelButton);

		this.setVisible(true);

	}
	private void disableEditable(JSpinner ed){
		JTextField tf = ((JSpinner.DefaultEditor) ed.getEditor()).getTextField();
		tf.setForeground(Color.BLACK); 
		tf.setBackground(Color.WHITE);
		tf.setEditable(false);		
	}

	public int getColumnCount() {
		return columnCount;
	}

	public int getRowCount() {
		return rowCount;
	}
	public int getMineCount() {
		return mineCount;
	}


}
