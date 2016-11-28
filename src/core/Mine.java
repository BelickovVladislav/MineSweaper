package core;

import java.awt.Color;

import enums.TypeCell;
import absctracts.ACell;

public class Mine extends ACell {

	/**
	 * 
	 */
	private static final long serialVersionUID = -52864818062160319L;

	public Mine() {
		super(TypeCell.Mine);
	}

	@Override
	public void openCell() {
		super.openCell();
		this.setText("M");
		setBackground(Color.RED);
		
	}

}
