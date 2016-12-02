package core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import absctracts.ACell;
import enums.TypeCell;

public class Mine extends ACell {
	private Image mineImage;

	/**
	 * 
	 */

	public Mine() {
		super(TypeCell.Mine);
		mineImage = Toolkit.getDefaultToolkit().getImage("images/mine.png");

	}

	@Override
	public void openCell() {
		super.openCell();
	}

	@Override
	public void paint(Graphics g) {
		if (isOpen()) {
			g.setColor(Color.RED);
			g.fill3DRect(getPoint().getX(), getPoint().getY(), getSize(),
					getSize(), !isOpen());
			g.drawImage(mineImage, getPoint().getX(), getPoint().getY(),
					getSize(), getSize(), null);
		} else
			super.paint(g);
	}

}
