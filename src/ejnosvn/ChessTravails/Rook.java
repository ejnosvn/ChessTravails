package ejnosvn.ChessTravails;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Chessman {

	public Rook(Table t) {
		super(t);
	}

	@Override
	public List<Field> getValidMoves(int startCol, int startRow) {
		List<Field> retFields = new ArrayList<Field>();
		checkValidMovesRight(startCol, startRow, retFields);
		checkValidMovesLeft(startCol, startRow, retFields);
		checkValidMovesDown(startCol, startRow, retFields);
		checkValidMovesUp(startCol, startRow, retFields);
		return retFields;
	}

	private void checkValidMovesUp(int startCol, int startRow, List<Field> retFields) {
		for (int row = startRow - 1; row >= 0; row--) {
			if (t.getField(startCol, row).isValid()) {
				retFields.add(t.getField(startCol, row));
			} else {
				break;
			}
		}
	}

	private void checkValidMovesDown(int startCol, int startRow, List<Field> retFields) {
		for (int row = startRow + 1; row < 8; row++) {
			if (t.getField(startCol, row).isValid()) {
				retFields.add(t.getField(startCol, row));
			} else {
				break;
			}
		}
	}

	private void checkValidMovesLeft(int startCol, int startRow, List<Field> retFields) {
		for (int col = startCol - 1; col >= 0; col--) {
			if (t.getField(col, startRow).isValid()) {
				retFields.add(t.getField(col, startRow));
			} else {
				break;
			}
		}
	}

	private void checkValidMovesRight(int startCol, int startRow, List<Field> retFields) {
		for (int col = startCol + 1; col < 8; col++) {
			if (t.getField(col, startRow).isValid()) {
				retFields.add(t.getField(col, startRow));
			} else {
				break;
			}
		}
	}

	@Override
	public List<Field> getNotBlockedMoves(int startCol, int startRow) {
		List<Field> retFields = new ArrayList<Field>();
		checkNotBlockedMovesRight(startCol, startRow, retFields);
		checkNotBlockedMovesLeft(startCol, startRow, retFields);
		checkNotBlockedMovesDown(startCol, startRow, retFields);
		checkNotBlockedMovesUp(startCol, startRow, retFields);
		return retFields;
	}

	private void checkNotBlockedMovesUp(int startCol, int startRow, List<Field> retFields) {
		for (int row = startRow - 1; row >= 0; row--) {
			if (t.getField(startCol, row).isNotBlocked()) {
				retFields.add(t.getField(startCol, row));
			} else {
				break;
			}
		}
	}

	private void checkNotBlockedMovesDown(int startCol, int startRow, List<Field> retFields) {
		for (int row = startRow + 1; row < 8; row++) {
			if (t.getField(startCol, row).isNotBlocked()) {
				retFields.add(t.getField(startCol, row));
			} else {
				break;
			}
		}
	}

	private void checkNotBlockedMovesLeft(int startCol, int startRow, List<Field> retFields) {
		for (int col = startCol - 1; col >= 0; col--) {
			if (t.getField(col, startRow).isNotBlocked()) {
				retFields.add(t.getField(col, startRow));
			} else {
				break;
			}
		}
	}

	private void checkNotBlockedMovesRight(int startCol, int startRow, List<Field> retFields) {
		for (int col = startCol + 1; col < 8; col++) {
			if (t.getField(col, startRow).isNotBlocked()) {
				retFields.add(t.getField(col, startRow));
			} else {
				break;
			}
		}
	}

}
