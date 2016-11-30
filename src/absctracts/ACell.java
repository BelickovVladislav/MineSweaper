package absctracts;

import interfaces.ICell;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

import enums.Point;
import enums.TypeCell;

public abstract class ACell implements ICell {

	private TypeCell type;
	private boolean open;
	private boolean warning, question;
	private Point point;
	private int size;
	
	public ACell() {
		super();
		type = TypeCell.Void;
		open = false;
		this.warning = false;
		this.question = false;
	}

	public void createCell(Point point, int size) {
		this.point = point;
		this.setSize(size);
	}

	public ACell(TypeCell type) {
		this.type = type;
		this.warning = false;
		this.question = false;
	}

	public void warning() {
		if (!warning && !question) {
			warning = true;
		} else if (warning && !question) {
			question = true;
			warning = false;
		} else if (question && !warning) {
			question = false;
			warning = false;
		}
	}

	public boolean isWarning() {
		return question || warning;
	}

	public boolean isWarningMine() {
		return warning;
	}

	public boolean isOpen() {
		return open;
	}

	public void openCell() {
		open = true;
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
	public Point getPoint(){
		return point;
	}
	public int getSize(){
		return size;
	}
	public void paint(Graphics g) {
		g.setColor(new Color(26,138,52));
		g.fill3DRect(point.getX(), point.getY(), getSize(), getSize(), !isOpen());
		
	

	}

	public void setSize(int size) {
		this.size = size;
	}
}
