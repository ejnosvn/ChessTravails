package ejnosvn.ChessTravails;

import java.util.List;


public abstract class Chessman {
	Table t = null;
	
	public Chessman(Table t) {
      this.t = t;
	}
	
	public abstract List<Field> getValidMoves(int i, int j, boolean blockedOnly);

	public List<Field> getValidMoves(Field f, boolean blockedOnly) {
		return getValidMoves(f.i, f.j, blockedOnly);
	}
}
