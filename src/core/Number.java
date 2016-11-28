package core;

import enums.TypeCell;
import absctracts.ACell;

public class Number extends ACell {
	
	
	private int number;

	public Number(int number) {
		super(TypeCell.Number);
		setNumber(number);
	}
	@Override
	public void openCell(){
		super.openCell();
		this.setText(Integer.toString(getNumber()));
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	

}
