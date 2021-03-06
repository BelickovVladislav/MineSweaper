package absctracts;

import javax.swing.JButton;

import interfaces.ICell;
import enums.TypeCell;

public abstract class ACell extends JButton implements ICell {

	private TypeCell type;
	private boolean open;
	private boolean warning, question;

	public ACell() {
		super();
		type = TypeCell.Void;
		open = false;
		this.warning = false;
		this.question = false;
	}

	public ACell(TypeCell type) {
		this.type = type;
		this.warning = false;
		this.question = false;
	}

	public void warning() {
		if (!warning && !question) {
			warning = true;
			this.setText("!");
		} else if (warning && !question) {
			question = true;
			warning = false;
			this.setText("?");
		} else if (question && !warning) {
			question = false;
			warning = false;
			this.setText("");
		}
	}
	public boolean isWarning(){
		return question || warning;
	}
	public boolean isWarningMine(){
		return warning;
	}
	public boolean isOpen() {
		return open;
	}

	public void openCell() {
		open = true;
		this.setEnabled(false);
	}

	public TypeCell getType() {
		return type;
	}

	@Override
	public boolean isMine() {
		return type == TypeCell.Mine;
	}

	@Override
	public boolean isNumber() {
		return type == TypeCell.Number;
	}

	@Override
	public boolean isVoid() {
		return type == TypeCell.Void;
	}

	public void setMine() {
		type = TypeCell.Mine;
	}

	public void setNumber() {
		type = TypeCell.Number;
	}

	public void setVoid() {
		type = TypeCell.Void;
	}

}
