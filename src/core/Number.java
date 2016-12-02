package core;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import absctracts.ACell;
import enums.TypeCell;

public class Number extends ACell {
	
	
	private int number;
	private Font font;

	public Number(int number) {
		super(TypeCell.Number);
		setNumber(number);
		
		
	}
	@Override
	public void openCell(){
		super.openCell();
		font = new Font("Verdana", Font.PLAIN, getSize()/2);
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
		g.setColor(Color.WHITE);
		g.setFont(font);
		if(this.isOpen())
			g.drawString(Integer.toString(getNumber()), getPoint().getX()+getSize()/4, getPoint().getY()+getSize()/2);
	}
	

}
