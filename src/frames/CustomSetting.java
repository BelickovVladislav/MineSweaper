package frames;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import enums.Level;

public class CustomSetting extends JFrame {
	private int columnCount = 9, rowCount = 9, mineCount = 9;
	JLabel labelMine, labelRow, labelColumn;
	JSpinner column, row, mine;
	JButton okButton, cancelButton;
	GridLayout layout;

	public CustomSetting() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		layout = new GridLayout(4, 2);
		this.setLayout(layout);
		this.setSize(300, 400);
		labelMine = new JLabel("Количество мин: ");
		labelRow = new JLabel("Количество строк: ");
		labelColumn = new JLabel("Количество столбцов: ");
		okButton = new JButton("Ок");
		cancelButton = new JButton("Отмена");
		final JFrame frame = this;
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

		column = new JSpinner(new SpinnerNumberModel(9, 1, 40, 1));
		row = new JSpinner(new SpinnerNumberModel(9, 1, 40, 1));
		mine = new JSpinner(new SpinnerNumberModel(9, 1, 40, 1));


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
