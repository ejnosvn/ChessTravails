package ejnosvn.ChessTravails;

import java.util.List;

public abstract class Chessman {
	Table t = null;

	public Chessman(Table t) {
		this.t = t;
	}

	public abstract List<Field> getValidMoves(int startCol, int startRow);

	public abstract List<Field> getNotBlockedMoves(int startCol, int startRow);

	public List<Field> getValidMoves(Field f, boolean blockedOnly) {
		return getValidMoves(f.column, f.row);
	}

	public List<Field> getNotBlockedMoves(Field f) {
		return getValidMoves(f.column, f.row);
	}
}
