package ejnosvn.ChessTravails;

import java.util.List;

public abstract class Chessman {
	Table t = null;
	
	public Chessman(Table t) {
      this.t = t;
	}
	
	public abstract List<Field> getValidMoves(int startCol, int startRow, boolean blockedOnly);

	public List<Field> getValidMoves(Field f, boolean blockedOnly) {
		return getValidMoves(f.column, f.row, blockedOnly);
	}
}
