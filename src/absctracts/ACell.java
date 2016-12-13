package absctracts;

import interfaces.ICell;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import enums.Point;
import enums.TypeCell;

public abstract class ACell implements ICell {

	private TypeCell type;
	private boolean open;
	private boolean warning, question;
	private Point point;
	private int size;
	private Color cellColor;
	Image flagImage, questionImage;
	public ACell() {
		super();
		type = TypeCell.Void;
		open = false;
		this.warning = false;
		this.question = false;
		this.cellColor = new Color(26, 138, 52);
	}

	public void createCell(Point point, int size) {
		flagImage = Toolkit.getDefaultToolkit().getImage("images/flag.png");
		questionImage = Toolkit.getDefaultToolkit().getImage("images/question.png");
		this.point = point;
		this.setSize(size);
	}

	public ACell(TypeCell type) {
		this.type = type;
		this.warning = false;
		this.question = false;
		this.cellColor = new Color(26, 138, 52);
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

	public Point getPoint() {
		return point;
	}

	public int getSize() {
		return size;
	}

	public void paint(Graphics g) {
		g.setColor(cellColor);
		g.fill3DRect(getPoint().getX(), getPoint().getY(), getSize(), getSize(),
				!isOpen()|| isWarningMine());
		
		if(isWarningMine()){
			g.drawImage(flagImage, getPoint().getX()+getSize()/4, getPoint().getY()+getSize()/4, getSize()/2,getSize()/2,null);					
		}
		if(question){
			g.drawImage(questionImage, getPoint().getX()+getSize()/4, getPoint().getY()+getSize()/4, getSize()/2,getSize()/2,null);		
		}
	}

	public void setSize(int size) {
		this.size = size;
	}
}
