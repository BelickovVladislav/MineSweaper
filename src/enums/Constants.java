package enums;

import java.awt.Dimension;
import java.awt.Toolkit;

import frames.CustomSetting;
import frames.HomeFrame;

public class Constants {
	/**
	 * Class with constants.
	 */

	public Constants(Level level) {
		Dimension sizeScreen = Toolkit.getDefaultToolkit().getScreenSize();
		switch (level) {
			case Custom:
				columnCount = HomeFrame.getCustomFrame().getColumnCount();
				rowCount = HomeFrame.getCustomFrame().getRowCount();
				mineCount = HomeFrame.getCustomFrame().getMineCount();
				cellSize = (int) Math.sqrt((sizeScreen.getWidth() * sizeScreen.getHeight())
						/ (columnCount * rowCount)) / 2;
				break;
			case Easy:
				columnCount = easyColumnCount;
				rowCount = easyRowCount;
				mineCount = easyMineCount;
				cellSize = (int) Math.sqrt((sizeScreen.getWidth() * sizeScreen.getHeight())
						/ (columnCount * rowCount)) / 2;
				break;
			case Medium:
				columnCount = mediumColumnCount;
				rowCount = mediumRowCount;
				mineCount = mediumMineCount;
				cellSize = (int) Math.sqrt((sizeScreen.getWidth() * sizeScreen.getHeight())
						/ (columnCount * rowCount)) / 2;
				break;
			case Hard:
				columnCount = hardColumnCount;
				rowCount = hardRowCount;
				mineCount = hardMineCount;
				cellSize = (int) Math.sqrt((sizeScreen.getWidth() * sizeScreen.getHeight())
						/ (columnCount * rowCount)) / 2;
				break;
			default:
				break;
		}
	}

	public int getCellSize() {
		return cellSize;
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

	private final int	easyColumnCount	= 9;
	private final int	easyRowCount		= 9;
	private final int	easyMineCount		= 12;

	private final int	mediumColumnCount	= 25;
	private final int	mediumRowCount		= 10;
	private final int	mediumMineCount	= 30;

	private final int	hardColumnCount	= 25;
	private final int	hardRowCount		= 10;
	private final int	hardMineCount		= 60;

	private int		columnCount, rowCount, mineCount, cellSize;

}
