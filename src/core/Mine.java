package core;

import java.awt.Color;
import java.awt.Graphics;

import absctracts.ACell;
import enums.TypeCell;

public class Mine extends ACell {

	/**
	 * 
	 */

	public Mine() {
		super(TypeCell.Mine);
	}

	@Override
	public void openCell() {
		super.openCell();
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		if (isOpen())
			g.fill3DRect(getPoint().getX(), getPoint().getY(), getSize(),
					getSize(), !isOpen());
		else
			super.paint(g);
	}

}
