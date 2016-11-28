package core;

import interfaces.IField;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import absctracts.ACell;
import enums.Constants;
import enums.Level;
import enums.Point;
import frames.HomeFrame;

public class Field extends JPanel implements IField {
	private Constants constant;
	private ACell[][] field;
	GridLayout layout;

	/**
	 * check open all cells;
	 * 
	 * @param field
	 * @return
	 */
	private boolean isOpenAll() {
		int count = 0;
		for (int i = 0; i < field.length; i++)
			for (int j = 0; j < field[i].length; j++)
				if (field[i][j].isVoid() || field[i][j].isNumber()) {
					if (field[i][j].isOpen())
						count++;
				} else if (field[i][j].isMine())
					if (field[i][j].isWarningMine())
						count++;
		return count == field.length * field[0].length;
	}

	/**
	 * open all mine;
	 * 
	 * @param field
	 */
	private void openMine() {
		for (int i = 0; i < field.length; i++)
			for (int j = 0; j < field[i].length; j++)
				if (field[i][j].isMine())
					field[i][j].openCell();
	}

	/**
	 * open cell and if cell void then open around this cell ignore mine
	 * 
	 * @param field
	 * @param pointI
	 * @param pointJ
	 * @throws Exception
	 */
	private void open(int pointI, int pointJ) throws Exception {
		ACell cell = field[pointI][pointJ];
		cell.openCell();
		if (cell.isVoid()) {

			for (int i = -1; i < 2; i++)
				for (int j = -1; j < 2; j++)
					try {
						if (field[pointI + i][pointJ + j].isVoid()) {
							if (!field[pointI + i][pointJ + j].isOpen()) {
								field[pointI + i][pointJ + j].openCell();
								open(pointI + i, pointJ + j);
							}
						} else if (field[pointI + i][pointJ + j].isNumber())
							field[pointI + i][pointJ + j].openCell();
					} catch (Exception ex) {
					}

		}
	}

	/**
	 * 
	 * @param level
	 */
	private void init(Level level) {
		constant = new Constants(level);
		layout = new GridLayout(getRowCount(), getColumnCount());
		this.setLayout(layout);
		generate();
		this.setPreferredSize(new Dimension(getRowCount() * getCellSize(),
				getColumnCount() * getCellSize()));
		this.setMinimumSize(new Dimension(getRowCount() * getCellSize(),
				getColumnCount() * getCellSize()));
		this.setMaximumSize((new Dimension(getRowCount() * getCellSize(),
				getColumnCount() * getCellSize())));
	}

	public Field() {
		init(Level.Easy);
	}

	public Field(Level level) {
		init(level);

	}

	private void generate() {

		field = new ACell[getRowCount()][getColumnCount()];
		Random rand = new Random();
		int mineCount = 0;
		while (mineCount < getMineCount()) {
			int x = rand.nextInt(getRowCount());
			int y = rand.nextInt(getColumnCount());
			if (field[x][y] == null) {
				field[x][y] = new Mine();
				mineCount++;
			}
		}

		for (int i = 0; i < getRowCount(); i++)
			for (int j = 0; j < getColumnCount(); j++)
				if (field[i][j] == null)
					field[i][j] = new Void();

		for (int i = 0; i < field.length; i++)
			for (int j = 0; j < field[i].length; j++) {
				if (field[i][j].isVoid()) {
					int count = 0;
					for (int i1 = -1; i1 < 2; i1++)
						for (int j1 = -1; j1 < 2; j1++) {
							try {
								if (field[i + i1][j + j1].isMine()) {
									count++;

								}
							} catch (Exception ex) {
							}

						}
					if (count > 0)
						field[i][j] = new Number(count);
				}
			}

		for (int i = 0; i < getRowCount(); i++) {
			for (int j = 0; j < getColumnCount(); j++) {
				field[i][j].createCell(
						new Point(j * constant.getCellSize() + 3, 
								i * constant.getCellSize() + 3),
						constant.getCellSize());
				//this.add(field[i][j]);
				field[i][j].addMouseListener(new MouseEventButton(field[i][j],
						i, j));
			}
		}

	}
	@Override
	public void paint(Graphics g){
		for(int i = 0; i < getRowCount(); i++)
			for(int j = 0; j < getColumnCount(); j++)
				field[i][j].paint(g);
		
	}

	// Getter
	@Override
	public int getColumnCount() {
		return constant.getColumnCount();
	}

	@Override
	public int getRowCount() {
		return constant.getRowCount();
	}

	@Override
	public int getMineCount() {
		return constant.getMineCount();
	}

	@Override
	public int getCellSize() {
		return constant.getCellSize();
	}

	private class MouseEventButton implements MouseListener {
		private ACell cell;
		private int i, j;

		public MouseEventButton(ACell cell, int i, int j) {
			this.cell = cell;
			this.i = i;
			this.j = j;

		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent event) {
			// TODO Auto-generated method stub
			if (event.getButton() == MouseEvent.BUTTON1 && !cell.isWarning()) {
				// cell.openCell();
				if (cell.isMine()) {
					openMine();
					JOptionPane.showMessageDialog(null, "You Lose!");
					HomeFrame.getGameFrame().dispose();
					return;
				}

				try {
					open(i, j);
				} catch (Exception e) {

				}
			} else if (event.getButton() == MouseEvent.BUTTON3) {
				if (!cell.isOpen())
					cell.warning();

			}
			if (isOpenAll()) {
				JOptionPane.showMessageDialog(null, "You Win!");
				HomeFrame.getGameFrame().dispose();
			}
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}
}
