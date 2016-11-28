package enums;

import frames.CustomSetting;
import frames.HomeFrame;

public class Constants {
	/**
	 * Class with constants.
	 */
	
	public Constants(Level level) {
		
		switch (level) {
		case Custom:
			columnCount = HomeFrame.getCustomFrame().getColumnCount();
			rowCount = HomeFrame.getCustomFrame().getRowCount();
			mineCount = HomeFrame.getCustomFrame().getMineCount();
			break;
		case Easy:
			columnCount = easyColumnCount;
			rowCount = easyRowCount;
			mineCount = easyMineCount;
			cellSize = easyCellSize;
			break;
		case Medium:
			columnCount = mediumColumnCount;
			rowCount = mediumRowCount;
			mineCount = mediumMineCount;
			cellSize = mediumCellSize;
			break;
		case Hard:
			columnCount = hardColumnCount;
			rowCount = hardRowCount;
			mineCount = hardMineCount;
			cellSize = hardCellSize;
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

	private final int easyColumnCount = 9;
	private final int easyRowCount = 9;
	private final int easyMineCount = 20;
	private final int easyCellSize = 50;

	private final int mediumColumnCount = 25;
	private final int mediumRowCount = 10;
	private final int mediumMineCount = 15;
	private final int mediumCellSize = 50;

	private final int hardColumnCount = 25;
	private final int hardRowCount = 10;
	private final int hardMineCount = 60;
	private final int hardCellSize = 45;
	
	private int columnCount, rowCount, mineCount, cellSize;

}
