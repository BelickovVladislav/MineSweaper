package interfaces;

import enums.TypeCell;

public interface ICell {
	boolean isMine();

	boolean isNumber();

	boolean isVoid();

	TypeCell getType();

}
