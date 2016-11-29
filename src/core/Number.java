package core;

import java.awt.Graphics;

import absctracts.ACell;
import enums.TypeCell;

public class Number extends ACell {
	
	
	private int number;

	public Number(int number) {
		super(TypeCell.Number);
		setNumber(number);
	}
	@Override
	public void openCell(){
		super.openCell();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public void paint(Graphics g){
		super.paint(g);
		if(this.isOpen())
			g.drawString(Integer.toString(getNumber()), getPoint().getX()+getSize()/2, getPoint().getY()+getSize()/2);
	}
	

}
