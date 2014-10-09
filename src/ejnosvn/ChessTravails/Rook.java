package ejnosvn.ChessTravails;

import java.util.ArrayList;
import java.util.List;

import ejnosvn.ChessTravails.Field.FieldCommand;

public class Rook extends Chessman {

	public Rook(Table t) {
		super(t);
	}

	@Override
	public List<Field> getValidMoves(int startCol, int startRow, FieldCommand fc) {
		List<Field> retFields = new ArrayList<Field>();
		checkValidMovesRight(startCol, startRow, retFields, fc);
		checkValidMovesLeft(startCol, startRow, retFields, fc);
		checkValidMovesDown(startCol, startRow, retFields, fc);
		checkValidMovesUp(startCol, startRow, retFields, fc);
		return retFields;
	}

	private void checkValidMovesUp(int startCol, int startRow, List<Field> retFields, FieldCommand fc) {
		for (int row = startRow - 1; row >= 0; row--) {
			if (fc.execute(t.getField(startCol, row))) {
				retFields.add(t.getField(startCol, row));
			} else {
				break;
			}
		}
	}

	private void checkValidMovesDown(int startCol, int startRow, List<Field> retFields, FieldCommand fc) {
		for (int row = startRow + 1; row < 8; row++) {
			if (fc.execute(t.getField(startCol, row))) {
				retFields.add(t.getField(startCol, row));
			} else {
				break;
			}
		}
	}

	private void checkValidMovesLeft(int startCol, int startRow, List<Field> retFields, FieldCommand fc) {
		for (int col = startCol - 1; col >= 0; col--) {
			if (fc.execute(t.getField(col, startRow))) {
				retFields.add(t.getField(col, startRow));
			} else {
				break;
			}
		}
	}

	private void checkValidMovesRight(int startCol, int startRow, List<Field> retFields, FieldCommand fc) {
		for (int col = startCol + 1; col < 8; col++) {
			if (fc.execute(t.getField(col, startRow))) {
				retFields.add(t.getField(col, startRow));
			} else {
				break;
			}
		}
	}

}
