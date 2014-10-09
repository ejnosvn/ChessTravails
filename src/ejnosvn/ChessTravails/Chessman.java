package ejnosvn.ChessTravails;

import java.util.List;

import ejnosvn.ChessTravails.Field.FieldCommand;

public abstract class Chessman {
	Table t = null;

	public Chessman(Table t) {
		this.t = t;
	}

	public abstract List<Field> getValidMoves(int startCol, int startRow, FieldCommand fc);

	public List<Field> getValidMoves(Field f, boolean blockedOnly, FieldCommand fc) {
		return getValidMoves(f.column, f.row, fc);
	}

}
